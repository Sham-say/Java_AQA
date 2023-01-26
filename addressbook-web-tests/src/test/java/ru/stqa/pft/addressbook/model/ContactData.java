package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contacts")
@Entity
@Table(name = "addressbook")
public class ContactData {
	@XStreamOmitField
	@Id
	@Column(name = "id")
	private int id = Integer.MAX_VALUE;
	@Expose
	@Column(name = "firstname")
	private String firstName;
	@Expose
	@Column(name = "lastname")
	private String lastName;
	@Expose
	@Column(name = "address")
	@Type(type = "text")
	private String address;
	@Column(name = "email")
	@Type(type = "text")
	private String email;
	@Column(name = "email2")
	@Type(type = "text")
	private String email2;
	@Column(name = "email3")
	@Type(type = "text")
	private String email3;
	@Transient
	private String allEmail;
	@Column(name = "home")
	@Type(type = "text")
	private String homePhone;
	@Column(name = "mobile")
	@Type(type = "text")
	private String mobilePhone;
	@Column(name = "work")
	@Type(type = "text")
	private String workPhone;
	@Expose
	@Transient
	private String allPhone;
	@Column(name = "photo")
	@Type(type = "text")
	private String photo;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "address_in_groups",
			joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
	private Set<GroupData> groups = new HashSet<GroupData>();
	public File getPhoto() {
		if (photo != null) {
			return new File(photo);
		} else {
			return null;
		}
	}

	public ContactData withPhoto(File photo) {
		this.photo = photo.getPath();
		return this;
	}


	public ContactData withId(int id) {
		this.id = id;
		return this;
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}
	public ContactData withEmail3(String email3) {
		this.email3 = email3;
		return this;
	}
	public ContactData withAllEmail(String allEmail) {
		this.allEmail = allEmail;
		return this;
	}
	public ContactData withHomePhone(String home) {
		this.homePhone = home;
		return this;
	}

	public ContactData withMobilePhone(String mobile) {
		this.mobilePhone = mobile;
		return this;
	}

	public ContactData withWorkPhone(String work) {
		this.workPhone = work;
		return this;
	}
	public ContactData withAllPhone(String allPhone) {
		this.allPhone = allPhone;
		return this;
	}
	public ContactData inGroup(GroupData group) {
		groups.add(group);
		return this;
	}

	public int getId() {return id;}

	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getAddress() {return address;}
	public String getEmail() {return email;}
	public String getEmail2() {return email2;}
	public String getEmail3() {return email3;}
	public String getAllEmail() {return allEmail;}
	public String getHomePhone() {return homePhone;}
	public String getMobilePhone() {return mobilePhone;}
	public String getWorkPhone() {return workPhone;}
	public String getAllPhone() {return allPhone;}
	public Groups getGroups() {
		return new Groups(groups);
	}


	@Override
	public String toString() {
		return "ContactData{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", address='" + address + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ContactData that = (ContactData) o;
		if (id != that.id) return false;
		if (!Objects.equals(firstName, that.firstName)) return false;
		return Objects.equals(lastName, that.lastName);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		return result;
	}

}