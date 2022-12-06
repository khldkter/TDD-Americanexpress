package pages;

import static common.CommonActions.click;
import static common.CommonActions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.CommonActions;
import common.CommonWaits;

public class HomePage {

	WebDriver driver;
	CommonWaits waits;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		waits = new CommonWaits(driver);

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[text()='User ID']")
	WebElement userIdElement;
	@FindBy(xpath = "//label[text()='Password']")
	WebElement passWordElement;
	@FindBy(xpath = "//select[@class='form-control']")
	WebElement cardsAndBankingElement;
	@FindBy(xpath = "//label[@for='rememberMe']")
	WebElement iAgreeCheckBoxElement;
	@FindBy(id = "loginSubmit")
	WebElement loginElement;
	@FindBy(xpath="(//a[text()='Forgot User ID or Password?'])[2]")
WebElement forgotUserIDElement ;
	public void logInSteps(String userId, String passWord, String cardsandBanking, String iAgreeCheckBox,
			String logIn,String forgotUserID) {
		input(userIdElement, "3478");
		input(passWordElement, "9292");
		click(cardsAndBankingElement);
		click(iAgreeCheckBoxElement);
		click(loginElement);
		click(forgotUserIDElement);
	}

}