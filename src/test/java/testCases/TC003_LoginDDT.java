package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class TC003_LoginDDT  extends BaseClass{
	
	/* validData---loginSuccess---Pass 
	 * InvalidData---loginSuccess---Fail
	 * InvalidData--Loginfail----Pass  */
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)//getting data provider from dif class
	public void verifyDDT(String email, String pwd, String ExpectedResult) {
		logger.info("***TC003_LoginDDT Testcase Started***");
		try {
		HomePage hp=new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		hp.clickLoginLink();
		logger.info("Clicked on login link");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		logger.info("Entered email into Email textfield");
		lp.setPwd(pwd);
		logger.info("Entered password into Password textfield");
		lp.clickLoginButton();
		logger.info("Clicked on Login button");
		boolean unDisp=hp.verifyUserName();
		
		if (ExpectedResult.equalsIgnoreCase("Valid")) {
			if (unDisp==true) {
				hp.logout();
				Assert.assertTrue(true);
				logger.info("Passed");
			}
			else {
				Assert.assertTrue(false);
				logger.info("failed");
			}	
		}
		if (ExpectedResult.equalsIgnoreCase("Invalid")) {
			if (unDisp==true) {
				hp.logout();
				Assert.assertTrue(false);
				logger.info("failed");
			}
			else {
				Assert.assertTrue(true);
				logger.info("Passed");
			}
		}
		
		}
		catch (Exception e) {
			Assert.fail();		
			}
		logger.info("***TC003_LoginDDT Testcase completed.***");
		}
	
}

