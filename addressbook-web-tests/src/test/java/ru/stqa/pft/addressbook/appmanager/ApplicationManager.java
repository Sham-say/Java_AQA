package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;

import java.util.Objects;
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
	private Browser browser;


	public ApplicationManager(Browser browser) {
		this.browser = browser;
	}

	public void init() {
		if (Objects.equals(browser, Browser.FIREFOX)) {
			wd = new FirefoxDriver(new FirefoxOptions().setBinary("C:/Program Files/Mozilla Firefox/firefox.exe"));
		} else if (Objects.equals(browser, Browser.CHROME)) {
			wd = new ChromeDriver();
		} else if (Objects.equals(browser, Browser.EDGE)) {
			wd = new EdgeDriver();
		}
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
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
