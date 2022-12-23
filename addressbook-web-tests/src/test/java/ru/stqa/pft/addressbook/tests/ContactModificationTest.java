package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
	@Test
	public void testModificationContact() {
		app.getContactHelper().submitContactEdit();
		app.getContactHelper().fillContactForm(new ContactData("ShamilM", "SayakhovM", "Fagimovich", "test1", "companys", "Hogvarts",
						"123456789", "Test@mail.ru", "www.home.ru", "14", "June", "1996", "kek", null), false);
		app.getContactHelper().submitContactUpdate();
		app.getContactHelper().returnToHomePage();
		System.out.println("contact update successfully!");
	}
}
