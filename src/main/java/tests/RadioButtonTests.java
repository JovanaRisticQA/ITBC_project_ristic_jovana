package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTests extends BaseTests {

    @BeforeMethod
    public void beforeThisClass(){
        getRadioButtonPage().goToPage();
    }

    @Test
    public void verifyUserCanSelectYesButton() {
        getRadioButtonPage().selectYesBtn();
        Assert.assertTrue(getRadioButtonPage().getYouHaveSelectedYesMSG().isDisplayed());
    }

    @Test
    public void verifyUserCanSelectImpressiveButton(){
        getRadioButtonPage().selectImpressiveBtn();
        Assert.assertTrue(getRadioButtonPage().getYouHaveSelectedImpressiveMsg().isDisplayed());
    }

    @Test
    public void verifyNoButtonIsDisabled(){
        getRadioButtonPage().selectNoButton();
        Assert.assertFalse(getRadioButtonPage().getNoButton().isSelected());
    }
}
