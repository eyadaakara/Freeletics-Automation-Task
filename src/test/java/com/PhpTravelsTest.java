package com;

import com.freeletics.drivers.InitDriver;
import com.freeletics.page.PhpTravelsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PhpTravelsTest {

  private InitDriver driver;
  private PhpTravelsPage phpTravelsPage;

  @BeforeClass
  public void setup() {
    driver = new InitDriver();
    driver.setup();
    phpTravelsPage = new PhpTravelsPage(driver);
  }

  @Test(priority = 1, description = "Verify that the hotels retrieved in Listing page successfully")
  public void verifyHotelsRetrieved() {

    driver.waitVisibility(phpTravelsPage.getCityField(), 10);
    phpTravelsPage.getCityField().click();
    phpTravelsPage.getCitySearchField().sendKeys("Munich");
    driver.waitVisibility(phpTravelsPage.getFirstSearchOption(), 10);
    phpTravelsPage.getFirstSearchOption().click();
    phpTravelsPage.getSearchButton().click();
    if (phpTravelsPage.getNoResultFoundImage().isDisplayed()) {
      Assert.assertTrue(phpTravelsPage.getNoResultFoundImage().isDisplayed());
      driver.getDriver().quit();
      System.out.println("The execution stopped because no result found!");
    } else {
      driver.waitVisibility(phpTravelsPage.getHotelsList().get(0), 10);
      Assert.assertTrue(phpTravelsPage.getHotelsList().size() >= 3);
      Assert.assertTrue(phpTravelsPage.getPricesHotelsList().get(0).isDisplayed());
      Assert.assertTrue(phpTravelsPage.getHotelsList().get(0).isDisplayed());
      Assert.assertEquals(phpTravelsPage.getCityNameInListingPage().getText(), "Munich");
      Assert.assertTrue(phpTravelsPage.getStarGradeLabel().isDisplayed());
      Assert.assertEquals(phpTravelsPage.getStarGradeLabel().getText(), "Star Grade");
      Assert.assertTrue(phpTravelsPage.getStarGradeContainer().isDisplayed());
      Assert.assertEquals(phpTravelsPage.getStarGradeList().size(), 5);
    }
  }

  @Test(priority = 2, description = "Verify that the hotel details page is open successfully")
  public void verifyHotelDetails() {

    phpTravelsPage.getHotelDetailsList().get(0).click();
    driver.waitVisibility(phpTravelsPage.getMorePhotosButton(), 10);

    Assert.assertTrue(phpTravelsPage.getMorePhotosButton().isDisplayed());
    Assert.assertEquals(phpTravelsPage.getMorePhotosButton().getText(), "More Photos");
  }

  @AfterClass()
  public void tearDown() {
    driver.tearDown();
  }
}
