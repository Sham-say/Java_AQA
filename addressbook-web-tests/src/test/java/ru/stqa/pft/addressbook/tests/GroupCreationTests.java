package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

	@Test
	public void testGroupCreation()  {
		app.getNavigatorHelper().gotoGroupPage();
		int before = app.getGroupHelper().getGroupCont();
		app.getGroupHelper().createGroup(new GroupData("test1", "logo", "comment"));
		int after = app.getGroupHelper().getGroupCont();
		Assert.assertEquals(after, before + 1);
	}

}

//app.getGroupHelper().groupName