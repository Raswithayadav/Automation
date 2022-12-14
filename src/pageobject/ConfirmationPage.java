package pageobject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import practice.abstractcomponents;

   public class ConfirmationPage extends abstractcomponents {
	WebDriver driver;


     public ConfirmationPage(WebDriver driver)
     {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
         }
      @FindBy(css=".hero-primary")
    WebElement ConfirmationMessage;
      
      public void verifyConfirmationMessage() 
      {
    	  JavascriptExecutor js1 = (JavascriptExecutor)driver;
	        js1.executeScript("scroll(0, -250);");
	        waitforWebElementToAppear(ConfirmationMessage);
	       System.out.println("THANK YOU FOR THE ORDER IS DISPLAYED");
			//return Confirmmessage;
	      
			
			
		
	       

}

	


	

}
