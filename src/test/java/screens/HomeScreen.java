package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreen extends BaseScreen {

  By loginButton = By.id("splash_login");

  public HomeScreen(AndroidDriver driver, WebDriverWait wait) {
    super(driver, wait);
    waitForPageLoaded();
  }

  public void waitForPageLoaded() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(loginButton));
  }

  public LoginScreen accessLogin() {
    driver.findElement(loginButton).click();
    return new LoginScreen(driver, wait);
  }
}
