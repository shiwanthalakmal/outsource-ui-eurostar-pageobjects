package com.outsource.qa.pages;

import com.outsource.qa.panels.RailplusFooterPanel;
import com.outsource.qa.panels.RailplusHeaderPanel;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 5/19/2016.
 */
public class RailDeliveryInfoPage extends BasicPage{

    RailplusHeaderPanel headerPanel;
    RailplusFooterPanel footerPanel;

    @FindBy(how= How.XPATH,using = "//*[@id='shop']/h1")                                      private WebElement lblDeliveryInfoTitle;
    @FindBy(how= How.XPATH,using = "//*[@id='shop']/p/a")                                     private WebElement lnkLoginNow;

    public RailDeliveryInfoPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        headerPanel = new RailplusHeaderPanel(driver);
        footerPanel = new RailplusFooterPanel(driver);
    }

    public RailDeliveryInfoPage check_And_Validate_Payment_DeliveryInfo_Page(String title){
        Assert.assertEquals(title, lblDeliveryInfoTitle.getText());
        return this;
    }

    public RailSignInPage step_Click_On_The_LoingNow_Link(){
        lnkLoginNow.click();
        return new RailSignInPage(driver);
    }
}
