package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTo().homePage();
		if (app.contact().list().size() == 0) {
			app.goTo().groupPage();
			if (app.group().list().size() == 0) {
				app.group().create(new GroupData("Test1", "test2", "test3"));
			}
			app.goTo().homePage();
			app.contact().create(new ContactData("test_first", "test_last", "Hogwars", "test@mail.com", "89876543210", "test1"));
		}
	}

	@Test(enabled = false)
	public void testContactDeletion() throws InterruptedException {
		List<ContactData> before = app.contact().list();
		int index = before.size() - 1;
		app.contact().selectContact(index);
		app.contact().submitContactDelete(6);
		List<ContactData> after = app.contact().list();
		Assert.assertEquals(after.size(), before.size() - 1);

		before.remove(index);
		Assert.assertEquals(before, after);
	}

}