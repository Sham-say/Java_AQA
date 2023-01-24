package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> validContacts() throws IOException {
		//File photo = new File("src/test/resources/stru.png");       //--фото
		List<Object[]> list = new ArrayList<Object[]>();
		BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.csv"));
		String line = reader.readLine();
		while (line != null) {
			String[] split = line.split(";");
			list.add(new Object[] {new ContactData().withLastName(split[0]).withFirstName(split[1]).withAddress(split[2]).withAllPhone(split[3])});
			line = reader.readLine();
		}
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