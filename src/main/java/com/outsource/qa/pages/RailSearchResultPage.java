package com.outsource.qa.pages;

import com.outsource.qa.panels.RailplusFooterPanel;
import com.outsource.qa.panels.RailplusHeaderPanel;
import com.outsource.qa.panels.TravelModalPanel;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 5/7/2016.
 */
public class RailSearchResultPage extends BasicPage {

    @FindBy(how= How.XPATH,using = "//*[@id='shop']/div[1]/h1")          private WebElement lblSearchResultTitle;

    RailplusHeaderPanel headerPanel;
    RailplusFooterPanel footerPanel;
    TravelModalPanel searchPanel;

    public RailSearchResultPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        headerPanel = new RailplusHeaderPanel(driver);
        footerPanel = new RailplusFooterPanel(driver);
        searchPanel = new TravelModalPanel(driver);
    }

    public RailSearchResultPage check_And_Validate_Location_Result_Title(String from,String to){
        Assert.assertEquals((from+" to "+to), lblSearchResultTitle.getText());
        return this;
    }

}
