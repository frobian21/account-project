package main;

import domain.Account;
import repo.AccountManager;
import service.Service;

public class App {
	public static void main(String[] args) {
		AccountManager accounts = new AccountManager();
		System.out.println("Hello my friends to the standard out");
		Service.addAccount(accounts.getAccounts(), new Account("firstName", "surname"));
		Service.convertMap(accounts.getAccounts());
	}
}
