package com.voctoria.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

	public WebDriver driver = Configuration.browser();

	@FindBy(xpath = "//div[@class='fabric-product-stacks-component']//article//a")
	private WebElement productLink;

	@FindBy(xpath = "//div[@class='fabric-purchasable-product-component-right']//div[@data-key='size1']//div[@role='radio']")
	private WebElement productsize;

	@FindBy(id = "primary-1")
	private WebElement addToCart;

	@FindBy(xpath = "//span[text()='Check Out']/..")
	private WebElement checkOut;

	@FindBy(xpath = "//span[text()='Check Out as Guest']/..")
	private WebElement checkOutGuest;

	@FindBy(className = "fabric-accordion-utility-item-header-text")
	private WebElement subtotalText;

	@FindBy(className = "price")
	private WebElement price;

	@FindBy(css = "button[class*='close']")
	private WebElement closePopUp;
	@FindBy(id = "consent_prompt_submit")
	private WebElement acceptButton;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void selectProduct(String menu, String product) {
		acceptButton.click();
		Actions action = new Actions(driver);
		WebElement menuName = driver.findElement(By.linkText(menu));

		action.moveToElement(menuName).build().perform();
		WebElement item = driver.findElement(By.linkText(product));
		item.click();

		closePopUp.click();

	}

	public void selectProduct() {
		productLink.click();
	}

	public void selectSizeAndCart() {

		productsize.click();

		CommonCode.explicitWait(driver, By.id("primary-1")).click();
		CommonCode.explicitWait(driver, By.xpath("//span[text()='Check Out']/..")).click();

		checkOutGuest.click();
	}

	public void validatePrice(String subtotal, String subTotalPrice) {

		Assert.assertEquals(subtotalText.getText().trim(), subtotal);
		Assert.assertEquals(price.getText().trim(), subTotalPrice);

	}

}
