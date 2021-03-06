import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgLoginAuthentication {

	private String url;
	private FirefoxDriver driver;

	@BeforeClass
	public void beforeClass() {
		// web app to be tested
		url = "http://narmada.cegres.co.in:3001/";
		System.setProperty("webdriver.gecko.driver", "~/geckodriver");
		//System.setProperty("webdriver.gecko.driver", "./bin/geckodriver.exe");
		// headless mode
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		driver = new FirefoxDriver(firefoxOptions);
		
		// head mode
		// WebDriver driver = new FirefoxDriver();

		/* selenium grid mode
		 * String node = "http:narmada.cegres.co.in:4444/wd/hub";
		 * DesiredCapabilities cap = DesiredCapabilities.firefox(); driver = new
		 * RemoteWebDriver(new URL(node), cap); driver.navigate().to(url);
		 */
	}

	@Test
	public void f() throws MalformedURLException {
		driver.get(url);
		System.out.println("Successfully opened the website.");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("login")).sendKeys("devops");
		driver.findElement(By.name("password")).sendKeys("test");
		driver.findElement(By.name("click")).click();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		System.out.println("closed...");
	}
}
