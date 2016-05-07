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
    @FindBy(how= How.XPATH,using = "//*[@id='agentslogin']/p/a[1]")                             private WebElement lnkForgotPass;
    @FindBy(how= How.XPATH,using = "//*[@id='agentslogin']/p/a[2]")                             private WebElement lnkNewArgent;
    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div[1]/p/strong")                private WebElement lblErrorMsg;
    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div/form/div/div[6]/input")      private WebElement btnForgotSent;
    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div/p[3]/a[2]")                  private WebElement lnkLoginBack;
    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div[1]/p/strong")                private WebElement lnkLoginError;

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
        Assert.assertEquals(error, lblErrorMsg.getText());
        return this;
    }

    public RailSignInPage step_Click_Forgot_Password_Link(){
        lnkForgotPass.click();
        return this;
    }

    public RailSignInPage step_Set_Forgot_Password_Recovery_Mail(String mail){
        txtFldUsername.sendKeys(mail);
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
}
