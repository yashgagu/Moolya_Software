package Moolya;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Base_Class {
	static WebDriver driver;
	static WebDriverWait wait;
	By women_Sec = By.xpath("//a[@title='Women']");
	By dress = By.xpath("//div/a/img[@title='Blouse']");
	By addToCart = By.xpath("(//div/a[@title='Add to cart']/span)[2]");
	By PCheckout = By.xpath("//div/a[@title='Proceed to checkout']");
	By Cart_checkout = By.xpath("//p[@class='cart_navigation clearfix']/a/span");
	By username = By.id("email");
	By password = By.id("passwd");
	By click = By.xpath("//button[@id='SubmitLogin']");
	By ProcessAddress = By.xpath("//button[@name='processAddress']");
	By confirmcheckbox = By.xpath("//div/span//input[@type='checkbox']");
	By processCarrier = By.xpath("//button[@name='processCarrier']");
	By payment = By.xpath("//p//a[@title='Pay by bank wire']");
	By confirmOrder = By.xpath("//button//span[text()='I confirm my order']");
	By succesful = By.xpath("//p/strong[text()='Your order on My Store is complete.']");

	
	public void launchurl(String url) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
		public void  clickFilter () {
			List<WebElement> filters = driver.findElements(By.xpath("//input[@type='checkbox']"));
			filters.get(0).click();
			filters.get(3).click();
			filters.get(7).click();
		}
	public void doclick(By locator) {
		driver.findElement(locator).click();
	}
	public WebElement getelement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}
	
	public void doSendkeys(By locator, String value) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);

	}

		public void movetoelement (By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(locator)).build().perform();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
