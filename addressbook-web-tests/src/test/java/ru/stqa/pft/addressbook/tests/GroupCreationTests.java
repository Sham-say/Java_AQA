package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

	@Test
	public void testGroupCreation()  {
		app.getNavigatorHelper().gotoGroupPage();
		List<GroupData> before = app.getGroupHelper().getGroupList();
		app.getGroupHelper().createGroup(new GroupData("test1", "logo", "comment"));
		List<GroupData> after = app.getGroupHelper().getGroupList();
		Assert.assertEquals(after.size(), before.size() + 1);
	}

}

//app.getGroupHelper().groupName