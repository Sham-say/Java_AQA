package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

	@Test
	public void testGroupCreation()  {
		app.getNavigatorHelper().gotoGroupPage();
		app.getGroupHelper().initGroupCreation();
		app.getGroupHelper().fillGroupForm(new GroupData(app.getGroupHelper().groupName, "test2", "test3"));
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupPage();
		System.out.println("group added successfully!");
	}

}

