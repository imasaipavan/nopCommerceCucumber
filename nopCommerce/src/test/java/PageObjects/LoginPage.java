package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	static WebDriver driver;
	
	public LoginPage(WebDriver dirver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static WebElement email(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@type='email']"));
	}
	
	public static WebElement password(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@type='password']"));
	}
	public static WebElement logIn(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='button-1 login-button']"));
	}
	
	public static WebElement logout(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@href='/logout']"));
	}
	
	
	
	
	public static void enterEmail(String email) {
		email(driver).sendKeys(email);
	}
	
	public static void enterPassword(String password) {
		password(driver).sendKeys(password);
	}

}
