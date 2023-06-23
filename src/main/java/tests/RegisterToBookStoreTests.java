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
        getRegisterToBookStorePage().enterLastName(lastName)
                .enterUsername(username)
                .enterPassword(password)
                .clickRegisterButton()
                .assertFirstNameIsRequired();
    }

    @Test
    public void verifyLastNameIsRequiredForRegistration() {
        getRegisterToBookStorePage().enterFirstName(firstName)
                .enterUsername(username)
                .enterPassword(password)
                .clickRegisterButton()
                .assertLastNameIsRequired();
    }

    @Test
    public void verifyUsernameIsRequiredForRegistration() {
        getRegisterToBookStorePage().enterFirstName(firstName)
                .enterLastName(lastName)
                .enterPassword(password)
                .clickRegisterButton()
                .assertUsernameIsRequired();
    }

    @Test
    public void verifyPasswordIsRequiredForRegistration() {
        getRegisterToBookStorePage().enterFirstName(firstName)
                .enterLastName(lastName)
                .enterUsername(username)
                .clickRegisterButton()
                .assertPasswordIsRequired();
    }

    @Test
    public void verifyReCaptchaIsRequiredForRegistration() {
        getRegisterToBookStorePage().enterFirstName(firstName)
                .enterLastName(lastName)
                .enterUsername(username)
                .enterPassword(password)
                .clickRegisterButton()
                .assertVerifyReCaptchaIsDisplayed();
    }

}