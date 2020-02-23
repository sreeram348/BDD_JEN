package Step_Definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


	public class ARSH_TC_SIMPLE {
		public WebDriver driver;
		@Given("^An application$")
		  public void an_application() throws InterruptedException  {
			 // Thread.sleep(3000);
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
			   driver= new ChromeDriver();
			   driver.manage().window().maximize();
			   driver.get(" http://192.168.43.216:8585/");
		}

		  @When("^Entering valid credentials in Login name, Password textbox$")
		  public void entering_valid_credentials_in_Login_name_Password_textbox()  {
			  driver.findElement(By.id("cyclosUsername")).sendKeys("arshh");
		      driver.findElement(By.xpath("//input[@value='z']")).click();
			  driver.findElement(By.xpath("//input[@value='x']")).click();
			  driver.findElement(By.xpath("//input[@value='c']")).click();
			  driver.findElement(By.xpath("//input[@value='v']")).click();
			  driver.findElement(By.xpath("//input[@value='b']")).click();
			  driver.findElement(By.xpath("//input[@value='n']")).click();
			  driver.findElement(By.xpath("//input[@value='m']")).click();
			  }

		  @When("^Click upon submit button$")
		  public void click_on_Submit_button() {
			  driver.findElement(By.xpath("//input[@type='submit']")).click();
			  }

		  @Then("^Member home page should get displayed$")
		  public void member_home_page_should_get_displayed() {
			  String expecteds="Logged user: arshh - arshiya";
			  String actuals=driver.findElement(By.xpath("//*[@id='loginDataBar']/span[1]")).getText();
              Assert.assertEquals(expecteds, actuals);
	System.out.println("PAge loaded");
		  }

		  
}