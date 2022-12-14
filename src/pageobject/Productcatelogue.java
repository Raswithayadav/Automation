package pageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import practice.abstractcomponents;

public class Productcatelogue extends abstractcomponents {
	WebDriver driver;

	public Productcatelogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//String[] itemsNeeded = { "ZARA COAT 3", "ADIDAS ORIGINAL", "IPHONE 13 PRO" };

	public void catelogue() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\chunchu.raswitha\\eclipse-workspace\\Automation1\\src\\pageobject\\website.properties");
		prop.load(fis);
		String[] itemsNeeded = prop.get("products").toString().split("#");
		String formattedname = itemsNeeded[0].trim();
		if (formattedname.length() == 0) {
			System.out.println(" total no .of products  " + formattedname.length());

			System.out.println("No products ");
            System.exit(0);
		
		}

		else if (formattedname.length() > 0) {
			int j = 0;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='container']//div[@class='row']//h5")));
			List<WebElement> products = driver
					.findElements(By.xpath("//div[@class='container']//div[@class='row']//h5"));

			for (int i = 0; i < products.size(); i++) {
				String[] name = products.get(i).getText().split("-");
				String formattedName = name[0].trim();
				List itemsNeedlist = Arrays.asList(itemsNeeded);
				if (itemsNeedlist.contains(formattedName)) {
					System.out.println(formattedName+ "product is added successfully");
					j++;
					driver.findElements(By.xpath("//section[@id='products']//button[2]")).get(i).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
					wait.until(ExpectedConditions
							.invisibilityOfAllElements(driver.findElements(By.cssSelector(".ng-animating"))));
					if (j == itemsNeeded.length) {
						break;

					}
				}
			}
		}

	}
}
