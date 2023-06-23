package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonPage extends BasePage {

    /**
     * Radio Buttons Page Elements
     */
    private WebElement yesButton;
    private WebElement youHaveSelectedYesMSG;
    private WebElement impressiveButton;
    private WebElement youHaveSelectedImpressiveMsg;
    private WebElement noButton;


    /**
     * Radio Buttons Page Constructor
     */
    public RadioButtonPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    /**
     * Radio Buttons Page Getters
     */
    public WebElement getYesButton(){
        yesButton = getDriver().findElement(By.xpath("//label[@for='yesRadio']"));
        return yesButton;
    }
    public WebElement getYouHaveSelectedYesMSG(){
        youHaveSelectedYesMSG = getDriver().findElement(
                By.xpath("//span[@class='text-success'][text()='Yes']"));
        return youHaveSelectedYesMSG;
    }
    public WebElement getImpressiveButton(){
        impressiveButton = getDriver().findElement(By.xpath("//label[@for='impressiveRadio']"));
        return impressiveButton;
    }
    public WebElement getYouHaveSelectedImpressiveMsg(){
        youHaveSelectedImpressiveMsg = getDriver().findElement(
                By.xpath("//span[@class='text-success'][text()='Impressive']"));
        return youHaveSelectedImpressiveMsg;
    }
    public WebElement getNoButton(){
        noButton = getDriver().findElement(By.xpath("//label[@for='noRadio']"));
        return noButton;
    }


    /**
     * Select Radio Button Methods
     */
    public RadioButtonPage selectYesBtn(){
        getWait().until(ExpectedConditions.elementToBeClickable(getYesButton()));
        getYesButton().click();
        return this;
    }

    public RadioButtonPage selectImpressiveBtn(){
        getWait().until(ExpectedConditions.elementToBeClickable(getImpressiveButton()));
        getImpressiveButton().click();
        return this;
    }

    public RadioButtonPage selectNoButton(){
        getWait().until(ExpectedConditions.elementToBeClickable(getNoButton()));
        getNoButton().click();
        return this;
    }


    /**
     * Go to Radio Buttons Page
     */
    public RadioButtonPage goToPage(){
        getDriver().get("https://demoqa.com/radio-button");
        return this;
    }
}
