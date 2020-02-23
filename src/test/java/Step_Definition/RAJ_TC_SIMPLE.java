package Step_Definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RAJ_TC_SIMPLE {

	WebDriver driver;
	
	@Given("^for an application$")
	public void for_an_application() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8585");
	}

	@When("^admin have already valid credential\\.$")
	public void admin_have_already_valid_credential(){
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
		//driver.findElement(By.xpath("//input[@value='Submit']")).click();

	}

	@Then("^submit the button$")
	public void submit_the_button() {
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.close();
		System.out.println("Home page ");
	
	}
	
	
	
}
