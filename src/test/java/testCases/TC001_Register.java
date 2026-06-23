package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class TC001_Register extends BaseClass {
	

	
	@Test(groups={"Regression","Master"})
	public void registrationTest() throws InterruptedException {
		logger.info("***Testcase started TC001_Register  ***");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickRegister();
		logger.info("Clicked on  Register link");
		RegisterPage Rp=new RegisterPage(driver);
		String regTextDisp=Rp.verifyRegisterPage();
		System.out.println(regTextDisp);
		Rp.clickMaleRadBtn();
		logger.info("Clicked on  radio button");
		Thread.sleep(3000);
		Rp.firstnameClicnEnter(randomString());
		logger.info("Entered first name");
		Thread.sleep(3000);
		Rp.lastnameClicnEnter(randomString());
		logger.info("Entered last name");
		Thread.sleep(3000);
		Rp.emailClickEnter(randomString()+"@gmail.com");
		logger.info("Entered email id");
		Thread.sleep(3000);
		
		
		String Pwd=randomString()+"@"+randomNumber();
		
		Rp.pwdClickEnter(Pwd);
		Thread.sleep(3000);
		Rp.cpwdclickEnter(Pwd);
		logger.info("Entered Pwd and Confirm pwd");
		Thread.sleep(3000);
		Rp.resgisterButtonclick();
		logger.info("Clicked on  Register liuttonnk");
		Thread.sleep(3000);
		String confrmMsg=Rp.dispConfirmation();
		System.out.println(confrmMsg);
		logger.info("Gets the conmfirmation mesg");
		if(confrmMsg.equals("Your Registeration Successfull")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed ");
			logger.debug("debug logs.");
			Assert.assertTrue(false);
		}
		
		}
		catch (Exception e) { 
			System.out.println("Error occured "+e);
			Assert.fail();
		}	
		Log.info("Testcase finished");
	}
}
