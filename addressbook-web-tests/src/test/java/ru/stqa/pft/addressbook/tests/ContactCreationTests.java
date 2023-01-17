package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


	@Test(enabled = false)
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

		before.add(contact);
		Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
		before.sort(byId);
		after.sort(byId);
		Assert.assertEquals(before, after);
	}
}