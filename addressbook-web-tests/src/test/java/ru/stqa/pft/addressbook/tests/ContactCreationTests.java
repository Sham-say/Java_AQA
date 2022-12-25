package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() {
		app.getNavigatorHelper().gotoHomePage();
		app.getContactHelper().createContact(new ContactData("test_first", "test_last", "Hogwars", "test@mail.com", "89876543210", "test1"),true);
	}
}
