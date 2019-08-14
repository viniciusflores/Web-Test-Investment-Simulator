package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import project_constants.AutomationTypeEnum;
import project_constants.Constants;

public class DriverFactory {
	protected static WebDriver driver;

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public static WebDriver createDriver(String browser) {
		if (driver == null) {
			try {
				ChromeOptions chromeOptions = new ChromeOptions();
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				switch (AutomationTypeEnum.valueOf(browser)) {
				case CHROME:
					WebDriverManager.chromedriver().setup();
					chromeOptions.addArguments("--window-size=1024,768");
					chromeOptions.addArguments("--start-maximized");
					chromeOptions.addArguments("--headless");
					driver = new ChromeDriver(chromeOptions);
					driver.get(Constants.URL);
					break;
				case FIREFOX:
					WebDriverManager.firefoxdriver().setup();
					firefoxOptions.addArguments("--window-size=1024,768");
					firefoxOptions.addArguments("--start-maximized");
					firefoxOptions.addArguments("--headless");
					driver = new FirefoxDriver(firefoxOptions);
					driver.get(Constants.URL);
					break;

				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driver;
	}

}
