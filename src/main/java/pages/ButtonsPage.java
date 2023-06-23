package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ButtonsPage extends BasePage {

    /**
     * Buttons Page Elements
     */
    private WebElement doubleClickMeBtn;
    private WebElement doubleClickMsg;
    private WebElement rightClickMeBtn;
    private WebElement rightClickMsg;
    private WebElement clickMeBtn;
    private WebElement dynamicClickMsg;


    /**
     * Buttons Page Constructor
     */
    public ButtonsPage(WebDriver driver, WebDriverWait wait, Actions action) {
        super(driver, wait, action);
    }


    /**
     * Buttons Page Getters
     */
    public WebElement getDoubleClickMeBtn(){
        doubleClickMeBtn = getDriver().findElement(By.id("doubleClickBtn"));
        return doubleClickMeBtn;
    }
    public WebElement getDoubleClickMsg(){
        doubleClickMsg = getDriver().findElement(By.id("doubleClickMessage"));
        return doubleClickMsg;
    }
    public WebElement getRightClickMeBtn(){
        rightClickMeBtn = getDriver().findElement(By.id("rightClickBtn"));
        return rightClickMeBtn;
    }
    public WebElement getRightClickMsg(){
        rightClickMsg = getDriver().findElement(By.id("rightClickMessage"));
        return rightClickMsg;
    }
    public WebElement getClickMeBtn(){
        clickMeBtn = getDriver().findElement(By.xpath("//button[text()='Click Me']"));
        return clickMeBtn;
    }
    public WebElement getDynamicClickMsg(){
        dynamicClickMsg = getDriver().findElement(By.id("dynamicClickMessage"));
        return dynamicClickMsg;
    }


    /**
     * Button Click Methods
     */
    public ButtonsPage doubleClickTheButton(){
        getAction().doubleClick(getDoubleClickMeBtn()).perform();
        return this;
    }

    public ButtonsPage rightClickTheButton(){
        getAction().contextClick(getRightClickMeBtn()).perform();
        return this;
    }

    public ButtonsPage leftClickTheButton(){
        getAction().click(getClickMeBtn()).perform();
        return this;
    }


    /**
     * Buttons Page Assert Methods
     */
    public ButtonsPage assertDoubleClickMessageIsDisplayed(){
        getWait().until(ExpectedConditions.visibilityOf(getDoubleClickMsg()));
        Assert.assertTrue(getDoubleClickMsg().isDisplayed());
        return this;
    }
    public ButtonsPage assertRightClickMessageIsDisplayed(){
        getWait().until(ExpectedConditions.visibilityOf(getRightClickMsg()));
        Assert.assertTrue(getRightClickMsg().isDisplayed());
        return this;
    }
    public ButtonsPage assertDynamicClickMessageIsDisplayed(){
        getWait().until(ExpectedConditions.visibilityOf(getDynamicClickMsg()));
        Assert.assertTrue(getDynamicClickMsg().isDisplayed());
        return this;
    }

    /**
     * Go to Buttons Page
     */
    public ButtonsPage goToPage(){
        getDriver().get("https://demoqa.com/buttons");
        return this;
    }

}
