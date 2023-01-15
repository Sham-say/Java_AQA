package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


	@Test
	public void addContact(){
		app.getNavigatorHelper().gotoHomePage();
		List<ContactData> before = app.getContactHelper().getContactList();
		app.getContactHelper().initContactCreation();
		if (app.getContactHelper().isThereAGroupWithContact()) {
			app.getNavigatorHelper().gotoGroupPage();
			app.getGroupHelper().createGroup(new GroupData("test2", null, null));
		}
		ContactData contact = new ContactData("test_first", "test_last", "Hogwars", "test@mail.com", "89876543210", "test2");
		app.getContactHelper().createContact(contact);
		List<ContactData> after = app.getContactHelper().getContactList();
		Assert.assertEquals(after.size(), before.size() + 1);

		int max = 0;
		for (ContactData c : after) {
			if (c.getId() > max) {
				max = c.getId();
			}
		}
		contact.setId(max);
		before.add(contact);
		Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
	}
}