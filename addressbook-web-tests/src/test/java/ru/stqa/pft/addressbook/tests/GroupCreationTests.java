package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

	@Test
	public void testGroupCreation()  {
		app.getNavigatorHelper().gotoGroupPage();
		app.getGroupHelper().initGroupCreation();
		app.getGroupHelper().fillGroupForm(new GroupData("Tes5", null, null));
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupPage();
		System.out.println("group added successfully!");
	}

}

//app.getGroupHelper().groupName