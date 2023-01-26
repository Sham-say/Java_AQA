package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {


	@BeforeMethod
	public void unsurePreconditions() {
		app.goTo().homePage();
		if (app.contact().all().size() == 0) {
			Groups groups=app.db().groups();
			app.contact().create(new ContactData().withLastName("Petrov").withFirstName("Petr")
					.withAddress("Street 5").withEmail("petrov@mail.ru")
					.withMobilePhone("+79521458745").inGroup(groups.iterator().next()));
		}
	}

	@Test//(enabled = false)
	public void testContactPhones() {
		ContactData contact = app.contact().all().iterator().next();
		ContactData contactInfoFormEditForm = app.contact().infoFromEditForm(contact);

		assertThat(contact.getAddress(), equalTo(contactInfoFormEditForm.getAddress()));
		assertThat(contact.getAllPhone(), equalTo(mergePhones(contactInfoFormEditForm)));
		assertThat(contact.getAllEmail(), equalTo(mergeEmail(contactInfoFormEditForm)));

	}

	private String mergeEmail(ContactData contact) {
		return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
				.stream().filter((s) -> !s.equals(""))
				.collect(Collectors.joining("\n"));

	}

	private String mergePhones(ContactData contact) {
		return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
				.stream().filter((s) -> ! s.equals(""))
				.map(ContactPhoneTests::cleaned)
				.collect(Collectors.joining("\n"));
	}

	public static String cleaned(String phone) {
		return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
	}

}
