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
 * Created by user on 5/15/2016.
 */
public class RailConfirmItineraryPage extends BasicPage {


    RailplusHeaderPanel headerPanel;
    RailplusFooterPanel footerPanel;

    @FindBy(how= How.XPATH,using = "//*[@id='shop']/h1")                                                                private WebElement lblConfirmationTitle;
    @FindBy(how= How.XPATH,using = "//*[@id='shop']/fieldset/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/strong")   private WebElement lblVerifyDestinationPlace;
    @FindBy(how= How.XPATH,using = "//*[@id='shop']/fieldset/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[4]/strong")   private WebElement lblVerifyArrivalPlace;
    @FindBy(how= How.XPATH,using = "//*[@id='shop']/fieldset/table/tbody/tr[2]/td[2]/span")                             private WebElement lblVerifyTicketPrice;
    @FindBy(how= How.XPATH,using = "//*[@id='shop']/fieldset/table/tbody/tr[2]/td[1]/span")                             private WebElement lblVerifyPassengerDetails;
    @FindBy(how= How.XPATH,using = "//*[@id='shop']/fieldset/table/tbody/tr[3]/td[2]/span")                             private WebElement lblBookingFee;
    @FindBy(how= How.XPATH,using = "//*[@id='shop']/fieldset/table/tbody/tr[4]/td[2]/strong")                           private WebElement lblTotalTravelFee;
    @FindBy(how= How.XPATH,using = "//*[@id='btnCheckOut']")                                                            private WebElement btnCheckOutProceed;
    @FindBy(how= How.XPATH,using = "//*[@id='btnContinue']")                                                            private WebElement btnContinueShopping;
    @FindBy(how= How.XPATH,using = "//*[@id='button-cart']/div/a")                                                      private WebElement lnkShoppingBag;

    public RailConfirmItineraryPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        headerPanel = new RailplusHeaderPanel(driver);
        footerPanel = new RailplusFooterPanel(driver);
    }

    public RailConfirmItineraryPage check_And_Validate_Confirmation_Page(String title){
        Assert.assertEquals(title,lblConfirmationTitle.getText());
        return this;
    }

    public RailConfirmItineraryPage check_And_Validate_Shopping_bag(String items){
        Assert.assertEquals(items,lnkShoppingBag.getText());
        return this;
    }

    public RailConfirmItineraryPage check_And_Validate_Shopping_Bucket_Total(String total){
        int netTotal = (Integer.parseInt(lblBookingFee.getText()) + Integer.parseInt(lblVerifyTicketPrice.getText()));
        Assert.assertEquals(total,String.valueOf(netTotal));
        return this;
    }

    public RailConfirmItineraryPage check_And_Validate_Passenger_Details(String details){

        return this;
    }

    public RailConfirmItineraryPage check_And_Validate_Travel_Locations(String desti,String arrival){

        return this;
    }

    public RailConfirmItineraryPage check_And_Validate_Cart_Travel_Cost(String cost){

        return this;
    }

    public RailPaymentPage step_Proceed_Checkout_Flow(){
        btnCheckOutProceed.click();
        return new RailPaymentPage(driver);
    }

    public RailplusHomePage step_Back_To_Continue_Shopping(){
        btnContinueShopping.click();
        return new RailplusHomePage(driver);
    }

}
