package TestCasesForListener;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserLunch {
	
	
	WebDriver driver ;
	
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
			driver.quit();
	}
	
	@Test (priority = 1)
	public void testPassing() {
		
		String pageTitle = driver.getTitle();	
		
		Assert.assertEquals(pageTitle, "Your Store");
	}
	
	@Test(priority = 2)
	public void testPassing1()
	{
		String expectedPageName = driver.findElement(By.xpath("//span[text()='My Account']")).getText();
		String actualPageName ="My Account";
		Assert.assertEquals(actualPageName,expectedPageName);
	}
	
	@Test(priority = 3 )
	public void testFailing() {
		
		String expectedCurrency = driver.findElement(By.xpath("//span[text()='Currency']")).getText();
		Assert.assertEquals("curreency" , expectedCurrency, "Test got Failed");
	}
	
	@Test(priority = 4)
	public void testSkipping()
	{
		int a =5,b=4;
		if(a>b)
				throw new SkipException("Test Skipped");
	}
	
}
