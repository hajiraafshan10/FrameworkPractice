package testCases;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC002_Login extends BaseClass{
	
	@Test(groups={"regression", "Master"})//for single no flower braces required
	public void loginTest() {
		try {
		logger.info("**TC002_Login testcase started**");
		HomePage hp=new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		hp.clickLoginLink();
		logger.info("Clicked on login link");
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("UserName"));
		logger.info("Entered email into Email textfield");
		lp.setPwd(p.getProperty("Password"));
		logger.info("Entered password into Password textfield");
		lp.clickLoginButton();
		logger.info("Clicked on Login button");
		boolean unDisp=hp.verifyUserName();
	
	Assert.assertTrue(unDisp);	
	//Assert.assertEquals(unDisp, true,"Login Failed");
		
	}catch (Exception e) {
		Assert.fail();
		logger.info("TestCase Failed");
	}
	logger.info("Execution Completed");

}}
