package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name=\"Email\"]")
	WebElement emailTF;
	
	@FindBy(xpath="//input[@name=\"Password\"]")
	WebElement PwdTF;
	
	@FindBy(xpath="//input[@value=\"Log in\"]")
	WebElement loginButton;
	
	public void setEmail(String email) {
		emailTF.click();
		emailTF.sendKeys(email);
	}
	public void setPwd(String pwd) {
		PwdTF.click();
		PwdTF.sendKeys(pwd);
	}
	public void clickLoginButton() {
		loginButton.click();
	}

	

}
