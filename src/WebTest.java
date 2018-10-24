import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "./bin/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://store.demoqa.com");
		System.out.println("Successfully opened the website.");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
		System.out.println("closed...");
	}

}
