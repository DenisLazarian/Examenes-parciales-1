package parcial1_2020_21;

public class Account {
    private final String idAccount;
    private int balance;


    public Account(String idAccount, int initialBalance){
        this.idAccount = idAccount;
        this.balance = initialBalance;
    }

    public String getId(){
        return idAccount;
    }

    public int getBalance(){
        return balance;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public boolean withdrawal(int amount){
        if(balance < amount) return false;
        balance -= amount;
        return true;
    }

}
