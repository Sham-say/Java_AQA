package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactModificationTest extends TestBase {
	@Test
	public void testModificationContact() {
		app.getNavigatorHelper().gotoHomePage();
		List<ContactData> before = app.getContactHelper().getContactList();
		if (!app.getContactHelper().isThereAContact()) {
			app.getNavigatorHelper().gotoGroupPage();
			if (!app.getGroupHelper().isThereAGroup()) {
				app.getGroupHelper().createGroup(new GroupData("Test1", "test2", "test3"));
			}
			app.getNavigatorHelper().gotoHomePage();
			app.getContactHelper().createContact(new ContactData("test_first", "test_last", "Hogwars", "test@mail.com", "89876543210", "test1"));
		}
		app.getContactHelper().initContactModification();
		app.getContactHelper().fillContactForm(new ContactData("test_first_mod", "test_last_mod", null, null, null, null), false);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		List<ContactData> after = app.getContactHelper().getContactList();
		Assert.assertEquals(after.size(), before.size());
	}
}