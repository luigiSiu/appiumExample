package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  public AppiumDriver<WebElement> driver;
  public WebDriverWait wait;

  public BasePage(AppiumDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }
}
