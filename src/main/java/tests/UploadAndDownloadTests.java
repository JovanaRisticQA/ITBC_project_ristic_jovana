package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadAndDownloadTests extends BaseTests {

        @BeforeMethod
        public void goToUrl(){
             getUploadAndDownloadPage().goToPage();
        }

        @Test
        public void verifyFileCanBeDownloaded() {
            getUploadAndDownloadPage().clickDownloadBtn()
                    .assertFileIsDownloaded();
        }

        @Test
        public void verifyFileCanBeUploaded() {
            getUploadAndDownloadPage().uploadImage()
                    .assertFileIsUploaded();
        }

}
