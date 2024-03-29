package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigatorHelper extends HelperBase {

	public NavigatorHelper(WebDriver wd) {super(wd);}

	public void groupPage() {
		if (isElementPresent(By.tagName("h1"))
						&& wd.findElement(By.tagName("h1")).getText().equals("Groups")
						&& isElementPresent(By.name("new"))) {
			return;
		}
		click(By.linkText("groups"));
	}

//	public void gotoAddNewContact() {
//		if (isElementPresent(By.tagName("h1"))
//				&& wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
//				&& isElementPresent(By.name("submit"))){
//			return;
//		}
//		click(By.linkText("add new"));
//	}

	public void Home() {
		if (isElementPresent(By.id("maintable"))) {
			return;
		}
		click(By.linkText("home"));
	}
}
