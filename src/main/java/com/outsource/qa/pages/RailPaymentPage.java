package com.outsource.qa.pages;

import com.outsource.qa.panels.RailplusFooterPanel;
import com.outsource.qa.panels.RailplusHeaderPanel;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 5/15/2016.
 */
public class RailPaymentPage extends BasicPage {

    RailplusHeaderPanel headerPanel;
    RailplusFooterPanel footerPanel;

    public RailPaymentPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        headerPanel = new RailplusHeaderPanel(driver);
        footerPanel = new RailplusFooterPanel(driver);
    }
}
