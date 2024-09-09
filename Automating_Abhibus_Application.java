package abhi_bus_application;


import java.time.Duration;
import java.util.List;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automating_Abhibus_Application {
	WebDriver driver;
	String Abhibus_URL = "https://www.abhibus.com ";
	public void Application_Launch()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\pushpa\\Desktop\\java folder\\JavaNewProgramms\\browser files\\geckodriver.exe ");
		driver = new FirefoxDriver();
		driver.get(Abhibus_URL);
		driver.manage().window().maximize();
		
	}
	public void Validating_Title()
	{
		String expected_Title = "Book Bus Tickets Online at Lowest Fare, Upto ₹350 Cashback On Bus Booking | AbhiBus";
		System.out.println("The expected title is -"+expected_Title);
		
		String actual_Title = driver.getTitle();
		System.out.println("The Actual title is -"+actual_Title);
		
		if(expected_Title.equalsIgnoreCase(actual_Title))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
	}
	public void Validating_Links() 
	{
		////*[@id="header-container"]
		By AbhibusHeaderblockProperty = By.xpath("//*[@id=\"header-container\"]");
		WebElement AbhibusHeaderblock=driver.findElement(AbhibusHeaderblockProperty);
		
		By HeaderblocksLinksProperty = By.tagName("a");
		List<WebElement>HeaderBlockLinks=AbhibusHeaderblock.findElements(HeaderblocksLinksProperty);
		
		int AbhibusLinksCount = HeaderBlockLinks.size();
		System.out.println(AbhibusLinksCount);
		
		//Displying names of Header block
		for(int arrayIndex=0;arrayIndex<=AbhibusLinksCount;arrayIndex++)
		{
			String HeaderBlockLinkNames = HeaderBlockLinks.get(arrayIndex).getText();
			System.out.println(arrayIndex+"-"+HeaderBlockLinkNames );
			
			String expected_Link_URLs = HeaderBlockLinks.get(arrayIndex).getAttribute(HeaderBlockLinkNames);
			System.out.println("The expected link URL Address --"+expected_Link_URLs);
			
			//performing operation on links
			HeaderBlockLinks.get(arrayIndex).click();
			//once click operation will be done the webpage will be moved  to the corresponding next page
			String actual_WebpageTitle = driver.getTitle();
			System.out.println("The title of the navigated Webpage is--"+actual_WebpageTitle);
			
			String actual_WebpageCurrentURLAddress = driver.getCurrentUrl();
			System.out.println("The current URL address of the Navigated webpage is-"+actual_WebpageCurrentURLAddress);
			
			if(actual_WebpageCurrentURLAddress.equalsIgnoreCase(expected_Link_URLs))
			{
				System.out.println("Successfully Navigated to the Links related url address Webpage - PASS");
			}
			else
			{
				System.out.println("Failed to Navigated to the Links related url address Webpage - FAIL");
			}
			//once click operation is done on the WebElement - the driver focus is shifted
			driver.navigate().back();
			
			//since the driver focus is on the next webpage
			AbhibusHeaderblockProperty = By.xpath("//*[@id=\"header-container\"]");
		    AbhibusHeaderblock=driver.findElement(AbhibusHeaderblockProperty);
		    
		    HeaderblocksLinksProperty = By.tagName("a");
			HeaderBlockLinks=AbhibusHeaderblock.findElements(HeaderblocksLinksProperty);
			
			System.out.println();
			
			///html/body/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/span/svg/g/path[2]
			///html/body/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/span/svg
			///html/body/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[2]/div/div[2]/input
			//<div class="container  " style="flex-flow: wrap; place-content: flex-start space-between; align-items: center;"><h4 class="title">Login to AbhiBus</h4><span><svg xmlns="http://www.w3.org/2000/svg" width="1rem" height="1rem" viewBox="0 0 20.828 20.828"><g fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"><path d="m19.414 1.414-18 18" data-name="Line 50"></path><path d="m1.414 1.414 18 18" data-name="Line 51"></path></g></svg></span></div>
			
		}
	}
		public void Login()
		{
			///html/body/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/span/svg/g/path[2]
			///html/body/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/span/svg
			//driver.switchTo().window(Abhibus_URL);
			String str = driver.getWindowHandle();
			driver.switchTo().window(str);
			System.out.println(str);
			WebDriverWait wait = new WebDriverWait(driver,20);
			By Loginproperty = By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/span/svg");
			WebElement Login=driver.findElement(Loginproperty);
			Login.click();
		}
	
		
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Automating_Abhibus_Application AB = new Automating_Abhibus_Application();
		AB.Application_Launch();
		AB.Validating_Title();
		AB.Validating_Links();
		AB.Login();
		
	}

}
