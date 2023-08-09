package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	public WebDriver driver;
	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public static WebElement customers(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='right fas fa-angle-left '])[4]"));
	}
	
	public static WebElement customersLink(WebDriver driver) {
		return driver.findElement(By.xpath("(//a[@href='/Admin/Customer/List'])[1]"));
	}

	public static WebElement addNewButon(WebDriver driver) {
		return driver.findElement(By.xpath("//a[@href='/Admin/Customer/Create']"));
	}
	
	public static WebElement email(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='Email']"));
	}
	
	public static WebElement password(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='Password']"));
	}
	public static WebElement firstName(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='FirstName']"));
	}
	public static WebElement lastName(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='LastName']"));
	}
	public static WebElement gender(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='Gender_Male']"));
	}
	public static WebElement companyName(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='Company']"));
	}
	public static WebElement adminComment(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='AdminComment']"));
	}
	public static WebElement saveButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@name='save']"));
	}
	public static WebElement successMessage(WebDriver driver) {
		return driver.findElement(By.tagName("body"));
	}
	
	
	
}
