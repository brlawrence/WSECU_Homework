package richard.wsecuHomework.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public static File file;
	
	public Base()   {
		String userdir = System.getProperty("user.dir");
		file = new File(userdir + "\\src\\main\\java\\richard\\wsecuHomework\\config\\config.properties");
		FileInputStream fileinput = null;
		try {
			fileinput = new FileInputStream(file);}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fileinput);
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
	
	
	public static void initialize() {
		ChromeOptions opt = new ChromeOptions();
		DesiredCapabilities cap = new DesiredCapabilities();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		cap.setCapability(ChromeOptions.CAPABILITY,opt);
		int timeout = Integer.valueOf(prop.getProperty("impTimeout"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		driver.get(prop.getProperty("url"));
	}
}
