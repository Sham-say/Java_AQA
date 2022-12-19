package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper {
	private WebDriver wd;

	public ContactHelper(WebDriver wd) {
		this.wd = wd;
	}

	public void returnToHomePage() {
		wd.findElement(By.linkText("home page")).click();
	}

	public void submitContactCreation() {
		wd.findElement(By.xpath("//input[21]")).click();
	}

	public void fillContactForm(ContactData contactData) {
		wd.findElement(By.name("firstname")).click();
		wd.findElement(By.name("firstname")).clear();
		wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
		wd.findElement(By.name("middlename")).click();
		wd.findElement(By.name("middlename")).clear();
		wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
		wd.findElement(By.name("lastname")).click();
		wd.findElement(By.name("lastname")).clear();
		wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
		wd.findElement(By.name("nickname")).click();
		wd.findElement(By.name("nickname")).clear();
		wd.findElement(By.name("nickname")).sendKeys(contactData.getFirstName());
		wd.findElement(By.name("title")).click();
		wd.findElement(By.name("title")).clear();
		wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
		wd.findElement(By.name("company")).click();
		wd.findElement(By.name("company")).clear();
		wd.findElement(By.name("company")).sendKeys(contactData.getCompanyName());
		wd.findElement(By.name("address")).click();
		wd.findElement(By.name("address")).clear();
		wd.findElement(By.name("address")).sendKeys(contactData.getFullAddress());
		wd.findElement(By.name("home")).click();
		wd.findElement(By.name("home")).clear();
		wd.findElement(By.name("home")).sendKeys(contactData.getPhoneNumber());
		wd.findElement(By.name("mobile")).click();
		wd.findElement(By.name("mobile")).clear();
		wd.findElement(By.name("mobile")).sendKeys(contactData.getPhoneNumber());
		wd.findElement(By.name("work")).click();
		wd.findElement(By.name("work")).clear();
		wd.findElement(By.name("work")).sendKeys(contactData.getPhoneNumber());
		wd.findElement(By.name("fax")).click();
		wd.findElement(By.name("fax")).clear();
		wd.findElement(By.name("fax")).sendKeys(contactData.getPhoneNumber());
		wd.findElement(By.name("email")).click();
		wd.findElement(By.name("email")).clear();
		wd.findElement(By.name("email")).sendKeys(contactData.getMailContact());
		wd.findElement(By.name("email2")).click();
		wd.findElement(By.name("email2")).clear();
		wd.findElement(By.name("email2")).sendKeys(contactData.getMailContact());
		wd.findElement(By.name("email3")).click();
		wd.findElement(By.name("email3")).clear();
		wd.findElement(By.name("email3")).sendKeys(contactData.getMailContact());
		wd.findElement(By.name("homepage")).click();
		wd.findElement(By.name("homepage")).clear();
		wd.findElement(By.name("homepage")).sendKeys(contactData.getHomePage());
		wd.findElement(By.name("bday")).click();
		new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getDay());
		wd.findElement(By.name("bmonth")).click();
		new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getMonth());
		wd.findElement(By.name("byear")).click();
		wd.findElement(By.name("byear")).clear();
		wd.findElement(By.name("byear")).sendKeys(contactData.getYear());
		wd.findElement(By.name("aday")).click();
		new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getDay());
		wd.findElement(By.name("amonth")).click();
		new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getMonth());
		wd.findElement(By.name("ayear")).click();
		wd.findElement(By.name("ayear")).clear();
		wd.findElement(By.name("ayear")).sendKeys(contactData.getYear());
		wd.findElement(By.name("address2")).click();
		wd.findElement(By.name("address2")).clear();
		wd.findElement(By.name("address2")).sendKeys(contactData.getFullAddress());
		wd.findElement(By.name("phone2")).click();
		wd.findElement(By.name("phone2")).clear();
		wd.findElement(By.name("phone2")).sendKeys(contactData.getPhoneNumber());
		wd.findElement(By.name("notes")).click();
		wd.findElement(By.name("notes")).clear();
		wd.findElement(By.name("notes")).sendKeys(contactData.getNotesContact());
	}
}