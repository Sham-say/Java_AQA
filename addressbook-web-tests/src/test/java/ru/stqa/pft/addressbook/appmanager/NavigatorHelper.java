package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigatorHelper {
	private WebDriver wd;

	public NavigatorHelper(WebDriver wd) {
		this.wd = wd;
	}

	public void gotoGroupPage() {
		wd.findElement(By.linkText("groups")).click();
	}

	public void gotoAddNewContact() {
		wd.findElement(By.linkText("add new")).click();
	}
}
