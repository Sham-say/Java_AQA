package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> validContacts() {
		File photo = new File("src/test/resources/stru.png");
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[] {new ContactData().withFirstName("FirstName 1").withLastName("LastName 1").withAddress("Hogwars 1").withEmail("test1@mail.com").withHomePhone("89876543211").withPhoto(photo)});
		list.add(new Object[] {new ContactData().withFirstName("FirstName 2").withLastName("LastName 2").withAddress("Hogwars 2").withEmail("test2@mail.com").withHomePhone("89876543212").withPhoto(photo)});
		list.add(new Object[] {new ContactData().withFirstName("FirstName 3").withLastName("LastName 3").withAddress("Hogwars 3").withEmail("test3@mail.com").withHomePhone("89876543213").withPhoto(photo)});
		return list.iterator();
	}
	@Test(dataProvider = "validContacts")//(enabled = false)
	public void addContact(ContactData contact){
		app.goTo().homePage();
		Contacts before = app.contact().all();
		app.contact().initContactCreation();
		if (app.contact().isThereAGroupWithContact()) {
			app.goTo().groupPage();
			app.group().create(new GroupData().withName("test2"));
		}
		app.contact().create(contact);
		assertThat(app.contact().count(), equalTo(before.size() + 1));
		Contacts after = app.contact().all();
		assertThat(after, equalTo(before.withAdded(
				contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt()))));
	}
}