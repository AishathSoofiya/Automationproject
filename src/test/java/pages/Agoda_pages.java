package pages;

import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


public class Agoda_pages {
	WebDriver driver;
	By logo= By.xpath("//*[@id=\"page-header\"]/section/div[1]/nav/div[1]/a/div/div/div/img");
	By signin= By.xpath("//*[@id=\"page-header\"]/section/div[2]/div[1]/div[1]/div[2]/button/div/div/span");
	By createaccount=By.xpath("//*[@id=\"page-header\"]/section/div[2]/div[1]/div[1]/div[1]/button/div/div/span");

	
	By box=By.xpath("/html/body/div[12]/div[2]/div[3]/button[2]");
	By Firstname=By.xpath("//*[@id=\"firstName\"]");
	By Lastname=By.xpath("//*[@id=\"lastName\"]");
	By Email=By.xpath("//*[@id=\"email\"]");
	By password=By.xpath("//*[@id=\"password\"]");
	By confirmpassword=By.xpath("//*[@id=\"confirmPassword\"]");
	By signup=By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/form/div/div[7]");
	
	By account= By.xpath("//*[@id=\"page-header\"]/section/div[2]/div[3]/div/button/div/div/h1");
	By signout=By.xpath("/html/body/div[15]/div/div/div[3]/div/button/div/div/p");
	
	By loginsignin=By.xpath("//*[@id=\"page-header\"]/section/div[2]/div[1]/div[1]/div[2]/button/div/div/span");
	By loginemail=By.xpath("//*[@id=\"email\"]");
	By loginpsswd=By.xpath("//*[@id=\"password\"]");
	By signinbtn=By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/form/div[1]/div[3]/button/div");
	
	By privatestays=By.xpath("//*[@id=\"tab-home\"]/div/div/h6");
	By destination=By.xpath("//*[@id=\"textInput\"]");
	By place=By.xpath("//*[@id=\"destination_suggestion_card\"]");
	By month1=By.xpath("//*[@id=\"check-in-box\"]/div/div/div/div[1]");
	By day1=By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/div[5]/div/div/div[1]/div/div/div[2]/div[1]/div[3]/div[3]/div[5]/span");
	By nextmonth=By.xpath("//*[@id=\"check-out-box\"]/div/div/div/div[1]");
	By day2=By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/div[5]/div/div/div[1]/div/div/div[2]/div[2]/div[3]/div[2]/div[3]");
	By people=By.xpath("//*[@id=\"occupancy-box\"]/div/div/div/div[1]");
	By adult=By.xpath("//*[@id=\"occupancy-selector\"]/div/div/div/div[1]/div[2]/button[2]");
	By children=By.xpath("//*[@id=\"occupancy-selector\"]/div/div/div[1]/div[2]/div[2]/button[2]");
	By childage=By.xpath("//*[@id=\"occupancy-selector\"]/div/div/div[2]/ul/div/li/div/select");
	By search=By.xpath("//*[@id=\"Tabs-Container\"]/button");
	By warning=By.xpath("//*[@id=\"occupancy-selector\"]/div/div/div[2]/div/div/div/div/span/span");
	By cart=By.xpath("//*[@id=\"page-header\"]/section/div[2]/div[2]/div/div/button/div/div/div/div/svg");
	By activities=By.xpath("//*[@id=\"tab-activities-tab\"]/div[2]/div/h6");
	By airporttransfer=By.xpath("//*[@id=\"tab-journey-tab\"]/div[2]/div[1]/h6");
	By couponsanddeals=By.xpath("//*[@id=\"7b1d66df275b1\"]/div[8]/div/a/span");
	
	//------------------constructor-------------------
	
	public Agoda_pages(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//-------------------Link validation--------------
	
	public void linkvalidation() throws Exception
	{
		String baseurl="https://www.agoda.com/en-in/?ds=BqgEiYLSR06m3CXk";
		driver.get(baseurl);
		URL ob=new URL(baseurl);
		HttpURLConnection con=(HttpURLConnection)ob.openConnection();
		con.connect();
		
		if(con.getResponseCode()==200)
		{
			System.out.println("valid url :" +baseurl);
		}
		else
		{
			System.out.println("invalid url :" +baseurl);
		}
	}
	
	//--------------------Title verification------------------
	
	public void titleverification()
	{
		String actualtitle=driver.getTitle();
		String expectedtitle="Agoda Official Site|Free Cancellation & Booking Deals|Over 2 Million Hotels";
		if(actualtitle.equals(expectedtitle))
		{
			System.out.println("Title Verified");
		}
		else
		{
			System.out.println("Title not verified");
		}
	}
	
	//------------------Content verification---------------------
	
	public void contentverification()
	{
		String content=driver.getPageSource();
		if(content.contains("Activities"))
		{
			System.out.println("Content Verified");
		}
		else
		{
			System.out.println("Content not verified");
		}
	}
	
	//-------------------Logo is present or not------------------
	
	public void logo()
	{
		
	   WebElement logo1=driver.findElement(logo);
	   if(logo1.isDisplayed())
	   {
		 System.out.println("Logo is present");
	   }
	   else
	   {
		 System.out.println("Logo is not present");
	   }
	}
	
	//--------------------Screenshot-----------------------------
	
	public void screen() throws Exception
	{
		System.out.println("---------------screenshot------------");
		File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1,new File("C:\\screenshots\\agoda.png"));
	}
	
	//--------------------Registration---------------------------
	
	public void register() throws Exception 
	{
	driver.findElement(box).click();
	Thread.sleep(5000);
    driver.findElement (createaccount).click();
   // Thread.sleep(20000);
   //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
   // Thread.sleep(10000);
   
	driver.findElement(Firstname).sendKeys("Hanna");
    driver.findElement(Lastname).sendKeys("Shajahan"); 
	driver.findElement(Email).sendKeys("ayshushenna@gmail.com");
    driver.findElement(password).sendKeys("Hannas7736");
    driver.findElement(confirmpassword).sendKeys("Hannas7736");

	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)", "");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.findElement(signup).click();

	
	//------------------------Sign out--------------------------
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(account).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(signout).click();
	}

	
	//------------------------Login------------------------------
	
	public void login() throws Exception
	{
	driver.findElement(box).click();
	driver.findElement(loginsignin).click();
    Thread.sleep(10000);


	File f=new File("C:\\Users\\aysha\\OneDrive\\Documents\\Projectdatadriven.xlsx");
    FileInputStream fi=new FileInputStream(f);
    XSSFWorkbook re=new XSSFWorkbook(fi);
    XSSFSheet sh=re.getSheet("Sheet1");
    System.out.println("last row number: "+sh.getLastRowNum());

    for(int i=1;i<=sh.getLastRowNum()-1;i++)
	{

	String Email=sh.getRow(i).getCell(0).getStringCellValue();
    String Password=sh.getRow(i).getCell(1).getStringCellValue();

	driver.findElement(loginemail).clear();
    driver.findElement(loginemail).sendKeys (Email);
    Thread.sleep(2000);
    System.out.println("email: "+Email);
    driver.findElement(loginpsswd).clear();
    driver.findElement(loginpsswd).sendKeys(Password);
    Thread.sleep(2000);
    System.out.println("password:" +Password);
    driver.findElement(signinbtn).click();
    Thread.sleep(2000);
    }
    System.out.println("Login Successful");
	}
	
	
//----------------------------Window Handling----------------------------
public void windowhandling() 
	{ 
		String parentwindow=driver.getWindowHandle();
		System.out.print("parentwindow : " +driver.getTitle());
		driver.findElement(couponsanddeals).click(); 
		//Set<String> allWindowHandle=driver.getWindowHandles(); 
		Set<String> allwindowhandles=driver.getWindowHandles();
		for(String handle:allwindowhandles)
		{
			System.out.println(handle); 
			if(!handle.equalsIgnoreCase(parentwindow))
			{ 
				driver.switchTo().window(handle);
				driver.findElement(privatestays).sendKeys("Charminar",Keys.ENTER);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				driver.close(); 
			}
			    driver.switchTo().window(parentwindow); 
		}
		 
	} 
	
//---------------------------Booking----------------------------------

public void booking()
{
    driver.findElement(privatestays).click();
    driver.findElement (destination).sendKeys("mumbai");
    driver.findElement(place).click();
    driver.findElement(month1).click();
    driver.findElement(day1).click();
    driver.findElement(nextmonth).click();
    driver.findElement(day2).click();
   
    while(true)
    {

    WebElement month=driver.findElement(month1);
    String month2=month.getText();

    System.out.println(month2);

    if(month2.equals("March 2024"))
    {
     System.out.println(month2);
     break;
    }
    else
    {
    driver.findElement(nextmonth);
    } 
    }
    List<WebElement>thedate1=driver.findElements(day2);
    System.out.println(thedate1);
    for(WebElement dateelement1:thedate1) {

    String dates=dateelement1.getText();

    System.out.println(dates);
    if(dates.equals("25"))
     {
      System.out.println(dates);
      dateelement1.click();
      System.out.println("selected date");
      break;
    }
    

driver.findElement(cart).click();
driver.navigate().back();
driver.findElement(activities).click();
driver.navigate().back();
driver.findElement(airporttransfer).click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
driver.navigate().back();
driver.findElement(signin).click(); 
driver.findElement(signout).click();
driver.quit();
driver.close();
      }
  }

}



