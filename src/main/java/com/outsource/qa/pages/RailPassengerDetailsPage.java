package com.outsource.qa.pages;

import com.outsource.qa.panels.RailplusFooterPanel;
import com.outsource.qa.panels.RailplusHeaderPanel;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by user on 5/15/2016.
 */
public class RailPassengerDetailsPage extends BasicPage {

    RailplusHeaderPanel headerPanel;
    RailplusFooterPanel footerPanel;

    @FindBy(how= How.XPATH,using = "//*[@id='shop']/div/h1")                private WebElement lblPassengerTitle;
    @FindBy(how= How.XPATH,using = "//*[@id='pax_title_1']")                private WebElement ddlMrTitle;
    @FindBy(how= How.XPATH,using = "//*[@id='pax_fname_1']")                private WebElement txtFldFirstName;
    @FindBy(how= How.XPATH,using = "//*[@id='pax_lname_1']")                private WebElement txtFldLastName;
    @FindBy(how= How.XPATH,using = "//*[@id='pax_countryofresidence_1']")   private WebElement txtFldCountry;
    @FindBy(how= How.XPATH,using = "//*[@id='pax_age_1']")                  private WebElement txtFldAge;
    @FindBy(how= How.XPATH,using = "//*[@id='pax_age_conditions']")         private WebElement chkBxCondition;
    @FindBy(how= How.XPATH,using = "//*[@id='btnContinue']")                private WebElement btnContinue;

    public RailPassengerDetailsPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        headerPanel = new RailplusHeaderPanel(driver);
        footerPanel = new RailplusFooterPanel(driver);
    }

    public RailPassengerDetailsPage check_And_Validate_Passenger_Title(String title){
        Assert.assertEquals(title,lblPassengerTitle.getText());
        return this;
    }

    public RailPassengerDetailsPage step_Set_MrTitle(String title){
        Select select = new Select(ddlMrTitle);
        select.selectByVisibleText(title);
        return this;
    }

    public RailPassengerDetailsPage step_Set_Passenger_FName(String fname){
        txtFldFirstName.sendKeys(fname);
        return this;
    }

    public RailPassengerDetailsPage step_Set_Passenger_LName(String lname){
        txtFldLastName.sendKeys(lname);
        return this;
    }

    public RailPassengerDetailsPage step_Set_Passenger_Country(String country){
        txtFldCountry.sendKeys(country);
        return this;
    }

    public RailPassengerDetailsPage step_Set_Passenger_Age(String age){
        txtFldAge.sendKeys(age);
        return this;
    }

    public RailPassengerDetailsPage step_Check_Accept_Condition(){
        chkBxCondition.click();
        return this;
    }

    public RailConfirmItineraryPage step_Continue_Passenger_Details_Flow(){
        btnContinue.click();
        return new RailConfirmItineraryPage(driver);
    }
}
