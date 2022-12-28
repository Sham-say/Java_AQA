package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() {
		app.getNavigatorHelper().gotoHomePage();
		app.getContactHelper().initContactCreation();
		if (app.getContactHelper().isThereAGroupWithContact()) {
			app.getNavigatorHelper().gotoGroupPage();
			app.getGroupHelper().createGroup(new GroupData("test1", "logo", "comment"));
			app.getContactHelper().initContactCreation();
		}
		app.getContactHelper().createContact(new ContactData("test_firstnew", "test_last", "Hogwars", "test@mail.com", "89876543210", "test180"),true);

	}
}
