package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTest extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTo().homePage();
		if (app.contact().all().size() == 0) {
			app.goTo().groupPage();
			if (app.group().all().size() == 0) {
				app.group().create(new GroupData().withName("Test1"));
			}
			app.goTo().homePage();
			app.contact().create(new ContactData()
					.withFirstName("test_first").withLastName("test_last").withAddress("Hogwars").withEmail("test@mail.com").withHome("89876543210").withGroup("Test1"));
		}
	}

	@Test//(enabled = false)
	public void testContactDeletion() throws InterruptedException {
		Set<ContactData> before = app.contact().all();
		ContactData deletedContact = before.iterator().next();
		app.contact().delete(deletedContact);
		Set<ContactData> after = app.contact().all();
		Assert.assertEquals(after.size(), before.size() - 1);

		before.remove(deletedContact);
		Assert.assertEquals(before, after);
	}

}