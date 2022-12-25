package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
	@Test
	public void testModificationContact() {
		app.getNavigatorHelper().gotoHomePage();
		app.getContactHelper().initContactModification();
		app.getContactHelper().fillContactForm(new ContactData("test_name_mod", "test_last_mod", null, null, null, null), false);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
	}
}
