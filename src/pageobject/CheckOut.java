package pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import practice.abstractcomponents;

public class CheckOut extends abstractcomponents {
	WebDriver driver;

	public CheckOut(WebDriver driver) {
		 super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// @FindBy(css="//input[@placeholder=\"Select Country\"]")
	// WebElement country;
	@FindBy(xpath = "//input[@placeholder=\"Select Country\"]")
	WebElement Selectcountry;
	@FindBy(xpath = "//button[@type='button'][2]")
	WebElement select;

	public void shippingDetails() throws IOException, InterruptedException {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-350)");
		// country.click();

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\chunchu.raswitha\\eclipse-workspace\\Automation1\\src\\pageobject\\website.properties");
		prop.load(fis);
		String place = prop.getProperty("place");
		// India.sendKeys(place);
		Selectcountry.sendKeys(place);
		Thread.sleep(2000);
		select.click();
		Thread.sleep(2000);
		WebElement placeOrder = driver.findElement(By.partialLinkText("PLACE ORDER"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView(true)", placeOrder);
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("PLACE ORDER")).click();
		// Placeorder.click();
	}

}
