package Vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class ContactsTestng extends BaseClass {
	WebDriverUtil wutil = new WebDriverUtil();
	PropertyFileUtil putil = new PropertyFileUtil();
	ExcelUtil eutil = new ExcelUtil();
	
	WebDriver driver;
	
	@Test
	public void ContactsTest() throws IOException, InterruptedException {
		
		//To Launch empty browser
	/*	WebDriver driver = new ChromeDriver();
		//To maximize the browser window
		wutil.maximize(driver);
		//To apply implicit wait for findelement()
		wutil.implicitwait(driver);
		
		//To read data from Property File
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		*/
		//To read data from Excel File
		String FIRSTNAME = eutil.getDataFromExcel("Contacts", 0, 1);
		String LASTNAME = eutil.getDataFromExcel("Contacts", 1, 1);
		String GROUP = eutil.getDataFromExcel("Contacts", 2, 1);
		String ORGNAME = eutil.getDataFromExcel("Contacts", 3, 1);
		
		
		
		
		//To launch application
	/*	driver.get(URL);
		
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		*/
		
		//To Click on Contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//To Click on Create Contacts..(+)
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		//Enter Firstname
		driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		
		//Enter LastName
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//To fail the testscript
		String actualurl = driver.getCurrentUrl();
		String expectedurl="http://localhost:8888/pune/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
		Assert.assertEquals(actualurl, expectedurl);
		
		//Click Group radio button
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//In dropdown select Team selling
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wutil.handledropdown(dropdown, GROUP);

		//Click on select(+)in Organization Name text feild
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//Transfer the driver control from Parent window to Child Window
		wutil.switchwindow(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		

		//To Enter Organization name in searchtf
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		
		//To Click on search now button
		driver.findElement(By.name("search")).click();
		
		//Click on Organization name
		driver.findElement(By.xpath("//a[text()='Intel']")).click();
	
	//To Transfer control from Child window to Parent window
		wutil.switchwindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		//Click on Save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	
		Thread.sleep(2000);
		
		//To Take screenshot of contact
		//wutil.screenshot(driver, "Contact");
		
		Thread.sleep(2000);
		
		//Mousehover on image
	/*	WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mousehover(driver, image);
		
		//Click on Signout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	*/
	
	}
}
