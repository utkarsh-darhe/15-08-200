package com.pritamecom.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;  //*to import all annotation pcakages
import com.pritamecom.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  //we create all reusable methods here
{	
	//So, we create object of ReadConfig class here
	ReadConfig readconfig = new ReadConfig();

	//So, we have to store both the variables in readconfig class here, so we will create string variable for that
	String url = readconfig.getBaseUrl(); //we create method in ReadConfig of getBaseUrl(), thus we read url here by calling that method here & store it in the url variable

	//like this we will store browser value too
	String browser = readconfig.getBrowser();

	//now we create setup method to launch the browser based on which value we get in browser like chrome/firefox/IE/etc.
	public static WebDriver driver;  //cretated static object of webdriver
	public static Logger logger;

	@BeforeClass  //we have to launch browser in the start, so we using @BeforeClass annotation
	public void setup()
	{

		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		default:
			driver = null;
			break;

		}

		//immplicit wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		//for logging purpose we have to create variable of loggerclass(created below webdriver)
		logger = LogManager.getLogger("com.pritamecom");  //initialize the logger

		//launch url

		driver.get(url);    //we get url from the base class, where we creates url variable
		logger.info("url opened");  //we writ the info which we want to log
	}

	// creating tearDown() for quiting browser
	@AfterClass   //we have to launch quit in the end, so we using @AfterClass annotation
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

	//to capture screenshot
	public void captureScreenShot(WebDriver driver, String testName) throws IOException
	{
		//step1: convert ebdriver object to take screenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);

		//step2: call getScreenshotAs methode to create image file
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File desti = new File(System.getProperty("user.dir" + "\\Screenshots\\" + testName + ".png"));

		//step3: copy image file to destination
		FileUtils.copyFile(src, desti);
	}

}
