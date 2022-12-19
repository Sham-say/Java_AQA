package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class NewContactTests extends TestBase {

	@Test
	public void addContact() throws Exception{
		gotoAddNewContact();
		fillContactForm(new ContactData("Shamil", "Sayakhov", "Fagimovich", "test1", "companys", "Hogvarts", "123456789", "Test@mail.ru", "www.home.ru", "14", "June", "1996", "kek"));
		submitContactCreation();
		returnToHomePage();
		System.out.println("contact added successfully!");
	}
}
