package com.voctoria.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.voctoria.pages.Configuration;
import com.voctoria.pages.HomePage;


public class SmokeTest {

	public WebDriver driver = Configuration.browser();
	public HomePage home;

	public SmokeTest() {
		home = new HomePage();

	}

	@BeforeSuite(alwaysRun = true)
	public void invokeUrl() {
		driver.get(Configuration.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterSuite(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

	@Test(testName = "search product", description = "search product", enabled = true, groups = { "sanity", "2" })
	public void searchProduct() {
		home.selectProduct("PANTIES", "Boyshorts");
		home.selectProduct();
		home.selectSizeAndCart();
		home.validatePrice("Merchandise Subtotal", "$24.50");

	}
}
