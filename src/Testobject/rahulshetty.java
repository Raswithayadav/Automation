package Testobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.CartPage;
import pageobject.CheckOut;
import pageobject.ConfirmationPage;
import pageobject.Loginpage;
import pageobject.Productcatelogue;

public class rahulshetty {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		 WebDriverManager.edgedriver().setup();
         WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			Loginpage loginpage=new Loginpage(driver);
			loginpage.goTo();
			loginpage.LoginApplication();
			Productcatelogue products=new Productcatelogue(driver);
			products.catelogue();
			CartPage Cart =new CartPage(driver);
			Cart.cartproducts();
			CheckOut check=new CheckOut(driver);
			check.shippingDetails();
	        ConfirmationPage conform=new ConfirmationPage(driver);
	        conform.verifyConfirmationMessage();
	
	}

}
