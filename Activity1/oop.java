//parent class bank Account
class BankAccount {
    private String accountHolderName;
    private double balance;
    //constructor
    public BankAccount(String accountHolderName, double initialbalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialbalance;
    }
    //Encapsulation: Getter and Setter Methods
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    public double getBalance() {
        return balance;
    }
    //Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit Amount.");
        }
    }
    //Method to withdray money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else {
            System.out.println("Invalid Withdrawal Amount.");
        }
    }
    //Polymorphism: Method Overriding
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}
//child class Savings Account
class SavingsAccount extends BankAccount {
    private double interestRate;
    //constructor
    public SavingsAccount(String accountHolderName, double initialbalance, double interestRate) {
        super(accountHolderName, initialbalance);
        this.interestRate = interestRate;
    }
    //Method to calculate interest
    public void calculateInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest Amount: " + interest);
    }
    //Method Overriding
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
//child class Current Account
class CurrentAccount extends BankAccount {
    private double overdraftLimit;
    //constructor
    public CurrentAccount(String accountHolderName, double initialbalance, double overdraftLimit) {
        super(accountHolderName, initialbalance);
        this.overdraftLimit = overdraftLimit;
    }
    //Method to withdraw money
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            double newBalance = getBalance() - amount;
        if (newBalance < 0) {
            overdraftLimit += newBalance; //Reduce overdraft limit
        }
        super.deposit(-amount);
        System.out.println("Amount Withdrawn: " + amount);
        } else {
            System.out.println("Invalid Withdrawal Amount or overdraft limit exceeded.");
        }
    }
    //Oveerriding displayAccountDetails method
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}
//Main class to test the banking system
public class oop {
    public static void main(String[] args) {
        //Create Savings Account
        SavingsAccount savingsAccount = new SavingsAccount("Gee", 5000, 3);
        savingsAccount.displayAccountDetails();
        savingsAccount.deposit(500);
        savingsAccount.calculateInterest();
        savingsAccount.withdraw(500);
        System.out.println();
        //Create Current Account
        CurrentAccount currentAccount = new CurrentAccount("Dao", 5000, 2000);
        currentAccount.displayAccountDetails();
        currentAccount.deposit(2000);
        currentAccount.withdraw(8000);
        currentAccount.displayAccountDetails();
    }
}
 