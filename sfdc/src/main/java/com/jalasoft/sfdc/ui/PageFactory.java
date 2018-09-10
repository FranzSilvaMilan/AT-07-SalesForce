package com.jalasoft.sfdc.ui;

import com.jalasoft.sfdc.config.ServersConfigReader;
import com.jalasoft.sfdc.constants.SFDCEnums.Skin;
import com.jalasoft.sfdc.ui.components.TopMenu;
import com.jalasoft.sfdc.ui.components.TopMenuClassic;
import com.jalasoft.sfdc.ui.components.TopMenuLight;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.AppLauncherClassic;
import com.jalasoft.sfdc.ui.pages.AppLuncherLight;
import com.jalasoft.sfdc.ui.pages.ProfilePage;
import com.jalasoft.sfdc.ui.pages.ProfilePageClassic;
import com.jalasoft.sfdc.ui.pages.ProfilePageLight;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageClassic;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageLight;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailPageClassic;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailPageLight;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageClassic;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;

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
                return new HomePageClassic();
            default:
                return new HomePageLight();
        }
    }

    /**
     *
     * @return
     */
    public static TopMenu getTopMenu() {
        switch (skin) {
            case CLASSIC:
                return new TopMenuClassic();
            default:
                return new TopMenuLight();
        }
    }

    /**
     *
     * @return
     */
    public static ProfilePage getProfilePage() {
        switch (skin) {
            case CLASSIC:
                return new ProfilePageClassic();
            default:
                return new ProfilePageLight();
        }
    }

    /**
     *
     * @return
     */
    public static AppLauncher getAppLauncher() {
        switch (skin) {
            case CLASSIC:
                return new AppLauncherClassic();
            default:
                return new AppLuncherLight();
        }
    }

    /**
     *
     * @return
     */
    public static AccountDetailPage getDetailAccountPage() {
        switch (skin) {
            case CLASSIC:
                return new AccountDetailPageClassic();
            default:
                return new AccountDetailPageLight();
        }
    }

    /**
     *
     * @return
     */
    public static AccountListPage getAccountListPage() {
        switch (skin) {
            case CLASSIC:
                return new AccountListPageClassic();
            default:
                return new AccountListPageLight();
        }
    }

}
