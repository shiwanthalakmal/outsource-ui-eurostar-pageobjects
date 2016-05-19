package com.outsource.qa.pages;

import com.outsource.qa.panels.RailplusFooterPanel;
import com.outsource.qa.panels.RailplusHeaderPanel;
import com.outsource.qa.panels.TravelModalPanel;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * RailplusHomePage.java - RailplusHome page related page-objects definition class
 *
 * @author Shiwantha Lakmal
 * @version 1.0-SNAPSHOT Last modified 04_20_2015
 * @since 04/20/2015.
 */
public class RailplusHomePage extends BasicPage{

    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div[1]/h1")          private WebElement lblHomeTitle;
    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div[1]/h2")          private WebElement lblAgencyCode;

    @FindBy(how= How.XPATH,using = "//*[@id='backtotop']/a")                        private WebElement lnkBackTop;


    @FindBy(how= How.XPATH,using = "//*[@id='slide-show-control-previous']/a")      private WebElement lnkPaginationLeft;
    @FindBy(how= How.XPATH,using = "//*[@id='slide-show-control-slide1']/a")        private WebElement lnkPaginationOne;
    @FindBy(how= How.XPATH,using = "//*[@id='slide-show-control-slide2']/a")        private WebElement lnkPaginationTwo;
    @FindBy(how= How.XPATH,using = "//*[@id='slide-show-content1']/div[1]/div/a")   private WebElement lnkBannerInfoOne;
    @FindBy(how= How.XPATH,using = "//*[@id='slide-show-content2']/div[1]/div/a")   private WebElement lnkBannerInfoTwo;
    @FindBy(how= How.XPATH,using = "//*[@id='slide-show-control-next']/a")          private WebElement lnkPaginationRight;

    //AgeRule Overlay Related
    @FindBy(how= How.XPATH,using = "//*[@id='ui-dialog-title-1']")                  private WebElement lblAgeRuleOverlayTitle;
    @FindBy(how= How.XPATH,using = "html/body/div[4]/div[11]/div/button")           private WebElement btnAgeRuleOverlayClose;

    @FindBy(how= How.XPATH,using = "//*[@id='breadcrumb-navigation']/div[2]/div/div/div/a[1]/span")        private WebElement btnFacebookk;
    @FindBy(how= How.XPATH,using = "//*[@id='breadcrumb-navigation']/div[2]/div/div/div/a[2]/span")        private WebElement btnTwitter;

    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div/h2")        private WebElement lblSearchInProgress;

    RailplusHeaderPanel headerPanel;
    TravelModalPanel ticketPanel;
    RailplusFooterPanel footerPanel;
    TravelModalPanel searchPanel;

    public RailplusHomePage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        headerPanel = new RailplusHeaderPanel(driver);
        ticketPanel = new TravelModalPanel(driver);
        footerPanel = new RailplusFooterPanel(driver);
        searchPanel = new TravelModalPanel(driver);
    }

    public void call_about_page(){
        headerPanel.test_step();
    }

    public void check_And_Validate_Eurostar_Home_Page(String title){
        Assert.assertEquals(title, lblHomeTitle.getText());
    }

    public void check_And_Validate_Staying_Home_page(){
        Assert.assertTrue(headerPanel.getHomeSubMenutab().getAttribute("class").equals("home rounded-top"));
    }

    public RailSearchResultPage check_And_Validate_Search_Inprogress(){
        try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
        Assert.assertEquals("Searching for trains...",lblSearchInProgress.getText());
        return new RailSearchResultPage(driver);
    }

    public RailplusHomePage step_Site_Logout(){
        Actions action = new Actions(driver);
        action.moveToElement(headerPanel.getSignInMenuLink()).build().perform();
        headerPanel.getBtnLogout().click();
        return this;
    }

    public void check_And_Validate_Logged_Agency_Code(String code){
        Assert.assertEquals(code, lblAgencyCode.getText());
    }

    public void check_And_Validate_Logged_Agency_Code_Not_Available(String code){
        check_And_Validate_Eurostar_Home_Page("Agent Area");
    }

    public RailplusHomePage step_Click_Facebook_Icon(){
        btnFacebookk.click();
        return this;
    }

    public RailplusHomePage step_Click_Twitter_Icon(){
        btnTwitter.click();
        return this;
    }

    public RailplusHomePage check_And_Validate_Facebook_Panel(String title){
        try { Thread.sleep(20000);} catch (InterruptedException e) { e.printStackTrace(); }
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Assert.assertEquals(title, driver.getTitle());
        return this;
    }

    public RailplusHomePage check_And_Validate_Twitter_Panel(String title){
        try { Thread.sleep(20000);} catch (InterruptedException e) { e.printStackTrace(); }
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Assert.assertEquals(title, driver.getTitle());
        return this;
    }

    public Object step_Click_Given_Main_Menu_Link(String link){
        if (link.equals("About")){headerPanel.click_About_link();return new RailAboutPage(driver);}
        else if (link.equals("Contact")){headerPanel.click_Contact_Link();return new RailContactPage(driver);}
        else if (link.equals("Maps")){headerPanel.click_Maps_Link();return new RailMapPage(driver);}
        else if (link.equals("Timetables")){headerPanel.click_Timetable_Link();return new RailTimetablePage(driver);}
        else if (link.equals("Subscribe")){headerPanel.click_Subscribe_Link();return new RailSubscribePage(driver);}
        else if (link.equals("Site")){footerPanel.click_Sitemap_Link();return new RailSiteMapPage(driver);}
        else if (link.equals("Privacy")){footerPanel.click_Privacy_Link();return new RailPrivacyPage(driver);}
        else{}
        return null;
    }

    public Object step_Click_Given_Special_Main_Menu_Link(String link){
        if (link.equals("Manage")){headerPanel.click_Manage_Booking_Link();return new RailManageBookPage(driver);}
        else if (link.equals("Signin")){headerPanel.click_My_SignIn_Link();return new RailSignInPage(driver);}
        else if (link.equals("Corporate")){headerPanel.click_Maps_Link();return new RailMapPage(driver);}
        else{}
        return null;
    }

    public RailManageBookPage step_Manage_Booking_link_Mouse_Over_And_Login_Without_Details(){
        Actions action = new Actions(driver);
        action.moveToElement(headerPanel.getManageMenulink()).build().perform();
        headerPanel.getManageLoginlink().click();
        return new RailManageBookPage(driver);
    }

    public RailSignInPage step_My_Sign_In_Link_Mouse_Over_And_Login_Without_Details(){
        Actions action = new Actions(driver);
        action.moveToElement(headerPanel.getManageMenulink()).build().perform();
        headerPanel.getManageLoginlink().click();
        return new RailSignInPage(driver);
    }

    public RailSignInPage step_Signin_Forgot_Password_Quick_Link_Navigation(){
        Actions action = new Actions(driver);
        action.moveToElement(headerPanel.getManageMenulink()).build().perform();
        headerPanel.click_SignIn_Forgot_Pass_Quick_Link();
        return new RailSignInPage(driver);
    }

    public RailSignInPage step_My_Sign_In_fill_username_feild(){
        return new RailSignInPage(driver);
    }

    public RailSignInPage step_My_Sign_In_fill_password_feild(){
        return new RailSignInPage(driver);
    }

    public RailplusHomePage step_Click_Given_Modal_Tab(String tab){
        searchPanel.action_Click_Banner_Modal_Option(tab);
        return this;
    }

    public RailplusHomePage check_And_Validate_Modal_Title(String title){

        return this;
    }

    public RailplusHomePage check_And_Validate_Ticket_Type_Default_Selection(){
        return ticketPanel.action_Ticket_Type_Default_Status();
    }

    public RailplusHomePage check_And_Validate_Fare_Type_Default_Selection(){
        return ticketPanel.action_Fare_Type_Default_Status();
    }

    public RailplusHomePage check_And_Validate_Seat_Reservation_Default_Selection(){
        return ticketPanel.action_Seat_Reservation_Default_Status();
    }

    public RailplusHomePage step_Click_Back_To_Top_Link(){
        lnkBackTop.click();
        return this;
    }

    public RailDestinationPage step_Click_On_The_Advance_Book_Link(){
        ticketPanel.action_Book_Train_Ticket_Link();
        return new RailDestinationPage(driver);
    }

    public RailplusHomePage step_Click_On_The_Age_Rule_Link(){
        ticketPanel.action_Age_Rules_Link();
        return this;
    }

    public RailplusHomePage check_And_Validate_Age_Rule_Overlay_Header(String title){
        Assert.assertTrue(lblAgeRuleOverlayTitle.isDisplayed());
        Assert.assertEquals(title, lblAgeRuleOverlayTitle.getText());
        return this;
    }

    public RailplusHomePage step_Close_Age_Rule_overlay(){
        btnAgeRuleOverlayClose.click();
        return this;
    }

    public RailplusHomePage check_And_Validate_Return_Date(String date){
        //Assert.assertTrue(ticketPanel.action_Set_Return_Ticket_Date(date).contains(date));
        //Assert.assertTrue(ticketPanel.action_Set_Return_Ticket_Date(date).contains(date));
        return this;
    }

    public RailplusHomePage check_And_Validate_Return_Time(String time){
        Assert.assertTrue(ticketPanel.action_Get_Return_Ticket_Time().contains("PM") || ticketPanel.action_Get_Return_Ticket_Time().contains("AM"));
        return this;
    }

    public RailplusHomePage click_Return_Search_Option(String state){
        ticketPanel.action_Return_Radio_Status(state);
        return this;
    }

    public RailplusHomePage click_OneWay_Search_Option(String state){
        ticketPanel.action_Oneway_Radio_Status(state);
        return this;
    }

    public RailplusHomePage step_Set_Travel_Scheduled_Date(String date){
        ticketPanel.action_Set_Departure_Date(date);
        return this;
    }

    public RailplusHomePage step_Set_Return_Scheduled_Date(String date){

        return this;
    }

    public RailplusHomePage step_Set_Arrival_Station(String arrival){
        ticketPanel.action_Set_Arrival_Station(arrival);
        lblHomeTitle.click();
        return this;
    }

    public RailplusHomePage step_Set_Departure_Station(String departure){
        ticketPanel.action_Set_Departure_Station(departure);
        lblHomeTitle.click();
        return this;
    }

    public RailSearchResultPage step_Perform_Search_Train(){
        ticketPanel.action_Click_Search_For_Trains();
        return new RailSearchResultPage(driver);
    }

    public RailplusHomePage step_Click_RailPass_Link(){
        ticketPanel.action_RailPass_Link();
        return this;
    }

    public RailplusHomePage check_And_Validate_RailPass_Overlay(String title){
        Assert.assertEquals(title, ticketPanel.action_Get_RailPass_Title().getText());
        return this;
    }

    public RailplusHomePage step_Close_RailPass_Overlay(){
        ticketPanel.action_Close_RailPass_Overlay();
        return this;
    }


    public RailplusHomePage step_Click_Banner_Pagination_icon(int index){
        switch(index){
            case 1 :
                lnkPaginationOne.click();
                break;
            case 2 :
                lnkPaginationTwo.click();
                break;
            default :
        }
        return this;
    }

    public RailDestinationPage step_Click_Banner_Quick_Link_Info_Button(int index){
        switch(index){
            case 1 :

                break;
            case 2 :
                lnkBannerInfoTwo.click();
                break;
            default :
        }
        return new RailDestinationPage(driver);
    }

    /**
     * Action: Navigate To The Banner Info Link
     * @param slide
     */
    private void action_Banner_Dynamic_Info_Navigation(int slide){
        switch (slide) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: ");
        }
    }

    /**
     * Action: Move Banner using Arrows
     * @param slide
     */
    private void action_Banner_Arrow_Navigation_Movement(int slide){
        switch (slide) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: ");
        }
    }

    /**
     * Action: Click Specific Banner Option
     * @param slide
     */
    private void action_Specific_Banner_Movement(int slide){
        switch (slide) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: ");
        }
    }
}
