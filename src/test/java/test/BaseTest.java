package test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import java.io.File;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

  public static String PACKAGE = "com.stuart.client.beta";
  private static AppiumDriverLocalService service;
  public AndroidDriver<WebElement> driver;
  public WebDriverWait wait;

  @BeforeClass
  public void setUp() throws Exception {
    service = AppiumDriverLocalService.buildDefaultService();
    service.start();

    if (service == null || !service.isRunning()) {
      throw new AppiumServerHasNotBeenStartedLocallyException(
          "An appium server node is not started!");
    }
    File classpathRoot = new File(System.getProperty("user.dir"));
    File app = new File(classpathRoot.getCanonicalPath(), "beta-release-client-20000102.apk");

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("deviceName", "Android Emulator");
    capabilities.setCapability("app", app.getAbsolutePath());
    capabilities.setCapability("appActivity", "com.stuart.client.activities.PosActivity");
    capabilities.setCapability("appPackage", PACKAGE);

    driver = new AndroidDriver<WebElement>(service.getUrl(), capabilities);
  }

  @AfterClass
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
    if (service != null) {
      service.stop();
    }
  }
}
