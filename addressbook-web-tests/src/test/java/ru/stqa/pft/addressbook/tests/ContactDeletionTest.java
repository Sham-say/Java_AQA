package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.sql.SQLOutput;
import java.util.List;

public class ContactDeletionTest extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.getNavigatorHelper().gotoHomePage();
		if (!app.getContactHelper().isThereAContact()) {
			app.getNavigatorHelper().gotoGroupPage();
			if (!app.getGroupHelper().isThereAGroup()) {
				app.getGroupHelper().createGroup(new GroupData("Test1", "test2", "test3"));
			}
			app.getNavigatorHelper().gotoHomePage();
			app.getContactHelper().createContact(new ContactData("test_first", "test_last", "Hogwars", "test@mail.com", "89876543210", "test1"));
		}
	}

	@Test(enabled = false)
	public void testContactDeletion() throws InterruptedException {
		List<ContactData> before = app.getContactHelper().getContactList();
		app.getContactHelper().selectContact(before.size() - 1);
		app.getContactHelper().submitContactDelete(5);
		List<ContactData> after = app.getContactHelper().getContactList();
		Assert.assertEquals(after.size(), before.size() - 1);

		before.remove(before.size() - 1);
		Assert.assertEquals(before, after);
	}

}