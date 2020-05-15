package ExampleTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class WebTest {

	AndroidDriver driver;
	DesiredCapabilities capabilities= new DesiredCapabilities();

  @BeforeMethod
  public void launchApp() throws MalformedURLException {
	  
	  capabilities.setCapability("platformName", "Android");
      capabilities.setCapability("deviceName", "emulator-5554");
      capabilities.setCapability("browserName", "Chrome");
      driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
      
  }
  
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("https://www.google.com");
	  Thread.sleep(5);
	  placeHolder("q").sendKeys("appium automation");
	  driver.findElementByName("btnK").click();
	  Thread.sleep(5);
	  
	  //Click on first link in the result
	  List<WebElement> allLinks = driver.findElementsByTagName("a");
	  for(WebElement link:allLinks){
		  if(link.getText().contains("Appium")){
			  System.out.println(link.getText());
			  link.click();
			  break;
		  };
	  }
  }
  
  public WebElement placeHolder(String locator) {
	  return driver.findElementByXPath("//input[@name = '"+locator+"']");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}

