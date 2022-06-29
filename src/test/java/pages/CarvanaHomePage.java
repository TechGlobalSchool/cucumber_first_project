package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.Hooks;
import utils.Driver;

import java.util.List;

public class CarvanaHomePage {
    public CarvanaHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='HeaderMenustyles__HeaderItems-ogb5qa-1 dewPuX']/*[contains(@data-qa, 'menu')]")
    public List<WebElement> headerItems;

    public void clickOnHeaderItem(String headerItemText){
        for(WebElement element: headerItems){
            if(element.getText().equals(headerItemText)){
                element.click();
                break;
            }
        }
    }

    public void moveToHeaderItem(String headerItemText){
        for(WebElement element: headerItems){
            if(element.getText().equals(headerItemText)){
                new Actions(Hooks.driver).moveToElement(element).perform();
                break;
            }
        }
    }

    @FindBy(css = "a[data-cv-test^='headerFinance']")
    public List<WebElement> financeItems;

    public void clickOnFinanceItem(String financeItemText){
        for(WebElement element: financeItems){
            if(element.getText().equals(financeItemText)){
                element.click();
                break;
            }
        }
    }

}
