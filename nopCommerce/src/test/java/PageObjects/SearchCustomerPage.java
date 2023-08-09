package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class SearchCustomerPage {
	public WebDriver driver;
	public WaitHelper wait;
	public SearchCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
	}
	
	public static WebElement searchEmail(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@name='SearchEmail']"));
	}
	
	public static WebElement enterFirstName(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@name='SearchFirstName']"));
	}
	
	public static WebElement enterLastName(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@name='SearchLastName']"));
	}
	public static WebElement clickSearchButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id='search-customers']"));
	}
	
	public static WebElement mailAfterSearch(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='odd']/td)[2]"));
	}
	
	public static WebElement nameAfterSearching(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='odd']/td)[3]"));
	}
	
	
}
