package pages;

import static common.CommonActions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonWaits;

public class AboutPages {
	CommonWaits waits;

	public AboutPages(WebDriver driver) {
		waits = new CommonWaits(driver);

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[contains(text(),'Forgot User ID or Password?')])[2]")
	WebElement forgotPassWordElement;
	@FindBy(xpath = "//label[text()='User ID']")
	WebElement userIdElement;
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continuElement;

	public void forgotPassWordSteps(String forgotPassWord,String userId,String continu) {
		click(forgotPassWordElement);
		input(userIdElement, "2425");
	
		waits.waitUntilVisible(continuElement);
		if (isPresent(continuElement) && isDisplayed(continuElement)) {
			click(continuElement);
		}
	}
}