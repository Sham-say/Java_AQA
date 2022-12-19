package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

	@Test
	public void testGroupCreation()  {
		app.gotoGroupPage();
		app.initGroupCreation();
		app.fillGroupForm(new GroupData(app.groupName, "test2", "test3"));
		app.submitGroupCreation();
		app.returnToGroupPage();
		System.out.println("group added successfully!");
	}

}

