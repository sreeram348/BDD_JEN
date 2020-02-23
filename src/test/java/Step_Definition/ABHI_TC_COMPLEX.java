package Step_Definition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Cucumber.Transform.ExcelDataToDataTable2;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;

public class ABHI_TC_COMPLEX {
	public WebDriver driver;
	@Given("^Admin log in$")
	public void admin_log_in() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium triang\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
	    driver= new ChromeDriver();
	    driver.get(" http://192.168.43.205:8585/");
		driver.manage().window().maximize();
		driver.findElement(By.id("cyclosUsername")).sendKeys("admin");

		driver.findElement(By.id("cyclosPassword")).click();
		driver.findElement(By.xpath("//input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//input[@value='3']")).click();
		driver.findElement(By.xpath("//input[@value='4']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

	
	}
	

	@Given("^enters <name>,<group>,<comment> at \"([^\"]*)\"\\.$")
	public void enters_name_group_comment_at(@Transform(ExcelDataToDataTable2.class)DataTable table) throws Throwable {
List<String> dataList = new ArrayList<String>(table.asList(String.class));
		
		for(int i=0;i<dataList.size();i++){
			
		System.out.println(dataList.get(0));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("memberUsername")).sendKeys(dataList.get(i));
		i++;

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@id='tdContents']//table[1]//tbody//tr[2]//td//table//tbody//tr[2]//td//fieldset//table//tbody//tr[2]//td[4]//input[@type='button']")).click();
		WebElement wb=driver.findElement(By.xpath("//select[@name='newGroupId']"));
		Select s=new Select(wb);
		s.selectByVisibleText(dataList.get(i));
		i++;
		driver.findElement(By.xpath("//textarea[@name='comments']")).sendKeys(dataList.get(i));
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Alert al=driver.switchTo().alert();
		al.accept();
		driver.findElement(By.xpath("//span[@class='menuText']")).click();		
		boolean b=driver.findElement(By.xpath("//tbody//tr//td[@class='tdHeaderTable']")).isDisplayed();
		if(b==true){
			System.out.println("Access provided to user");
		}
		else{
			System.out.println("Access denied");
		}

		}
		
		
		driver.close();

	}

}
