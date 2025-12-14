import java.util.*;

class Account{
    private long accountNo;
    private String accountHolderName;
    private double balance;
    
    Account(long accountNo, String accountHolderName, double balance){
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    
    public long getAccountNo(){
        return this.accountNo;
    }
    
    public String getAccountHolderName(){
        return this.accountHolderName;
    }
    
    public double getBalance(){
        return this.balance;
    }
    
    public boolean deposit(double depositAmountValue){
        if(depositAmountValue <= 0){
            return false;
        }
        this.balance += depositAmountValue;
        return true;
    }
    
    public boolean withdraw(double withdrawAmountValue){
        if(this.balance < withdrawAmountValue){
            return false;
        }
        
        this.balance -= withdrawAmountValue;
        return true;
    }
    
    protected void setBalance(double amount){
        this.balance = amount;
    }
}

class SavingsAccount extends Account{
   
    private double intrest;
    
    SavingsAccount(long accountNo, String accountHolderName, double balance, double intrest){
        super(accountNo, accountHolderName, balance);
        this.intrest = intrest;
    }
    
    public double calculateIntrest(){
        return intrest * this.getBalance();
    }
}

class CurrentAccount extends Account{
    
    private double overdraftLimit;
    
    CurrentAccount(long accountNo, String accountHolderName, double balance, double overdraftLimit){
        super(accountNo, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    
    @Override
    public boolean withdraw(double amount){
        if(amount > this.getBalance() + overdraftLimit){
            return false;
        }
        if(amount > this.getBalance()){
            overdraftLimit = overdraftLimit - (amount - this.getBalance());
            setBalance(0);
            return true;
        }
        double newBalanceAmount = this.getBalance() - amount;
        this.setBalance(newBalanceAmount);
        return true;
    }
}

public class Main
{
	public static void main(String[] args) {
		SavingsAccount p1 = new SavingsAccount(123,"yash",100.0, 5);
		if(p1.withdraw(80)){
		    System.out.println("Amount withdrawn from " + p1.getAccountHolderName() + "'s account");
		}
		else{
		    System.out.println("Unable to withdrawn from " + p1.getAccountHolderName() + "'s account as insufficient balance");
		}
		System.out.println(p1.getAccountHolderName() + "'s balance = " + p1.getBalance());

		
		CurrentAccount p2 = new CurrentAccount(200, "ram", 100.0, 200.0);
		
		if(p2.withdraw(400)){
		    System.out.println("Amount withdrawn from " + p2.getAccountHolderName() + "'s account");
		}
		else{
		    System.out.println("Unable to withdrawn from " + p2.getAccountHolderName() + "'s account as insufficient balance");
		}
		System.out.println(p2.getAccountHolderName() + "'s balance = " + p2.getBalance());
	}
}