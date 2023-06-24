package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;

public class UploadAndDownloadPage extends BasePage {

    /**
     * Upload and Download Page Elements
     */
    private WebElement downloadBtn;
    private WebElement chooseFileBtn;
    private WebElement uploadedFileMessage;

    /**
     * Images
     */
    private String imageDownloadPath = "C://Users//jovan//Downloads//";
    private String downloadImageName;
    private File downloadImage;
    private String uploadImageName = "Image123.jpg";
    private File imageToUpload = new File(
            "C://Users//jovan//IdeaProjects//ITBC_project_ristic_jovana//src//main//java//Images//Image123.jpg");


    /**
     * Upload and Download Page Constructor
     */
    public UploadAndDownloadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    /**
     * Upload and Download Page Getters
     */
    public WebElement getDownloadBtn() {
        downloadBtn = getDriver().findElement(By.id("downloadButton"));
        return downloadBtn;
    }

    public WebElement getChooseFileBtn() {
        chooseFileBtn = getDriver().findElement(By.id("uploadFile"));
        return chooseFileBtn;
    }

    public WebElement getUploadedFileMessage() {
        uploadedFileMessage = getDriver().findElement(By.xpath("//p[@id='uploadedFilePath']"));
        return uploadedFileMessage;
    }

    /**
     * Image Upload and Download Methods
     */
    public UploadAndDownloadPage clickDownloadBtn(){
        getDownloadBtn().click();
        getWait().until(ExpectedConditions.attributeToBeNotEmpty(getDownloadBtn(), "box-shadow"));
        return this;
    }

    public UploadAndDownloadPage uploadImage() {
        getChooseFileBtn().sendKeys(imageToUpload.getAbsolutePath());
        return this;
    }

    /**
     * Upload and Download Assertion Methods
     */
    public UploadAndDownloadPage assertFileIsDownloaded(){
        downloadImageName = getDownloadBtn().getAttribute("download");
        downloadImage = new File(imageDownloadPath + downloadImageName);
        Assert.assertTrue(downloadImage.exists());
        return this;
    }

    public UploadAndDownloadPage assertFileIsUploaded(){
        getWait().until(ExpectedConditions.visibilityOf(getUploadedFileMessage()));
        Assert.assertTrue(getUploadedFileMessage().isDisplayed());
        Assert.assertTrue(getUploadedFileMessage().getText().contains(uploadImageName));
        return this;
    }


    /**
     * Go to Upload and Download Page
     */
    public void goToPage(){
        getDriver().get("https://demoqa.com/upload-download");
    }
}
