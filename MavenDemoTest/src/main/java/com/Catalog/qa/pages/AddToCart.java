package com.Catalog.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Catalog.qa.CommonMethod.CommonMethod;

public class AddToCart {
	private WebDriver driver;
	public CommonMethod Cm;
	
	@FindBy(how=How.LINK_TEXT, using="Samsung Galaxy Tab")
	private WebElement SamsungTab;
	
	@FindBy(how=How.LINK_TEXT, using="Hewlett Packard LaserJet 1100Xi")
	private WebElement Hewlett;
	
	@FindBy(how=How.LINK_TEXT, using="Microsoft IntelliMouse Explorer")
	private WebElement Microsoftmouse;
	
	@FindBy(how=How.LINK_TEXT, using="Microsoft Internet Keyboard PS/2")
	private WebElement Microsoftkeyboard;
	
	@FindBy(how=How.LINK_TEXT, using="Disciples: Sacred Lands")
	private WebElement Disciples;
	
	@FindBy(how=How.LINK_TEXT, using="The Wheel Of Time")
	private WebElement TheWheeloftime;
	
	@FindBy(how=How.LINK_TEXT, using="Unreal Tournament")
	private WebElement Unrealtournament;
	
	@FindBy(how=How.LINK_TEXT, using="SWAT 3: Close Quarters Battle")
	private WebElement Swat3close;
	
	@FindBy(how=How.LINK_TEXT, using="Beloved")
	private WebElement beloved;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tdb4\"]/span[2]")
	private WebElement AddtoCart;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/input[1]")
	private WebElement Textbox;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tdb4\"]/span[2]")
	private WebElement update;
	
	
	public AddToCart( WebDriver driver) {
	this.driver = driver;
	Cm = new CommonMethod();
	this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	System.out.println("Loading SIgnIN page..."); 
	PageFactory.initElements(this.driver, this);
}

		public void updateCart( String stext) {
		      	 String ActualText=SamsungTab.getText();
				  System.out.println("ExpectedText="+stext+"\n"+"ActualText="+ActualText);
				  Assert.assertEquals(stext.trim(),ActualText.trim());
		}

		public void clickSamungTab() {
			/*Cm.setValue(SamsungTab, Stab);
			//Cm.setValue(Hewlett, Lasserjet);
			//Cm.setValue(Microsoftmouse, Mmouse);
			//Cm.setValue(Microsoftkeyboard, Mkeyboard);
			//Cm.setValue(Disciples, Dsacredlands);
			//Cm.setValue(TheWheeloftime, wheeltime);
			Cm.setValue(Unrealtournament, Unrealtournment);
			Cm.setValue(Swat3close, Battle);
			Cm.setValue(beloved, Beloved);*/
			Cm.click(SamsungTab);
		}
		
		public void clickHewlett() {
			Cm.click(Hewlett);
		}
		
		public void clickMicrosoftmouse() {
		Cm.click(Microsoftmouse);
		}
	
		public void clickMicrosoftkeyboard() {
			Cm.click(Microsoftkeyboard);
		}
		
		public void clickDisciples() {
			Cm.click(Disciples);
		}
		public void clickTheWheeloftime() {
			Cm.click(TheWheeloftime);
		}
		public void clickUnrealtournament() {
			Cm.click(Unrealtournament);
		}
		public void clickSwat3close() {
			Cm.click(Swat3close);
		}
		
		public void clickbeloved() {
			Cm.click(beloved);
		}
		
		public void clickAddtocart() {
			Cm.click(AddtoCart);
			
		}
		
		}

