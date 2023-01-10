package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {


	@Test
	public void testGroupDeletion() {
		app.getNavigatorHelper().gotoGroupPage();
		int before = app.getGroupHelper().getGroupCont();
		if (! app.getGroupHelper().isThereAGroup()) {
			app.getGroupHelper().createGroup(new GroupData("test1", "logo", "comment"));
		}
		app.getGroupHelper().selectGroup(before - 1);
		app.getGroupHelper().deleteSelectedGroups();
		app.getGroupHelper().returnToGroupPage();
		int after = app.getGroupHelper().getGroupCont();
		Assert.assertEquals(after, before - 1);

	}
}
