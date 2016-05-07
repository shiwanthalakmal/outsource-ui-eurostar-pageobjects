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
 * Created by user on 4/20/2016.
 */
public class RailSignInPage extends BasicPage {

    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div[1]/h1")                      private WebElement txtHeaderTitle;
    @FindBy(how= How.XPATH,using = "(//input[@id='agent_email'])[2]")                           private WebElement txtFldUsername;
    @FindBy(how= How.XPATH,using = "(//input[@id='agent_password'])[2]")                        private WebElement txtFldPassword;
    @FindBy(how= How.XPATH,using = "(//input[@name='login'])[2]")                               private WebElement btnSignin;
    @FindBy(how= How.XPATH,using = "(//a[contains(text(),'Forgot Password')])[2]")              private WebElement lnkForgotPass;
    @FindBy(how= How.XPATH,using = "(//input[@id='agent_email'])[2]")                           private WebElement txtFldForgotMail;
    @FindBy(how= How.XPATH,using = "(//a[contains(@href, '?action=new-agent')])[2]")            private WebElement lnkNewArgent;
    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div[1]/p/strong")                private WebElement lblErrorMsg;
    @FindBy(how= How.XPATH,using = "//div[@id='content-wrapper']/div/p")                        private WebElement lblForgotErrorMsg;
    @FindBy(how= How.XPATH,using = "//input[@value='Send']")                                    private WebElement btnForgotSent;
    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div/p[3]/a[2]")                  private WebElement lnkLoginBack;
    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div[1]/p/strong")                private WebElement lnkLoginError;
    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div/h2")                         private WebElement lblForgotTitle;

    RailplusHeaderPanel headerPanel;
    RailplusFooterPanel footerPanel;

    public RailSignInPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        headerPanel = new RailplusHeaderPanel(driver);
        footerPanel = new RailplusFooterPanel(driver);
    }

    public RailSignInPage check_And_Validate_PageHeader(String title){
        Assert.assertEquals(title, txtHeaderTitle.getText());
        return this;
    }

    public RailSignInPage step_Set_Login_Credentials(String user,String pass){
        txtFldUsername.sendKeys(user);
        txtFldPassword.sendKeys(pass);
        return this;
    }

    public RailSignInPage step_Set_User_SignIn_Username(String user){
        txtFldUsername.sendKeys(user);
        return this;
    }

    public RailSignInPage step_Set_User_SignIn_Password(String pass){
        txtFldPassword.sendKeys(pass);
        return this;
    }

    public RailSignInPage step_Press_SignIn_Button(){
        btnSignin.click();
        return this;
    }

    public RailSignInPage check_And_Validate_LoginError_Message(String error) {
        Assert.assertEquals(error, lblErrorMsg.getText());
        return this;
    }

    public RailSignInPage check_And_Validate_ForgotPass_Error_Message(String error) {
        Assert.assertEquals(error, lblForgotErrorMsg.getText());
        return this;
    }

    public RailSignInPage check_And_Validate_ForgotPass_Title(String title){
        Assert.assertEquals(title, lblForgotTitle.getText());
        return this;
    }

    public RailSignInPage check_And_Validate_Registration_Title(String title){
        Assert.assertEquals(title, lblForgotTitle.getText());
        return this;
    }

    public RailSignInPage step_Click_Forgot_Password_Link(){
        lnkForgotPass.click();
        return this;
    }

    public RailSignInPage step_Set_Forgot_Password_Recovery_Mail(String mail){
        txtFldForgotMail.sendKeys(mail);
        return this;
    }

    public RailSignInPage step_Press_Forgot_Recovery_Sent(){
        btnForgotSent.click();
        return this;
    }

    public RailSignInPage step_Back_To_Login(){
        lnkLoginBack.click();
        return this;
    }

    public RailRegistrationPage step_Click_New_Argent_Registration(){
        lnkNewArgent.click();
        return new RailRegistrationPage(driver);
    }

    public RailSignInPage check_And_Validate_Login_UI_Availability(){
        Assert.assertTrue(txtFldUsername.isDisplayed());
        Assert.assertTrue(txtFldPassword.isDisplayed());
        Assert.assertTrue(btnSignin.isDisplayed());
        return this;
    }

    public RailSignInPage check_And_Validate_Login_Link_Availability(){
        Assert.assertTrue(lnkNewArgent.isDisplayed());
        Assert.assertTrue(lnkForgotPass.isDisplayed());
        return this;
    }

}
