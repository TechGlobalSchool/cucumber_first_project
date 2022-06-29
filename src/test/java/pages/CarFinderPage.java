package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarFinderPage {
    public CarFinderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[class='leftSide']>h1")
    public WebElement carvanaCarFinderHeading1;

    @FindBy(css = "div[class='leftSide']>h3")
    public WebElement carvanaCarFinderHeading3;

    @FindBy(css = "a[data-qa='router-link']")
    public WebElement tryCarFinderLink;

    @FindBy(css = "div[data-qa='headline']")
    public WebElement headline;

    @FindBy(css = "div[data-qa='sub-heading']")
    public WebElement subHeading;
}
