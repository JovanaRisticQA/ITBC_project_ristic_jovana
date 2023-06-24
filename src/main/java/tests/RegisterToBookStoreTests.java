package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterToBookStoreTests extends BaseTests {

    @BeforeMethod
    public void beforeEachMethod(){
        getRegisterToBookStorePage().goToPage();
    }

    @Test
    public void verifyFirstNameIsRequiredForRegistration() {
        getRegisterToBookStorePage().enterLastName(getLastName())
                .enterUsername(getUsername())
                .enterPassword(getPassword())
                .clickRegisterButton()
                .assertFirstNameIsRequired();
    }

    @Test
    public void verifyLastNameIsRequiredForRegistration() {
        getRegisterToBookStorePage().enterFirstName(getFirstName())
                .enterUsername(getUsername())
                .enterPassword(getPassword())
                .clickRegisterButton()
                .assertLastNameIsRequired();
    }

    @Test
    public void verifyUsernameIsRequiredForRegistration() {
        getRegisterToBookStorePage().enterFirstName(getFirstName())
                .enterLastName(getLastName())
                .enterPassword(getPassword())
                .clickRegisterButton()
                .assertUsernameIsRequired();
    }

    @Test
    public void verifyPasswordIsRequiredForRegistration() {
        getRegisterToBookStorePage().enterFirstName(getFirstName())
                .enterLastName(getLastName())
                .enterUsername(getUsername())
                .clickRegisterButton()
                .assertPasswordIsRequired();
    }

    @Test
    public void verifyReCaptchaIsRequiredForRegistration() {
        getRegisterToBookStorePage().enterFirstName(getFirstName())
                .enterLastName(getLastName())
                .enterUsername(getUsername())
                .enterPassword(getPassword())
                .clickRegisterButton()
                .assertVerifyReCaptchaIsDisplayed();
    }

}