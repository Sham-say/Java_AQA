package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class NewContactTests extends TestBase {

	@Test
	public void addContact() throws Exception{
		app.getNavigatorHelper().gotoAddNewContact();
		app.getContactGroup().fillContactForm(new ContactData("Shamil", "Sayakhov", "Fagimovich", "test1", "companys", "Hogvarts", "123456789", "Test@mail.ru", "www.home.ru", "14", "June", "1996", "kek"));
		app.getContactGroup().submitContactCreation();
		app.getContactGroup().returnToHomePage();
		System.out.println("contact added successfully!");
	}
}
