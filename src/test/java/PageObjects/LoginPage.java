package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy (xpath="//span[text()='Sign In']")
//	WebElement signin;
	
//	@FindBy (xpath="//*[@placeholder='Search for area, street name..']")
//	WebElement addressph;
//	
//	@FindBy (xpath="//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div[3]/div/div/div[1]")
//	WebElement address;
	
	@FindBy (xpath="//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[1]/div/a[1]")
	WebElement login;
	
	@FindBy (id="mobile")
	WebElement numberph;
	
	@FindBy(xpath="//*[@class='_381fS'][@id='otp']")
	WebElement otpph;
	
	@FindBy (xpath="//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div/form/div[2]/a")
	WebElement authlogin;
	
	@FindBy (xpath="//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div/div[2]/form/div[2]/div[2]/a")
	WebElement verifyotp;
	
	//ActionMethods
	
	public boolean pageload() {
		boolean status=login.isDisplayed();
		return status;
	}
	public void loginclick() {
		login.click();
	}
	public void enternumber(String mobile) {
		numberph.sendKeys(mobile);
	}
	
	public void authlogin() {	
		authlogin.click();
	}
	
	public void enterotp(String otp) {
		otpph.sendKeys(otp);
	}
	
	public void verifyotp() {
		while (otpph.getAttribute("value").length() < 6) {
            try {
                Thread.sleep(1000); // Wait for 1 second (adjust as needed)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		verifyotp.click();
	}


}
