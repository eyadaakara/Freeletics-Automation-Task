package com.freeletics.page;

import com.freeletics.drivers.InitDriver;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
@Setter
public class PhpTravelsPage {

  private final InitDriver driver;

  @FindBy(className = "input-items")
  private WebElement cityField;

  @FindBy(className = "select2-search__field")
  private WebElement citySearchField;

  @FindBy(className = "select2-selection__rendered")
  private WebElement cityNameInListingPage;

  @FindBy(
      xpath =
          "//li[contains(@class,'select2-results__option select2-results__option--highlighted')]")
  private WebElement firstSearchOption;

  @FindBy(id = "submit")
  private WebElement searchButton;

  @FindBy(className = "card-img")
  private List<WebElement> hotelsList;

  @FindBy(xpath = "(//a[@class='more_details effect mt-0 btn-block ladda-button waves-effect'])")
  private List<WebElement> hotelDetailsList;

  @FindBy(xpath = "(//span[contains(@class,'price__num')])")
  private List<WebElement> pricesHotelsList;

  @FindBy(xpath = "//h3[@class='title stroke-shape'][contains(.,'Star Grade')]")
  private WebElement starGradeLabel;

  @FindBy(xpath = "//ul[contains(@class,'list remove_duplication')]")
  private WebElement starGradeContainer;

  @FindBy(xpath = "//label[@class='custom-control-label']")
  private List<WebElement> starGradeList;

  @FindBy(xpath = "//a[@class='btn theme-btn waves-effect']")
  private WebElement morePhotosButton;

  @FindBy(xpath = "//img[contains(@alt,'no results')]")
  private WebElement noResultFoundImage;

  public PhpTravelsPage(InitDriver driver) {
    this.driver = driver;
    PageFactory.initElements(this.driver.getDriver(), this);
  }
}
