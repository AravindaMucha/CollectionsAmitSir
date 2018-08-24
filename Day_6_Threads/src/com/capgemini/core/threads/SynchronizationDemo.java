package com.capgemini.core.threads;

class SavingAccount{
	
	private int Id;
	private double balance;
	
	public SavingAccount() {
		super();
	}

	public SavingAccount(int id, double balance) {
		super();
		Id = id;
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "SavingAccount [Id=" + Id + ", balance=" + balance + "]";
	}	
}

class Transaction{
	SavingAccount sa;

	public Transaction(SavingAccount sa) {
		super();
		this.sa = sa;
	}
	
	public synchronized void  performTransaction() {
		
		System.out.println(Thread.currentThread().getName() + " Checks balance " + sa.getBalance());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " Performing Withdrawl of 5000 ");
		sa.withdraw(5000);
		
		System.out.println(Thread.currentThread().getName() + " checks balance " + sa.getBalance());
	}
}

class Person extends Thread{
	
	private Transaction tr;
	
	public Person(Transaction tr) {
		super();
		this.tr = tr;
	}

	
	
	@Override
	public void run() {
		tr.performTransaction();
	}
}

public class SynchronizationDemo {
	public static void main(String[] args) {
		
		SavingAccount sa = new SavingAccount(1001, 100000);
		
		Transaction tr = new Transaction(sa);
		
		Person p1 = new Person(tr);
		Person p2 = new Person(tr);
		Person p3 = new Person(tr);
		
		p1.setName("Eric");
		p2.setName("Jhon");
		p3.setName("Peter");
		
		p1.start();
		p2.start();
		p3.start();	
		
	}
}
