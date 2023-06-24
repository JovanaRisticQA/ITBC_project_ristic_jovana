package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ToolTipsPage extends BasePage {

    /**
     * Tool Tips Page Elements
     */
    private WebElement hoverToSeeMeButton;
    private WebElement hoverToSeeMeTextField;
    private WebElement textLink;
    private WebElement numberLink;
    private WebElement youHoveredOverTheButtonMessage;
    private WebElement youHoveredOverTheTextFieldMessage;
    private WebElement youHoveredOverTheTextLinkMessage;
    private WebElement youHoveredOverTheNumbersLinkMessage;


    /**
     * Tool Tips Page Constructor
     */
    public ToolTipsPage(WebDriver driver, WebDriverWait wait, Actions action, JavascriptExecutor js) {
        super(driver, wait, action, js);
    }


    /**
     * Tool Tips Page Getters
     */
    public WebElement getHoverToSeeMeButton() {
        hoverToSeeMeButton = getDriver().findElement(By.id("toolTipButton"));
        return hoverToSeeMeButton;
    }
    public WebElement getHoverToSeeMeTextField() {
        hoverToSeeMeTextField = getDriver().findElement(By.id("toolTipTextField"));
        return hoverToSeeMeTextField;
    }
    public WebElement getTextLink() {
        textLink = getDriver().findElement(By.linkText("Contrary"));
        return textLink;
    }
    public WebElement getNumberLink() {
        numberLink = getDriver().findElement(By.linkText("1.10.32"));
        return numberLink;
    }
    //setTimeout(()=> {debugger},5000)    -- add to console to “freeze” the browser
                                         // (it's easier to get selectors for Tool Tips)
    public WebElement getYouHoveredOverTheButtonTooltip(){
        youHoveredOverTheButtonMessage = getDriver().findElement(
                By.xpath("//div[text()='You hovered over the Button']"));
        return youHoveredOverTheButtonMessage;
    }
    public WebElement getYouHoveredOverTheTextFieldTooltip(){
        youHoveredOverTheTextFieldMessage = getDriver().findElement(
                By.xpath("//div[text()='You hovered over the text field']"));
        return youHoveredOverTheTextFieldMessage;
    }
    public WebElement getYouHoveredOverTheTextLinkTooltip(){
        youHoveredOverTheTextLinkMessage = getDriver().findElement(
                By.xpath("//div[text()='You hovered over the Contrary']"));
        return youHoveredOverTheTextLinkMessage;
    }
    public WebElement getYouHoveredOverTheNumberLinkTooltip(){
        youHoveredOverTheNumbersLinkMessage = getDriver().findElement(
                By.xpath("//div[text()='You hovered over the 1.10.32']"));
        return youHoveredOverTheNumbersLinkMessage;
    }


    /**
     * Tool Tips Hover Methods
     */
    public ToolTipsPage hoverOnButton(){
        getWait().until(ExpectedConditions.elementToBeClickable(getHoverToSeeMeButton()));
        getAction().moveToElement(getHoverToSeeMeButton()).perform();
        return this;
    }

    public ToolTipsPage hoverOnTextField(){
        getWait().until(ExpectedConditions.elementToBeClickable(getHoverToSeeMeTextField()));
        getAction().moveToElement(getHoverToSeeMeTextField()).perform();
        return this;
    }

    public ToolTipsPage hoverOnTextLink(){
        getWait().until(ExpectedConditions.elementToBeClickable(getTextLink()));
        getAction().moveToElement(getTextLink()).perform();
        return this;
    }

    public ToolTipsPage hoverOnNumberLink(){
        getJs().executeScript("window.scrollBy(0, 200)");
        getWait().until(ExpectedConditions.elementToBeClickable(getNumberLink()));
        getAction().moveToElement(getNumberLink()).perform();
        return this;
    }


    /**
     * Tool Tips Page Assert Methods
     */
    public ToolTipsPage assertTooltipIsDisplayedWhenHoverOnBtn(){
        getWait().until(ExpectedConditions.visibilityOf(getYouHoveredOverTheButtonTooltip()));
        Assert.assertTrue(getYouHoveredOverTheButtonTooltip().isDisplayed());
        return this;
    }

    public ToolTipsPage assertTooltipIsDisplayedWhenHoverOnTextField(){
        getWait().until(ExpectedConditions.visibilityOf(getYouHoveredOverTheTextFieldTooltip()));
        Assert.assertTrue(getYouHoveredOverTheTextFieldTooltip().isDisplayed());
        return this;
    }

    public ToolTipsPage assertTooltipIsDisplayedWhenHoverOnTextLink(){
        getWait().until(ExpectedConditions.visibilityOf(getYouHoveredOverTheTextLinkTooltip()));
        Assert.assertTrue(getYouHoveredOverTheTextLinkTooltip().isDisplayed());
        return this;
    }

    public ToolTipsPage assertTooltipIsDisplayedWhenHoverOnNumberLink(){
        getWait().until(ExpectedConditions.visibilityOf(getYouHoveredOverTheNumberLinkTooltip()));
        Assert.assertTrue(getYouHoveredOverTheNumberLinkTooltip().isDisplayed());
        return this;
    }


    /**
     * Go to Tool Tips Page
     */
    public void goToPage(){
        getDriver().get("https://demoqa.com/tool-tips");
    }
}
