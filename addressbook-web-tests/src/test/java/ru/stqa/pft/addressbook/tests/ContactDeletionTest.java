package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

	@Test
public void testContactDeletion() {
		if (! app.getContactHelper().isThereAContact()) {
			app.getContactHelper().createContact(new ContactData("test_first", "test_last", "Hogwars", "test@mail.com", "89876543210", "test1"),true);
		}
		app.getContactHelper().selectContact();
		app.getContactHelper().submitContactDelete();
	}
}
