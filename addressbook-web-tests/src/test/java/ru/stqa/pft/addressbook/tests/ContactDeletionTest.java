package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTest extends TestBase {

//	@Test
//public void testContactDeletion() {
//		if (! app.getContactHelper().isThereAContact()) {
//			app.getContactHelper().createContact(new ContactData("test_first", "test_last", "Hogwars", "test@mail.com", "89876543210", "test1"));
//		}
//		app.getContactHelper().selectContact();
//		app.getContactHelper().submitContactDelete();
//	}
//}

	@Test
	public void testContactDeletion(){
		app.getNavigatorHelper().gotoHomePage();
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
	}
}