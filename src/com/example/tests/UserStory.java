package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;	
import org.openqa.selenium.support.ui.Select;

public class UserStory {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://foodchain.co/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUserStory6() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("name1")).clear();
    driver.findElement(By.id("name1")).sendKeys("justin");
    driver.findElement(By.id("email1")).clear();
    driver.findElement(By.id("email1")).sendKeys("test@test.co");
    driver.findElement(By.id("iOS")).click();
    driver.findElement(By.id("submit1")).click();
    assertEquals("test@test.co", driver.findElement(By.id("email1")).getAttribute("value"));
    assertEquals("justin", driver.findElement(By.id("name1")).getAttribute("value"));
  }

  @Test
  public void testUserStory7() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("name1")).clear();
    driver.findElement(By.id("name1")).sendKeys("test");
    driver.findElement(By.id("email1")).clear();
    driver.findElement(By.id("email1")).sendKeys("test@test.co");
    driver.findElement(By.id("iOS")).click();
    driver.findElement(By.id("Android")).click();
    assertEquals("Android", driver.findElement(By.id("Android")).getAttribute("value"));
    assertEquals("iOS", driver.findElement(By.id("iOS")).getAttribute("value"));
  }

  @Test
  public void testUserStory8() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("name1")).clear();
    driver.findElement(By.id("name1")).sendKeys("justin");
    driver.findElement(By.id("submit1")).click();
    assertEquals("Check that you entered your email correctly.", closeAlertAndGetItsText());
    driver.findElement(By.id("name1")).clear();
    driver.findElement(By.id("name1")).sendKeys("");
    driver.findElement(By.id("email1")).clear();
    driver.findElement(By.id("email1")).sendKeys("jrust@test.co");
    driver.findElement(By.id("submit1")).click();
    assertEquals("Check that you entered your name correctly.", closeAlertAndGetItsText());
  }

  @Test
  public void testCase9() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("name1")).clear();
    driver.findElement(By.id("name1")).sendKeys("justin");
    driver.findElement(By.id("email1")).clear();
    driver.findElement(By.id("email1")).sendKeys("test@invalidemail");
    driver.findElement(By.id("Android")).click();
    driver.findElement(By.id("submit1")).click();
    assertEquals("Check that you entered your email correctly.", closeAlertAndGetItsText());
    driver.findElement(By.id("email1")).clear();
    driver.findElement(By.id("email1")).sendKeys("test@invalidemail.thisisinvalid");
    driver.findElement(By.id("submit1")).click();
    assertEquals("Check that you entered your email correctly.", closeAlertAndGetItsText());
    driver.findElement(By.id("email1")).clear();
    driver.findElement(By.id("email1")).sendKeys("test@invalidemail.thisis invalid");
    driver.findElement(By.id("submit1")).click();
    assertEquals("Check that you entered your email correctly.", closeAlertAndGetItsText());
    driver.findElement(By.id("email1")).clear();
    driver.findElement(By.id("email1")).sendKeys("test@");
    driver.findElement(By.id("submit1")).click();
    assertEquals("Check that you entered your email correctly.", closeAlertAndGetItsText());
  }

  @Test
  public void test10() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("name1")).clear();
    driver.findElement(By.id("name1")).sendKeys("justin");
    driver.findElement(By.id("email1")).clear();
    driver.findElement(By.id("email1")).sendKeys("validemail@valid.co");
    driver.findElement(By.id("Android")).click();
    driver.findElement(By.id("submit1")).click();
    assertEquals("", closeAlertAndGetItsText());
  }

  @Test
  public void test11() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("name1")).clear();
    driver.findElement(By.id("name1")).sendKeys("justin");
    driver.findElement(By.id("email1")).clear();
    driver.findElement(By.id("email1")).sendKeys("validemail@valid.co");
    driver.findElement(By.id("Android")).click();
    driver.findElement(By.id("submit1")).click();
    assertEquals("justin", driver.findElement(By.id("name1")).getAttribute("value"));
    assertEquals("", driver.findElement(By.id("email1")).getAttribute("value"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
