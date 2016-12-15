package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.Constant;

public class BrowserType {

    @Test
    public static WebDriver Execute() {

         // Set Browsers
         WebDriver driver = null;

        	 System.setProperty("webdriver.chrome.driver","C:\\Users\\nazmul.haque.HC\\Desktop\\ChromeDriver\\chromedriver.exe");
             driver = new ChromeDriver();        
          // Navigate to URL
          driver.get(Constant.URL);
          driver.manage().window().maximize();

          return driver;

    } 
}