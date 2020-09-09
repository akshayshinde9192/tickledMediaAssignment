package FirstMaven.tickledMedia;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class oneGo {

	AppiumDriver<MobileElement> driver;

	public void setUp() throws InterruptedException {
		System.out.println("*******Creating session************");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "vivo 1804");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("appPackage", "com.tickledmedia.ParentTown");
		cap.setCapability("appActivity", "com.theasianparent.app.MainActivity");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("**********Session Created***********");
	}

	public void login() throws InterruptedException {

		driver.findElement(By.id("txt_login")).click();

		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup"))
				.click();
		System.out.println("**********Entered the Frame*********");

		Thread.sleep(500);
		driver.findElementById("text1").click();
		System.out.println("************Enter Parent-Child Frame*************");
		driver.findElement(By.id("et_user_email")).clear();
		Thread.sleep(500);
		driver.findElement(By.id("et_user_email")).sendKeys("automationTest@gmail.com");

		driver.findElement(By.id("et_password")).sendKeys("Automation@123"); // To enter Password
		Thread.sleep(500);
		driver.findElement(By.id("btn_login")).click(); // Hit Login Button
		Thread.sleep(3000);
	}

	public void navigation() throws InterruptedException {

		driver.findElement(By.id("recycler_view")).click();

		Thread.sleep(1500);
		TouchAction a = new TouchAction(driver);
		a.tap(84, 168).perform();
		System.out.println("*************Profile button clicked**************");
		Thread.sleep(1000);

		TouchAction a2 = new TouchAction(driver);
		a2.tap(84, 168).perform();

		driver.findElement(By.id("img_notification")).click();
		System.out.println("************Notification clicked*************");
		Thread.sleep(1000);
		TouchAction a3 = new TouchAction(driver);
		a3.tap(84, 168).perform();

	}

	public void actions() throws InterruptedException {

		driver.findElement(By.id("fabAddPost")).click();

		driver.findElement(By.id("txt_post_question_title")).click();

		driver.findElement(By.id("txt_title")).sendKeys("Boredom being Quarantine in 2020");

		Thread.sleep(1000);

		driver.findElement(By.id("et_post")).sendKeys("Waiting for vaccine and vacation");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("img_list_scroll")));
		driver.findElement(By.id("btn_post")).click();

		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("emojiAppCompatTextView")));
		System.out.println("***********Element frame visible*************");

		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[3]/android.view.ViewGroup/android.widget.RadioButton"))
				.click();

		System.out.println("**********Radio Button Clicked*************");
		Thread.sleep(1000);

		driver.findElement(By.id("btn_done")).click();
		Thread.sleep(2000);

	}

	public void logOut() {
		driver.closeApp();
		System.out.println("*********Application Closed************");
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		oneGo obj = new oneGo();
		obj.setUp();
		obj.login();
		obj.navigation();
		obj.actions();
		obj.logOut();
	}

}