package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
	@Test
	public void testModificationContact() {
		app.getNavigatorHelper().gotoHomePage();
		if (! app.getContactHelper().isThereAContact()) {
			app.getContactHelper().createContact(new ContactData("test_first", "test_last", "Hogwars", "test@mail.com", "89876543210", "test1"),true);
		}
		app.getContactHelper().initContactModification();
		app.getContactHelper().fillContactForm(new ContactData("test_first_mod", "test_last_mod", null, null, null, null), false);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
	}
}
