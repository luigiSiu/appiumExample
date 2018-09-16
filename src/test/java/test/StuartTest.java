package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RequestCourierPage;

public class StuartTest extends BaseTest {

  @Test
  public void testRequestCourierPage() {
    LoginPage loginPage = new HomePage(driver, wait).accessLogin();
    RequestCourierPage requestCourierPage = loginPage
        .login("stuartandroid@mailinator.com", "test1234");
    Assert.assertTrue(requestCourierPage.isPageLoaded(), "TEST KO: Request cards are not present.");
  }
}
