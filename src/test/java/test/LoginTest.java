package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RequestCourierPage;

public class LoginTest extends BaseTest {

  @Test
  public void testLogin() {
    LoginPage loginPage = new HomePage(driver, wait).accessLogin();
    RequestCourierPage requestCourierPage = loginPage
        .login("stuartandroid@mailinator.com", "test1234");
    Assert.assertTrue(requestCourierPage.isPageLoaded(), "TEST KO: Request cards are not present.");
  }
}
