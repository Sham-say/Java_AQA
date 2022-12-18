package ru.stqa.pft.addressbook;

public class ContactData {
	private final String firstName;
	private final String middleName;
	private final String lastName;
	private final String title;
	private final String companyName;
	private final String fullAddress;
	private final String phoneNumber;
	private final String mailContact;
	private final String homePage;
	private final String day;
	private final String month;
	private final String year;
	private final String notesContact;

	public ContactData(String firstName, String middleName, String lastName, String title, String companyName, String fullAddress, String phoneNumber, String mailContact, String homePage, String day, String month, String year, String notesContact) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.title = title;
		this.companyName = companyName;
		this.fullAddress = fullAddress;
		this.phoneNumber = phoneNumber;
		this.mailContact = mailContact;
		this.homePage = homePage;
		this.day = day;
		this.month = month;
		this.year = year;
		this.notesContact = notesContact;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getTitle() {
		return title;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getMailContact() {
		return mailContact;
	}

	public String getHomePage() {
		return homePage;
	}

	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public String getNotesContact() {
		return notesContact;
	}
}