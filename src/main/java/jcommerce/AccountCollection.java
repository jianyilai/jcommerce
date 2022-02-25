package jcommerce;

import java.util.*;

public class AccountCollection {

    private ArrayList<Account> accounts = new ArrayList<>();
    private int capacity;

    public AccountCollection() {
    	/*accounts.add(new Account("adminTest","password","admin@email.com"));
    	accounts.add(new Account("userTest","password","user@email.com"));
    	accounts.add(new Account("jianyi","pass123","jianyi@email.com"));*/

        this.capacity = 20;
    }

    public AccountCollection(int capacity) {
        this.capacity = capacity;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
    	if(accounts.size() != capacity) {
    		accounts.add(account);
    	}
    }
}