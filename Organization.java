package Vtigercrm;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.ListenerImplementation;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;


@Listeners(ListenerImplementation.class)
public class Organization {

	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutil = new JavaUtil();
	
	@Test
	public void OrganizationTest() throws IOException, InterruptedException {
		
	WebDriver driver = new ChromeDriver();	
	//To maximize the window
	wutil.maximize(driver);
	//To apply wait for findelement()
	wutil.implicitwait(driver);
	
	//To read data from Property File
	String URL = putil.getDataFromPropertyFile("Url");
	String USERNAME =putil.getDataFromPropertyFile("Username");
	String PASSWORD = putil.getDataFromPropertyFile("Password");
	
	//To read data from Excel File
	String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
	String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);
	
	
	//To launch the application
	driver.get(URL);
	
	// Login to application 
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//Click on Organization
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	
	//Click on Create Organization..(+)
	driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
	
	//Enter Organization Name
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
	
	//In AssignedTo Click on Group
	driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	
	//In the dropdown select Support group
	WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
	wutil.handledropdown(dropdown, GROUP);
	
	//Click on Save Button
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	
	Thread.sleep(2000);
	
	//Mousehover on image
	WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	wutil.mousehover(driver, image);
	
	//Click on Signout
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	
	
	
	
	
	
	
	
	}
}
