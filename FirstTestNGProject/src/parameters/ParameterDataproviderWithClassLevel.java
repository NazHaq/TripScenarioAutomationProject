package parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import utility.BrowserType;

public class ParameterDataproviderWithClassLevel {

     WebDriver driver;

     @BeforeTest	
     public void setUp(){
     	   driver = BrowserType.Execute();
     }

        

      @Test(dataProvider="SearchProvider",dataProviderClass=DataproviderClass.class)

       public void testMethod(String user,String password) throws InterruptedException{

            {
            		
        		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
        	    driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        	    driver.findElement(By.id("log")).sendKeys(user);
        	    driver.findElement(By.id("pwd")).sendKeys(password);
        	    driver.findElement(By.id("login")).click();
   
                System.out.println("Welcome ->"+user+" Your search key is->"+password);

                Thread.sleep(3000);

                //get text from search box

                String testAuthor = driver.findElement(By.id("log")).getAttribute("value");
                String testPassword = driver.findElement(By.id("pwd")).getAttribute("value");

                System.out.println(testAuthor +"::::"+user);

                driver.findElement(By.id("log")).clear();
                driver.findElement(By.id("pwd")).clear();

                //verify if search box has correct value
                Assert.assertTrue(testAuthor.equalsIgnoreCase(user));
                Assert.assertTrue(testPassword.equalsIgnoreCase(password));

        }

        }

}