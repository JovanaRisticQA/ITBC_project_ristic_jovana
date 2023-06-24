package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    /**
     * Base Test Elements
     */
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Actions action;
    private RadioButtonPage radioButtonPage;
    private RegisterToBookStorePage registerToBookStorePage;
    private ButtonsPage buttonsPage;
    private ToolTipsPage toolTipsPage;
    private SelectablePage selectablePage;
    private TextBoxPage textBoxPage;

    /**
     * Faker and Faker-generated data
     */
    private Faker faker = new Faker();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String fullName = faker.name().fullName();
    private String username = faker.name().username();
    private String password = faker.internet().password();
    private String email = faker.internet().emailAddress();
    private String currentAddress = faker.address().secondaryAddress();
    private String permanentAddress = faker.address().fullAddress();


    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "C://Users//jovan//OneDrive//Desktop//Newfolder//chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
        radioButtonPage = new RadioButtonPage(driver, wait);
        registerToBookStorePage = new RegisterToBookStorePage(driver, wait, js);
        buttonsPage = new ButtonsPage(driver, wait, action);
        toolTipsPage = new ToolTipsPage(driver, wait, action, js);
        selectablePage = new SelectablePage(driver, wait, js);
        textBoxPage = new TextBoxPage(driver, wait, js);
    }

    /**
     * Getters for WebDriver and all pages
     */
    public WebDriver getDriver() {
        return driver;
    }
    public RadioButtonPage getRadioButtonPage() {
        return radioButtonPage;
    }
    public RegisterToBookStorePage getRegisterToBookStorePage(){
        return registerToBookStorePage;
    }
    public ButtonsPage getButtonsPage(){
        return buttonsPage;
    }
    public ToolTipsPage getToolTipsPage(){
        return toolTipsPage;
    }
    public SelectablePage getSelectablePage(){
        return selectablePage;
    }
    public TextBoxPage getTextBoxPage() {
        return textBoxPage;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    @AfterClass
    public void cleanUp(){
        getDriver().close();
    }

}
