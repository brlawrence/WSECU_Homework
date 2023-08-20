package richard.wsecuHomework.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import richard.wsecuHomework.base.Base;

public class LoginPage extends Base {
	
	public WebElement userName() {
		return (driver.findElement(By.xpath("//form/input[@id='digital-banking-username']")));
	}
	
	public WebElement signInButton() {
		return (driver.findElement(By.xpath("//form/input[@type='submit' and @class='button']")));
	}
	
	public void signIn(String userNameInput) {
	userName().click();
	userName().sendKeys(userNameInput);
	signInButton().click();
	}
}