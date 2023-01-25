package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
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
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> validContactsFromXml() throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
			String xml = "";
			String line = reader.readLine();
			while (line != null) {
				xml += line;
				line = reader.readLine();
			}
			XStream xStream = new XStream();
			xStream.processAnnotations(ContactData.class);
			xStream.allowTypes(new Class[]{ContactData.class});
			List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
			return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
		}
	}

	@Test(dataProvider = "validContactsFromXml")//(enabled = false)
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