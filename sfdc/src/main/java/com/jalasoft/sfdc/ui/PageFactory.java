package com.jalasoft.sfdc.ui;

import com.jalasoft.sfdc.config.ServersConfigReader;
import com.jalasoft.sfdc.constants.SFDCEnums.Skin;
import com.jalasoft.sfdc.ui.components.TopMenu;
import com.jalasoft.sfdc.ui.components.TopMenuClassic;
import com.jalasoft.sfdc.ui.components.TopMenuLight;
import com.jalasoft.sfdc.ui.pages.AppLauncher;
import com.jalasoft.sfdc.ui.pages.AppLauncherClassic;
import com.jalasoft.sfdc.ui.pages.AppLauncherLight;
import com.jalasoft.sfdc.ui.pages.ProfilePage;
import com.jalasoft.sfdc.ui.pages.ProfilePageClassic;
import com.jalasoft.sfdc.ui.pages.ProfilePageLight;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailsPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPage;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageClassic;
import com.jalasoft.sfdc.ui.pages.account.AccountListPageLight;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailsPageClassic;
import com.jalasoft.sfdc.ui.pages.account.AccountDetailsPageLight;
import com.jalasoft.sfdc.ui.pages.home.HomePage;
import com.jalasoft.sfdc.ui.pages.home.HomePageClassic;
import com.jalasoft.sfdc.ui.pages.home.HomePageLight;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitieListPage;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitieListPageClassic;
import com.jalasoft.sfdc.ui.pages.opportunities.OpportunitieListPageLight;
import com.jalasoft.sfdc.ui.pages.products.ProductDetailsPage;
import com.jalasoft.sfdc.ui.pages.products.ProductDetailsPageClassic;
import com.jalasoft.sfdc.ui.pages.products.ProductDetailsPageLight;

/**
 * PageFactory class.
 *
 * @author Franz Silva.
 * @author Erik Vargas.
 * @author Daniel Sandoval.
 */
public class PageFactory {
    private static Skin skin = ServersConfigReader.getInstance().getSkin();

    //****************************************************************
    // Pages
    //****************************************************************

    /**
     * Returns an Instance of HomePage for the respective Skin.
     * @return HomePageClassic or HomePageLight.
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
     * Returns an Instance of TopMenu for the respective Skin.
     * @return TopMenuClassic or TopMenuLight.
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
     * Returns an Instance of ProfilePage for the respective Skin.
     * @return ProfilePageClassic or ProfilePageLight.
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
     * Returns an Instance of AppLauncher for the respective Skin.
     * @return AppLauncherClassic or AppLauncherLight.
     */
    public static AppLauncher getAppLauncher() {
        switch (skin) {
            case CLASSIC:
                return new AppLauncherClassic();
            default:
                return new AppLauncherLight();
        }
    }

    /**
     * Returns an Instance of AccountDetailsPage for the respective Skin.
     * @return AccountDetailsPageClassic or AccountDetailsPageLight.
     */
    public static AccountDetailsPage getDetailAccountPage() {
        switch (skin) {
            case CLASSIC:
                return new AccountDetailsPageClassic();
            default:
                return new AccountDetailsPageLight();
        }
    }

    /**
     * Returns an Instance of AccountListPage for the respective Skin.
     * @return AccountListPageClassic or AccountListPageLight.
     */
    public static AccountListPage getAccountListPage() {
        switch (skin) {
            case CLASSIC:
                return new AccountListPageClassic();
            default:
                return new AccountListPageLight();
        }
    }

    /**
     * Returns an Instance of ProductDetailsPage for the respective Skin.
     * @return ProductDetailsPageClassic or ProductDetailsPageLight.
     */
    public static ProductDetailsPage getProductDetailsPage() {
        switch (skin) {
            case CLASSIC:
                return new ProductDetailsPageClassic();
            default:
                return new ProductDetailsPageLight();
        }
    }

    /**
     * Returns an Instance of OpportunitieListPage for the respective Skin.
     * @return OpportunitieListPageClassic or OpportunitieListPageLight.
     */
    public static OpportunitieListPage getOpportunitieListPage() {
        switch (skin) {
            case CLASSIC:
                return new OpportunitieListPageClassic();
            default:
                return new OpportunitieListPageLight();
        }
    }
}
