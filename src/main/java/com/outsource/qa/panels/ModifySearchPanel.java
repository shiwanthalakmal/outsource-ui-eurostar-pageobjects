package com.outsource.qa.panels;

import com.outsource.qa.pages.BasicPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 5/8/2016.
 */
public class ModifySearchPanel extends BasicPage {

    @FindBy(how= How.XPATH,using = "//form/h2")                          private WebElement lblSearchTitle;
    @FindBy(how= How.XPATH,using = "//form[@id='8CEEAE59-03CA-B8BE-1365A1815ECFC5CA']/fieldset/div[2]/div/input")    private WebElement radioBtnOneWay;
    @FindBy(how= How.XPATH,using = "//form[@id='8CEEAE59-03CA-B8BE-1365A1815ECFC5CA']/fieldset/div[3]/div/input")    private WebElement radioBtnReturn;
    @FindBy(how= How.XPATH,using = "//input[@id='departureStation']")    private WebElement txtFldDepartureStation;
    @FindBy(how= How.XPATH,using = "//input[@id='arrivalStation']")    private WebElement txtFldArrivalStation;
    @FindBy(how= How.XPATH,using = "//input[@id='departureStation']")                      private WebElement txtFldDepartureDate;
    @FindBy(how= How.XPATH,using = "//div[@id='journeyDetails']/div[4]/div/input")                      private WebElement txtFldDepartureTime;
    @FindBy(how= How.XPATH,using = "//div[@id='returnDateContainer']/div[2]/div/input")                 private WebElement txtFldReturnDate;
    @FindBy(how= How.XPATH,using = "//div[@id='returnDateContainer']/div[4]/div/input")                 private WebElement txtFldReturnTime;
    @FindBy(how= How.XPATH,using = "//div[@id='journeyDetails']/div[7]/div/select")                     private WebElement dropDownAdult;
    @FindBy(how= How.XPATH,using = "//div[@id='journeyDetails']/div[8]/div/select")                     private WebElement dropDownChild;
    @FindBy(how= How.XPATH,using = "//div[@id='journeyDetails']/div[9]/div/select")                     private WebElement dropDownSenior;
    @FindBy(how= How.XPATH,using = "//div[@id='journeyDetails']/div[10]/div/select")                    private WebElement dropDownYouth;

    @FindBy(how= How.XPATH,using = "//div[@id='journeyDetails']/div[15]/div/input")                     private WebElement chkBxSeatReserve;
    @FindBy(how= How.XPATH,using = "//div[@id='journeyDetails']/div[15]/div/label/span/strong/a")       private WebElement lnkRailPass;
    @FindBy(how= How.XPATH,using = "//div[@id='journeyDetails']/div[19]/div/input")                     private WebElement radioBtnCheapest;
    @FindBy(how= How.XPATH,using = "//div[@id='journeyDetails']/div[20]/div/input")                     private WebElement radioBtnFlexiblr;
    @FindBy(how= How.XPATH,using = "//div[@id='journeyDetails']/div[21]/div/input")                     private WebElement radioBtnDirect;
    @FindBy(how= How.XPATH,using = "//input[@id='btnSearchForTrainTickets']")                     private WebElement btnSearchForTrain;
    @FindBy(how= How.XPATH,using = "//div[@id='journeyDetails']/div[25]/div[2]/strong/a")               private WebElement lnkHowFarAdvance;
    @FindBy(how= How.XPATH,using = "//div[11]/div/button")                                              private WebElement btnOverlayClose;

    public ModifySearchPanel(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement get_Overlay_Title(){
        return this.lblSearchTitle;
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
     * Action: Click 'Search For Trains' Option
     */
    public void action_Click_Search_For_Trains(){
        btnSearchForTrain.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
