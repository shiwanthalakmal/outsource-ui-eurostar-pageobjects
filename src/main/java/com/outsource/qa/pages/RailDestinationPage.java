package com.outsource.qa.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 4/20/2016.
 */
public class RailDestinationPage extends BasicPage {

    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div[1]/h1")          private WebElement lblDestinationTitle;

    public RailDestinationPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RailDestinationPage  check_And_Validate_Eurostart_Destination_Page(String title){
        Assert.assertEquals(title,lblDestinationTitle.getText());
        return this;
    }
}
