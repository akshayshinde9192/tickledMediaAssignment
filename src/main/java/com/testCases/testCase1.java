package com.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.setup.baseSetUp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class testCase1 extends baseSetUp {

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

}
