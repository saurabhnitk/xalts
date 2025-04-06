package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnboardNodePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//h2[text()='Onboard OCN Node']")
	WebElement onboardNodeLink;
	
	@FindBy(xpath="//span[text()='Node ID']/../..")
	WebElement nodeidField;
	
	@FindBy(xpath="//span[text()='Public IP']/../..")
	WebElement publicipField;

	public OnboardNodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterNodeid(String nodeid) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(nodeidField));
		nodeidField.sendKeys(nodeid);
	}

	public void enterPublicIp(String publicIp) {
		publicipField.sendKeys(publicIp);
	}

}
