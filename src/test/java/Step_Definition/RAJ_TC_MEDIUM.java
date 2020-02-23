package Step_Definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RAJ_TC_MEDIUM {
public static WebDriver driver;
	
	@Given("^As an Admin.$")
	public void Login() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8585");
		driver.manage().window().maximize();
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
		driver.findElement(By.xpath("//input[@value='Submit']")).click();

	}

	@When("^enters  Member's valid credentials$")
	public void member_enters_his_valid_credentials() {
		driver.findElement(By.id("memberUsername")).sendKeys("vishmaja");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Thread.sleep(2000); working
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 200)");
		/*
		 * Robot robot=new Robot(); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyPress(KeyEvent.VK_ENTER);
		 */
		driver.findElement(By.xpath("//input[@linkurl='grantLoan?memberId=8']")).click();

	}

	@When("^Click on Submit button$")
	public void click_on_submit_button() {
		driver.findElement(By.id("amount")).sendKeys("1000");
		driver.findElement(By.id("description")).sendKeys("10000 rupees");

		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("^Loan details page displayed$")
	public void loan_details_page_displayed() {

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Alert al = driver.switchTo().alert();
		al.accept();

		driver.findElement(By.xpath("//input[@linkurl='searchLoans?memberId=8']")).click();

	}


}
