package Step_Definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PRAV_TC_MEDIUM {
  public WebDriver driver;
  
	@Given("^Registered User$")
	public void registered_User()  {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:8585/");
		
		driver.manage().window().maximize();
		  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		  driver.findElement(By.xpath("//input[@value='1']")).click();
		  driver.findElement(By.xpath("//input[@value='2']")).click();
		  driver.findElement(By.xpath("//input[@value='3']")).click();
		  driver.findElement(By.xpath("//input[@value='4']")).click();
		 		  
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@When("^User logs into his account and repay the amount$")
	public void user_logs_into_his_account_and_repay_the_amount() throws InterruptedException  {
		driver.findElement(By.xpath("//li[@id='menu0']//span[2]")).click();
		driver.findElement(By.id("memberUsername")).sendKeys("manzoor");
		driver.findElement(By.id("memberName")).sendKeys("manzoor");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@linkurl='searchLoans?memberId=9']")).click();
		driver.findElement(By.xpath("//img[@src='/pages/images/view.gif']")).click();
		driver.findElement(By.id("amountText")).clear();
		driver.findElement(By.id("amountText")).sendKeys("5000");
		driver.findElement(By.xpath("//input[@value='Repay']")).click();
		
		WebDriverWait wait1= new WebDriverWait(driver, 300);
		if(wait1.until(ExpectedConditions.alertIsPresent())==null)
		{
			System.out.println("want to cancel payment");
		    driver.switchTo().alert().dismiss();
		}
		else
		{
			System.out.println("want to pay");
		    driver.switchTo().alert().accept();
		}
		    
	    boolean b=driver.findElement(By.xpath("//table//tr//td[@class='tdHeaderTable'")).isDisplayed();
	     if(b==true)
	    	 System.out.println("Payment done");
	     else
	    	 System.out.println("Payment canceled");
	}

	@And("^Click on Ok and logs out$")
	public void click_on_Ok_and_logs_out()  {
	    
		WebDriverWait wait2= new WebDriverWait(driver, 300);
		if(wait2.until(ExpectedConditions.alertIsPresent())==null)
		{
			System.out.println("Amount didn't payed");
			driver.switchTo().alert().dismiss();
		}
		else
		{
			System.out.println("Amount payed");
		    driver.switchTo().alert().accept();
		}
		
		driver.findElement(By.xpath("//li[@class='menu lastMenuHover']//span[@class='menuText']")).click();
		
		WebDriverWait wait3= new WebDriverWait(driver, 300);
		if(wait3.until(ExpectedConditions.alertIsPresent())==null)
		{
			System.out.println("Didn't logged out");
			driver.switchTo().alert().dismiss();
		}
		else
		{
			System.out.println("Logged out");
		    driver.switchTo().alert().accept();
		}
		
	}

	@Then("^Admin logs into his account and can see pending loans$")
	public void admin_logs_into_his_account_and_can_see_pending_loans()  {
		
		 driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		  driver.findElement(By.xpath("//input[@value='1']")).click();
		  driver.findElement(By.xpath("//input[@value='2']")).click();
		  driver.findElement(By.xpath("//input[@value='3']")).click();
		  driver.findElement(By.xpath("//input[@value='4']")).click();
		 		  
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
		  
		  driver.findElement(By.xpath("//li[@id='menu0']//span[2]")).click();
			driver.findElement(By.id("memberUsername")).sendKeys("manzoor");
			driver.findElement(By.id("memberName")).sendKeys("manzoor");
		  
			driver.findElement(By.xpath("//input[@linkurl='searchLoans?memberId=9']")).click();
			boolean b=driver.findElement(By.xpath("//tbody//tr//td[@class='tdHeaderTable']")).isDisplayed();
			if(b==true){
				System.out.println("Admin login successful");
			}
			else{
				System.out.println("Admin login failed");
			}
			driver.close();
	    
	}

}
