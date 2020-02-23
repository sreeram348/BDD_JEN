package Step_Definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PRAV_TC_SIMPLE {
	public WebDriver driver;

	@Given("^Registered user$")
	public void registered_user() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://localhost:8585/");
			
			 driver.findElement(By.id("cyclosUsername")).sendKeys("qwerty");
			  driver.findElement(By.xpath("//input[@value='1']")).click();
			  driver.findElement(By.xpath("//input[@value='2']")).click();
			  driver.findElement(By.xpath("//input[@value='3']")).click();
			  driver.findElement(By.xpath("//input[@value='4']")).click();
			  driver.findElement(By.xpath("//input[@value='5']")).click();
			  driver.findElement(By.xpath("//input[@value='6']")).click();
			  
			  driver.findElement(By.xpath("//input[@type='submit']")).click();
			  
	}
		

	@When("^User modify his profile page$")
	public void user_modify_his_profile_page() {
		
		driver.findElement(By.xpath("//img[@src='/systemImage?image=quickAccess_updateProfile']")).click();
		  driver.findElement(By.id("modifyButton")).click();
		  driver.findElement(By.xpath("//input[@fieldname='address']")).clear();
		  driver.findElement(By.xpath("//input[@fieldname='address']")).sendKeys("1-31/6");
		 
	}
		

	@When("^Click on Submit$")
	public void click_on_Submit() throws InterruptedException  {
		
		 driver.findElement(By.id("saveButton")).click();
		 Thread.sleep(2000);
	}
		

	@Then("^A pop up message displays regarding changes made in profile page\\.$")
	public void a_pop_up_message_displays_regarding_changes_made_in_profile_page() {
		WebDriverWait wait= new WebDriverWait(driver, 300);
		if(wait.until(ExpectedConditions.alertIsPresent())==null)
			
			System.out.println("Profile didn't changed");
		else
			System.out.println("Profile Modification Done");
		    driver.switchTo().alert().accept();
		    
		   boolean b1=driver.findElement(By.xpath("//tbody//tr//td[@class='tdHeaderTable']")).isDisplayed();
		   if(b1==true)
			   System.out.println("Profile changed successfully");
		   else
			   System.out.println("Profile didn't changed");
		   
		   driver.close();
	}

}
