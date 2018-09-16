package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PickUpRequestDetailsPage;
import pages.RequestCourierPage;
import pages.RequestPickUpPage;

public class StuartTest extends BaseTest {

  @Test
  public void testRequestPickUp() {
    LoginPage loginPage = new HomePage(driver, wait).accessLogin();
    RequestCourierPage requestCourierPage = loginPage
        .login("stuartandroid@mailinator.com", "test1234");
    Assert.assertTrue(requestCourierPage.isPageLoaded(), "TEST KO: Request cards are not present.");

    RequestPickUpPage requestPickUpPage = requestCourierPage.requestPickUp();
    PickUpRequestDetailsPage pickUpRequestDetailsPage = requestPickUpPage
        .waitForAllowDeviceLocationAlert()
        .setAllowDeviceLocation()
        .searchAddress("Travessera de Gràcia, 176-178, 08012 Barcelona");
    Assert.assertTrue(pickUpRequestDetailsPage.isPageLoaded(),
        "TEST KO: Request cards are not present.");
  }
}
