package practice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class example {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriverManager.edgedriver().setup();
         WebDriver driver = new EdgeDriver();
         String[] itemsNeeded= {"ZARA COAT 3","ADIDAS ORIGINAL","IPHONE 13 PRO"};
			driver.get("https://rahulshettyacademy.com/client/");
			driver.manage().window().maximize();
			
			driver.findElement(By.id("userEmail")).sendKeys("sun@gmail.com");
			driver.findElement(By.id("userPassword")).sendKeys("Jack@123");
			driver.findElement(By.id("login")).click();
			  addItems(driver, itemsNeeded);  
	           driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
	           WebElement element = driver.findElement(By.xpath("//button[text()='Checkout']"));
	           JavascriptExecutor js = (JavascriptExecutor)driver;
	        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	           js.executeScript("scroll(0,400)");
	        Thread.sleep(5000);
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element);
	        element.click();
	      
	       // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	      // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Checkout']"))).click();
	     


	       driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).click();
	        driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).sendKeys("India");
	          Thread.sleep(3000);
	         
	         JavascriptExecutor js1 = (JavascriptExecutor)driver;
	        js1.executeScript("scroll(0, -250);");
	          driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	          driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
	        
	}
	    public static void addItems(WebDriver driver, String[] itemsNeeded) {
	       int j = 0;
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']//div[@class='row']//h5")));
	        List<WebElement> products = driver.findElements(By.xpath("//div[@class='container']//div[@class='row']//h5"));



	       for (int i = 0; i < products.size(); i++) {
	             String[] name = products.get(i).getText().split("-");
	             String formattedName = name[0].trim();
	             List itemsNeedlist = Arrays.asList(itemsNeeded);
	             if (itemsNeedlist.contains(formattedName)) {
	                 j++;
	                 driver.findElements(By.xpath("//section[@id='products']//button[2]")).get(i).click();
	                 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	                 wait.until(ExpectedConditions
	                         .invisibilityOfAllElements(driver.findElements(By.cssSelector(".ng-animating"))));
	                 if (j == itemsNeeded.length) {
	                     System.out.println("Productname 1 = Zara coat 3 ");
	                     System.out.println("Productname 2= Adidas Original ");
	                     System.out.println("Productname 3 = IPHONE 13 Pro ");
	                     System.out.println("THANK YOU FOR THE ORDER IS DISPLAYED");
	                     break;
	                     
	                 }
	             }
	         }
	     }
	

	}


