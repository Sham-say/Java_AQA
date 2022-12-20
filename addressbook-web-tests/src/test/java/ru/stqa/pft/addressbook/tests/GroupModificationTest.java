package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase{
	@Test
public void testGroupModification()	{
		app.getNavigatorHelper().gotoGroupPage();
		app.getGroupHelper().selectGroup();
		app.getGroupHelper().initGroupModification();
		app.getGroupHelper().fillGroupForm(new GroupData(app.getGroupHelper().groupName, "test2", "test3"));
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();
	}
}
