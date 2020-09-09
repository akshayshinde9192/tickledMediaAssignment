package com.setup;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class baseSetUp {

	public AppiumDriver driver;

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
