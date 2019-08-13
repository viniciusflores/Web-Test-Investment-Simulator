package core;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

/**
 * 
 * @author vinicius.flores
 *
 */
@Listeners({ ScreenshotUtility.class })
public class BaseTest extends DriverFactory {

	@BeforeClass
	@Parameters({ "browser", "device" })
	public static void setUpBaseTest(String type, String device) {
		setProperty("BROWSER", type);
		setProperty("DEVICE", device);
		
		createDriver(getProperty("BROWSER"), getProperty("DEVICE"));
	}

	@AfterClass
	public static void tearDown() {
		killDriver();
	}

	public static void waitFixed(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
