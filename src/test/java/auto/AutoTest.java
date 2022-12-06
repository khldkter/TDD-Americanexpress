package auto;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;

public class AutoTest extends BaseClass{
	
	
	@Parameters({"userId", "passWord", "cardsAndBanking","iAgreeCheckBox","login","forgotUserId"})
	@Test
	public void logInSteapsTest(String userId, String passWord, String cardsandBanking,String iAgreeCheckBox,String login,String forgotUserID ) {
	homePage.logInSteps(userId, passWord, cardsandBanking,iAgreeCheckBox,login,forgotUserID);	
	
	} 
}
