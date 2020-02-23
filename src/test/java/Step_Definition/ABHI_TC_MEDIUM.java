package Step_Definition;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ABHI_TC_MEDIUM {
	public WebDriver driver;
	@Given("^as a registered user$")
	public void as_a_registered_user() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
	    driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(" http://192.168.43.205:8585/");
	
		
	}

	@When("^User log in and click on account link and then member payment link$")
	public void user_log_in_and_click_on_account_link_and_then_member_payment_link() throws Exception {
		driver.findElement(By.id("cyclosUsername")).sendKeys("Abhi12");

		driver.findElement(By.id("cyclosPassword")).click();
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
		driver.findElement(By.xpath("//input[@value='5']")).click();
		driver.findElement(By.xpath("//input[@value='6']")).click();
		driver.findElement(By.xpath("//input[@value='b']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		driver.findElement(By.xpath("//li[@id='menu2']//span[@class='menuText']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@id='submenu2.4']//span[@class='subMenuText']")).click();

	}

	@When("^valid credentials in login,amount and description textbox are entered and submitted$")
	public void valid_credentials_in_login_amount_and_description_textbox_are_entered_and_submitted() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='memberUsername']")).sendKeys("saa");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10 );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='InputBoxDisabled']")));
		
		driver.findElement(By.xpath("//input[@id='memberName']")).sendKeys("saanv");
		WebDriverWait wait1 = new WebDriverWait(driver, 10 );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='InputBoxDisabled']")));
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("1");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("abcde");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Then("^click on submit button and then account information link$")
	public void click_on_submit_button_and_then_account_information_link() throws Exception{
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//li[@id='submenu2.0']//span[@class='subMenuText']")).click();
		
		Boolean s1=driver.findElement(By.xpath("//td[@class='headerLabel']")).isDisplayed();
		if(s1=true){
		System.out.println("Transaction successful");
		}
		else{
			System.out.println("Transaction declined");
		}

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@id='menu7']//span[@class='menuText']")).click();
		Alert al=driver.switchTo().alert();
		al.accept();
		driver.close();
		
	}
}
