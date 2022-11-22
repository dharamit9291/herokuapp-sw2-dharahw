package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utitlities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

   @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
@Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
    sendTextToElement(By.id("username"),"tomsmith");
    sendTextToElement(By.id("password"), "SuperSecretPassword!");
    clickOnElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']"));

    String expMessage = "Secure Area";
    String actMessage = getTextFromElement(By.xpath("//h2"));
    Assert.assertEquals("Not matched ",expMessage,actMessage);

}
@Test
    public void verifyTheUsernameErrorMessage (){
    sendTextToElement(By.id("username"),"tomsmit");
    sendTextToElement(By.id("password"), "SuperSecretPassword!");
    clickOnElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']"));

    String expMessage = "Your username is invalid!";
    String actMessage = getTextFromElement(By.xpath("//div[@id = 'flash']")).substring(0,25);
    Assert.assertEquals("Error happened ",expMessage,actMessage);

}

@Test
        public void verifyThePasswordErrorMessage (){
        sendTextToElement(By.id("username"),"tomsmith");
        sendTextToElement(By.id("password"), "SuperSecretPassword");
        clickOnElement(By.xpath("//i[@class = 'fa fa-2x fa-sign-in']"));

        String expMessage = "Your password is invalid!";
        String actMessage = getTextFromElement(By.xpath("//div[@id = 'flash']")).substring(0,25);
        Assert.assertEquals("Error happened ",expMessage,actMessage);
}

@After
    public void teardown(){
       closeBrowser();
      }
}
