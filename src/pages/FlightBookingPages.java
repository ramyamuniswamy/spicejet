package pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class FlightBookingPages {
	@FindBy(css = "div[class='css-1dbjc4n r-1awozwy r-1xfd6ze r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73']")
	WebElement ContinueButton;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement lastName;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement mobileNumber;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement email;

	@FindBy(xpath = "//div[text()='I am flying as the primary passenger']")
	WebElement checkBoxButton;

	@FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
	WebElement conButton;

	@FindBy(xpath = "(//div[@data-testid='add-ons-continue-footer-button'])[3]")
	WebElement continueButton2;
	@FindBy(className = "name_on_card_iframe")
	WebElement iframeCardName;

	@FindBy(className = "card_exp_month_iframe")
	WebElement iframeExpMonth;

	@FindBy(className = "card_exp_year_iframe")
	WebElement iframeExpYear;

	@FindBy(className = "security_code_iframe")
	WebElement iframeSecurCode;

	@FindBy(id = "card_exp_month")
	WebElement expMonth;

	@FindBy(id = "card_exp_year")
	WebElement expYear;

	@FindBy(id = "security_code")
	WebElement securitycode;
	@FindBy(className = "card_number_iframe")
	WebElement iframeCardNumber;

	@FindBy(id = "card_number")
	WebElement cardNumber;

	@FindBy(id = "name_on_card")
	WebElement nameCard;

	WebDriver driver;

	public FlightBookingPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToBooking() {
		ContinueButton.click();
	}

	public void bookingDetail(String fname, String lName, String number, String em) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lName);
		mobileNumber.sendKeys(number);
		email.sendKeys(em);
		checkBoxButton.click();
		conButton.click();
		continueButton2.click();
	}
	public void PaymentMethods() {
		continueButton2.click();
	}

	public void switchToFrameCardNumber() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeCardNumber));
	}

	public void switchToFrameCardName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeCardName));
	}

	public void switchToFrameExpMonth() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeExpMonth));
	}

	public void switchToFrameExpYear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeExpYear));
	}

	public void switchToFrameSecurCode() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeSecurCode));
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void cardNumber(String number) {
		switchToFrameCardNumber();
		cardNumber.sendKeys(number);
		switchToDefaultContent();
	}

	public void cardName(String name) {
		switchToFrameCardName();
		nameCard.sendKeys(name);
		switchToDefaultContent();
	}

	public void expiryMonth(String mm) {
		switchToFrameExpMonth();
		expMonth.sendKeys(mm);
		switchToDefaultContent();
	}

	public void expiryYear(String yy) {
		switchToFrameExpYear();
		expYear.sendKeys(yy);
		switchToDefaultContent();
	}

	public void secureCode(String cvv) {
		switchToFrameSecurCode();
		securitycode.sendKeys(cvv);
		switchToDefaultContent();
	}

}
