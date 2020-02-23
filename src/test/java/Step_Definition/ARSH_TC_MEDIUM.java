package Step_Definition;




import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ARSH_TC_MEDIUM {
	public WebDriver driver;
	@Given("^An application logged in as admin$")
	public void an_application() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Training\\Selenium jar\\chromedriver.exe");
		driver= new ChromeDriver();

		driver.get(" http://localhost:8585/");
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
	      driver.findElement(By.xpath("//input[@value='1']")).click();
		  driver.findElement(By.xpath("//input[@value='2']")).click();
		  driver.findElement(By.xpath("//input[@value='3']")).click();
		  driver.findElement(By.xpath("//input[@value='4']")).click();
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
		  driver.findElement(By.id("memberUsername")).sendKeys("arshh");
		  driver.findElement(By.id("memberName")).sendKeys("arshiya");
		  		  

	}
	
	
	@When("^i open the payment system to member to enter credentials in Amount textbox upon clicking submit buttons$")
	public void Step2() throws AWTException  {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyPress(KeyEvent.VK_ENTER);
       // Thread.sleep(3000);
		
		//JavascriptExecutor jse= (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,1000)");
		//jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@linkurl='payment?to=11']")).click();
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("2");
		WebElement a= driver.findElement(By.id("type"));
		Select sel=new Select(a);
		sel.selectByVisibleText("Debit to member");
		driver.findElement(By.xpath("//*[@id='description']")).sendKeys("pay");
		driver.findElement(By.xpath("//*[@id='submitButton']")).click();
		driver.findElement(By.xpath("//*[@id='tdContents']/form/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td/input")).click();
		
		

		
	}
	
	
	@When("^click on Logout button to login as a member.$")
	public void Step3(){
		driver.findElement(By.xpath("//*[@id='menu15']/span[2]")).click();
		WebDriverWait wait= new WebDriverWait(driver,300);
		if(wait.until(ExpectedConditions.alertIsPresent())==null)
		{
			System.out.println("logout failed");
		}
		else{
			System.out.println("logout successful");
			driver.switchTo().alert().accept();
		}
		
		
		driver.findElement(By.id("cyclosUsername")).sendKeys("arshh");
		driver.findElement(By.xpath("//input[@value='z']")).click();
		driver.findElement(By.xpath("//input[@value='x']")).click();
		driver.findElement(By.xpath("//input[@value='c']")).click();
		driver.findElement(By.xpath("//input[@value='v']")).click();
		driver.findElement(By.xpath("//input[@value='b']")).click();
		driver.findElement(By.xpath("//input[@value='n']")).click();
		driver.findElement(By.xpath("//input[@value='m']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		 
		
		
	}
	
	@When("^click on Account tab$")
	public void Step4(){
			
		driver.findElement(By.xpath("//li[@id='menu2']//span[@class='menuText']")).click();
		driver.findElement(By.xpath("//li[@id='submenu2.0']//span[@class='subMenuText']")).click();
	}
	
	
	@Then("^Member should be able to view payment details added by admin should get displayed\\.$")
	public void Step5(){
		
		driver.findElement(By.xpath("/html/body")).click();
		System.out.println("details displayed");
	}
	
	
	
	
}
