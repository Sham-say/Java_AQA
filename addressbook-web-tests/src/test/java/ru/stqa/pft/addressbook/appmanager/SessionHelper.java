package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {


	public SessionHelper(WebDriver wd) {

		super(wd);
	}

	public void login(String username, String password) {
		type(By.name("user"), username);
		type(By.name("pass"), password);
		click(By.xpath("//input[@value='Login']"));
	}

	public void logOut(String username, String password) {
		click(By.linkText("Logout"));
		type(By.name("user"), username);
		type(By.name("pass"), password);
	}
}
