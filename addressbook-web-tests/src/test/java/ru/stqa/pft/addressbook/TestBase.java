package ru.stqa.pft.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
	//переменные для логина и пароля
	String userLogin = "admin";
	String userPassword = "secret";
	//переменная для имени создаваемой группы
	String groupName = "group Barancev";
	private WebDriver wd;
	private JavascriptExecutor js;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		wd = new FirefoxDriver(new FirefoxOptions().setBinary("C:/Program Files/Mozilla Firefox/firefox.exe"));
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wd.get("http://localhost/addressbook/");
		login(userLogin, userPassword);
	}

	private void login(String username, String password) {
		wd.findElement(By.name("user")).click();
		wd.findElement(By.name("user")).clear();
		wd.findElement(By.name("user")).sendKeys(username);
		wd.findElement(By.name("pass")).clear();
		wd.findElement(By.name("pass")).sendKeys(password);
		wd.findElement(By.xpath("//input[@value='Login']")).click();
	}

	protected void returnToGroupPage() {
		wd.findElement(By.linkText("group page")).click();
	}

	protected void submitGroupCreation() {
		wd.findElement(By.name("submit")).click();
	}

	protected void fillGroupForm(GroupData groupData) {
		wd.findElement(By.name("group_name")).click();
		wd.findElement(By.name("group_name")).clear();
		wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
		wd.findElement(By.name("group_header")).click();
		wd.findElement(By.name("group_header")).clear();
		wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
		wd.findElement(By.name("group_footer")).click();
		wd.findElement(By.name("group_footer")).clear();
		wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
	}

	protected void initGroupCreation() {
		wd.findElement(By.name("new")).click();
	}

	protected void gotoGroupPage() {
		wd.findElement(By.linkText("groups")).click();
	}

	protected void returnToHomePage() {
		wd.findElement(By.linkText("home page")).click();
	}

	protected void submitContactCreation() {
		wd.findElement(By.xpath("//input[21]")).click();
	}

	protected void fillContactForm(ContactData contactData) {
		wd.findElement(By.name("firstname")).click();
		wd.findElement(By.name("firstname")).clear();
		wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
		wd.findElement(By.name("middlename")).click();
		wd.findElement(By.name("middlename")).clear();
		wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
		wd.findElement(By.name("lastname")).click();
		wd.findElement(By.name("lastname")).clear();
		wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
		wd.findElement(By.name("nickname")).click();
		wd.findElement(By.name("nickname")).clear();
		wd.findElement(By.name("nickname")).sendKeys(contactData.getFirstName());
		wd.findElement(By.name("title")).click();
		wd.findElement(By.name("title")).clear();
		wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
		wd.findElement(By.name("company")).click();
		wd.findElement(By.name("company")).clear();
		wd.findElement(By.name("company")).sendKeys(contactData.getCompanyName());
		wd.findElement(By.name("address")).click();
		wd.findElement(By.name("address")).clear();
		wd.findElement(By.name("address")).sendKeys(contactData.getFullAddress());
		wd.findElement(By.name("home")).click();
		wd.findElement(By.name("home")).clear();
		wd.findElement(By.name("home")).sendKeys(contactData.getPhoneNumber());
		wd.findElement(By.name("mobile")).click();
		wd.findElement(By.name("mobile")).clear();
		wd.findElement(By.name("mobile")).sendKeys(contactData.getPhoneNumber());
		wd.findElement(By.name("work")).click();
		wd.findElement(By.name("work")).clear();
		wd.findElement(By.name("work")).sendKeys(contactData.getPhoneNumber());
		wd.findElement(By.name("fax")).click();
		wd.findElement(By.name("fax")).clear();
		wd.findElement(By.name("fax")).sendKeys(contactData.getPhoneNumber());
		wd.findElement(By.name("email")).click();
		wd.findElement(By.name("email")).clear();
		wd.findElement(By.name("email")).sendKeys(contactData.getMailContact());
		wd.findElement(By.name("email2")).click();
		wd.findElement(By.name("email2")).clear();
		wd.findElement(By.name("email2")).sendKeys(contactData.getMailContact());
		wd.findElement(By.name("email3")).click();
		wd.findElement(By.name("email3")).clear();
		wd.findElement(By.name("email3")).sendKeys(contactData.getMailContact());
		wd.findElement(By.name("homepage")).click();
		wd.findElement(By.name("homepage")).clear();
		wd.findElement(By.name("homepage")).sendKeys(contactData.getHomePage());
		wd.findElement(By.name("bday")).click();
		new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getDay());
		wd.findElement(By.name("bmonth")).click();
		new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getMonth());
		wd.findElement(By.name("byear")).click();
		wd.findElement(By.name("byear")).clear();
		wd.findElement(By.name("byear")).sendKeys(contactData.getYear());
		wd.findElement(By.name("aday")).click();
		new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getDay());
		wd.findElement(By.name("amonth")).click();
		new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getMonth());
		wd.findElement(By.name("ayear")).click();
		wd.findElement(By.name("ayear")).clear();
		wd.findElement(By.name("ayear")).sendKeys(contactData.getYear());
		wd.findElement(By.name("new_group")).click();
		new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupName);
		wd.findElement(By.name("address2")).click();
		wd.findElement(By.name("address2")).clear();
		wd.findElement(By.name("address2")).sendKeys(contactData.getFullAddress());
		wd.findElement(By.name("phone2")).click();
		wd.findElement(By.name("phone2")).clear();
		wd.findElement(By.name("phone2")).sendKeys(contactData.getPhoneNumber());
		wd.findElement(By.name("notes")).click();
		wd.findElement(By.name("notes")).clear();
		wd.findElement(By.name("notes")).sendKeys(contactData.getNotesContact());
	}

	protected void gotoAddNewContact() {
		wd.findElement(By.linkText("add new")).click();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		logOut(userLogin, userPassword);
		wd.quit();
	}

	private void logOut(String username, String password) {
		wd.findElement(By.linkText("Logout")).click();
		wd.findElement(By.name("user")).clear();
		wd.findElement(By.name("user")).sendKeys(username);
		wd.findElement(By.name("pass")).clear();
		wd.findElement(By.name("pass")).sendKeys(password);
	}

	private boolean isElementPresent(By by) {
		try {
			wd.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	protected void deleteSelectedGroups() {
		wd.findElement(By.name("delete")).click();
	}

	protected void selectGroup() {
		wd.findElement(By.name("selected[]")).click();
	}
}
