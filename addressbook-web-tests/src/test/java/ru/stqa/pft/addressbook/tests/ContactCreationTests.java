package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {


	@Test
	public void addContact(){
		app.getNavigatorHelper().gotoHomePage();
		int before = app.getContactHelper().getContactCont();
		app.getContactHelper().initContactCreation();
		if (app.getContactHelper().isThereAGroupWithContact()) {
			app.getNavigatorHelper().gotoGroupPage();
			app.getGroupHelper().createGroup(new GroupData("test2", null, null));
		}
		app.getContactHelper().createContact(new ContactData("test_firstnew", "test_last", "Hogwars", "test@mail.com", "89876543210", "test568"));
		int after = app.getContactHelper().getContactCont();
		Assert.assertEquals(after, before + 1);
	}
}