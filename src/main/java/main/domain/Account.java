package main.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastName;
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountNumber;

	public Account() {

	}

	public Account(String firstName, String lastName) {
		setFirstName(firstName);
		setFirstName(lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setFirstName(String name) {
		firstName = name;
	}

	public void setLastName(String name) {
		lastName = name;
	}

	public void setAccountNumber(int number) {
		accountNumber = number;
	}

}
