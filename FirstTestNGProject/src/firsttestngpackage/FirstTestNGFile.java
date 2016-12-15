/*
 * This is my first automation Selenium Webdriver-TestNG framework.
 * This test use Selenium Webdriver-TestNG frame work to run test module and create html reports
 * This test also uses @Dataprovider parameterize methods to pass parameters and run tests for multiple iterations
 */

package firsttestngpackage;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import org.testng.Assert;

import org.testng.annotations.*;

import utility.BrowserType;

import parameters.DataproviderClass;

import parameters.UserDataProvider;

public class FirstTestNGFile {
	
	public WebDriver driver;
	public String expected =null;	
	public String actual =null;
	WebElement element=null;
//Launch the test URL    
@BeforeTest	
public void setUp(){
	   driver = BrowserType.Execute();
}
//Verify the Home page details
@Test(priority=0)
  public void verifyHomepageTitle() {
	 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
     expected = "ONLINE STORE | Toolsqa Dummy Test site";
	 actual = driver.getTitle();
	 Assert.assertEquals(expected, actual);

  }
//Verify that new users can register
@Test(priority=1)
public void user_Register()
{	
	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	driver.findElement(By.linkText("Register")).click();
    expected = "ONLINE STORE � Registration Form";
	actual = driver.getTitle();
	Assert.assertEquals(expected, actual);
    
    try{
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
    }catch (Exception e){
		}
   
   
    Assert.assertNotNull(driver.findElement (By.partialLinkText("Back to ONLINE STORE")));
    driver.findElement (By.partialLinkText("Back to ONLINE STORE")).click();
    System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
}

// Verify valid user name and password tests

@Test(dataProvider="SearchProvider",dataProviderClass=DataproviderClass.class, priority=2)
public void valid_UserCredential(String user,String password) throws InterruptedException
     {
	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
    driver.findElement(By.xpath(".//*[@id='account']/a")).click();
    driver.findElement(By.id("log")).sendKeys(user);
    driver.findElement(By.id("pwd")).sendKeys(password);
    driver.findElement(By.id("login")).click();

    System.out.println("Welcome ->"+user+" Your password is->"+password);

    Thread.sleep(3000);

    //type user name and password

    String testAuthor = driver.findElement(By.id("log")).getAttribute("value");
    String testPassword = driver.findElement(By.id("pwd")).getAttribute("value");

    System.out.println(testAuthor +"::::"+user);

    //verify if the user name and password are correct ones
    Assert.assertTrue(testAuthor.equalsIgnoreCase(user));
    Assert.assertTrue(testPassword.equalsIgnoreCase(password));
    
    // clear the input fields
    driver.findElement(By.id("log")).clear();
    driver.findElement(By.id("pwd")).clear();

}

// Verify invalid user name and password test
@Test(dataProvider="UserProvider",dataProviderClass=UserDataProvider.class, priority=3)
public void invalid_UserCredential(String user,String password) throws InterruptedException
{	
	System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
    driver.findElement(By.xpath(".//*[@id='account']/a")).click();
    driver.findElement(By.id("log")).sendKeys(user);
    driver.findElement(By.id("pwd")).sendKeys(password);
    driver.findElement(By.id("login")).click();

    System.out.println("Welcome ->"+user+" Your password is->"+password);

    Thread.sleep(3000);

    //type user name and password

    String testAuthor = driver.findElement(By.id("log")).getAttribute("value");
    String testPassword = driver.findElement(By.id("pwd")).getAttribute("value");

    System.out.println(testAuthor +"::::"+user);


    //verify if the user name and password are correct ones
    Assert.assertTrue(testAuthor.equalsIgnoreCase(user));
    Assert.assertTrue(testPassword.equalsIgnoreCase(password));
    
    // clear the input fields
    driver.findElement(By.id("log")).clear();
    driver.findElement(By.id("pwd")).clear();
}
//Launch the test URL
@AfterTest
public void closeBrowser(){
	 driver.quit();
}


}
