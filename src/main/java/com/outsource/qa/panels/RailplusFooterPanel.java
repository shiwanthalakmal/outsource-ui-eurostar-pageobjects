package com.outsource.qa.panels;

import com.outsource.qa.pages.BasicPage;
import com.outsource.qa.pages.RailPrivacyPage;
import com.outsource.qa.pages.RailSiteMapPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 4/18/2016.
 */
public class RailplusFooterPanel extends BasicPage{

    @FindBy(how= How.XPATH,using = "//*[@id='footer-links']/li[1]/a")
    private WebElement lnkPrivacy;
    @FindBy(how= How.XPATH,using = "//*[@id='footer-links']/li[2]/a")
    private WebElement lnkTerms;
    @FindBy(how= How.XPATH,using = "//*[@id='footer-links']/li[3]/a")
    private WebElement lnkSite;

    public RailplusFooterPanel(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RailSiteMapPage click_Sitemap_Link(){
        lnkSite.click();
        return new RailSiteMapPage(driver);
    }

    public RailPrivacyPage click_Privacy_Link(){
        lnkSite.click();
        return new RailPrivacyPage(driver);
    }
}
