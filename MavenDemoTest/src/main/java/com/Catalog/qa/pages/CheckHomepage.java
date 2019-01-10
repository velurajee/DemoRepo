package com.Catalog.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Catalog.qa.CommonMethod.CommonMethod;

public class CheckHomepage {

	private WebDriver driver;
	public CommonMethod Cm;
	
	@FindBy(xpath= "//*[@id=\"storeLogo\"]/a/img")
	 private WebElement Logo;
	
	@FindBy(xpath= "//*[@id=\"tdb1\"]/span[2]")
	private WebElement Cartcontents;
	
	@FindBy(xpath="//*[@id=\"tdb2\"]/span[2]")
	private WebElement Checkout;
	
	@FindBy(xpath="//*[@id=\"tdb3\"]/span[2]")
	private WebElement Myaccount;
	
	@FindBy(xpath="//*[@id=\"columnLeft\"]/div[1]/div[1]")
	private WebElement categories;
	
	@FindBy(xpath="//*[@id=\"columnRight\"]/div[1]/div[1]/a")
	private WebElement Shoppingcart;
	
	//@FindBy(xpath="//*[@id=\"columnLeft\"]/div[2]/div[2]/form/select")
	//private WebElement Dropdown;
	
	@FindBy(xpath="//*[@id=\"tdb4\"]/span[2]")
	private WebElement Courageunderfire;
	
	@FindBy(xpath="//*[@id=\"tdb5\"]/span[2]")
	private WebElement checkout;
	
	@FindBy(name="email_address")
	private WebElement emailaddress;
	
	@FindBy(name="password")
	private WebElement pwd;
	
	@FindBy(xpath="//*[@id=\"tdb5\"]/span[2]")
	private WebElement sign;
	
	
	@FindBy(xpath="//*[@id=\"tdb6\"]/span[2]")
	private WebElement continuebutton;
	
	@FindBy(name="payment")
	private WebElement paypal;
	
	@FindBy(xpath="//*[@id=\"tdb6\"]/span[2]")
	private WebElement button;
	

	public CheckHomepage (WebDriver driver) {
		this.driver = driver;
		Cm = new CommonMethod();
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Loading SIgnIN page..."); 
		PageFactory.initElements(this.driver, this);
  }

public void verifylogo( String name) {
	String ActualText= Logo.getText();
	System.out.println("ExpectedText="+name+"\n"+"ActualText="+ActualText);
	Assert.assertEquals(name.trim(),ActualText.trim());
	
}
public void CheckCartcontents() {
	Cm.click(Cartcontents);
	
}


public void ClickCheckout() {
	Cm.click(Checkout);
	
}

public void ClickMyaccount() {
	Cm.click(Myaccount);
	
}

public void verifycategories( String name4) {
	String ActualText= categories.getText();
	System.out.println("ExpectedText="+name4+"\n"+"ActualText="+ActualText);
	Assert.assertEquals(name4.trim(),ActualText.trim());
	
}
	
	
public void verifyShopppingcart( String name5) {
	String ActualText= Shoppingcart.getText();
	System.out.println("ExpectedText="+name5+"\n"+"ActualText="+ActualText);
	Assert.assertEquals(name5.trim(),ActualText.trim());
}
/*public void clickShoppingcart() {
	Cm.click(Shoppingcart);
}*/

	

public void countryDetail ( String name) {
	Select select= new Select(driver.findElement(By.xpath("//*[@id=\"columnLeft\"]/div[2]/div[2]/form/select")));
	//Select select= new Select(driver.findElement(By.name("country")));
	select.selectByVisibleText(name);
}

public void clickBuynow() {
	Cm.click(Courageunderfire);
}
public void clickcheckout() {
	Cm.click(checkout);
}

public void enteremailaddress(String id, String spwd) {
	Cm.setValue(emailaddress, id);
	Cm.setValue(pwd, spwd);
}
	public void clicksingin() {
	Cm.click(sign);
	}
	public void clickcontinuebutton() {
		Cm.click(continuebutton);
	}
	public void clickpaypal() {
		
	Cm.click(paypal);
	}
	public void clickbutton() {
	Cm.click(button);
}
	
}


