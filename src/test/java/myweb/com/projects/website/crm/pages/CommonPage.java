package myweb.com.projects.website.crm.pages;

import myweb.com.projects.website.crm.pages.Dashboard.DashboardPage;
import myweb.com.projects.website.crm.pages.SignIn.SignInPage;
import myweb.com.utils.WebUI;
import org.openqa.selenium.By;

public class CommonPage {

    public SignInPage signInPage;
    public DashboardPage dashboardPage;


    public By dropdownAccount = By.xpath("//a[@id='user-dropdown']//span[2]");
    public By buttonSignOut = By.xpath("//a[normalize-space()='Sign Out']");


    public SignInPage signOut() {
        WebUI.clickElement(dropdownAccount);
        WebUI.clickElement(buttonSignOut);
        return new SignInPage();
    }

    public SignInPage getSignInPage() {
        if (signInPage == null) {
            signInPage = new SignInPage();
        }
        return signInPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }



}
