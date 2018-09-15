import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Stuart {

  private static AppiumDriverLocalService service;
  public AppiumDriver<WebElement> driver;

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
    capabilities.setCapability("appPackage", "com.stuart.client.beta");

    driver = new AndroidDriver<>(service.getUrl(), capabilities);
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

  @Test
  public void testBasicAlert() {
    driver.findElement(By.id("com.stuart.client.beta:id/splash_login")).click();
  }
}
