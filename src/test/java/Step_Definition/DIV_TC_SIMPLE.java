package Step_Definition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class DIV_TC_SIMPLE {
	public WebDriver driver;

	@Given("^as an admin$")
	public void as_an_admin()  {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.43.54:8585/");

		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
	}

	@When("^Entering valid Credentials in Member Login Text box upon Click on submit button of change group Permission$")
	public void entering_valid_Credentials_in_Member_Login_Text_box_upon_Click_on_submit_button_of_change_group_Permission() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("memberUsername")).sendKeys("divya123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_DOWN);
		driver.findElement(By.xpath("//div[@id='tdContents']//table[1]//tbody//tr[2]//td//table//tbody//tr[2]//td//fieldset//table//tbody//tr[2]//td[2]//input[@type='button']")).click();

	}

	@When("^Click on new group list box to enter valid credential in comments text box upon$")
	public void click_on_new_group_list_box_to_enter_valid_credential_in_comments_text_box_upon() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ng=driver.findElement(By.xpath("//select[@name='newGroupId']"));
		Select sel=new Select(ng);
		sel.selectByVisibleText("Full members"); 
		
		driver.findElement(By.id("comments")).sendKeys("welcome");

	}

	@When("^click on submit$")
	public void click_on_submit() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Then("^A popup must displayed \"([^\"]*)\"$")
	public void a_popup_must_displayed(String arg1)  {
		
		Alert a =driver.switchTo().alert();
		a.accept(); 
		String expected="The member's group was changed";
		String actual=a.getText();
		Assert.assertEquals(expected, actual);
		driver.close();
	}


}
