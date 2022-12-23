package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
	@Test
	public void testModificationContact() {
		app.getNavigatorHelper().gotoHomePage();
		app.getContactHelper().initContactModification();
		app.getContactHelper().fillContactForm(new ContactData("test_name", "test_midd", null), false);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
	}
}
