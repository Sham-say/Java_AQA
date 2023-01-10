package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTest extends TestBase {


	@Test
	public void testContactDeletion() throws InterruptedException {
		app.getNavigatorHelper().gotoHomePage();
		int before = app.getContactHelper().getContactCont();
		if(!app.getContactHelper().isThereAContact()){
			app.getNavigatorHelper().gotoGroupPage();
			if(!app.getGroupHelper().isThereAGroup()){
				app.getGroupHelper().createGroup(new GroupData("test1", "logo", "comment"));
			}
			app.getNavigatorHelper().gotoHomePage();
			app.getContactHelper().createContact(new ContactData("test_first", "test_last", "Hogwars", "test@mail.com", "89876543210", "test555"));
		}
		app.getContactHelper().selectContact();
		app.getContactHelper().submitContactDelete();
		Thread.sleep(5000);
		int after = app.getContactHelper().getContactCont();
		Assert.assertEquals(after, before - 1);
	}
}