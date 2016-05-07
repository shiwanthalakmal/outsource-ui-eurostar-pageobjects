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
 * Created by user on 5/7/2016.
 */
public class RailRegistrationPage extends BasicPage {


    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div[1]/h1")                                  private WebElement txtHeaderTitle;
    @FindBy(how= How.XPATH,using = "//*[@id='content-wrapper']/div/form/table/tbody/tr[15]/td[2]/input")    private WebElement btnRegister;
    @FindBy(how= How.XPATH,using = "//div[@id='content-wrapper']/div/p/strong")                             private WebElement lblRegisterError;
    @FindBy(how= How.XPATH,using = "//div[@id='content-wrapper']/div/h2")                                   private WebElement lblRegisterTitle;

    RailplusHeaderPanel headerPanel;
    RailplusFooterPanel footerPanel;

    public RailRegistrationPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        headerPanel = new RailplusHeaderPanel(driver);
        footerPanel = new RailplusFooterPanel(driver);
    }

    public RailRegistrationPage check_And_Validate_PageHeader(String title){
        Assert.assertEquals(title, txtHeaderTitle.getText());
        return this;
    }

    public RailRegistrationPage step_Press_Registration_Submission_With_Errors(){
        btnRegister.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public RailRegistrationPage check_And_Validate_RegistrationErrorMsg(String msg){
        Assert.assertEquals(msg, lblRegisterError.getText());
        return this;
    }

    public RailRegistrationPage check_And_Validate_Registration_Title(String title){
        Assert.assertEquals(title, lblRegisterTitle.getText());
        return this;
    }
}
