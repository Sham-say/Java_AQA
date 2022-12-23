package ru.stqa.pft.addressbook.model;

public class ContactData {
	private final String firstName;
	private final String middleName;

	private String group;

	public ContactData(String firstName, String middleName, String group) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.group = group;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getGroup() {
		return group;
	}
}