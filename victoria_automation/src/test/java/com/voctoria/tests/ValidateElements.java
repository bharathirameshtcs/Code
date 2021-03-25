package com.voctoria.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.voctoria.pages.Configuration;

public class ValidateElements {

	public static void main(String[] args) {
		WebDriver driver = Configuration.browser();
		driver.get(Configuration.URL);
		Assert.assertTrue(driver.findElement(By.className("fabric-masthead-category-nav-component")).isDisplayed(),
				"nav menu is not displayed");
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='PANTIES']")).isDisplayed(),
				"nav menu is not displayed");
		Assert.assertTrue(driver.findElement(By.cssSelector("a[data-link-name='NEW!']")).isDisplayed(),
				"New menu link is not displayed");
		Assert.assertTrue(driver.findElements(By.cssSelector("a[data-link-name='offers']")).size()==1,
				"offers link is not displayed");
		driver.quit();
		
	}
}
