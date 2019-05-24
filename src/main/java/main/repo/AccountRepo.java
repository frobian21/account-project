package main.repo;

import main.domain.Account;

public interface AccountRepo {
	public String retrieveAllAccounts();

	public String createAccount(String account);

	public Account readAccount(int id);

	public Account updateAccount(Account account);

	public String deleteAccount(int id);

}
