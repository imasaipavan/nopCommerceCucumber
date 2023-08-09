package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.CustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import Utilities.WaitHelper;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseClass{

	@Before
	public void setup() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("config.properties");
		prop.load(file);
		if(prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(prop.getProperty("browserName").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(prop.getProperty("browserName").equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		logger = Logger.getLogger("nopCommerce"); //Added logger
		PropertyConfigurator.configure("log4j.properties");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}


	@Given("User launched the Chorme")
	public void user_launched_the_chorme() {

		logger.info("---- Url is invoked ----");
		login = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("User enters Emails as {string} and password as {string}")
	public void user_enters_emails_as_and_password_as(String email, String password) {
		logger.info("---- Entered Email ----");
		login.email(driver).clear();
		login.email(driver).sendKeys(email);
		logger.info("---- Entered Password ----");
		login.password(driver).clear();
		login.password(driver).sendKeys(password);

	}

	@When("User clicks on Login")
	public void user_clicks_on_login() {
		logger.info("---- Clicked Login ----");
		login.logIn(driver).click();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String pageTitle) {
		Assert.assertEquals(driver.getTitle(), pageTitle);

	}

	@When("User clicks on logout link")
	public void user_clicks_on_logout_link() throws InterruptedException {
		login.logout(driver).click();
		Thread.sleep(3000);
	}

	@Then("Close browser")
	public void close_browser() {
		driver.quit();
	}

	// Add customer details

	@Then("User views Dashbord")
	public void user_views_dashbord() {
		addCust = new CustomerPage(driver);
		Assert.assertEquals(addCust.getTitle(), "Dashboard / nopCommerce administration");
	}

	@When("User clicks Add Customer menu")
	public void user_clicks_add_customer_menu() throws InterruptedException {
		Thread.sleep(3000);
		logger.info("---- Clicked Customer link ----");
		addCust.customers(driver).click();
	}

	@When("clicks on customer menu item")
	public void clicks_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		addCust.customersLink(driver).click();
		logger.info("---- Clicked Customer link ----");
	}

	@When("clicks on Add new button")
	public void clicks_on_add_new_button() throws InterruptedException {
		Thread.sleep(3000);
		addCust.addNewButon(driver).click();
		logger.info("---- Clicked Add New button ----");
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals(addCust.getTitle(), "Add a new customer / nopCommerce administration");
		logger.info("---- View Add New Customer Page ----");
	}

	@When("user enter customer info")
	public void user_enter_customer_info() {

		String email = BaseClass.randomString()+"@gmail.com";
		addCust.email(driver).sendKeys(email);
		logger.info("---- Entered email ----");
		addCust.password(driver).sendKeys("Admin");
		logger.info("---- Entered password ----");
		addCust.firstName(driver).sendKeys("Admin");
		logger.info("---- Entered First Name ----");
		addCust.lastName(driver).sendKeys("Admin");
		logger.info("---- Entered Last Name ----");
		addCust.companyName(driver).sendKeys("Admin");
		logger.info("---- Entered Company Name ----");
		addCust.adminComment(driver).sendKeys("Admin");
		logger.info("---- Entered Admin Comment ----");
	}

	@When("clicks on save button")
	public void clicks_on_save_button() {
		addCust.saveButton(driver).click();
		logger.info("---- Clicked Save Button ----");
	}

	@Then("user can veiw the message {string}")
	public void user_can_veiw_the_message(String successMessage) {

		Assert.assertTrue(addCust.successMessage(driver).getText().contains("The new customer has been added successfully."));
	}



	// Search a customer with Email

	@When("Enter customer email")
	public void enter_customer_email() {
		searchCust = new SearchCustomerPage(driver);
		wait = new WaitHelper(driver);
		searchCust.searchEmail(driver).sendKeys("admin@yourStore.com");
		logger.info("---- Entered customer email to search ----");
	}

	@When("click on search button")
	public void click_on_search_button() {
		searchCust.clickSearchButton(driver).click();
		logger.info("---- Clicked Search Button ----");
	}

	@Then("user should found email in search table")
	public void user_should_found_email_in_search_table() {
		wait.waitForElement(searchCust.mailAfterSearch(driver));
		String searchedEmail = searchCust.mailAfterSearch(driver).getText();
		Assert.assertEquals("admin@yourStore.com", searchedEmail);
		logger.info("---- Found Searched Mail ----");

	}

	// Search Customer by First and Last Names
	@When("Enter customer firstName and lastName")
	public void Enter_customer_firstName_and_lastName() {
		searchCust = new SearchCustomerPage(driver);
		wait = new WaitHelper(driver);
		searchCust.enterFirstName(driver).sendKeys("John");
		searchCust.enterLastName(driver).sendKeys("Smith");
		logger.info("---- Entered First and Last Names ----");
	}

	@Then("user should found Name in search table")
	public void user_should_found_Name_in_search_table() {
		wait.waitForElement(searchCust.mailAfterSearch(driver));
		String searchedName = searchCust.nameAfterSearching(driver).getText();
		Assert.assertEquals(searchedName, "John Smith");
		logger.info("---- Found Searched First and Last Names ----");

	}


}
