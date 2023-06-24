package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TextBoxPage extends BasePage {

    /**
     * Text Box Page Elements
     */
    private WebElement nameField;
    private WebElement emailField;
    private WebElement currentAddressField;
    private WebElement permanentAddressField;
    private WebElement submitButton;
    private WebElement outputName;
    private WebElement outputEmail;
    private WebElement outputCurrentAddress;
    private WebElement outputPermanentAddress;


    /**
     * Text Box Page Constructor
     */
    public TextBoxPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        super(driver, wait, js);
    }


    /**
     * Text Box Page Getters
     */
    public WebElement getNameField() {
        nameField = getDriver().findElement(By.id("userName"));
        return nameField;
    }
    public WebElement getEmailField() {
        emailField = getDriver().findElement(By.id("userEmail"));
        return emailField;
    }
    public WebElement getCurrentAddressField() {
        currentAddressField = getDriver().findElement(By.xpath("//textarea[@id='currentAddress']"));
        return currentAddressField;
    }
    public WebElement getPermanentAddressField() {
        permanentAddressField = getDriver().findElement(By.xpath("//textarea[@id='permanentAddress']"));
        return permanentAddressField;
    }
    public WebElement getSubmitButton() {
        getJs().executeScript("window.scrollBy(0, 400)");
        submitButton = getDriver().findElement(By.id("submit"));
        return submitButton;
    }
    public WebElement getOutputName() {
        outputName = getDriver().findElement(By.id("name"));
        return outputName;
    }
    public WebElement getOutputEmail() {
        outputEmail = getDriver().findElement(By.id("email"));
        return outputEmail;
    }
    public WebElement getOutputCurrentAddress() {
        outputCurrentAddress = getDriver().findElement(By.xpath("//p[@id='currentAddress']"));
        return outputCurrentAddress;
    }
    public WebElement getOutputPermanentAddress() {
        outputPermanentAddress = getDriver().findElement(By.xpath("//p[@id='permanentAddress']"));
        return outputPermanentAddress;
    }


    /**
     * Text Box Page Fill In Data Methods
     */
    public TextBoxPage enterName(String name){
        getNameField().sendKeys(name);
        return this;
    }

    public TextBoxPage enterEmail(String email){
        getEmailField().sendKeys(email);
        return this;
    }

    public TextBoxPage enterCurrentAddress(String currentAddress){
        getCurrentAddressField().sendKeys(currentAddress);
        return this;
    }

    public TextBoxPage enterPermanentAddress(String permanentAddress){
        getPermanentAddressField().sendKeys(permanentAddress);
        return this;
    }
    public TextBoxPage clickSubmitButton(){
        getSubmitButton().click();
        return this;
    }


    /**
     * Text Box Page Assert Methods
     */
    public TextBoxPage assertOutputShowsDataCorrectly(String name, String email, String currentAddress, String permanentAddress){
        boolean correctName = getOutputName().getText().equals("Name:" + name);
        boolean correctEmail = getOutputEmail().getText().equals("Email:" + email);
        boolean correctCurrentAddress = getOutputCurrentAddress().getText().equals("Current Address :" + currentAddress);
        boolean correctPermanentAddress = getOutputPermanentAddress().getText().equals("Permananet Address :" + permanentAddress);
        Assert.assertTrue(correctName && correctEmail && correctCurrentAddress && correctPermanentAddress);
        return this;
    }

    public TextBoxPage assertFormRequiresValidEmailFormat(){
        Assert.assertEquals(getEmailField().getAttribute("class"), "mr-sm-2 field-error form-control");
        return this;
    }


    /**
     * Go to Text Box Page
     */
    public void goToPage(){
        getDriver().get("https://demoqa.com/text-box");
    }

}
