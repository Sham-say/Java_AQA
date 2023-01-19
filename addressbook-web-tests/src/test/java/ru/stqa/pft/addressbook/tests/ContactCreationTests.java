package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {



	@Test//(enabled = false)
	public void addContact(){
		app.goTo().homePage();
		Contacts before = app.contact().all();
		app.contact().initContactCreation();
		if (app.contact().isThereAGroupWithContact()) {
			app.goTo().groupPage();
			app.group().create(new GroupData().withName("test2"));
		}
		ContactData contact = new ContactData()
				.withFirstName("test_first").withLastName("test_last").withAddress("Hogwars").withEmail("test@mail.com").withHome("89876543210").withGroup("test2");
		app.contact().create(contact);
		Contacts after = app.contact().all();
		assertThat(after.size(), equalTo(before.size() + 1));

		;
		assertThat(after, equalTo(before.withAdded(
				contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt()))));
	}
}