package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

  By emailInput = By.id("edit_email");
  By pwdInput = By.id("login_password");
  By loginButton = By.id("login_button");

  public LoginPage(AndroidDriver driver, WebDriverWait wait) {
    super(driver, wait);
    waitForPageLoaded();
  }

  public void waitForPageLoaded() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(emailInput));
  }

  public RequestCourierPage login(String email, String pwd) {
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(pwdInput).sendKeys(pwd);
    driver.findElement(loginButton).click();
    return new RequestCourierPage(driver, wait);
  }
}
