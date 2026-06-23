package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	
	public RegisterPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//h1[text()='Register']")
	WebElement registerText;
	
	@FindBy(xpath="//label[text()='Male']")
	WebElement maleRadioButton;
	
	@FindBy(xpath="//label[text()='Female']")
	WebElement femaleRadioButton;
	
	@FindBy(xpath="//input[@id=\"FirstName\"]")
	WebElement firstName;
	
	
	@FindBy(xpath="//input[@id=\"LastName\"]")
	WebElement lastName;
	
	
	@FindBy(xpath="//input[@id=\"Email\"]")
	WebElement emailTF;
	
	@FindBy(xpath="//input[@name=\"Password\"]")
	WebElement password;
	
	@FindBy(xpath="//input[@name=\"ConfirmPassword\"]")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@value=\"Register\"]")
	WebElement registerButton;
	
	//div[contains(text(),'Your registration completed')]
	
	@FindBy(xpath="//div[contains(text(),'Your registration completed')]")
	WebElement confirmationText;
	
	public String verifyRegisterPage() {
		try {
			return (registerText.getText());
		}catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	public void clickMaleRadBtn() {
		maleRadioButton.click();
	}
	public void clickfemaleRadBtn() {
		femaleRadioButton.click();
	}
	
	public void firstnameClicnEnter(String FN) {
		firstName.click();
		firstName.sendKeys(FN);
	}
	public void lastnameClicnEnter(String LN) {
		lastName.click();
		lastName.sendKeys(LN);
	}
	public void emailClickEnter(String email) {
		emailTF.click();
		emailTF.sendKeys(email);
	}
	public void pwdClickEnter(String pwd) {
		password.click();
		password.sendKeys(pwd);
	}
	public void cpwdclickEnter(String cpwd) {
		confirmPassword.click();
		confirmPassword.sendKeys(cpwd);
	}
	public void resgisterButtonclick() {
		registerButton.click();
		
	}
	public String dispConfirmation() {
		try {
			return (confirmationText.getText());
		}catch(Exception e){
		return(	e.getMessage());
		}
		
	}

}
