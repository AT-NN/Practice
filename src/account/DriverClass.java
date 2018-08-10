package account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverClass {

	public static void main(String[] args) {
		List<Account> accounts = new ArrayList<>();
		
		accounts.add(new Account("Ivanov","Ivan",100));
		accounts.add(new Account("Ivanov","IvAn",50));
		accounts.add(new Account("Ivanov","Oleg",100));
		accounts.add(new Account("ivanov","oleg",200));
		accounts.add(new Account("ivanin","oleg",300));
		
		System.out.println("Initial list");
		for (Account a:accounts) System.out.println(a);
		
		System.out.println();
		System.out.println("Default sorting");
		Collections.sort(accounts);
		for (Account a:accounts) System.out.println(a);
		
		System.out.println();
		System.out.println("Additional sorting");
		Collections.sort(accounts,new AccountComparator());
		for (Account a:accounts) System.out.println(a);
	}

}
