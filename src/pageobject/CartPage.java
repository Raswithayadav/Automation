package pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import practice.abstractcomponents;

public class CartPage extends abstractcomponents{
	WebDriver driver;

	public CartPage(WebDriver driver) {
		 super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement Cart;
	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkout;

	public void cartproducts() throws InterruptedException {
		Cart.click();
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		WebElement checkOut = driver.findElement(By.xpath("//button[text()='Checkout']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", checkOut);
		Thread.sleep(1000);
		checkout.click();
	}

}
