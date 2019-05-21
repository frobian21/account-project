package service;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Account;

public class Service {
	private static int accountNumber=0;
	public static void addAccount(Map<Integer, Account> accMap, Account acc) {
		acc.setAccountNumber(++accountNumber);
		accMap.put(accountNumber, acc);
	}
	public static Account retrieveAccount(Map<Integer, Account> accMap, int accNo) {
		return accMap.get(accNo);
	}
	public static void convertMap(Map<Integer, Account> accMap) {
    ObjectMapper mapper = new ObjectMapper();
    try {
    	System.out.println(mapper.writeValueAsString(accMap));
    	mapper.writeValue(System.out, accMap);
    } catch (Exception e) {
        e.printStackTrace();
    }    
	}

}
