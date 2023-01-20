package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;


public class ContactHelper extends HelperBase {
	public ContactHelper(WebDriver wd) {super(wd);}

	public void initContactCreation() { click(By.linkText("add new"));}

	public void fillContactForm(ContactData contactData, boolean creation) {

		type(By.name("firstname"), contactData.getFirstName());
		type(By.name("lastname"), contactData.getLastName());
		type(By.name("address"), contactData.getAddress());
		type(By.name("email"), contactData.getEmail());
		type(By.name("home"), contactData.getHome());

		if (creation) {
			clickSelect(By.name("new_group"), contactData.getGroup());
		} else {
			Assert.assertFalse(isElementPresent(By.name("new_group")));
		}
	}


	public void selectContactById(int id) {
		wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
	}

	public void submitContactDelete(int timeOut) throws InterruptedException {
		click(By.xpath("//input[@value='Delete']"));
		wd.switchTo().alert().accept();
		timeOut(timeOut);
	}

	public void submitContactCreation() {click(By.name("submit"));}
	public void returnToHomePage() {click(By.linkText("home page"));}
	public void initContactModification(int id) {
		wd.findElement(By.cssSelector("a[href='edit.php?id=" + id +"']")).click();
	}

	public void submitContactModification() {
		click(By.name("update"));
	}

	public void create(ContactData contact) {
		initContactCreation();
		fillContactForm(contact, true);
		submitContactCreation();
		contactsCache = null;
		returnToHomePage();
	}

	public void modify(ContactData contact) {
		initContactModification(contact.getId());
		fillContactForm(contact, false);
		submitContactModification();
		contactsCache = null;
		returnToHomePage();
	}

	public boolean isThereAContact() {
		return isElementPresent(By.name("selected[]"));
	}

	public boolean isThereAGroupWithContact() {
		int  countElements = wd.findElements(By.xpath("//*[@id=\"content\"]/form/select[5]/option")).size();
		if (countElements >= 2){
			return false;
		}
		return true;
	}


	public void delete(ContactData contact) throws InterruptedException{
		selectContactById(contact.getId());
		submitContactDelete(5);
		contactsCache = null;
	}

	private Contacts contactsCache = null;

	public Contacts all() {
		if (contactsCache != null) {
			return new Contacts(contactsCache);
		}

		contactsCache = new Contacts();
		List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=\"entry\"]"));
		for (WebElement element : elements){
			String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
			String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
			int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
			contactsCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
		}
		return new Contacts(contactsCache);
	}
}

