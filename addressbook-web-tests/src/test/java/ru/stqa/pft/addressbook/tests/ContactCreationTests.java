package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;

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
		File photo = new File("src/test/resources/stru.png");
		ContactData contact = new ContactData()
				.withFirstName("test_first").withLastName("test_last").withAddress("Hogwars").withEmail("test@mail.com").withHomePhone("89876543210").withPhoto(photo);
		app.contact().create(contact);
		assertThat(app.group().count(), equalTo(before.size() + 1));
		Contacts after = app.contact().all();
		assertThat(after, equalTo(before.withAdded(
				contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt()))));
	}
}