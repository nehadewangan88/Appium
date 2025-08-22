package GeneralStoreApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class GeneralTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@Test
	public void configureAppium() throws MalformedURLException, URISyntaxException
	{
				service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Neha//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
				// service.start();
				System.out.println("Service Started!!!");
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("AndroidEmulator");
				options.setApp("C://Users//Neha//eclipse-workspace//Appium//src//test//java//resources//General-Store.apk");
				options.setChromedriverExecutable("C://Program Files (x86)//Google//Chrome//Application//chromedriver.exe");
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.quit();
				service.stop();
	}

}
