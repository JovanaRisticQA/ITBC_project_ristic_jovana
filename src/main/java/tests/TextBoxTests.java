package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends BaseTests {

    @BeforeMethod
    public void beforeEachMethod(){
        getTextBoxPage().goToPage();
    }

    @Test
    public void verifyUserCanFillInAllFields() {
        getTextBoxPage().enterName(getFullName())
                .enterEmail(getEmail())
                .enterCurrentAddress(getCurrentAddress())
                .enterPermanentAddress(getPermanentAddress())
                .clickSubmitButton()
                .assertOutputShowsDataCorrectly(getFullName(), getEmail(), getCurrentAddress(), getPermanentAddress());
    }

    @Test
    public void verifyUserHasToEnterValidEmailFormat() {
        getTextBoxPage().enterName(getFullName())
                .enterEmail("x")
                .enterCurrentAddress(getCurrentAddress())
                .enterPermanentAddress(getPermanentAddress())
                .clickSubmitButton()
                .assertFormRequiresValidEmailFormat();
    }
}
