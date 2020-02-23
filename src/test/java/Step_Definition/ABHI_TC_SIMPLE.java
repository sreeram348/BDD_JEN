package Step_Definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ABHI_TC_SIMPLE {

	public WebDriver driver;
	@Given("^As a registered user$")
	public void as_a_registered_user() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
	    driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(" http://192.168.43.205:8585/");
		driver.findElement(By.id("cyclosUsername")).sendKeys("Abhi9");

		driver.findElement(By.id("cyclosPassword")).click();
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
		driver.findElement(By.xpath("//input[@value='5']")).click();
		driver.findElement(By.xpath("//input[@value='6']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();  

	}

	@When("^user click on personal link and then click on Change password link$")
	public void user_click_on_personal_link_and_then_click_on_Change_password_link() {
		driver.findElement(By.xpath("//li[@id='menu1']//span[@class='menuText']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.findElement(By.xpath("//li[@id='submenu1.7']//span[@class='subMenuText']")).click();
	   
	}

	@When("^valid credentials are entered in the New Password textbox$")
	public void valid_credentials_are_entered_in_the_New_Password_textbox() {
		
		driver.findElement(By.xpath("//input[@name='oldPassword']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='newPassword']")).sendKeys("123457");
		driver.findElement(By.xpath("//input[@name='newPasswordConfirmation']")).sendKeys("123457");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Alert al=driver.switchTo().alert();
		al.accept();
		driver.findElement(By.xpath("//li[@id='menu7']//span[@class='menuText']")).click();
		Alert al1=driver.switchTo().alert();
		al1.accept();
		
		
	}

	@Then("^password is changed and user able to login with new Password$")
	public void password_is_changed_and_user_able_to_login_with_new_Password() {
		driver.findElement(By.id("cyclosUsername")).sendKeys("Abhi9");

		driver.findElement(By.id("cyclosPassword")).click();
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
		driver.findElement(By.xpath("//input[@value='5']")).click();
		driver.findElement(By.xpath("//input[@value='7']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		boolean b=driver.findElement(By.xpath("//tbody//tr//td[@class='tdHeaderTable']")).isDisplayed();
		if(b==true){
			System.out.println("Login successful");
		}
		else{
			System.out.println("Login failed");
		}
		driver.close();

	}
	
}
