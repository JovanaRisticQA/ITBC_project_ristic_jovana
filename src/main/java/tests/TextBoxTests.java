package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends BaseTests {

    @BeforeMethod
    public void beforeThisClass(){
        getTextBoxPage().goToPage();
    }

    @Test
    public void verifyUserCanFillInAllFields() {
        getTextBoxPage().enterName(fullName)
                .enterEmail(email)
                .enterCurrentAddress(currentAddress)
                .enterPermanentAddress(permanentAddress)
                .clickSubmitButton()
                .assertOutputShowsDataCorrectly(fullName, email, currentAddress, permanentAddress);
    }

    @Test
    public void verifyUserHasToEnterValidEmailFormat() throws InterruptedException {
        getTextBoxPage().enterName(fullName)
                .enterEmail("x")
                .enterCurrentAddress(currentAddress)
                .enterPermanentAddress(permanentAddress)
                .clickSubmitButton()
                .assertFormRequiresValidEmailFormat();
    }
}
