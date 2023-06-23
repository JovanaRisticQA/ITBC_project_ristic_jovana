package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectableTests extends BaseTests {

    @BeforeMethod
    public void beforeThisClass(){
        getSelectablePage().goToPage();
    }

    @Test
    public void verifyFirstItemIsSelectedUponClick(){
        getSelectablePage().clickFirstListItem()
                .assertFirstItemChangesColorOnClick();
    }

    @Test
    public void verifySecondItemIsSelectedUponClick(){
        getSelectablePage().clickSecondListItem()
                .assertSecondItemChangesColorOnClick();
    }

    @Test
    public void verifyThirdItemIsSelectedUponClick(){
        getSelectablePage().clickThirdListItem()
                .assertThirdItemChangesColorOnClick();
    }

    @Test
    public void verifyFourthItemIsSelectedUponClick(){
        getSelectablePage().clickFourthListItem()
                .assertFourthItemChangesColorOnClick();
    }
}
