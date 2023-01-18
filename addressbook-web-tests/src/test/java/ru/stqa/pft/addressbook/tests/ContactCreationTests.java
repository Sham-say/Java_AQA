package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.Set;

public class ContactCreationTests extends TestBase {



	@Test//(enabled = false)
	public void addContact(){
		app.goTo().homePage();
		Set<ContactData> before = app.contact().all();
		app.contact().initContactCreation();
		if (app.contact().isThereAGroupWithContact()) {
			app.goTo().groupPage();
			app.group().create(new GroupData().withName("test2"));
		}
		ContactData contact = new ContactData()
				.withFirstName("test_first").withLastName("test_last").withAddress("Hogwars").withEmail("test@mail.com").withHome("89876543210").withGroup("test2");
		app.contact().create(contact);
		Set<ContactData> after = app.contact().all();
		Assert.assertEquals(after.size(), before.size() + 1);

		contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt());
		before.add(contact);
		Assert.assertEquals(before, after);
	}
}