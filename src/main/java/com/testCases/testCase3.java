package com.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.setup.baseSetUp;

import io.appium.java_client.MobileElement;

public class testCase3 extends baseSetUp {
	
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

}
