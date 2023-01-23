package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class HelperBase {
	public WebDriver wd;

	public HelperBase(WebDriver wd) {
		this.wd = wd;
	}

	protected static void timeOut(int timeOut) throws InterruptedException {
		TimeUnit.SECONDS.sleep(timeOut);
	}

	protected void click(By locator) {
		wd.findElement(locator).click();
	}

	protected void type(By locator, String text) {
		click(locator);
		if (text != null) {
			String existingText = wd.findElement(locator).getAttribute("value");
			if (! text.equals(existingText)) {
				wd.findElement(locator).clear();
				wd.findElement(locator).sendKeys(text);
			}
		}
	}

	protected void attach(By locator, File file) {
		if (file != null) {
			wd.findElement(locator).sendKeys(file.getAbsolutePath());
		}
	}



	protected boolean isElementPresent(By locator) {
		try {
			wd.findElement(locator);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	protected void clickSelect(By locator, String text) {
		if (text != null) {
			String selectText = wd.findElement(locator).getAttribute("value");
			if (!text.equals(selectText)) {
				wd.findElement(locator).click();
				try {
					new Select(wd.findElement(locator)).selectByVisibleText(text);
				} catch (NoSuchElementException e){
					wd.findElement(By.xpath("//select[5]/option[2]")).click();
				}
			}
		}
	}
}
