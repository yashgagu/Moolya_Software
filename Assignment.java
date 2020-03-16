package Moolya;

import java.util.List;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment extends Base_Class {

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"G:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);

	}

	@Test
	public void main() throws InterruptedException {

		
		launchurl("http://automationpractice.com/");
		wait.until(ExpectedConditions.visibilityOf(getelement(women_Sec)));
		doclick(women_Sec);
		Thread.sleep(3000);
		clickFilter();

		movetoelement(dress);

		doclick(addToCart);

		wait.until(ExpectedConditions.visibilityOf(getelement(PCheckout)));
		doclick(PCheckout);

		wait.until(ExpectedConditions.visibilityOf(getelement(Cart_checkout)));
		doclick(Cart_checkout);

		wait.until(ExpectedConditions.visibilityOf(getelement(username)));
		doSendkeys(username, "yashkarn@live.in");
		doSendkeys(password, "123456");
		doclick(click);

		wait.until(ExpectedConditions.visibilityOf(getelement(ProcessAddress)));
		doclick(ProcessAddress);
		movetoelement(confirmcheckbox);
		doclick(confirmcheckbox);

		doclick(processCarrier);
		
		wait.until(ExpectedConditions.visibilityOf(getelement(payment)));
		doclick(payment);
		wait.until(ExpectedConditions
				.visibilityOf(getelement(confirmOrder)));
		doclick(confirmOrder);
		String Expected = getelement(succesful).getText();
		Assert.assertEquals(Expected, "Your order on My Store is complete.", "Text Case Passed");

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
