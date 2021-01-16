package IntroSeleniumHOMEWORK;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertAutomate {

	/*
	 * 1. Navigate to URL : https://www.seleniumeasy.com/test/javascript-alert-box-demo.html
	   2. Scroll down to third Alert box ( Click for promot Box )  click the button ( use Actions class ) 
	   3 pupop will display and enter the message inbox ( your name )  click OK button
	   4 After click OK button, you will see message below EX : You have entered 'Techcircle' !
		  Verify use ( assertion ) Assert message has displayed.
	      Also i would like to see other assertion is : before message call : Click below button for prompt box. 
	       is different than new message, Expected TRUE. 
	 */
	
	WebDriver driver;
		
		@Before
		
		public void beforeMethod() {
	
	
	WebDriverManager.chromedriver().setup();
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

  }

		@Test
		
		public void Test1() throws InterruptedException {
			
			driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
			
			((JavascriptExecutor)driver).executeScript("scroll(0,400)");
			
			Actions act = new Actions(driver);
			
			Thread.sleep(3000);
			
			WebElement promptBox = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[3]/div[2]/button"));
			
			Thread.sleep(3000);
			
			act.moveToElement(promptBox).click().perform();
			
			Thread.sleep(3000);
			
			String AlertBox = "Beenish";
			
			driver.switchTo().alert().sendKeys(AlertBox);
			driver.switchTo().alert().accept();
			
		
			Thread.sleep(3000);
			
			WebElement expectedMsg= driver.findElement(By.id("prompt-demo"));
			
			String expectedMsgBox = expectedMsg.getText();
			
			System.out.println(expectedMsgBox);
			
		
			Assert.assertTrue(expectedMsg.isDisplayed());
				
			
		}
	
		@After
		
		public void  end() {
			
			driver.close();
		}
	
}
	
