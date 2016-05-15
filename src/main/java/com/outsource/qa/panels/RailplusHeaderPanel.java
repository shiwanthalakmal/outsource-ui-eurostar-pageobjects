package com.outsource.qa.panels;

import com.outsource.qa.pages.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by user on 4/18/2016.
 */
public class RailplusHeaderPanel extends BasicPage {

    @FindBy(how= How.XPATH,using = "//*[@id='header-bar-navigation']/div[2]/ul/li[1]/a")
    private WebElement lnkAbout;
    @FindBy(how= How.XPATH,using = "//*[@id='header-bar-navigation']/div[2]/ul/li[2]/a")
    private WebElement lnkContact;
    @FindBy(how= How.XPATH,using = "//*[@id='header-bar-navigation']/div[2]/ul/li[3]/a")
    private WebElement lnkMap;
    @FindBy(how= How.XPATH,using = "//*[@id='header-bar-navigation']/div[2]/ul/li[4]/a")
    private WebElement lnkTimetable;
    @FindBy(how= How.XPATH,using = "//*[@id='header-bar-navigation']/div[2]/ul/li[5]/a")
    private WebElement lnkSubscribe;
    @FindBy(how= How.XPATH,using = "//*[@id='header-bar-navigation']/div[1]/ul/li[1]/a")
    private WebElement btnManageBooking;
    @FindBy(how= How.XPATH,using = "//*[@id='btnGetBooking']")
    private WebElement btnManageBookingLogin;
    @FindBy(how= How.XPATH,using = "//div[@id='header-bar-navigation']/div/ul/li[2]/a")
    private WebElement btnRailSignIn;
    @FindBy(how= How.XPATH,using = "//*[@id='login']")
    private WebElement btnSignInLogin;
    @FindBy(how= How.XPATH,using = "//*[@id='header-bar-navigation']/div[1]/ul/li[3]/a")
    private WebElement btnCorporateSite;
    @FindBy(how= How.XPATH,using = "//*[@id='phone']/span/a")
    private WebElement lblRailPhone;
    @FindBy(how= How.XPATH,using = "//*[@id='search-query']")
    private WebElement txtSearchBox;
    @FindBy(how= How.XPATH,using = "//*[@id='header-bar-search']/form/input")
    private WebElement btnSearchGo;
    @FindBy(how= How.XPATH,using = "//*[@id='header-bar-navigation']/div[1]/ul/li[2]/div/div/div/p/a[1]")
    private WebElement lnkForgotQuickLink;
    @FindBy(how= How.XPATH,using = "//*[@id='header-bar-navigation']/div[1]/ul/li[2]/div/div/div/p/a[2]")
    private WebElement lnkCreateArgentQuickLink;



    @FindBy(how= How.XPATH,using = "//*[@id='button-home']/a")
    private WebElement btnHomeTab;
    @FindBy(how= How.XPATH,using = "//*[@id='button-eurostar']/a")
    private WebElement btnEurostarTab;
    @FindBy(how= How.XPATH,using = "//*[@id='button-point-to-point']/a")
    private WebElement btnPointTicketTab;
    @FindBy(how= How.XPATH,using = "//*[@id='button-rail-passes']/a")
    private WebElement btnRailPassesTab;
    @FindBy(how= How.XPATH,using = "//*[@id='button-destinations']/a")
    private WebElement btnDestinationsTab;
    @FindBy(how= How.XPATH,using = "//*[@id='button-great-train-journeys']/a")
    private WebElement btnGreatTrainTab;
    @FindBy(how= How.XPATH,using = "//*[@id='button-sightseeing-and-transport']/a")
    private WebElement btnSightseeingTab;
    @FindBy(how= How.XPATH,using = "//*[@id='button-specials']/a")
    private WebElement btnSpecialsTab;
    @FindBy(how= How.XPATH,using = "//*[@id='button-media']/a")
    private WebElement btnNewsTab;
    @FindBy(how= How.XPATH,using = "//*[@id='nav-blog']/a")
    private WebElement btnBlogTab;
    @FindBy(how= How.LINK_TEXT,using = "Logout")
    private WebElement lnkLogout;

    public RailplusHeaderPanel(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void test_step(){
        lnkAbout.click();
    }

    public WebElement getHomeSubMenutab(){
        return btnHomeTab;
    }

    public WebElement getAboutMenuLink(){
        return lnkAbout;
    }

    public WebElement getContactMenuLink(){
        return lnkContact;
    }

    public WebElement getMapsMenuLink(){
        return lnkMap;
    }

    public WebElement getTimetableMenuLink(){
        return lnkTimetable;
    }

    public WebElement getSubscribeMenuLink(){
        return lnkSubscribe;
    }

    public WebElement getManageMenulink() { return btnManageBooking; }

    public WebElement getSiginForgotQuickLink() { return lnkForgotQuickLink; }

    public WebElement getManageLoginlink() { return btnManageBookingLogin; }

    public WebElement getCreateArgentLink() { return lnkCreateArgentQuickLink; }

    public WebElement getSignInMenuLink() {return btnRailSignIn; }

    public WebElement getBtnSignInLogin() {return btnSignInLogin; }

    public WebElement getBtnLogout(){ return lnkLogout; }

    public RailAboutPage click_About_link(){
        this.lnkAbout.click();
        return new RailAboutPage(driver);
    }

    public RailContactPage click_Contact_Link(){
        this.lnkContact.click();
        return new RailContactPage(driver);
    }

    public RailMapPage click_Maps_Link(){
        this.lnkMap.click();
        return new RailMapPage(driver);
    }

    public RailTimetablePage click_Timetable_Link(){
        this.lnkTimetable.click();
        return new RailTimetablePage(driver);
    }

    public RailSubscribePage click_Subscribe_Link(){
        this.lnkSubscribe.click();
        return new RailSubscribePage(driver);
    }

    public RailManageBookPage click_Manage_Booking_Link(){
        this.btnManageBooking.click();
        return new RailManageBookPage(driver);
    }

    public RailSignInPage click_My_SignIn_Link(){
        this.btnRailSignIn.click();
        return new RailSignInPage(driver);
    }

    public RailplusHomePage click_SignIn_Forgot_Pass_Quick_Link(){
        lnkForgotQuickLink.click();
        return new RailplusHomePage(driver);
    }

    public RailplusHomePage click_SignIn_Create_New_Argent(){
        lnkCreateArgentQuickLink.click();
        return new RailplusHomePage(driver);
    }


}
