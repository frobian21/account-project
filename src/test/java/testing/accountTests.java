package testing;

import repo.AccountManager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Account;
import service.Service;

public class accountTests {
	AccountManager accounts;
	
	@Before
	public void init() {
		accounts = new AccountManager();
	}
	@Test
	public void test1() {
		Service.addAccount(accounts.getAccounts(), new Account("name", "surname"));
		Service.addAccount(accounts.getAccounts(), new Account("name", "me"));
		assertEquals("count not 2", 2, Service.countName(accounts.getAccounts(),"name"));
	}	
	@Test
	public void test2() {
		Service.addAccount(accounts.getAccounts(), new Account("name", "surname"));
		assertEquals("count not 1", 1, Service.countName(accounts.getAccounts(),"name"));
	}
	
}
