package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inventory {
	public static final String INVENTORY_URL =  "https://www.saucedemo.com/inventory.html";
	public static final String SORTMENU_XPATH = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select";
	public static final String LOWTOHIGHBTN_XPATH = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]";
	
	public static void pressSort(WebDriver driver) {
		driver.findElement(By.xpath(SORTMENU_XPATH)).click();
	}
	public static void sortLoHi(WebDriver driver) { 
		driver.findElement(By.xpath(LOWTOHIGHBTN_XPATH)).click();
	}
}