package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() {
		app.getNavigatorHelper().gotoHomePage();
		app.getContactHelper().initContactCreation();
		app.getContactHelper().fillContactForm(new ContactData("test_name", "test_midd", "test1"),
						true);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
	}
}
