package com.Catalog.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Catalog.qa.CommonMethod.CommonMethod;

public class CreateanAccount {
	private WebDriver driver;
	public CommonMethod Cm;
	
	
	@FindBy(how=How.LINK_TEXT, using="create an account")
	private WebElement Createanaccount;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[2]/table/tbody/tr[1]/td[1]")
	private WebElement Gender;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[2]/table/tbody/tr[1]/td[2]/input[2]")
	private WebElement Female;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[2]/table/tbody/tr[1]/td[2]/input[1]")
	private WebElement Male;
	
	@FindBy(how=How.NAME, using="firstname")
	private WebElement Firstname;
	
	@FindBy(how=How.NAME, using="lastname")
	private WebElement Lastname;
	
	@FindBy(how=How.NAME, using="dob")
	private WebElement Dateofbirth;
	
	@FindBy(how=How.NAME, using="email_address")
	private WebElement Emailaddress;
	
	@FindBy(how=How.NAME, using="company")
	private WebElement Companyname;
	
	@FindBy(how=How.NAME, using="street_address")
	private WebElement Streetaddress;
	
	@FindBy(how=How.NAME, using="suburb")
	private WebElement Subrub;
	
	@FindBy(how=How.NAME, using="postcode")
	private WebElement Postalcode;
	
	@FindBy(how=How.NAME, using="city")
	private WebElement City;
	
	@FindBy(how=How.NAME, using="state")
	private WebElement State;
	
	@FindBy(how=How.NAME, using="country")
	private WebElement Country;
	
	@FindBy(how=How.NAME, using="telephone")
	private WebElement Telephonenumber;
	
	@FindBy(how=How.NAME, using="fax")
	private WebElement Faxnumber;
	
	@FindBy(how=How.NAME, using="password")
	private WebElement password; 
	
	@FindBy(how=How.NAME, using="confirmation")
	private WebElement passwordconformation;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tdb4\"]/span[2]")
	private WebElement Continue;
	
	public CreateanAccount(WebDriver driver) {
		this.driver = driver;
		Cm = new CommonMethod();
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Loading SIgnIN page..."); 
		PageFactory.initElements(this.driver, this);
  }
	
	public void clickcreateanaccount() {
		Cm.click(Createanaccount);
	}
	
	public void clickcontinue() {
		Cm.click(Continue);
	}
	
	public void Gender( ) {
		//Cm.click(Gender);
		//Cm.click(Female);
		//Cm.click(Male);
	}
	
	public void personalDetail( String Fname, String Lname, String Dbirth, String Eaddress) {
		Cm.setValue(Firstname, Fname);
		Cm.setValue(Lastname, Lname);
		Cm.setValue(Dateofbirth, Dbirth);
		Cm.setValue(Emailaddress, Eaddress);	
		}
	
	public void addressDetail ( String saddress, String pcode, String Scity, String Cstate ) {
		Cm.setValue(Streetaddress, saddress);
		Cm.setValue(Postalcode, pcode);
		Cm.setValue(City, Scity);
		Cm.setValue(State, Cstate);
	}
	
	public void countryDetail ( String name) {
		//Select select= new Select(driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/form/div/div[4]/table/tbody/tr[6]/td[2]/select")));
		Select select= new Select(driver.findElement(By.name("country")));
		select.selectByVisibleText(name);	
	}
	
	public void contactDetail ( String Tnumber, String Pwd, String Cpwd) {
		Cm.setValue(Telephonenumber, Tnumber);
		Cm.setValue(password, Pwd);
		Cm.setValue(passwordconformation, Cpwd);	
	}
}
	


