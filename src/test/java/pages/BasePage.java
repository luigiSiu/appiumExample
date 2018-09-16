package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  public AndroidDriver<WebElement> driver;
  public WebDriverWait wait;

  public BasePage(AndroidDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }
}
