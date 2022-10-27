package myweb.com.projects.website.crm.pages.Dashboard;

import myweb.com.projects.website.crm.pages.CommonPage;
import myweb.com.utils.WebUI;
import org.openqa.selenium.By;

public class DashboardPage extends CommonPage {

    public DashboardPage() {
    }

    public String pageText = "Dashboard";
    public String pageUrl = "/dashboard";

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuClients = By.xpath("//span[normalize-space()='Clients']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks']");

    public DashboardPage openDashboardPage() {
        WebUI.clickElement(menuDashboard);
        return this;
    }



}
