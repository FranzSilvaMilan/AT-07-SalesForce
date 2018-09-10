package com.jalasoft.sfdc.ui;

import com.jalasoft.sfdc.config.ServersConfigReader;
import com.jalasoft.sfdc.constants.SFDCEnums.Skin;
import com.jalasoft.sfdc.ui.components.TopMenu;
import com.jalasoft.sfdc.ui.components.TopMenuClassic;
import com.jalasoft.sfdc.ui.components.TopMenuLight;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.AppLauncherClassic;
import com.jalasoft.sfdc.ui.pages.AppLuncherLight;
import com.jalasoft.sfdc.ui.pages.DetailPage;
import com.jalasoft.sfdc.ui.pages.ProfilePage;
import com.jalasoft.sfdc.ui.pages.ProfilePageClassic;
import com.jalasoft.sfdc.ui.pages.ProfilePageLight;
import com.jalasoft.sfdc.ui.pages.account.AccountHomePage;
import com.jalasoft.sfdc.ui.pages.account.AccountHomePageClassic;
import com.jalasoft.sfdc.ui.pages.account.AccountHomePageLight;
import com.jalasoft.sfdc.ui.pages.account.DetailAccountPageClassic;
import com.jalasoft.sfdc.ui.pages.account.DetailAccountPageLight;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageClassic;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;
import com.jalasoft.sfdc.ui.pages.products.ProducHomePageLight;
import com.jalasoft.sfdc.ui.pages.products.ProductFormPage;
import com.jalasoft.sfdc.ui.pages.products.ProductFormPageClassic;
import com.jalasoft.sfdc.ui.pages.products.ProductFormPageLIght;
import com.jalasoft.sfdc.ui.pages.products.ProductHomePage;
import com.jalasoft.sfdc.ui.pages.products.ProductHomePageClassic;

public class PageFactory {
    private static Skin skin = ServersConfigReader.getInstance().getSkin();

    //****************************************************************
    // Pages
    //****************************************************************

    /**
     * Returns an Instance of HomePage for the respective Skin
     *
     * @return
     */
    public static HomePage getHomePage() {
        switch (skin) {
            case CLASSIC:
                System.out.println("return homepage Classic ++++++++++++++++++++++++++++++++");
                return new HomePageClassic();
            default:
                System.out.println("return homepage light ++++++++++++++++++++++++++++++++");
                return new HomePageLight();
        }
    }

    public static TopMenu getTopMenu() {
        switch (skin) {
            case CLASSIC:
                System.out.println("return topmenu Classic ++++++++++++++++++++++++++++++++");
                return new TopMenuClassic();
            default:
                System.out.println("return topmenu light ++++++++++++++++++++++++++++++++");
                return new TopMenuLight();
        }
    }

    public static ProfilePage getProfilePage() {
        switch (skin) {
            case CLASSIC:
                System.out.println("return profile Classic ++++++++++++++++++++++++++++++++");
                return new ProfilePageClassic();
            default:
                System.out.println("return profile light ++++++++++++++++++++++++++++++++");
                return new ProfilePageLight();
        }
    }

    public static AppLauncher getAppLauncher() {
        switch (skin) {
            case CLASSIC:
                System.out.println("return appLauncher Classic ++++++++++++++++++++++++++++++++");
                return new AppLauncherClassic();
            default:
                System.out.println("return appLauncher light ++++++++++++++++++++++++++++++++");
                return new AppLuncherLight();
        }
    }

    public static AccountHomePage getAccountHomePage() {
        switch (skin) {
            case CLASSIC:
                System.out.println("return account home page Classic ++++++++++++++++++++++++++++++++");
                return new AccountHomePageClassic();
            default:
                System.out.println("return account home page light ++++++++++++++++++++++++++++++++");
                return new AccountHomePageLight();
        }
    }

    public static DetailPage getDetailAccountPage() {
        switch (skin) {
            case CLASSIC:
                System.out.println("return detail account home page Classic ++++++++++++++++++++++++++++++++");
                return new DetailAccountPageClassic();
            default:
                System.out.println("return detail account home page light ++++++++++++++++++++++++++++++++");
                return new DetailAccountPageLight();
        }
    }

}
