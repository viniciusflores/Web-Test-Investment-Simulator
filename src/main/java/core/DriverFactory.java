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
				ChromeOptions options = new ChromeOptions();
				FirefoxOptions optionsFirefox = new FirefoxOptions();
				switch (AutomationTypeEnum.valueOf(browser)) {
				case CHROME:
					WebDriverManager.chromedriver().setup();
					options.addArguments("--window-size=1024,768");
					options.addArguments("--start-maximized");
					//options.addArguments("--headless");
					driver = new ChromeDriver(options);
					driver.get(Constants.URL);
					break;
				case FIREFOX:
					WebDriverManager.firefoxdriver().setup();
					optionsFirefox.addArguments("--headless");
					driver = new FirefoxDriver(optionsFirefox);
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
