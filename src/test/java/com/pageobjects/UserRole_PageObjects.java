package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRole_PageObjects {

	@FindBy(linkText = "Admin")
	public static WebElement Admin;
	@FindBy(linkText = "User Management")
	public static WebElement userManagement;
	@FindBy(xpath = "//a[@id='menu_admin_UserManagement']//following::a")
	public static WebElement users;
	@FindBy(xpath = "//*[@id=\"searchSystemUser_userType\"]")
	public static WebElement userType;
	@FindBy(xpath = "//select[@id='searchSystemUser_status']")
	public static WebElement userStatus;
	@FindBy(xpath = "//input[@id='searchBtn']")
	public static WebElement searchButton;
	@FindBy(xpath = "//tr[3]//td[3]")
	public static WebElement UserRoleValue;
	@FindBy(xpath = "//tr[3]//td[5]")
	public static WebElement UserStatusValue;

}
