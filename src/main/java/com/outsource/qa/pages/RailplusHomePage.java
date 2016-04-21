package com.outsource.qa.pages;

import com.outsource.qa.panels.RailplusHeaderPanel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/**
 * RailplusHomePage.java - RailplusHome page related page-objects definition class
 *
 * @author Shiwantha Lakmal
 * @version 1.0-SNAPSHOT Last modified 04_20_2015
 * @since 04/20/2015.
 */
public class RailplusHomePage extends BasicPage{

    RailplusHeaderPanel headerPanel;






    public RailplusHomePage(RemoteWebDriver driver) {
        super(driver);
        headerPanel = new RailplusHeaderPanel(driver);
    }

    public void call_about_page(){
        headerPanel.test_step();
    }




    /**
     * Action: Navigate To The Banner Info Link
     * @param slide
     */
    private void action_Banner_Dynamic_Info_Navigation(int slide){
        switch (slide) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: ");
        }
    }

    /**
     * Action: Move Banner using Arrows
     * @param slide
     */
    private void action_Banner_Arrow_Navigation_Movement(int slide){
        switch (slide) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: ");
        }
    }

    /**
     * Action: Click Specific Banner Option
     * @param slide
     */
    private void action_Specific_Banner_Movement(int slide){
        switch (slide) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: ");
        }
    }
}
