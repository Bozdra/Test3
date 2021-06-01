/*Test Selenium
Zadatak
Napisati program na programskom jeziku Java koji sluzi za testiranje sajta https://www.saucedemo.com/ 
Pokusati logovanje prvo sa nevalidnim, a potom sa validnim kredencijalima i proveriti da li se nakon
 toga korisnik nalazi na odgovarajucoj staranici. Na stranici https://www.saucedemo.com/inventory.html 
 sortirati proizvode po ceni (od najnize ka najvisoj). Proveriti da li je sortiranje ispravno. 
Program pisati postujuci page object model. Koristiti Test NG za proveru ispravnosti testova. 
Kredencijale procitati iz datoteke data.xlsx. Resenje okaciti na GitHub nalog i svoj folder na google drive-u 
(napraviti folder pod nazivom kontrolni3).
*/package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
public static final String HOME_URL = "https://www.saucedemo.com/";
public static final String USERNAME_ID = "user-name";
public static final String PASSWORD_ID = "password";
public static final String LOGINBTN_ID = "login-button";

public static void inputUsername(WebDriver driver, String username) {
	driver.findElement(By.id(USERNAME_ID)).sendKeys(username);
}
public static void inputPassword(WebDriver driver, String password) {
	driver.findElement(By.id(PASSWORD_ID)).sendKeys(password);
}
public static void clickLogin(WebDriver driver) {
	driver.findElement(By.id(LOGINBTN_ID)).click();
}
}
