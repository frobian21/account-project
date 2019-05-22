package domain;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountNumber;
	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastName;

	public Account() {
	}

	public Account(String firstName, String surname) {
		this.firstName = firstName;
		lastName = surname;
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
