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
 * Created by user on 4/20/2016.
 */
public class RailTimetablePage extends BasicPage {

    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div[1]/h1")     private WebElement lblTimetableTitle;
    RailplusHeaderPanel headerPanel;
    RailplusFooterPanel footerPanel;

    public RailTimetablePage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        headerPanel = new RailplusHeaderPanel(driver);
        footerPanel = new RailplusFooterPanel(driver);
    }

    public RailTimetablePage check_And_Validate_PageHeader(String title){
        Assert.assertEquals(title, lblTimetableTitle.getText());
        return this;
    }
}
