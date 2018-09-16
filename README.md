
# appiumExample

In order to be able to run this test Gradle , Appium and the Android SDK platform tools are needed:

I recommend [Brew](https://brew.sh/) to install both dependencies:
* [Gradle](https://gradle.org/install/)
* Follow [Appium](http://appium.io/docs/en/about-appium/getting-started/#installing-appium) install guide
* [Android SDK](https://developer.android.com/studio/): Needed to have Appium dependencies to communicate with the Android device and also to create virtual devices in order to run the automated tests against them.
  * And set the environment variables:
  `export ANDROID_HOME=~/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools`

Once those dependencies are resolved, to execute the test just run: `gradle test`

----

As did in other test automation examples, I am using Gradle, TestNG and the page object pattern.
* Gradle provides an easy way to resolve dependencies from the testing framework and to lunch the tests.
* TestNG is a powerful testing framework that will not only gives the property to launch tests, also will provide solutions like to modify the tests listeners, test groups, etc..
* With the page object pattern every different page from the app will be represented by a single class. Un such way this framework will be easily to increase and maintain.
  * Here the 'page' is substituted by 'screen', as every step in the app could be called a different screen.
  * Also mention that in this example should be easy to add more tests and go further more in every test. So could finally be a smoke test or a regression suite in 'little time'.

Wait for page loaded:
In this example I am using the wait for page loaded in each page object constructor, so every time a new page object is needed, the framework will wait for the most relevant element is present, assuring that the test can continue. This also allows avoid explicit waits in the test class.

Test definition:
This test just verifies the request courier page:
  * Access the login screen and login into the system
  * Verify the request courier page is loaded
