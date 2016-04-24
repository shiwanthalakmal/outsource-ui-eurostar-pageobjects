package com.outsource.qa.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 4/23/2016.
 */
public class RailSiteMapPage extends BasicPage{

    public RailSiteMapPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
