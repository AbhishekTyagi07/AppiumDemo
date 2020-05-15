package ExampleTests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;


public class NativeTest {

	AndroidDriver driver;
	DesiredCapabilities capabilities= new DesiredCapabilities();
	
	MobileElement btn_six = (MobileElement) driver.findElement(By.id("com.android.calculator2:id/digit_6"));
	MobileElement btn_three = (MobileElement) driver.findElement(By.id("com.android.calculator2:id/digit_3"));
	MobileElement btn_equal = (MobileElement) driver.findElement(By.id("com.android.calculator2:id/eq"));
	MobileElement btn_add = (MobileElement) driver.findElement(By.id("com.android.calculator2:id/op_add"));
	MobileElement result = (MobileElement) driver.findElement(By.id("com.android.calculator2:id/formula"));


	  @BeforeMethod
	  public void launchApp() throws MalformedURLException {
		  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		  capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		  capabilities.setCapability("appPackage", "com.android.calculator2");
		  capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
		  URL url = new URL("http://0.0.0.0:4723/wd/hub");
		  driver = new AndroidDriver(url, capabilities);
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void add() {
		  btn_six.click();
		  btn_add.click();
		  btn_three.click();
		  btn_equal.click();
		  assert result.getText().equals("9");
	  }
	  
	
	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }

}
