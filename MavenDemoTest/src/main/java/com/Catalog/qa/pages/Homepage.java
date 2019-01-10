package com.Catalog.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Catalog.qa.CommonMethod.CommonMethod;

public class Homepage {
	private WebDriver driver;
	public CommonMethod CM;
	
	  @FindBy(how = How.LINK_TEXT, using = "log yourself in")
	  private WebElement LOGYOURSELFIN;
	  
	  @FindBy(how=How.XPATH, using="//*[@id='bodyContent']/h1")
	  private WebElement HEADER;
	  
	  @FindBy(how=How.XPATH, using="//*[@id='tdb4']/span")
	  private WebElement LOGOFF;
	  
	//  @FindBy(how=How.LINK_TEXT, using=" create an account?")
	 // private WebElement AccountCreation ;
	   
	public Homepage(WebDriver driver){
			this.driver = driver;
			CM = new CommonMethod();
			this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Loading WelcomePage page..."); 
			PageFactory.initElements(this.driver, this);
	  }
	  
	  public void clickYourSelfLink(){
			CM.click(LOGYOURSELFIN);

		}
	  
		public void Logoff(){
			CM.click(LOGOFF);
		}
		
		public void verifyHeader(String sText){
			
			 String ActualText=HEADER.getText();
			  System.out.println("ExpectedText="+sText+"\n"+"ActualText="+ActualText);
			  Assert.assertEquals(sText.trim(),ActualText.trim());
		}
		
}





