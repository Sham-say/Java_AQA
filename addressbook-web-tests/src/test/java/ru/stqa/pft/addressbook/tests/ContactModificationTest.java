package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {
	@Test
	public void testModificationContact() {
		app.getNavigatorHelper().gotoHomePage();

		if (!app.getContactHelper().isThereAContact()) {
			app.getNavigatorHelper().gotoGroupPage();
			if (!app.getGroupHelper().isThereAGroup()) {
				app.getGroupHelper().createGroup(new GroupData("Test1", "test2", "test3"));
			}
			app.getNavigatorHelper().gotoHomePage();
			app.getContactHelper().createContact(new ContactData("test_first", "test_last", "Hogwars", "test@mail.com", "89876543210", "test1"));
		}
		List<ContactData> before = app.getContactHelper().getContactList();
		app.getContactHelper().initContactModification(before.size() - 1);
		ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"test_first_mod", "test_last", null, null, null, null);
		app.getContactHelper().fillContactForm(contact, false);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		List<ContactData> after = app.getContactHelper().getContactList();
		Assert.assertEquals(after.size(), before.size());

		before.remove(before.size()-1);
		before.add(contact);
		Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
		before.sort(byId);
		after.sort(byId);
		Assert.assertEquals(before, after);
	}
}