package pages;

import static test.BaseTest.PACKAGE;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestPickUpPage extends BasePage {

  By allowDeviceLocation = By.id("com.android.packageinstaller:id/permission_allow_button");
  By addressInput = By
      .id("com.stuart.client.activities.AddressSearchActivity:id/search_address_input");

  public RequestPickUpPage(AndroidDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public RequestPickUpPage waitForAllowDeviceLocationAlert() {
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(allowDeviceLocation));
    return this;
  }

  public RequestPickUpPage setAllowDeviceLocation() {
    driver.findElement(allowDeviceLocation).click();
    return this;
  }

  public PickUpRequestDetailsPage searchAddress(String address) {
    Activity addressSearchActivity = new Activity(PACKAGE,
        "com.stuart.client.activities.AddressSearchActivity");
    driver.startActivity(addressSearchActivity);
    driver.findElement(addressInput).sendKeys(address);
    return new PickUpRequestDetailsPage(driver, wait);
  }
}
