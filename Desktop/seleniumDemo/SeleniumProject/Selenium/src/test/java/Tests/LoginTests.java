package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTests {
	WebDriver driver;

	@BeforeClass
	public void configure() throws InterruptedException {
		 String homeDirectory ="user.dir";
		 //Download and add the gecko driver (firefox driver is called as geckodriver)to the drivers folder
//			 System.setProperty("webdriver.gecko.driver","C:\\Users\\Sajee Thamanga\\Desktop\\driver\\chromedriver.exe");
			 System.setProperty("webdriver.chrome.driver", System.getProperty(homeDirectory)+"/src/test/resources/drivers/chromedriver.exe");
			 //System.setProperty("webdriver.gecko.driver", GeckoDriverPath);
		 	 this.driver = new ChromeDriver(); 
		 
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * System.getProperty(homeDirectory)+
		 * "/src/test/resources/drivers/chromedriver.exe"); this.driver = new
		 * ChromeDriver();
		 */
		 
			 driver.get("http://localhost:3000/login");
			 driver.manage().window().maximize();
			 Thread.sleep(2000);
	}
	
	@AfterClass
	public void clearDrivers() {
		driver.quit();
	}
	
	@Test(description="Verify that able to create a new user",priority=1)
	public void creatingANewUser() throws InterruptedException {
		//Login to the Application
		driver.findElement(By.xpath("//input[@name='email']")).click();

		for(int i=0; i<=7; i++) {
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);	
		}
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("shamika");
		
		driver.findElement(By.xpath("//input[@name='password']")).click();
		
		for(int i=0; i<=3; i++) {
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.BACK_SPACE);
		}
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Dashboardabcd']")).isDisplayed());
		
		//Creating a new User
		driver.findElement(By.xpath("//div[text()='Add New User']")).click();
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Add New User']")).isDisplayed());
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("sajee");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("rodrigo");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("sr");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("saje@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("123");
		driver.findElement(By.xpath("//button[text()='Sign Up Now']")).click();	
		
//		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Add New User']")).isDisplayed());
	}
	

}
