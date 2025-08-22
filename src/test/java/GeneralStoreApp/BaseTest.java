package GeneralStoreApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException
	{
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Neha//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
				//service.start();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("deviceName", "AndroidEmulator");
		capabilities.setCapability("appPackage", "com.androidsample.generalstore");
		capabilities.setCapability("appActivity", "/com.androidsample.generalstore.AllProductsActivity");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("app", "C://Users//Neha//eclipse-workspace//Appium//src//test//java//resources//General-Store.apk");
			/*	UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("AndroidEmulator");
				options.setApp("C://Users//Neha//eclipse-workspace//Appium//src//test//java//resources//General-Store.apk");
				options.setChromedriverExecutable("C://Program Files (x86)//Google//Chrome//Application//chromedriver.exe"); */
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),capabilities);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
	}
	
	public void waitForElementToAppear(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(element, "text", "Cart"));
		
		
	}
	
	public void longPressAction(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
		
	}
	
	public void scrollToDesiredElement(WebElement scrollelement)
	{
		
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("elementId", ((RemoteWebElement) scrollelement).getId(), "direction", "down","percent",1));
		
		}
	
	public void scrollToElementByName(String name)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("+"new UiSelector().text(\""+name+"\"))"));
		
	//	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text("+name+"));"));
	}
	@AfterClass
	public void tearDown()
	{
		 driver.quit();
		 service.stop();
	}

}
