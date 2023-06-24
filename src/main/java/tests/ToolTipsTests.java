package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTests extends BaseTests {

    @BeforeMethod
    public void beforeEachMethod(){
        getToolTipsPage().goToPage();
    }


    @Test
    public void verifyMsgAppearsWhenHoverOnButton() {
        getToolTipsPage().hoverOnButton()
                .assertTooltipIsDisplayedWhenHoverOnBtn();
    }

    @Test
    public void verifyMsgAppearsWhenHoverOnTextField() {
        getToolTipsPage().hoverOnTextField()
                .assertTooltipIsDisplayedWhenHoverOnTextField();
    }

    @Test
    public void verifyMsgAppearsWhenHoverOnTextLink() {
        getToolTipsPage().hoverOnTextLink()
                .assertTooltipIsDisplayedWhenHoverOnTextLink();
    }

    @Test
    public void verifyMsgAppearsWhenHoverOnNumberLink() {
        getToolTipsPage().hoverOnNumberLink()
                .assertTooltipIsDisplayedWhenHoverOnNumberLink();
    }
}