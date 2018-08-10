package account;

import java.util.Comparator;

public class AccountComparator implements Comparator<Account> {

	@Override
	public int compare(Account acc1, Account acc2) {
		if (acc1.getBalance()<acc2.getBalance()) return -1;
		else if (acc1.getBalance()>acc2.getBalance()) return 1;
		     else return acc1.getLastAndFirstName().compareToIgnoreCase(acc2.getLastAndFirstName());
	}
}
