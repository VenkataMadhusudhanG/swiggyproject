package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	WebDriver driver;
	LoginPage lp;
	WebDriverWait wait;
	@BeforeClass
	void launch() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		lp=new LoginPage(driver);
		driver.get("https://www.swiggy.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
	}
	@Test
	void pageloadtest() {
		
		Assert.assertEquals(lp.pageload(), true);
	}
	
	@Test
	void loadtest() throws InterruptedException  {
		lp.loginclick();
		lp.enternumber("7780632321");
		lp.authlogin();
		lp.verifyotp();
		Assert.assertEquals(driver.getTitle(), "Order food online from India's best food delivery service. Order from restaurants near you");

	}
	
	
	

}
