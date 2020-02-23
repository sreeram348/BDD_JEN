package Step_Definition;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SREE_TC_MEDIUM {

	public WebDriver driver;
	@Given("^as an Application logged in as admin$")
	public void as_an_Application_logged_in_as_admin() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8585/");
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.id("cyclosPassword")).click();
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();  

	}

	@When("^I open the manage advertisments of a valid user to insert new credentials , check the radio button upon clicking submit buttons$")
	public void i_open_the_manage_advertisments_of_a_valid_user_to_insert_new_credentials_check_the_radio_button_upon_clicking_submit_buttons() throws InterruptedException, AWTException{

		driver.findElement(By.id("memberUsername")).sendKeys("manzoor");
		JavascriptExecutor a = (JavascriptExecutor)driver;

		a.executeScript("window.scrollBy(0,700)");
		Thread.sleep(1000);
		// a.executeScript("document.getElementBylinkurl('memberAds?memberId=9').scrollIntoView()");
		driver.findElement(By.xpath("//input[@linkurl='memberAds?memberId=9']")).click(); 
		 driver.findElement(By.id("newButton")).click();
		 driver.findElement(By.name("ad(category)")).click();
		// WebElement Li = driver.findElement(By.xpath("//select[@name='ad(category)']")).click();
		          Robot robot=new Robot();
		          robot.keyPress(KeyEvent.VK_DOWN);
		          robot.keyPress(KeyEvent.VK_ENTER);
		          
		          driver.findElement(By.xpath("//input[@name='ad(price)']")).sendKeys("7");
		          driver.findElement(By.xpath("//input[@name='ad(price)']")).sendKeys("7");
		          driver.findElement(By.id("saveButton")).click();
		          Alert alt = driver.switchTo().alert();
		          String aleartmsg = alt.getText();
		          //System.out.println("The alert message is " +aleartmsg);
		          alt.accept();
		          driver.findElement(By.id("backButton")).click();





	}
	@When("^Click on Logout button to login as a member\\.$")
	public void click_on_Logout_button_to_login_as_a_member() throws AWTException {
		 Robot robot=new Robot();
         robot.keyPress(KeyEvent.VK_DOWN);
         robot.keyPress(KeyEvent.VK_ENTER);
      driver.findElement(By.xpath("//li[@id='menu15']//span[@class='menuText']")).click();
      Alert a=driver.switchTo().alert();
      a.accept();
      
      driver.findElement(By.id("cyclosUsername")).sendKeys("sree");
      driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
	//	driver.findElement(By.xpath("//input[@value='5']")).click();
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}

	@When("^click on personal tab$")
	public void click_on_personal_tab() {
		driver.findElement(By.xpath("//li[@id='menu1']//span[@class='menuText']")).click();
		driver.findElement(By.xpath("//li[@id='submenu1.2']//span[@class='subMenuText']")).click();

	}
	@Then("^Member should  be able to view the Advertisement added by admin should get displayed$")
	public void member_should_be_able_to_view_the_Advertisement_added_by_admin_should_get_displayed() {

		String expected="Advertisements";
		String actual=driver.findElement(By.xpath("//li[@id='submenu1.2']//span[@class='subMenuText']")).getText();
          assertEquals(expected, actual);
          System.out.println("The advertisments are displayed"); 
		driver.close();
		
	}



}
