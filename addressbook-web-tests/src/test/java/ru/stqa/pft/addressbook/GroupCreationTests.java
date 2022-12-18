package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

	@Test (priority = 0) //приоритет выполнения теста
	public void testGroupCreation()  {
		gotoGroupPage();
		initGroupCreation();
		fillGroupForm(new GroupData(groupName, "test2", "test3"));
		submitGroupCreation();
		returnToGroupPage();
		System.out.println("group added successfully!");
	}

	@Test(priority = 1)
	public void addContact() throws Exception{
		gotoAddNewContact();
		fillContactForm(new ContactData("Shamil", "Sayakhov", "Fagimovich", "test1", "companys", "Hogvarts", "123456789", "Test@mail.ru", "www.home.ru", "14", "June", "1996", "kek"));
		submitContactCreation();
		returnToHomePage();
		System.out.println("contact added successfully!");
	}

}

