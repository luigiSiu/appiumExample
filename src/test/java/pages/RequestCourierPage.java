package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestCourierPage extends BasePage {

  By requestPickupCard = By.id("com.stuart.client.beta:id/request_pickup_card");
  By requestDropOffCard = By.id("com.stuart.client.beta:id/request_drop_off_card");

  public RequestCourierPage(AppiumDriver driver, WebDriverWait wait) {
    super(driver, wait);
    waitForPageLoaded();
  }

  public void waitForPageLoaded() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(requestPickupCard));
  }

  public boolean isPageLoaded() {
    return driver.findElements(requestPickupCard).size() > 0
        && driver.findElements(requestDropOffCard).size() > 0;
  }
}
