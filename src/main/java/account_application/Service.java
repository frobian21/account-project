package account_application;

public class Service {
	private int i=1;
	public void addAccount(Account acc) {
		acc.setAccountNumber(i);
		accountManager.accMap.put(i++, acc);
	}
	public Account retrieveAccount(int accNo) {
		return accountManager.accMap.get(accNo);
	}

}
