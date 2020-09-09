package com.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.setup.baseSetUp;

import io.appium.java_client.MobileElement;

public class testCase2 extends baseSetUp{
	
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

}
