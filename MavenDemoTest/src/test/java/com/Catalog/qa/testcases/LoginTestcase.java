package com.Catalog.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Catalog.qa.CommonMethod.CommonMethod;
import com.Catalog.qa.pages.AddToCart;
import com.Catalog.qa.pages.CheckHomepage;
import com.Catalog.qa.pages.CreateanAccount;
import com.Catalog.qa.pages.Homepage;
import com.Catalog.qa.pages.SignInPage;
import com.Catalog.qa.util.TestUtil;

public class LoginTestcase {
	private WebDriver driver;
	public String sURL="http://107.170.213.234/catalog/";
	public CommonMethod CM;
	
	@Parameters("browserName")
	@BeforeMethod
		public void setUp(String browserName) {
System.out.println("Browser name is :" + browserName);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Software testing Assignments\\Selenium\\Drivers\\chromedriver\\chromedriver.exe");
			 driver=new ChromeDriver();
		}	
if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver","C:\\Software testing Assignments\\Selenium\\Drivers\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			 driver=new FirefoxDriver();
		
	}

		
		CM=new CommonMethod();
		driver=CM.openBrowser("Chrome");
		CM.openUrl(sURL);
}
	

  @DataProvider
	public Object[][] getcatalogdata() {
	String sheetname="login";
		Object data[][]= TestUtil.gettestdata(sheetname);
		return data;
	}
	
	@Test(priority=1,dataProvider="getcatalogdata")
	public void testcase01( String emailid, String pwd ) {
		//Click log your self link
		//driver.findElement(By.linkText("log yourself in")).click();
		Homepage WP=new Homepage(driver);
			WP.clickYourSelfLink();
			SignInPage SI=new SignInPage(driver);
			//SI.Login("ecalix@test.com","test123");
			SI.Login(emailid, pwd);
			WP.verifyHeader("Welcome to iBusiness");
			WP.Logoff();
	}
	@DataProvider
	public Object[][] getcreatanaccountdata() {
		String sheetname="ca";
		Object data[][]= TestUtil.gettestdata(sheetname);
		return data;
}

	@Test(priority=2,dataProvider="getcreatanaccountdata")
//	public void testcase02(String gender, String firstname, String lastname, String dateofbirth, String emailadress, String streetaddress, String postcode, String city, String state, String country, String telephonenumber, String faxnumber,String password, String passwordconfirmation ) {
public void testcase02(String gender, String firstname, String lastname, String dateofbirth, String emailadress, String streetaddress, String postcode, String city, String state, String country, String telephonenumber, String faxnumber,String password, String passwordconfirmation) {

		CreateanAccount CA=new CreateanAccount( driver);
				CA.clickcreateanaccount();
				//CA.Gender();
		
	//CA.personalDetail("Rajee", "Thambi", "04/09/2000", "velu.rajee@gmail.com");
				CA.personalDetail(firstname, lastname, dateofbirth, emailadress);
	//CA.addressDetail("scodfield", "94568", "Dublin", "CA");
			    CA.addressDetail(streetaddress, postcode, city, state);
	//CA.countryDetail("United States");
				//CA.countryDetail(country);
	//CA.contactDetail("000-000-789", "rajee", "ra");
				CA.contactDetail(telephonenumber, password, passwordconfirmation);
				CA.clickcontinue();
	}
	
	
	

	@Test(priority=3)
	public void testcase03( ) {
		
			AddToCart AD= new AddToCart( driver);
			 // AD.clickSamungTab();
			// AD.updateCart("Samsung Galaxy Tab");
			 AD.clickSamungTab();
			 AD.clickAddtocart();		 
			 new Homepage(driver);
			 AD.clickMicrosoftmouse();
			 AD.clickAddtocart();
		}
			 @Test(priority=4)
			 public void testcase04(){
			AddToCart AD= new AddToCart( driver);
			 new Homepage(driver);   
			 AD.clickMicrosoftkeyboard();
			 AD.clickAddtocart();
			 }
			 
			 @Test(priority=5)
			 public void testcase05() {
			AddToCart AD= new AddToCart( driver);	 
			 new Homepage(driver);
			 AD.clickHewlett();
			 AD.clickAddtocart();
			 }
			 
			 @Test(priority=6)
			 public void testcase06() {
			 AddToCart AD= new AddToCart( driver);
			 new Homepage(driver);
			 AD.clickDisciples();
			 AD.clickAddtocart();
			 }
			 
			 @Test(priority=7)
			 public void testcase07() {
			 AddToCart AD= new AddToCart( driver);
			 new Homepage(driver);
			 AD.clickSwat3close();
			 AD.clickAddtocart();
			 }
			 
			 @Test(priority=8)
			 public void testcase08(){
			 AddToCart AD= new AddToCart( driver);
			 new Homepage(driver);
			 AD.clickTheWheeloftime();
			 AD.clickAddtocart();
			 }
			 
			 @Test(priority=9)
			 public void testcase09() {
			 AddToCart AD= new AddToCart( driver);
			 new Homepage(driver);
			 AD.clickUnrealtournament();
			 AD.clickAddtocart();
			 
			 }
			 @Test(priority=10)
			 public void testcase10() {
			AddToCart AD= new AddToCart( driver);
			 new Homepage(driver);
			 AD.clickbeloved();
			 AD.clickAddtocart();
			 
		} 
	
	
    @Test(priority=11)
	public void testcase11() {
		CheckHomepage CH= new CheckHomepage(driver);
		CH.verifylogo("Oscommerce");
	}
		@Test(priority=12)
		public void testcase12() {
			CheckHomepage CH= new CheckHomepage(driver);		
		CH.ClickCheckout();
		CH.CheckCartcontents();
		CH.ClickMyaccount();
		CH.verifycategories("Categories");
		CH.verifyShopppingcart("Shopping Cart");
		//CH.clickShoppingcart();
			
		}
			@Test(priority=13)
			public void testcase13() {
				CheckHomepage CH= new CheckHomepage(driver);
			
		CH.countryDetail("Fox");
		CH.clickBuynow();
		CH.ClickCheckout();
		CH.enteremailaddress("ecalix@test.com", "test123");
		CH.clicksingin();
		CH.clickcontinuebutton();
		CH.clickpaypal();
		CH.clickbutton();
		}
		
	
	
	@AfterMethod
	public void tearDown()  {
		CM.closeBrowser();
	}

}



