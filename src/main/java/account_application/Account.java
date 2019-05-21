package account_application;

public class Account {
	private String firstName;
	private String lastName;
	private int accountNumber;
	
	public Account() {;
	}
	public Account(String firstName, String surname) {
		this.firstName=firstName;
		lastName=surname;
	}
	
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public int getAccountNumber(){
		return accountNumber;
	}
	public void setFirstName(String name){
		firstName=name;
	}
	public void setLastName(String name){
		lastName=name;
	}
	public void setAccountNumber(int number){
		accountNumber=number;
	}
	
}
