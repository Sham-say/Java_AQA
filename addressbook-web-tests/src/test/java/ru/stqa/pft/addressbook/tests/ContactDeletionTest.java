package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTo().homePage();
		if (app.db().contacts().size() == 0) {
			app.goTo().groupPage();
			if (app.db().groups().size() == 0) {
				app.group().create(new GroupData().withName("Test1"));
			}
			app.goTo().homePage();
			app.contact().create(new ContactData()
					.withFirstName("test_first").withLastName("test_last").withAddress("Hogwars").withEmail("test@mail.com").withHomePhone("89876543210").withGroup("Test1"));
		}
	}

	@Test//(enabled = false)
	public void testContactDeletion() throws InterruptedException {
		Contacts before = app.db().contacts();
		ContactData deletedContact = before.iterator().next();
		app.contact().delete(deletedContact);
		assertThat(app.group().count(), equalTo(before.size() - 1));
		Contacts after = app.db().contacts();
		assertThat(after, equalTo(before.without(deletedContact)));
		verifyContactListInUI();
	}

}