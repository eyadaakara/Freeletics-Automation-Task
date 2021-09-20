package com.freeletics.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitDriver {

  protected WebDriver driver;
  protected ChromeOptions options = new ChromeOptions();

  /**
   * setup method: helps to start launching the driver and navigate to the intended URL. options: to
   * dismiss the notification browser popup. maximize: to open the browser page in full screen mode.
   */
  public void setup() {
    options.addArguments("--disable-notifications");
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(options);
    driver.get("https://www.phptravels.net/");
    driver.manage().window().maximize();
  }

  /** tearDown: to kill the up and running driver. */
  public void tearDown() {
    driver.quit();
  }

  public WebDriver getDriver() {
    return driver;
  }

  /**
   * @param elementBy: the element you are waiting for
   * @param time: the time you will wait fore in seconds.
   */
  public void waitVisibility(WebElement elementBy, int time) {
    WebDriverWait wait = new WebDriverWait(driver, time);
    wait.until(ExpectedConditions.visibilityOf(elementBy));
  }
}
