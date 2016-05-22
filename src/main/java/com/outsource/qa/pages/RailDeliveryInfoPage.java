package com.outsource.qa.pages;

import com.outsource.qa.panels.RailplusFooterPanel;
import com.outsource.qa.panels.RailplusHeaderPanel;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 5/19/2016.
 */
public class RailDeliveryInfoPage extends BasicPage{

    RailplusHeaderPanel headerPanel;
    RailplusFooterPanel footerPanel;

    @FindBy(how= How.XPATH,using = "//*[@id='shop']/h1")                                      private WebElement lblDeliveryInfoTitle;
    @FindBy(how= How.XPATH,using = "//*[@id='shop']/p/a")                                     private WebElement lnkLoginNow;


    @FindBy(how= How.XPATH,using = "//*[@id='shop']/form/fieldset[2]/div/table/tbody/tr[1]/td[2]/select")  private WebElement ddlAttentionTo;
    @FindBy(how= How.XPATH,using = "//*[@id='dp1463896655515']")                              private WebElement txtFldDepartureDate;
    @FindBy(how= How.XPATH,using = "//*[@id='delivery_phone']")                               private WebElement txtFldPhoneNo;
    @FindBy(how= How.XPATH,using = "//*[@id='delivery_email']")                               private WebElement txtFldEmail;
    @FindBy(how= How.XPATH,using = "//*[@id='shop']/form/fieldset[2]/div/table/tbody/tr[4]/td[2]/input[1]")             private WebElement radioBtnAddress;
    @FindBy(how= How.XPATH,using = "//*[@id='dialogBox']")                                    private WebElement lblValidationError;

    @FindBy(how= How.XPATH,using = "//*[@id='postagetypeid5']")                               private WebElement radioBtnPostage;
    @FindBy(how= How.XPATH,using = "//*[@id='shop']//table/tbody/tr/td[3]/p[4]/input[1]")     private WebElement chkBxPostage;
    @FindBy(how= How.XPATH,using = "//*[@id='promotionCode']")                                private WebElement txtFldPromotionCode;
    @FindBy(how= How.XPATH,using = "//*[@id='btnGetDiscount']")          private WebElement btnDiscount;
    @FindBy(how= How.XPATH,using = "//*[@id='promocodeResponse']/ul/li/strong")               private WebElement lblDiscountError;
    @FindBy(how= How.XPATH,using = "//*[@id='promocodeResponse']/ul/li")                      private WebElement lblLogedDiscountError;


    public RailDeliveryInfoPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        headerPanel = new RailplusHeaderPanel(driver);
        footerPanel = new RailplusFooterPanel(driver);
    }

    public RailDeliveryInfoPage check_And_Validate_Payment_DeliveryInfo_Page(String title){
        Assert.assertEquals(title, lblDeliveryInfoTitle.getText());
        return this;
    }

    public RailSignInPage step_Click_On_The_LoingNow_Link(){
        lnkLoginNow.click();
        return new RailSignInPage(driver);
    }

    public RailDeliveryInfoPage check_And_Validate_Departure_Date_Editability(){
        Assert.assertTrue(txtFldDepartureDate.isEnabled());
        return this;
    }

    public RailDeliveryInfoPage check_And_Validate_Contact_Info_Editability(){
        Assert.assertTrue(ddlAttentionTo.isEnabled());
        Assert.assertTrue(txtFldEmail.isEnabled());
        Assert.assertTrue(txtFldPhoneNo.isEnabled());
        return this;
    }

    public RailDeliveryInfoPage step_Set_Departure_Date_Value(String date) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementByXPath(\'//*[@id='shop']//table/tbody/tr/td/p/input\').value = '" + date + "';");
        return this;
    }

    public RailDeliveryInfoPage step_Set_Postage_Details(){
        radioBtnPostage.click();
        chkBxPostage.click();
        return this;
    }

    public RailDeliveryInfoPage step_Set_Delivery_Email_Address(String email){
        txtFldEmail.clear();
        txtFldEmail.sendKeys(email);
        return this;
    }

    public RailDeliveryInfoPage step_Set_Promotion_Code(String code){
        txtFldPromotionCode.sendKeys(code);
        return this;
    }

    public RailDeliveryInfoPage check_And_Validate_Discount_Error_Message(String error){
        Assert.assertEquals(error, lblLogedDiscountError.getText());
        return this;
    }

    public RailDeliveryInfoPage check_And_Validate_Logged_Discount_Error_Message(String error){
        Assert.assertEquals(error, lblDiscountError.getText());
        return this;
    }

    public RailDeliveryInfoPage step_Click_Discount_Button(){
        btnDiscount.click();
        return this;
    }
}
