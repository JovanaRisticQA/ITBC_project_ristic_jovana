package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterToBookStorePage extends BasePage {

    /**
     * Register to Bookstore Page Elements
     */
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement registerButton;
    private WebElement verifyReCaptchaMsg;


    /**
     * Bookstore Registration Page Constructor
     */
    public RegisterToBookStorePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        super(driver, wait, js);
    }


    /**
     * Bookstore Registration Page Getters
     */
    public WebElement getFirstNameField(){
        firstNameField = getDriver().findElement(By.id("firstname"));
        return firstNameField;
    }
    public WebElement getLastNameField(){
        lastNameField = getDriver().findElement(By.id("lastname"));
        return lastNameField;
    }
    public WebElement getUsernameField(){
        usernameField = getDriver().findElement(By.id("userName"));
        return usernameField;
    }
    public WebElement getPasswordField(){
        passwordField = getDriver().findElement(By.id("password"));
        return passwordField;
    }
    public WebElement getRegisterButton(){
        registerButton = getDriver().findElement(By.id("register"));
        return registerButton;
    }
    public WebElement getVerifyReCaptchaMsg(){
        verifyReCaptchaMsg = getDriver().findElement(
                By.xpath("//p[text()='Please verify reCaptcha to register!']"));
        return verifyReCaptchaMsg;
    }


    /**
     * Fill In Registration Page Fields Methods
     */
    public RegisterToBookStorePage enterFirstName(String firstName){
        getFirstNameField().sendKeys(firstName);
        return this;
    }

    public RegisterToBookStorePage enterLastName(String lastName){
        getLastNameField().sendKeys(lastName);
        return this;
    }

    public RegisterToBookStorePage enterUsername(String username){
        getUsernameField().sendKeys(username);
        return this;
    }

    public RegisterToBookStorePage enterPassword(String password){
        getPasswordField().sendKeys(password);
        return this;
    }

    public RegisterToBookStorePage clickRegisterButton(){
        getJs().executeScript("window.scrollBy(0, 200)");
        getRegisterButton().click();
        return this;
    }


    /**
     * Bookstore Registration Page Assert Methods
     */
    public RegisterToBookStorePage assertFirstNameIsRequired(){
        Assert.assertEquals(getFirstNameField().getAttribute("class"), "mr-sm-2 is-invalid form-control");
        return this;
    }

    public RegisterToBookStorePage assertLastNameIsRequired(){
        Assert.assertEquals(getLastNameField().getAttribute("class"), "mr-sm-2 is-invalid form-control");
        return this;
    }

    public RegisterToBookStorePage assertUsernameIsRequired(){
        Assert.assertEquals(getUsernameField().getAttribute("class"), "mr-sm-2 is-invalid form-control");
        return this;
    }

    public RegisterToBookStorePage assertPasswordIsRequired(){
        Assert.assertEquals(getPasswordField().getAttribute("class"), "mr-sm-2 is-invalid form-control");
        return this;
    }

    public RegisterToBookStorePage assertVerifyReCaptchaIsDisplayed(){
        getWait().until(ExpectedConditions.visibilityOf(getVerifyReCaptchaMsg()));
        Assert.assertTrue(getVerifyReCaptchaMsg().isDisplayed());
        return this;
    }


    /**
     * Go to Bookstore Registration Page
     */
    public RegisterToBookStorePage goToPage(){
        getDriver().get("https://demoqa.com/register");
        return this;
    }

}