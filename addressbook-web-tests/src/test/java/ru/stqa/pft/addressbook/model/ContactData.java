package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

	private final String id;
	private final String firstName;


	private String lastName;
	private String address;
	private String email;
	private String home;
	private String group;

	public ContactData(String id, String firstName, String lastName,String address, String email, String home, String group) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.home = home;
		this.group = group;
	}

	public ContactData(String firstName, String lastName,String address, String email, String home, String group) {
		this.id = null;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.home = home;
		this.group = group;
	}

	public String getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ContactData that = (ContactData) o;

		if (!Objects.equals(id, that.id)) return false;
		if (!Objects.equals(firstName, that.firstName)) return false;
		return Objects.equals(lastName, that.lastName);
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ContactData{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
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