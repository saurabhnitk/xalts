package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcases extends BaseTest{

	WebDriver driver;
	
	@Test(description="verify Sign Up button remains disabled if user enters invalid email id and valid password",priority=1)
	@Parameters({"invalid_email", "password"})
	public void userSignupInvalidEmail(String email,String password) throws InterruptedException {
		login.clickGetStartedButton();
		login.enterEmail(email);
		login.enterPassword(password);
		login.confirmPassword(password);
		Assert.assertTrue(!login.checkSignUpButtonIsEnabled());
	}
	
	@Test(description="verify Sign Up button remains disabled if user enters valid email id and password not containing uppercase letter",priority=2)
	@Parameters({"email", "password_no_uppercase"})
	public void userSignupPasswordNoUppercaseLetter(String email,String password) throws InterruptedException {
		login.enterEmail(email);
		login.enterPassword(password);
		login.confirmPassword(password);
		Thread.sleep(1000);
		Assert.assertTrue(!login.checkSignUpButtonIsEnabled());
	}

	@Test(description="verify Sign Up button remians disabled if user enters valid email id and password not containing lowercase letter",priority=3)
	@Parameters({"password_no_lowercase"})
	public void userSignupPasswordNoLowercaseLetter(String password) throws InterruptedException {
		login.enterPassword(password);
		login.confirmPassword(password);
		Thread.sleep(1000);
		Assert.assertTrue(!login.checkSignUpButtonIsEnabled());
	}

	@Test(description="verify Sign Up button remians disabled if user enters valid email id and password not containing number",priority=4)
	@Parameters({"password_without_number"})
	public void userSignupPasswordNotContainingNumber(String password) throws InterruptedException {
		login.enterPassword(password);
		login.confirmPassword(password);
		Thread.sleep(1000);
		Assert.assertTrue(!login.checkSignUpButtonIsEnabled());
	}

	@Test(description="verify Sign Up button remians disabled if user enters valid email id and password not containing special character",priority=5)
	@Parameters({"password_without_special_character"})
	public void userSignupPasswordNotContainingSpecialCharacter(String password) throws InterruptedException {
		login.enterPassword(password);
		login.confirmPassword(password);
		Thread.sleep(1000);
		Assert.assertTrue(!login.checkSignUpButtonIsEnabled());
	}

	@Test(description="verify Sign Up button remians disabled if user enters valid email id and password length less than 8",priority=6)
	@Parameters({"password_length_less_than_eight"})
	public void userSignupPasswordLengthLessThanEight(String password) throws InterruptedException {
		login.enterPassword(password);
		login.confirmPassword(password);
		Thread.sleep(1000);
		Assert.assertTrue(!login.checkSignUpButtonIsEnabled());
	}

	@Test(description="verify user is able to sign up with valid email and password",priority=7)
	@Parameters({"password"})
	public void userSignupWithValidEmailAndPassword(String password) throws InterruptedException {
		login.enterPassword(password);
		login.confirmPassword(password);
		Thread.sleep(1000);
		Assert.assertTrue(!login.checkSignUpButtonIsEnabled());
		login.clickSignupButton();
		login.clickSignoutButton();
	}

	@Test(description="verify user is able to login with signed up credentials",priority=8)
	@Parameters({"email", "password"})
	public void userLogin(String email,String password) throws InterruptedException {
		login.clickSigninButton();
		login.signin(email, password);
	}

}
