package base;

import static utils.IConstant.CHROME;
import static utils.IConstant.EDGE;
import static utils.IConstant.FIREFOX;
import static utils.IConstant.IMPLICIT_WAIT;
import static utils.IConstant.PAGELOAD_WAIT;
import static utils.IConstant.SAFARI;
import static utils.IConstant.URL;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AboutPages;
import pages.HomePage;
import utils.Configuration;

public class BaseClass {

	Configuration config = new Configuration();
	WebDriver driver;
	protected HomePage homePage;
	protected AboutPages aboutPages;
	
	@Parameters("browser")
	@BeforeMethod
	public void setUpDriver(String browser){
		initDriver(browser);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(config.getProperty(URL));

		long pageLoadTime = Long.parseLong(config.getProperty(PAGELOAD_WAIT));

		long implicitWait = Long.parseLong(config.getProperty(IMPLICIT_WAIT));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		initObjectClasses();
	}
	private void initDriver(String browser) {
		switch (browser) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
	}
	private void initObjectClasses() {	
	homePage = new HomePage(driver);
	aboutPages = new AboutPages(driver);

	}
	
	

	public WebDriver getDriver() {
		return driver;
	}
	
	
	
	@AfterMethod
	public void closingDriverSession() {
	
	}	
}