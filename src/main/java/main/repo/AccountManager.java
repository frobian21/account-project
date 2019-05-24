package main.repo;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import main.domain.Account;
import main.util.JSONUtil;
import main.repo.AccountRepo;

@Alternative
public class AccountManager implements AccountRepo {
	
	private Map<Integer, Account> accMap = new HashMap<>();
	
	private int count;

	@Inject
	private JSONUtil util;

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	private static AccountManager repo = new AccountManager();

	public static AccountManager getInstance() {
		return repo;
	}

	@Override
	public String retrieveAllAccounts() {
		return this.util.toJSON(this.accMap.values());
	}

	@Override
	public String createAccount(String account) {
		this.accMap.put(this.count++, util.fromJSON(account, Account.class));
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	public Account readAccount(int id) {
		return this.accMap.get(id);
	}

	@Override
	public Account updateAccount(Account account) {
		this.accMap.put(account.getAccountNumber(), account);
		return this.accMap.get(account.getAccountNumber());
	}

	@Override
	public String deleteAccount(int id) {
		this.accMap.remove(id);
		return "{\"message\": \"account sucessfully deleted\"}";
	}
}
