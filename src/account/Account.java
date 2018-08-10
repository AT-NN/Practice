package account;

public class Account implements Comparable<Account>{
	private String lastName;	
	private String firstName;
	private double balance;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Account(String lastName, String firstName, double balance) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.balance = balance;
	}
	
	public String getLastAndFirstName(){
		return lastName+firstName;
	}
	
	@Override
	public String toString() {
		return lastName + " " + firstName + " " + balance;
	}
	
	@Override
	public int compareTo(Account acc2) {
		if (lastName.compareToIgnoreCase(acc2.lastName)<0) return -1;
		else if (lastName.compareToIgnoreCase(acc2.lastName)>0) return 1;
		     else if (firstName.compareToIgnoreCase(acc2.firstName)<0) return -1;
				else if (firstName.compareToIgnoreCase(acc2.firstName)>0) return 1;	
				     else if (balance<acc2.balance) return -1;
						else if (balance>acc2.balance) return 1;
						     else return 0;
	}
	
	
}
