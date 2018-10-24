import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "./bin/geckodriver.exe");
		
		//headless mode
		/*FirefoxBinary firefoxBinary = new FirefoxBinary(); 
		firefoxBinary.addCommandLineOptions("--headless");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		FirefoxDriver driver = new FirefoxDriver(firefoxOptions);*/
		
		//head mode
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://facebook.com");
		System.out.println("Successfully opened the website.");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("email")).sendKeys("dummy");
		driver.findElement(By.name("pass")).sendKeys("dummy");
		driver.findElement(By.id("loginbutton")).click();
		
		driver.quit();
		System.out.println("closed...");
	}

}
