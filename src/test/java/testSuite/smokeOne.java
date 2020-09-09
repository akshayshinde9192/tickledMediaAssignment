package testSuite;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class smokeOne {

	AppiumDriver driver;

	@Test(priority = 1)
	public void invalidUserName() {
		MobileElement loginPage = (MobileElement) driver.findElement(By.id("txt_login"));

		loginPage.click();

		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup"))
				.click();
		System.out.println("**********Entered Frame************");

		driver.findElementById("text1").click();
		System.out.println("************Enter Parent-Child Frame*************");
		driver.findElement(By.id("et_user_email")).clear();

		MobileElement userNameTxtFld = (MobileElement) driver.findElement(By.id("et_user_email"));
		userNameTxtFld.clear();
		userNameTxtFld.sendKeys("invalid user email123333");

		MobileElement passwordTxtFld = (MobileElement) driver.findElement(By.id("et_password"));
		MobileElement loginBtn = (MobileElement) driver.findElement(By.id("btn_login"));

		passwordTxtFld.sendKeys("jhsajdgastfwjrvksadb");
		loginBtn.click();

		MobileElement errorTxt = (MobileElement) driver.findElement(By.id("textinput_error"));

		String actualErrorTxt = errorTxt.getAttribute("text");
		System.out.println("Actual Error Text - " + actualErrorTxt);
		String expectedErrorTxt = "Please enter valid email";

		Assert.assertEquals(actualErrorTxt, expectedErrorTxt);
	}

	@Test(priority = 2)
	public void invalidPassword() {

		MobileElement userNameTxtFld = (MobileElement) driver.findElement(By.id("et_user_email"));
		userNameTxtFld.clear();
		userNameTxtFld.sendKeys("automationTest@gmail.com");

		MobileElement passwordTxtFld = (MobileElement) driver.findElement(By.id("et_password"));
		MobileElement loginBtn = (MobileElement) driver.findElement(By.id("btn_login"));

		passwordTxtFld.sendKeys("jhsajdgastfwjrvksadb");
		loginBtn.click();

		MobileElement errorTxt = (MobileElement) driver.findElement(By.id("textinput_error"));

		String actualErrorTxt = errorTxt.getAttribute("text");
		System.out.println("Actual Error Text - " + actualErrorTxt);
		String expectedErrorTxt = "Please enter the correct password";

		Assert.assertEquals(actualErrorTxt, expectedErrorTxt);
	}

	@Test(priority = 3)
	public void validLogin() {

		MobileElement userNameTxtFld = (MobileElement) driver.findElement(By.id("et_user_email"));
		userNameTxtFld.clear();
		userNameTxtFld.sendKeys("automationTest@gmail.com");

		MobileElement passwordTxtFld = (MobileElement) driver.findElement(By.id("et_password"));
		MobileElement loginBtn = (MobileElement) driver.findElement(By.id("btn_login"));

		passwordTxtFld.sendKeys("Automation@123");
		loginBtn.click();

		MobileElement homeTitle = (MobileElement) driver.findElement(By.id("txt_explore"));

		String actualProductTxt = homeTitle.getAttribute("text");
		System.out.println("Product Title - " + actualProductTxt);
		String expectedProductTxt = "Explore theAsianparent";

		Assert.assertEquals(actualProductTxt, expectedProductTxt);
	}

	@BeforeClass

	public void beforeClass() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "vivo 1804");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("appPackage", "com.tickledmedia.ParentTown");
		cap.setCapability("appActivity", "com.theasianparent.app.MainActivity");

		/* cap.setCapability("app", ""); */

		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		String sessionId = driver.getSessionId().toString();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
