package main.repo;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import main.domain.Account;
import main.util.JSONUtil;

@Transactional(SUPPORTS)
public class AccountRepoDB implements AccountRepo {

	@Inject
	private JSONUtil util;

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String retrieveAllAccounts() {
		TypedQuery<Account> query = manager.createQuery("SELECT m FROM Accounts m ORDER BY m.accountnumber DESC",
				Account.class);
		Collection<Account> accounts = query.getResultList();
		return util.toJSON(accounts);
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account anAccount = util.fromJSON(account, Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"movie has been sucessfully added\"}";
	}

	@Override
	public Account readAccount(int id) {
		return manager.find(Account.class, id);
	}

	@Override
	@Transactional(REQUIRED)
	public Account updateAccount(int id, Account account) {
		if (manager.contains(manager.find(Account.class, id))) {
			manager.remove(manager.find(Account.class, id));
			manager.persist(account);
//			manager.refresh(manager.find(Account.class, id));
		}
		return manager.find(Account.class, id);
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(int id) {
		if (manager.contains(manager.find(Account.class, id))) {

			manager.remove(manager.find(Account.class, id));
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

}
