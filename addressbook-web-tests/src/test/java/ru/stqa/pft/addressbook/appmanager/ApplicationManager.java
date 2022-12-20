package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;


public class ApplicationManager {
	public WebDriver wd;

	private ContactHelper contactHelper;
	private SessionHelper sessionHelper;
	private NavigatorHelper navigatorHelper;
	private GroupHelper groupHelper;
	//переменные для логина и пароля
	String userLogin = "admin";
	String userPassword = "secret";
	private JavascriptExecutor js;

	public void init() {
		wd = new FirefoxDriver(new FirefoxOptions().setBinary("C:/Program Files/Mozilla Firefox/firefox.exe"));
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wd.get("http://localhost/addressbook/");
		contactHelper = new ContactHelper(wd);
		groupHelper = new GroupHelper(wd);
		navigatorHelper = new NavigatorHelper(wd);
		sessionHelper = new SessionHelper(wd);
		sessionHelper.login(userLogin, userPassword);
	}


	public void stop() {
		sessionHelper.logOut(userLogin, userPassword);
		wd.quit();
	}


	private boolean isElementPresent(By by) {
		try {
			wd.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public GroupHelper getGroupHelper() {
		return groupHelper;
	}

	public NavigatorHelper getNavigatorHelper() {
		return navigatorHelper;
	}

	public ContactHelper getContactHelper() {
		return contactHelper;
	}
}
