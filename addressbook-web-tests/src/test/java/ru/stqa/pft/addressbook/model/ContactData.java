package ru.stqa.pft.addressbook.model;

public class ContactData {
	private final String firstName;

	private String lastName;
	private String address;
	private String email;
	private String home;
	private String group;

	public ContactData(String firstName, String lastName,String address, String email, String home, String group) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.home = home;
		this.group = group;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getHome() {
		return home;
	}

	public String getGroup() {
		return group;
	}
}