package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.sql.SQLOutput;
import java.util.List;

public class ContactDeletionTest extends TestBase {


	@Test
	public void testContactDeletion() throws InterruptedException {
		app.getNavigatorHelper().gotoHomePage();
		if(!app.getContactHelper().isThereAContact()){
			app.getNavigatorHelper().gotoGroupPage();
			if(!app.getGroupHelper().isThereAGroup()){
				app.getGroupHelper().createGroup(new GroupData("test1", "logo", "comment"));
			}
			app.getNavigatorHelper().gotoHomePage();
			app.getContactHelper().createContact(new ContactData("test_first", "test_last", "Hogwars", "test@mail.com", "89876543210", "test555"));
		}
		List<ContactData> before = app.getContactHelper().getContactList();
		app.getContactHelper().selectContact();
		app.getContactHelper().submitContactDelete(5);
		List<ContactData> after = app.getContactHelper().getContactList();
		Assert.assertEquals(after.size(), before.size() - 1);
	}
}