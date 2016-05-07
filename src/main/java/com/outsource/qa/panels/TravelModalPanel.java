package com.outsource.qa.panels;

import com.outsource.qa.pages.BasicPage;
import com.outsource.qa.pages.RailplusHomePage;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by user on 4/21/2016.
 */
public class TravelModalPanel extends BasicPage {

    //Main banner modal tabs
    @FindBy(how= How.XPATH,using = "//*[@id='booking-form-container']/div[1]/ul/li[1]/a/span[1]")   private WebElement btnTrainTicketsTab;
    @FindBy(how= How.XPATH,using = "//*[@id='booking-form-container']/div[1]/ul/li[2]/a/span[1]")   private WebElement btnRailPassesTab;
    @FindBy(how= How.XPATH,using = "//*[@id='booking-form-container']/div[1]/ul/li[3]/a/span[1]")   private WebElement btnTravelExtrasTab;
    @FindBy(how= How.XPATH,using = "//*[@id='booking-form-container']/div[1]/ul/li[4]/a/span[1]")   private WebElement btnFerryTicketsTab;

    //Train Ticket Search Modal
    @FindBy(how= How.XPATH,using = "//*[@id='27CDF252-E37D-A3FC-56C134F9617EC192']/h2")     private WebElement lblSearchPanelTitle;
    @FindBy(how= How.XPATH,using = "//*[@id='roundTripNo']")                                private WebElement radioBtnOnewaOption;
    @FindBy(how= How.XPATH,using = "//*[@id='roundTripYes']")                               private WebElement radioBtnchkBxReturnOption;
    @FindBy(how= How.XPATH,using = "//*[@id='departureStation']")                           private WebElement txtFldDepartureStation;
    @FindBy(how= How.XPATH,using = "//*[@id='returnDate']")                                 private WebElement txtFldReturnDate;
    @FindBy(how= How.XPATH,using = "//*[@id='returnTimePeriodDisplay']")                    private WebElement txtFldReturnTime;
    @FindBy(how= How.XPATH,using = "//*[@id='arrivalStation']")                             private WebElement txtFldArrivalStation;
    @FindBy(how= How.XPATH,using = "//*[@id='departureDate']")                              private WebElement txtFldDepartureDate;
    @FindBy(how= How.XPATH,using = "//*[@id='departureTimePeriodDisplay']")                 private WebElement btnDepartureTime;
    @FindBy(how= How.XPATH,using = "//*[@id='departureTimePeriod']")                        private WebElement ddlDepartureTime;
    @FindBy(how= How.XPATH,using = "//*[@id='departureTimeDiv']/div[2]/button")             private WebElement btnDepartureOk;
    @FindBy(how= How.XPATH,using = "//*[@id='paxCountAdults']")                             private WebElement ddlAdultOption;
    @FindBy(how= How.XPATH,using = "//*[@id='paxCountChildren']")                           private WebElement ddlChildOption;
    @FindBy(how= How.XPATH,using = "//*[@id='paxCountSeniors']")                            private WebElement ddlSeniorOption;
    @FindBy(how= How.XPATH,using = "//*[@id='paxCountYouth']")                              private WebElement ddlYouthOption;
    @FindBy(how= How.XPATH,using = "//*[@id='passholderFaresOnly']")                        private WebElement chkBxSeatReservation;
    @FindBy(how= How.XPATH,using = "//*[@id='ageRules']")                                   private WebElement lnkAgeRules;
    @FindBy(how= How.XPATH,using = "//*[@id='packageTypePrice']")                           private WebElement radioBtnCheapestFares;
    @FindBy(how= How.XPATH,using = "//*[@id='packageTypeFlexible']")                        private WebElement radioBtnFlexibleFares;
    @FindBy(how= How.XPATH,using = "//*[@id='packageTypeDirect']")                          private WebElement radioBtnDirectTrains;
    @FindBy(how= How.XPATH,using = "//*[@id='btnSearchForTrainTickets']")                   private WebElement btnSearchForTrains;
    @FindBy(how= How.XPATH,using = "//*[@id='journeyDetails']/div[20]/div[2]/strong/a")     private WebElement lnkCanBookTicket;

    //Rail Passes Search Modal
    @FindBy(how= How.XPATH,using = "//*[@id='booking-form-passes']/h2")                     private WebElement lblRailTitle;
    @FindBy(how= How.XPATH,using = "//*[@id='europe-passes']")                              private WebElement ddlEuropRailPasses;
    @FindBy(how= How.XPATH,using = "//*[@id='uk-passes']")                                  private WebElement ddlUKRailPasses;
    @FindBy(how= How.XPATH,using = "//*[@id='japan-passes']")                               private WebElement ddlJapanRailPasses;
    @FindBy(how= How.XPATH,using = "//*[@id='asia-passes']")                                private WebElement ddlAsiaRailPasses;
    @FindBy(how= How.XPATH,using = "//*[@id='usa-passes']")                                 private WebElement ddlUSARailPasses;
    @FindBy(how= How.XPATH,using = "//*[@id='canada-passes']")                              private WebElement ddlCanadaRailPasses;

    //Travel Extras
    @FindBy(how= How.XPATH,using = "//*[@id='booking-form-addons']/h2")                     private WebElement lblTravelTitle;
    @FindBy(how= How.XPATH,using = "//*[@id='london / uk-addons']")                         private WebElement ddlUKTravel;
    @FindBy(how= How.XPATH,using = "//*[@id='paris-addons']")                               private WebElement ddlParisTravel;
    @FindBy(how= How.XPATH,using = "//*[@id='usa/canada-addons']")                          private WebElement ddlCanadaTravel;
    @FindBy(how= How.XPATH,using = "//*[@id='europe-addons']")                              private WebElement ddlEuropeTravel;
    @FindBy(how= How.XPATH,using = "//*[@id='japan-addons']")                               private WebElement ddlJapanTravel;

    //Ferry Ticket
    @FindBy(how= How.XPATH,using = "//*[@id='booking-form-ferry']/h2")                      private WebElement lblFerryTitle;
    @FindBy(how= How.XPATH,using = "//*[@id='booking-form-ferry']/div[1]/div[2]/strong/a")  private WebElement lnkBookEngine;

    public TravelModalPanel(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RailplusHomePage action_Ticket_Type_Default_Status(){
        Assert.assertTrue(radioBtnOnewaOption.isSelected());
        Assert.assertTrue(!radioBtnchkBxReturnOption.isSelected());
        return new RailplusHomePage(driver);
    }

    public RailplusHomePage action_Fare_Type_Default_Status(){
        Assert.assertTrue(radioBtnCheapestFares.isSelected());
        Assert.assertTrue(!radioBtnFlexibleFares.isSelected());
        Assert.assertTrue(!radioBtnDirectTrains.isSelected());
        return new RailplusHomePage(driver);
    }

    public RailplusHomePage action_Seat_Reservation_Default_Status(){
        Assert.assertTrue(!chkBxSeatReservation.isSelected());
        return new RailplusHomePage(driver);
    }

    /**
     * Action: Choose Home Page Banner Modal Option
     * @param tab
     */
    public void action_Click_Banner_Modal_Option(String tab){
        if (tab.equals("Train")){
            btnTrainTicketsTab.click();
        }else if (tab.equals("Rail")){
            btnRailPassesTab.click();
        }else if (tab.equals("Travel")){
            btnTravelExtrasTab.click();
        }else if (tab.equals("Ferry")){
            btnFerryTicketsTab.click();
        }else{

        }
    }

    public void action_verify_modal_title(String tab){
        if (tab.equals("Train")){
            btnTrainTicketsTab.click();
        }else if (tab.equals("Rail")){
            btnRailPassesTab.click();
        }else if (tab.equals("Travel")){
            btnTravelExtrasTab.click();
        }else if (tab.equals("Ferry")){
            btnFerryTicketsTab.click();
        }else{

        }
    }

    /**
     * Action: Change One-way Choose Option
     * @param state
     */
    public void action_Oneway_Radio_Status(String state){
        if (state.equals("OFF")){
            if(radioBtnOnewaOption.isSelected()){radioBtnOnewaOption.click();}
        }else{
            if(!radioBtnOnewaOption.isSelected()){radioBtnOnewaOption.click();}
        }
    }

    /**
     * Action: Change One-way Choose Option
     * @param state
     */
    public void action_Return_Radio_Status(String state){
        if (state.equals("OFF")){
            if(radioBtnchkBxReturnOption.isSelected()){radioBtnchkBxReturnOption.click();}
        }else{
            if(!radioBtnchkBxReturnOption.isSelected()){radioBtnchkBxReturnOption.click();}
        }
    }

    /**
     * Action: Set Departure Station Details
     * @param station
     */
    public void action_Set_Departure_Station(String station){
        txtFldDepartureStation.clear();
        txtFldDepartureStation.sendKeys(station);
    }

    /**
     * Action: Set Arrival Station Details
     * @param station
     */
    public void action_Set_Arrival_Station(String station){
        txtFldArrivalStation.clear();
        txtFldArrivalStation.sendKeys(station);
    }

    /**
     * Action: Set Departure Date
     * @param date
     */
    public void action_Set_Departure_Date(String date){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('departureDate').value = '"+date+"';");
    }

    /**
     * Action: Set Departure Time
     * @param time
     */
    private void action_Set_Departure_Time(String time){
        btnDepartureTime.clear();
        new Select(ddlDepartureTime).selectByVisibleText(time);
        btnDepartureOk.click();
    }

    /**
     * Action: Return Return Date Text
     * @return String
     */
    public void action_Set_Return_Ticket_Date(String date){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('returnDate').value = '"+date+"';");
    }

    /**
     * Action: Return Return Time Text
     * @return String
     */
    public String action_Get_Return_Ticket_Time(){
        return txtFldReturnTime.getAttribute("value");
    }

    /**
     * Action: Set Adults Option
     * @param adult
     */
    public void action_Set_Adults_Option(String adult){
        new Select(ddlAdultOption).selectByVisibleText(adult);
    }

    /**
     * Action: Set Child Option
     * @param child
     */
    public void action_Set_Child_Option(String child){
        new Select(ddlChildOption).selectByVisibleText(child);
    }

    /**
     * Action: Set Seniors Option
     * @param senior
     */
    public void action_Set_Seniors_Option(String senior){
        new Select(ddlSeniorOption).selectByVisibleText(senior);
    }

    /**
     * Action: Set Youths Option
     * @param youth
     */
    public void action_Set_Youths_Option(String youth){
        new Select(ddlYouthOption).selectByVisibleText(youth);
    }

    /**
     * Action: Set Seat Reservation Availability
     * @param state
     */
    public void action_Seat_Reservation_Availability(String state){
        if (state.equals("OFF")){

        }else{
            chkBxSeatReservation.click();
        }
    }

    /**
     * Action: Set Different Faires Availability
     * @param option
     * @param state
     */
    public void action_Set_Fares_Availability(String option,String state){
        if (option.equals("cheapest")){

        }else if (option.equals("flexible")){

        }else if (option.equals("direct")){

        }else{}
    }

    /**
     * Action: Click 'Search For Trains' Option
     */
    public void action_Click_Search_For_Trains(){
        btnSearchForTrains.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Action: Click'Age Rules' Link
     */
    public void action_Age_Rules_Link(){
        lnkAgeRules.click();
    }

    /**
     * Action: Book Train Ticket Link
     */
    public void action_Book_Train_Ticket_Link(){
        lnkCanBookTicket.click();
    }

}
