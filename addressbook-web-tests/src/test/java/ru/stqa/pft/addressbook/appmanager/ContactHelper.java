package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;


public class ContactHelper extends HelperBase {
	public ContactHelper(WebDriver wd) {super(wd);}

	public void initContactCreation() { click(By.linkText("add new"));}

	public void fillContactForm(ContactData contactData, boolean creation) {

		type(By.name("firstname"), contactData.getFirstName());
		type(By.name("lastname"), contactData.getLastName());
		type(By.name("address"), contactData.getAddress());
		type(By.name("email"), contactData.getEmail());
		type(By.name("home"), contactData.getHomePhone());
		attach(By.name("photo"), contactData.getPhoto());

		if (creation) {
			if (contactData.getGroups().size() > 0) {
				Assert.assertTrue(contactData.getGroups().size() == 1);
				new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
			}
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

	public int count() {
		return wd.findElements(By.name("selected[]")).size();
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
		List<WebElement> rows = wd.findElements(By.name("entry"));
		for (WebElement row : rows){
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String lastName = cells.get(1).getText();
			String firstName = cells.get(2).getText();
			String allPhones = cells.get(5).getText();
			String allEmails = cells.get(4).getText();
			String address = cells.get(3).getText();
			int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("id"));
			contactsCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
					.withAllPhone(allPhones).withAddress(address).withAllEmail(allEmails));
		}
		return new Contacts(contactsCache);
	}

	public ContactData infoFromEditForm(ContactData contact) {
		initContactModificationById(contact.getId());
		String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
		String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
		String home = wd.findElement(By.name("home")).getAttribute("value");
		String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
		String work = wd.findElement(By.name("work")).getAttribute("value");
		String email = wd.findElement(By.name("email")).getAttribute("value");
		String email2 = wd.findElement(By.name("email2")).getAttribute("value");
		String email3 = wd.findElement(By.name("email3")).getAttribute("value");
		String address = wd.findElement(By.name("address")).getAttribute("value");
		wd.navigate().back();
		return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
				.withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
				.withEmail(email).withEmail2(email2).withEmail3(email3)
				.withAddress(address);
	}

	private void initContactModificationById(int id) {
		wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
	}
}

