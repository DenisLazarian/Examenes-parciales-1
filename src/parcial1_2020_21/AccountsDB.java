package parcial1_2020_21;

public class AccountsDB {

    private Account[] accounts;
    private int it;
    private int sizeIncrement;

    public AccountsDB(int initialSize, int sizeIncrement){
        this.accounts = new Account[initialSize];
        this.sizeIncrement = sizeIncrement;
        it = 0;
    }




    public boolean addAccount(String id, int initialBalance){
        if(isNullId(id) || exist(id) > -1 || initialBalance < 0 ){
            return false;
        }

        resize();
        accounts[it] = new Account(id, initialBalance);
        it += 1;
        return true;
    }

    private boolean isNullId(String id){
        return id.isEmpty() || id.isBlank() || id == null;
    }

    public Account getAccount(String id){
        return (exist(id) < 0) ? null : accounts[exist(id)];
    }


    public boolean transfer(String idFrom, String idTo, int amount){
        int idf = exist(idFrom);
        int idt =  exist(idTo);
        if(isNullId(idFrom) || isNullId(idTo) ||
                idf < 0 ||
                idt < 0 ||
                amount < 0 ||
                accounts[exist(idFrom)].getBalance() < amount
        ) return false;

        accounts[idf].withdrawal(amount);
        accounts[idt].deposit(amount);

        return true;
    }

    private void resize() {
        if(it >= accounts.length){
            Account[] aux = accounts;
            accounts = new Account[it + sizeIncrement];

            for (int i = 0; i < it; i++) {
                accounts[i] = aux[i];
            }
        }
    }

    private int exist(String id) {
        for (int i = 0; i < it; i++) {
            if(accounts[i].getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public int getListLength(){
        return accounts.length;
    }

}
