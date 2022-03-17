package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageObjects {
	@FindBy(id = "menu_dashboard_index")
	public static WebElement dashboard;
	@FindBy(xpath = "//div[@id='task-list-group-panel-menu_holder']//following::td[1]")
	public static WebElement dash_Board_Page_Objects;

}
