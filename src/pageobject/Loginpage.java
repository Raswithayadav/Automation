package pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practice.abstractcomponents;


	

	public class Loginpage extends abstractcomponents{
		
		WebDriver  driver;
		public  Loginpage(WebDriver driver) 
		{
			super(driver);
			//intialization
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement passwordEle;
		
		@FindBy(id="login")
		WebElement submit;
		
		public void LoginApplication() throws IOException{
			Properties prop = new Properties();
	        FileInputStream fis = new FileInputStream("C:\\Users\\chunchu.raswitha\\eclipse-workspace\\Automation1\\src\\pageobject\\website.properties");
	        prop.load(fis);
	        String email =prop.getProperty("email");
	        userEmail.sendKeys(email);
	        String password =prop.getProperty("password");
	        passwordEle.sendKeys(password);
	        submit.click();
			
		}
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client/");
		}

	

}

