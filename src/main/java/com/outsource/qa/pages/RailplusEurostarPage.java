package com.outsource.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by user on 4/20/2016.
 */
public class RailplusEurostarPage {

    //Train Ticket Search Modal
    @FindBy(how= How.XPATH,using = "//*[@id='27CDF252-E37D-A3FC-56C134F9617EC192']/h2")     private WebElement lblSearchPanelTitle;
    @FindBy(how= How.XPATH,using = "//*[@id='roundTripNo']")                                private WebElement radioBtnOnewaOption;
    @FindBy(how= How.XPATH,using = "//*[@id='roundTripYes']")                               private WebElement radioBtnchkBxReturnOption;
    @FindBy(how= How.XPATH,using = "//*[@id='departureStation']")                           private WebElement txtFldDepartureStation;
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
}
