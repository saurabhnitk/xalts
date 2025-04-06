package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test extends BaseTest{

	WebDriver driver;
	
	@Test(description="verify user is able to sign up successfully",priority=1)
	@Parameters({ "email", "password" })
	public void verifyUserSignup(String email, String password) throws InterruptedException {
		login.clickGetStartedButton();
		login.enterEmail(email);
		login.enterPassword(password);
		login.confirmPassword(password);
		login.clickSignupButton();
		login.clickSignoutButton();
	}
	
	@Test(description="verify user is able to log in successfully",priority=2)
	@Parameters({ "email", "password" })
	public void verifyUserLogin(String email, String password) throws InterruptedException {
		login.clickSigninButton();
		login.signin(email, password);
	}

}
