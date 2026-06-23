package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;//(from Apache careful while importing)
import org.apache.logging.log4j.Logger;//(not from Apache core)

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	public WebDriverWait wait;

	@BeforeClass(groups = { "Sanity", "Regression", "Master", "DataDriven" })
	@Parameters({ "os", "browser" })
	public void setUp(String os, String br) throws IOException {
		// loading config.properties file
		FileReader file = new FileReader("./src//main//resources//config.Properties");
		p = new Properties();
		p.load(file);
		logger = LogManager.getLogger(this.getClass());
		// driver=new ChromeDriver();

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			if (os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);

			} else {
				System.out.println("No matching os");
				return;
			}
			// Browser
			switch (br.toLowerCase()) {
			case "chrome":
				cap.setBrowserName("chrome");
				break;
			case "edge":
				cap.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No matching browser");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		} else {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;

			default:
				// driver=new ChromeDriver(); break; or
				System.out.println("invalid browser name");
				return; // will stop the execution here itself ,exit from execution

			}

		}

		driver.manage().window().maximize();
		// from properties file
		driver.get(p.getProperty("appUrl2"));

		// driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10000));

	}

	@AfterClass(groups = { "Sanity", "Regression", "Master", "DataDriven" })
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String randonText = RandomStringUtils.randomAlphabetic(5);
		return randonText;
	}

	public String randomNumber() {
		String randonDigits = RandomStringUtils.randomNumeric(10);
		return randonDigits;
	}

	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourcefile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		sourcefile.renameTo(targetFile);
		return targetFilePath;
	}

}
