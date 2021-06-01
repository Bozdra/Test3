/*Test Selenium
Zadatak
Napisati program na programskom jeziku Java koji sluzi za testiranje sajta https://www.saucedemo.com/ 
Pokusati logovanje prvo sa nevalidnim, a potom sa validnim kredencijalima i proveriti da li se nakon
 toga korisnik nalazi na odgovarajucoj staranici. Na stranici https://www.saucedemo.com/inventory.html 
 sortirati proizvode po ceni (od najnize ka najvisoj). Proveriti da li je sortiranje ispravno. 
Program pisati postujuci page object model. Koristiti Test NG za proveru ispravnosti testova. 
Kredencijale procitati iz datoteke data.xlsx. Resenje okaciti na GitHub nalog i svoj folder na google drive-u 
(napraviti folder pod nazivom kontrolni3).
*/
package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objs.Home;
import objs.Inventory;

public class TestSajta {
	private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
}
	
	@Test (priority = 1)
	public void invalidLogin() {
		File f = new File("data.xlsx");
	
		
		try {
		InputStream in = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(in);
		Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row .getCell(0);
		Cell cell1 = row.getCell(1);
		String user = cell.toString();
		String pass = cell1.toString();
		
		driver.get(Home.HOME_URL);
		Home.inputUsername(driver, user);
		Home.inputPassword(driver, pass);
		Home.clickLogin(driver);
		
		Assert.assertEquals(driver.getCurrentUrl(), Home.HOME_URL);
		
		wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Test (priority = 2)
	public void validLogin() {
		File f = new File("data.xlsx");
	
		
		try {
		InputStream in = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(in);
		Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(1);
		Cell cell = row .getCell(0);
		Cell cell1 = row.getCell(1);
		String user = cell.toString();
		String pass = cell1.toString();
		
		driver.get(Home.HOME_URL);
		Home.inputUsername(driver, user);
		Home.inputPassword(driver, pass);
		Home.clickLogin(driver);
		
		Assert.assertEquals(driver.getCurrentUrl(), Inventory.INVENTORY_URL);
		
		wb.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Test (priority = 3)
	public void testSortinga() { 
		
		
		driver.get(Home.HOME_URL);
		Home.inputUsername(driver, "standard_user");
		Home.inputPassword(driver, "secret_sauce");
		Home.clickLogin(driver);
		Inventory.pressSort(driver);
		Inventory.sortLoHi(driver);
		
	
		List<String> cene = new ArrayList<>();
		List <WebElement> products = driver.findElements(By.className("inventory_item_price"));
		for (WebElement product : products)
	    {
			String cena = product.getText();
			String a = cena.toString();
			cene.add(a);
	    }
		List<String> b = new ArrayList<String>();
		b.add("$7.99");
		b.add("$9.99");
		b.add("$15.99");
		b.add("$15.99");
		b.add("$29.99");
		b.add("$49.99");
		Assert.assertEquals(cene, b); 
		
}
}
