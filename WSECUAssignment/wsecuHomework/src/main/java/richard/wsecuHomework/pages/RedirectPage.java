package richard.wsecuHomework.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import richard.wsecuHomework.base.Base;

public class RedirectPage extends Base {
	
	public WebElement passwordInput() {
		return (driver.findElement(By.xpath("//div/input[@name='password']")));
	}
	
	public WebElement signInButton() {
		return (driver.findElement(By.xpath("//div/button[@type='submit']")));
	}
	
	public WebElement inCorrectUserNameErrorMessage() {
		return (driver.findElement(By.xpath("//div[contains(text(),'incorrect username')]")));
	}
	
}