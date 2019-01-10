package com.Catalog.qa.CommonMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.Catalog.qa.util.WebEventListener;

public class CommonMethod {
	private  WebDriver driver;
	Logger logger;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistner;
	
	public WebDriver openBrowser(String sBrowserType){
		 logger = Logger.getLogger("devpinoyLogger");
		 logger.debug("Starting od Selenium tests");
		 //logger.debug("Google Chrome browser Opens");
		 //logger.debug("Google Chrome browser Navigation");
		 File file= new File("C:\\Users\\Admin\\eclipse-workspace\\MavenDemoTest\\src\\main\\java\\com\\Catalog\\qa\\config\\Config.Properties");
			FileInputStream fileInput=null;
			try {
				fileInput=new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Properties prop = new Properties();
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		if (sBrowserType.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));
			driver=new ChromeDriver();
			System.out.println("OPeninng the chrome");
			logger.debug("Google Chrome browser Opens");
			logger.debug("Google Chrome browser Navigation");
			
		}else if(sBrowserType.equalsIgnoreCase("FireFox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\driver\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get(prop.getProperty("url"));
			System.out.println("Opening the Firefox");
		}else{
			Assert.fail("Please select browser");
		}
		e_driver=new EventFiringWebDriver(driver);
		eventlistner=new WebEventListener();
		driver=e_driver;
			//driver.manage().deleteAllCookies();    
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	        driver.manage().window().maximize();  
	        return driver;
		
	}
	
	public void closeBrowser(){
		driver.quit();
		System.out.println("close browser");
	}
	
	public void openUrl(String sURL){
		driver.get(sURL);
		System.out.println("Opening the URL");
	}
	
	
	public void setValue(WebElement slocator,String sValue){
		String Element=slocator.getText();
		try {	
			System.out.println(Element + "trying to set the value");
			slocator.clear();
			slocator.sendKeys(sValue);
			System.out.println(sValue + " entered");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(Element + "field not found");
		}
	}
	
	public void click(WebElement slocator){
		try {
			
			String Element=slocator.getText();
			if ((Element.isEmpty()) || (Element==null)){
				Element=slocator.getAttribute("value");
			}
			System.out.println(Element + " trying to click");

			slocator.click();
			System.out.println(Element + " clicked ");
			
			//acceptPopup();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(slocator + " not clicked ");
		}
	}
	

}



