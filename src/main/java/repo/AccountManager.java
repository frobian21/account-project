package repo;

import java.util.HashMap;
import java.util.Map;

import domain.Account;

public class AccountManager {
	private Map<Integer, Account> accMap = new HashMap<>();

	public Map<Integer, Account> getAccounts() {
		return accMap;
	}
}
