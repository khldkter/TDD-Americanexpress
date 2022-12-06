package auto;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseClass;

public class AboutPagesTest extends BaseClass {
	
	@Parameters({"forgotPassWord","userId","continu"})
	@Test
	public void forgotPassWordStepsTest(String forgotPassWord,String userId,String continu)  {
	aboutPages.forgotPassWordSteps(forgotPassWord, userId, continu);
	
	}
	
}