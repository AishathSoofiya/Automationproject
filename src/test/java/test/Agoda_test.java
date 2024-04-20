package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Agoda_pages;


public class Agoda_test {
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void urlload()
	{
		driver.get("https://www.agoda.com/en-in/?ds=BqgEiYLSR06m3CXk");
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws Exception
	{
		Agoda_pages ob=new Agoda_pages(driver);
		ob.titleverification();
		ob.contentverification();
		ob.logo();
		ob.screen(); 
		//ob.register();
		//ob.login();
		ob.linkvalidation();
		//ob.booking();
		//ob.windowhandling();
		
		}
}
