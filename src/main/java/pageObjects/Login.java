package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
	WebDriver driver;
	
	@FindBy(xpath="//button[text()='Get Started']")
	WebElement getStartedButton;
	
	@FindBy(xpath="//input[@id='outlined-basic' and @type='text']")
	WebElement emailField;
	
	@FindBy(xpath="(//input[@id='outlined-basic' and @type='password'])[1]")
	WebElement passwordField;
	
	@FindBy(xpath="(//input[@id='outlined-basic' and @type='password'])[2]")
	WebElement confirmPasswordField;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement signupButton;
	
	@FindBy(xpath="//button[text()='Sign Out']")
	WebElement signoutButton;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signinButton;

	@FindBy(xpath="//button[text()='Already have an account? Click here to sign in.']")
	WebElement signinLink;
	
	@FindBy(xpath="//h1[text()='Getting Started']")
	WebElement gettingStartedText;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickGetStartedButton() {
		getStartedButton.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(emailField));
	}
	
	public void enterEmail(String email) {
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	public void confirmPassword(String password) {
		confirmPasswordField.clear();
		confirmPasswordField.sendKeys(password);
	}
	
	public boolean checkSignUpButtonIsEnabled() {
		if(signupButton.isDisplayed() && signupButton.isEnabled()) {
			return true;
		}
		return false;
	}
	
	public void clickSignupButton() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.elementToBeClickable(signupButton));
		signupButton.click();
		wait.until(ExpectedConditions.visibilityOf(getStartedButton));
	}
	
	public void clickSignoutButton() {
		signoutButton.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(signinButton));
	}
	
	public void clickSigninButton() {
		signinButton.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(signinLink));
		signinLink.click();
	}
	
	public void signin(String email,String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		signinButton.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(getStartedButton));
		getStartedButton.click();
		wait.until(ExpectedConditions.visibilityOf(gettingStartedText));
	}

}
