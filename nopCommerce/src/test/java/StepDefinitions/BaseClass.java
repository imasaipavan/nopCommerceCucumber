package StepDefinitions;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;

import PageObjects.CustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import Utilities.WaitHelper;

public class BaseClass {
	public WaitHelper wait;
	public WebDriver driver;
	public LoginPage login;
	public CustomerPage addCust;
	public SearchCustomerPage searchCust;
	public static Logger logger;
	
	// for creating mail with unique mail address
	public static double randomString() {
		 double time = System.currentTimeMillis();
		 return time;
	}

}
