package main.service;

import javax.inject.Inject;

import main.domain.Account;
import main.repo.AccountRepo;
import main.util.JSONUtil;

public class Service {
	@Inject
	JSONUtil json;

	@Inject
	AccountRepo repo;

	public Service() {

	}

	public void setJson(JSONUtil json) {
		this.json = json;
	}

	public void setRepo(AccountRepo repo) {
		this.repo = repo;
	}

	public String addAccount(String acc) {
		return repo.createAccount(acc);
	}

	public String retrieveAccount(int accNo) {
		return json.toJSON(this.repo.readAccount(accNo));
	}
	public String retrieveAllAccounts() {
		return repo.retrieveAllAccounts();
	}
	public String deleteAccount(int id) {
		return repo.deleteAccount(id);
	}
	public String updateAccount(String account) {
		return json.toJSON(repo.updateAccount(json.fromJSON(account, Account.class)));
	}
}
