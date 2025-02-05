package Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.utility;

public class Login_using_incorrect_credentials {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		driver=utility.getBrowser("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
	@Test
	public void testValidLogin() throws InterruptedException {
		driver.get("https://www.saucedemo.com"); // Update path to where the login page is saved locally

		// Locate elements and interact with the page
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		// Enter valid credentials
		username.sendKeys("standard_user");
		password.sendKeys("secret_");

		// Click the login button
		loginButton.click();

		// Validate successful login (in this case, we're just checking if the error message is hidden)
		String error_message = driver.findElement(By.xpath("//div/form/div[3]/h3")).getText();
		//error_message.getText();
		Assert.assertEquals(error_message, "Epic sadface: Username and password do not match any user in this service");
		Thread.sleep(5000);
	}
	@AfterTest
	public void afterTest() {
		driver.close();
		//comment
	}


}
