package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement registerLink;
	
	@FindBy(xpath="//a[text()='Log in']") 
	WebElement loginLink;
	
	@FindBy(xpath="//div[@class=\"header-links\"]//a[@class=\"account\"]")
	WebElement userName;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logoutButton;
	
	public void clickRegister() {
		registerLink.click();
	}
	
	public void clickLoginLink() {
		loginLink.click();
	}
	
	public boolean verifyUserName() {
		
		try {
		if (userName.isDisplayed()) {
			return true;
		}else {
			return false;
		}
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}			
	}
	public void logout() {
		logoutButton.click();
	}
	
		}
	
	
