package GeneralStoreApp;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LoginTest extends  BaseTest {

	String amount;
	@Test(priority=1)
	public void ErrorValidation ()
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Australia']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		DeviceRotation landScape = new DeviceRotation(0,0,90);
	//	driver.rotate(landScape);
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getDomAttribute("name");
		System.out.println(toastMessage);
	}
	
	@Test(priority=2)
	public void findProduct()
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Neha Dewangan");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		scrollToElementByName("Air Jordan 9 Retro");
		
	}
	
	

	@Test(priority=3)
	public void loginToApp() throws InterruptedException
	{
	/*	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Neha Dewangan");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		scrollToElementByName("Air Jordan 9 Retro"); */
		List<WebElement> products= driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]"));
		List<WebElement> addToCarts= driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]"));
		List<WebElement> amounts = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]"));
		for(int i=0;i<products.size();i++)
		{
			String prodName=products.get(i).getText();
			WebElement addToCart = addToCarts.get(i);
			
			System.out.println(prodName);
			if(prodName.equals("Air Jordan 9 Retro"))
			{
				addToCart.click();
				Thread.sleep(3000);
				amount = amounts.get(i).getText();
				Double productValue = Double.parseDouble(amount.substring(1));
				System.out.println(productValue);
			}
			
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		WebElement cartPageTitle = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
		
		waitForElementToAppear(cartPageTitle);
		longPressAction(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
		Set <String> contexts = driver.getContextHandles();
		for(String contextName : contexts)
		{
			System.out.println(contextName);
		}
		
	/*	driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Testing Vacancies");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER); */
	}
	
	
}

