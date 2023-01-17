package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		app.goTo().homePage();
		if (app.contact().list().size() == 0) {
			app.goTo().groupPage();
			if (app.group().list().size() == 0) {
				app.group().create(new GroupData("Test1", "test2", "test3"));
			}
			app.goTo().homePage();
			app.contact().create(new ContactData("test_first", "test_last", "Hogwars", "test@mail.com", "89876543210", "test1"));
		}
	}

	@Test(enabled = false)
	public void testModificationContact() {
		List<ContactData> before = app.contact().list();
		int index = before.size() - 1;
		ContactData contact = new ContactData(before.get(index).getId(),"test_first_mod", "test_last", null, null, null, null);
		app.contact().modify(index, contact);
		List<ContactData> after = app.contact().list();
		Assert.assertEquals(after.size(), before.size());

		before.remove(index);
		before.add(contact);
		Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
		before.sort(byId);
		after.sort(byId);
		Assert.assertEquals(before, after);
	}
}