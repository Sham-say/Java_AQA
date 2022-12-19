package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

	@Test
	public void testGroupCreation()  {
		gotoGroupPage();
		initGroupCreation();
		fillGroupForm(new GroupData(groupName, "test2", "test3"));
		submitGroupCreation();
		returnToGroupPage();
		System.out.println("group added successfully!");
	}

}

