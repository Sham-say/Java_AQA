package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

	@Test
public void testContactDeletion() {
		app.getContactHelper().selectContact();
		app.getContactHelper().submitContactDelete();
		System.out.println("contact delete successfully!");
	}
}
