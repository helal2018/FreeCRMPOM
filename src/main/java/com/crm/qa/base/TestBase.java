package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {


	
	public static WebDriver driver;

	public static Properties prop;

	public  static EventFiringWebDriver e_driver;

	public static WebEventListener eventListener;
	
	
	//Initialize prop inside the constructor class
	public TestBase() {
		
		try {

			prop = new Properties();

			FileInputStream ip = new FileInputStream("C:\\Users\\falga\\OneDrive\\Desktop\\JavaClass\\Eclipse\\Workspace\\POMModel\\src\\main\\java\\com\\crm\\qa\\config\\config. properties");

			prop.load(ip);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
	
	
	public static void initialization(){

		String browserName = prop.getProperty("browser");

		

		if(browserName.equals("chrome")){

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\falga\\OneDrive\\Desktop\\JavaClass\\Eclipse\\Workspace\\POMModel\\src\\main\\java\\driver\\chromedriver.exe");	

			driver = new ChromeDriver(); 

		}

		else if(browserName.equals("FF")){

			System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\falga\\\\OneDrive\\\\Desktop\\\\JavaClass\\\\Eclipse\\\\Workspace\\\\POMModel\\\\src\\\\main\\\\java\\\\driver\\\\chromedriver.exe");

			driver = new FirefoxDriver(); 

		}

		

		

		e_driver = new EventFiringWebDriver(driver);

		// Now create object of EventListerHandler to register it with EventFiringWebDriver

		eventListener = new WebEventListener();

		e_driver.register(eventListener);

		driver = e_driver;

		

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMOUT, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);

		

		driver.get(prop.getProperty("url"));

		

	}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

