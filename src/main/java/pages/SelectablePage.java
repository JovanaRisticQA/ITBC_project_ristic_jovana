package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SelectablePage extends BasePage {

    /**
     * Selectable Page Elements
     */

    private WebElement firstListItem;
    private WebElement secondListItem;
    private WebElement thirdListItem;
    private WebElement fourthListItem;



    /**
     * Selectable Page Constructor
     */
    public SelectablePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        super(driver, wait, js);
    }



    /**
     * Selectable Page Getters
     */
    public WebElement getFirstListItem(){
        firstListItem = getDriver().findElement(
                By.xpath("//li[text()='Cras justo odio']"));
        return firstListItem;
    }
    public WebElement getSecondListItem(){
        secondListItem = getDriver().findElement(
                By.xpath("//li[text()='Dapibus ac facilisis in']"));
        return secondListItem;
    }
    public WebElement getThirdListItem(){
        thirdListItem = getDriver().findElement(
                By.xpath("//li[text()='Morbi leo risus']"));
        return thirdListItem;
    }
    public WebElement getFourthListItem(){
        fourthListItem = getDriver().findElement(
                By.xpath("//li[text()='Porta ac consectetur ac']"));
        return fourthListItem;
    }



    /**
     * Selectable Click Methods
     */
    public SelectablePage clickFirstListItem(){
        getWait().until(ExpectedConditions.elementToBeClickable(getFirstListItem()));
        getFirstListItem().click();
        return this;
    }
    public SelectablePage clickSecondListItem(){
        getWait().until(ExpectedConditions.elementToBeClickable(getSecondListItem()));
        getSecondListItem().click();
        return this;
    }
    public SelectablePage clickThirdListItem(){
        getWait().until(ExpectedConditions.elementToBeClickable(getThirdListItem()));
        getThirdListItem().click();
        return this;
    }
    public SelectablePage clickFourthListItem(){
        getJs().executeScript("window.scrollBy(0, 200)");
        getWait().until(ExpectedConditions.elementToBeClickable(getFourthListItem()));
        getFourthListItem().click();
        return this;
    }


    /**
     * Selectable Assert Methods
     */
    public SelectablePage assertFirstItemChangesColorOnClick(){
        Assert.assertEquals(getFirstListItem().getAttribute("class"),
                "mt-2 list-group-item active list-group-item-action");
        return this;
    }

    public SelectablePage assertSecondItemChangesColorOnClick(){
        Assert.assertEquals(getSecondListItem().getAttribute("class"),
                "mt-2 list-group-item active list-group-item-action");
        return this;
    }

    public SelectablePage assertThirdItemChangesColorOnClick(){
        Assert.assertEquals(getThirdListItem().getAttribute("class"),
                "mt-2 list-group-item active list-group-item-action");
        return this;
    }

    public SelectablePage assertFourthItemChangesColorOnClick(){
        Assert.assertEquals(getFourthListItem().getAttribute("class"),
                "mt-2 list-group-item active list-group-item-action");
        return this;
    }

    public SelectablePage assertAllItemsAreSelected(){
        boolean firstItemIsSelected = "mt-2 list-group-item active list-group-item-action".equals(
                getFirstListItem().getAttribute("class"));
        boolean secondItemIsSelected = "mt-2 list-group-item active list-group-item-action".equals(
                getSecondListItem().getAttribute("class"));
        boolean thirdItemIsSelected = "mt-2 list-group-item active list-group-item-action".equals(
                getThirdListItem().getAttribute("class"));
        boolean fourthItemIsSelected = "mt-2 list-group-item active list-group-item-action".equals(
                getFourthListItem().getAttribute("class"));
        Assert.assertTrue(firstItemIsSelected && secondItemIsSelected && thirdItemIsSelected && fourthItemIsSelected);
        return this;
    }


    /**
     * Go to Selectable Page
     */
    public SelectablePage goToPage(){
        getDriver().get("https://demoqa.com/selectable");
        return this;
    }

}
