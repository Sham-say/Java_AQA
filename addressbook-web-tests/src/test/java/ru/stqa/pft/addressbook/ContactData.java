package ru.stqa.pft.addressbook;

public class ContactData {
	private final String familia;
	private final String name;
	private final String adress;
	private final String number1;
	private final String number2;
	private final String number3;
	private final String email;

	public ContactData(String familia, String Name, String adress, String number1, String number2, String number3, String email) {
		this.familia = familia;
		name = Name;
		this.adress = adress;
		this.number1 = number1;
		this.number2 = number2;
		this.number3 = number3;
		this.email = email;
	}

	public String getFamilia() {
		return familia;
	}

	public String getName() {
		return name;
	}

	public String getAdress() {
		return adress;
	}

	public String getNumber1() {
		return number1;
	}

	public String getNumber2() {
		return number2;
	}

	public String getNumber3() {
		return number3;
	}

	public String getEmail() {
		return email;
	}
}
