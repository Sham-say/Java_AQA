package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase{
	@Test
public void testGroupModification()	{
		app.getNavigatorHelper().gotoGroupPage();
		int before = app.getGroupHelper().getGroupCont();
		if (!app.getGroupHelper().isThereAGroup()) {
			app.getGroupHelper().createGroup(new GroupData("test1", "logo", "comment"));
		}
		app.getGroupHelper().selectGroup(before - 1);
		app.getGroupHelper().initGroupModification();
		app.getGroupHelper().fillGroupForm(new GroupData("new_test1", null, null));
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();
		int after = app.getGroupHelper().getGroupCont();
		Assert.assertEquals(after, before);
	}
}



//app.getGroupHelper().groupName