package richard.wsecuHomework.test;
import richard.wsecuHomework.base.Base;
import richard.wsecuHomework.pages.LoginPage;
import richard.wsecuHomework.pages.RedirectPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

//import com.relevantcodes.extentreports.LogStatus;

import java.lang.Object;

public class FullSequenceTest extends Base {
	LoginPage lp = new LoginPage();
	RedirectPage rp = new RedirectPage();
	String userNameInput = "thisuserwillnotwork";
	String incorrectPasswordInput = "thispasswillfailforsure";
	String actualMessage = "", actualURL = "";
	
public FullSequenceTest() throws Exception {
	super();   // This calls the constructor of the parent class
}

@BeforeMethod
public void sequenceOfActions() throws Exception {
	Base.initialize();
}

@Test(priority = 1, description="Login redirection URL test")
public void sequence1() throws Exception {
	
	// Initial page - entering incorrect user name
	lp.signIn(userNameInput);
	
	// Landing page - entering incorrect password
	rp.passwordEntry(incorrectPasswordInput);
	
	actualURL = driver.getCurrentUrl();
	
	Reporter.log("Validating Redirection URL");
	Assert.assertEquals(actualURL, prop.getProperty("RedirectionURL"), "Incorrect Redirection Landing Page");
	

}

@Test(priority=2, description="Login error message Test")
public void sequence2() throws Exception {
	
	Reporter.log("Testing Error Message");
		lp.signIn(userNameInput);
		rp.passwordEntry(incorrectPasswordInput);
		actualMessage = rp.inCorrectUserNameErrorMessage().getText();
	Assert.assertEquals(actualMessage, prop.getProperty("errorMessage"), "Incorrect Error Message");	
}
	@AfterMethod
public void teardown() {
	driver.quit();
}

}
