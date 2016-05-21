package com.outsource.qa.pages;

import com.outsource.qa.panels.ModifySearchPanel;
import com.outsource.qa.panels.RailplusFooterPanel;
import com.outsource.qa.panels.RailplusHeaderPanel;
import com.outsource.qa.panels.TravelModalPanel;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 5/7/2016.
 */
public class RailSearchResultPage extends BasicPage {

    @FindBy(how= How.XPATH,using = "//*[@id='shop']/div[1]/h1")             private WebElement lblSearchResultTitle;
    @FindBy(how= How.XPATH,using = "//*[@id='btnContinue']")                private WebElement btnShoppingCart;
    @FindBy(how= How.XPATH,using = "html/body/div[3]/div[2]/div/h2")        private WebElement lblConditionOverlayTitle;
    @FindBy(how= How.XPATH,using = "//div[@class='ui-dialog-buttonset']/button")                    private WebElement btnConditionClose;
    @FindBy(how= How.XPATH,using = "//*[@id='departurePanel']/div[2]/div[5]/div[1]/div[4]/a[1]")    private WebElement btnJourneyDetails;
    @FindBy(how= How.XPATH,using = "//span[contains(., 'Journey Details')]")                        private WebElement lblJourneyTitle;
    @FindBy(how= How.XPATH,using = "html/body/div[3]/div[11]/div/button")                           private WebElement btnJourneyClose;
    @FindBy(how= How.XPATH,using = "//*[@id='departurePanel']/div[2]/div[10]/input[1]")                           private WebElement btnEarlierSort;
    @FindBy(how= How.XPATH,using = "//*[@id='departurePanel']/div[2]/div[10]/input[2]")                           private WebElement btnLaterSort;
    @FindBy(how= How.XPATH,using = "//*[@id='departurePanel']/div[2]/div[5]/div[1]/div[3]/span[1]")                           private WebElement lblSortText;
    @FindBy(how= How.XPATH,using = "//*[@id='shop']/div[2]/input")                                                              private WebElement btnModifySearch;
    @FindBy(how= How.XPATH,using = "//*[@id='shop']/div[4]/p")                                                                  private WebElement lblNoOfPassengers;

    RailplusHeaderPanel headerPanel;
    RailplusFooterPanel footerPanel;
    TravelModalPanel searchPanel;
    ModifySearchPanel modifySearchPanel;
    TravelModalPanel travelModalpanel;

    String total_cost = "";
    String sort_before = "";

    public RailSearchResultPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        headerPanel = new RailplusHeaderPanel(driver);
        footerPanel = new RailplusFooterPanel(driver);
        searchPanel = new TravelModalPanel(driver);
        modifySearchPanel = new ModifySearchPanel(driver);
        travelModalpanel = new TravelModalPanel(driver);
    }

    public RailSearchResultPage check_And_Validate_Location_Result_Title(String from,String to){
        Assert.assertEquals((from+" to "+to), lblSearchResultTitle.getText());
        return this;
    }

    public RailSearchResultPage step_Select_First_Class_Travel_Option(String option){
        total_cost = driver.findElement(By.xpath("//*[@id='departurePanel']/div[2]/div[5]/div[2]//*[@id='fareOption_"+option+"']/span")).getText();
        driver.findElement(By.xpath("//*[@id='departurePanel']/div[2]/div[5]/div[2]//*[@id='radio_"+option+"']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public RailPassengerDetailsPage step_Perform_Shopping_Cart_Button(){
        btnShoppingCart.click();
        return new RailPassengerDetailsPage(driver);
    }

    public RailSearchResultPage step_Select_Second_Class_Travel_Option(String option){
        total_cost = total_cost + driver.findElement(By.xpath("//*[@id='departurePanel']/div[2]/div[5]/div[3]/div/div["+option+"]//span")).getText();
        driver.findElement(By.xpath("//*[@id='departurePanel']/div[2]/div[5]/div[3]/div/div["+option+"]//input")).click();
        return this;
    }

    public RailSearchResultPage check_And_Validate_Condition_Overlay(){
        Assert.assertEquals("Conditions",lblConditionOverlayTitle.getText());
        btnConditionClose.click();
        return this;
    }

    public RailSearchResultPage step_Click_Journey_Details_Link(){
        btnJourneyDetails.click();
        return this;
    }

    public RailSearchResultPage check_And_Verify_Journey_Details_Title(){
        Assert.assertEquals("Journey Details", lblJourneyTitle.getText());
        return this;
    }

    public RailSearchResultPage check_And_Validate_Earlier_Sort_Functionality(){
        sort_before = lblSortText.getText();
        btnEarlierSort.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(!sort_before.equals(lblSortText.getText()));
        return this;
    }

    public RailSearchResultPage check_And_Validate_Later_Sort_Functionality(){
        sort_before = lblSortText.getText();
        btnLaterSort.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(!sort_before.equals(lblSortText.getText()));
        return this;
    }





    public RailSearchResultPage step_Click_Modify_Search_Button(){
        btnModifySearch.click();
        return this;
    }

    public RailSearchResultPage step_Set_Departure_Station_Details(String dep){
        modifySearchPanel.action_Set_Departure_Station(dep);
        modifySearchPanel.get_Overlay_Title().click();
        return this;
    }

    public RailSearchResultPage step_Set_Arrival_Station_Details(String arr){
        modifySearchPanel.action_Set_Arrival_Station(arr);
        modifySearchPanel.get_Overlay_Title().click();
        return this;
    }

    public RailSearchResultPage step_Click_Search_For_Train_Button(){
        modifySearchPanel.action_Click_Search_For_Trains();
        return this;
    }

    public RailSearchResultPage check_And_Validate_Search_Not_Found_Error_Message(String msg){
        Assert.assertEquals(msg, travelModalpanel.get_Search_Not_Found_Error().getText());
        return this;
    }

    public RailSearchResultPage check_And_Validate_Waning_Alert_Message(String msg){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
        return this;
    }

    public RailSearchResultPage check_And_Validate_NoOf_Passenger_Details(String details){
        Assert.assertEquals(details,lblNoOfPassengers.getText());
        return this;
    }

}
