package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.RequestCourierScreen;

public class StuartTest extends BaseTest {

  @Test
  public void testRequestCourierScreen() {
    LoginScreen loginScreen = new HomeScreen(driver, wait).accessLogin();
    RequestCourierScreen requestCourierScreen = loginScreen
        .login("stuartandroid@mailinator.com", "test1234");
    Assert.assertTrue(requestCourierScreen.isScreenLoaded(), "TEST KO: Request cards are not present.");
  }
}
