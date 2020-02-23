package Step_Definition;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DIV_TC_MEDIUM {
public WebDriver driver;
	
	
	@Given("^as an member$")
	public void as_an_member()  {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.43.54:8585/");

		driver.findElement(By.id("cyclosUsername")).sendKeys("divya98");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
		driver.findElement(By.xpath("//input[@value='5']")).click();
		driver.findElement(By.xpath("//input[@value='6']")).click();
		driver.findElement(By.xpath("//input[@value='7']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	   
	}

	@When("^Click on Account tab upon select system payment link$")
	public void click_on_Account_tab_upon_select_system_payment_link() throws InterruptedException  {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@id='menu2']//span[@class='menuText']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@id='submenu2.5']//span[@class='subMenuText']")).click();
	    
	}

	@When("^Valid credentials in Amount textbox,Transaction type and Description textbox are entered and selected$")
	public void valid_credentials_in_Amount_textbox_Transaction_type_and_Description_textbox_are_entered_and_selected() {
		driver.findElement(By.id("amount")).sendKeys("5430");
		WebElement ng=driver.findElement(By.id("type"));
		Select sel=new Select(ng);
		sel.selectByVisibleText("Member to community"); 
		driver.findElement(By.id("description")).sendKeys("loan");
		
	}

	@When("^Click on submit button and Account Information link$")
	public void click_on_submit_button_and_Account_Information_link()  {
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	}

	@Then("^A popup must be displayed \"([^\"]*)\"$")
	public void a_popup_must_be_displayed(String arg1) throws InterruptedException  {
		boolean b1=driver.findElement(By.xpath("//tbody/tr[2]/td/table/tbody/tr[1]/td")).isDisplayed();
		System.out.println(b1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.findElement(By.xpath("//li[@id='submenu2.0']//span[@class='subMenuText']")).click();
		   
		   
		   String expected="Account balance";
		   String actual = driver.findElement(By.xpath("//td[@class='headerLabel']")).getText();
	     assertEquals(expected, actual);
	     System.out.println("Page loaded Sucessful");
	     driver.close();
	}

}
