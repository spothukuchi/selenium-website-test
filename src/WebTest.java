import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebTest {

	public static void main(String[] args) throws MalformedURLException {
		System.setProperty("webdriver.gecko.driver", "~/geckodriver");
		
		//web app to be tested
		String url = "http://facebook.com";
		
		//selenium grid url
		//String node = "http:narmada.cegres.co.in:4444/wd/hub";
		
		//headless mode
		/*FirefoxBinary firefoxBinary = new FirefoxBinary(); 
		firefoxBinary.addCommandLineOptions("--headless");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		FirefoxDriver driver = new FirefoxDriver(firefoxOptions);*/
		
		//head mode
		WebDriver driver = new FirefoxDriver();
		
		//selenium grid
		/*DesiredCapabilities cap = DesiredCapabilities.firefox();
		driver = new RemoteWebDriver(new URL(node), cap);
		driver.navigate().to(url);*/
		
		driver.get(url);
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
