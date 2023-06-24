package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends BaseTests {

    @BeforeMethod
    public void beforeEachMethod(){
        getButtonsPage().goToPage();
    }

    @Test
    public void verifyUserCanDoubleClickTheButton(){
        getButtonsPage().doubleClickTheButton()
                .assertDoubleClickMessageIsDisplayed();
    }

    @Test
    public void verifyUserCanRightClickTheButton(){
        getButtonsPage().rightClickTheButton()
                .assertRightClickMessageIsDisplayed();
    }

    @Test
    public void verifyUserCanLeftClickTheButton(){
        getButtonsPage().leftClickTheButton()
                .assertDynamicClickMessageIsDisplayed();
    }
}