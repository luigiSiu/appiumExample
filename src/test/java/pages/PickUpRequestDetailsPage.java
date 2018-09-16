package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PickUpRequestDetailsPage extends BasePage {

  By contactEditMap = By.id("contact_edit_map");

  public PickUpRequestDetailsPage(AppiumDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public boolean isPageLoaded() {
    return driver.findElements(contactEditMap).size() != 0;
  }
}
