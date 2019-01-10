package com.Catalog.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Catalog.qa.CommonMethod.CommonMethod;

public class SignInPage {
	private WebDriver driver;
	public CommonMethod CM;
	
	  @FindBy(how = How.LINK_TEXT, using = "log yourself in")
	  private WebElement LOGYOURSELFIN;
	  
	  @FindBy(how=How.NAME, using="email_address")
	  private WebElement EMAILADDRESS;
	  
	  @FindBy(how=How.NAME, using="password")
	  private WebElement PWD;
	  
	  @FindBy(how=How.XPATH, using="//*[@id='tdb5']/span[2]")
	  private WebElement SIGNIN;
	  	  
	  public SignInPage(WebDriver driver){
			this.driver = driver;
			CM = new CommonMethod();
			this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Loading SIgnIN page..."); 
			PageFactory.initElements(this.driver, this);
	  }
	
		public void Login(String sUserNamae, String sPWD){
			CM.setValue(EMAILADDRESS,sUserNamae);
			CM.setValue(PWD,sPWD);  
			CM.click(SIGNIN);
		}
}

