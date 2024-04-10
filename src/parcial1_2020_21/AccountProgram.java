package parcial1_2020_21;

import acm.program.CommandLineProgram;
import acm.util.RandomGenerator;

import java.util.StringTokenizer;

public class AccountProgram extends CommandLineProgram {

    private AccountsDB accountsDB;
    private int numErrors;
    public void run() {
        initializeResults();
        processAccounts();
        selectAccount();
    }

    private void selectAccount() {
        String id = readLine("Cuenta: ");

        Account count = accountsDB.getAccount(id);

        String h = numErrors > 1 || numErrors==0 ? "han": "ha";
        String err = numErrors > 1  || numErrors==0? "errores": "error";

        if(count != null)
            println("El saldo de "+id+" es "+count.getBalance()+" y "+h+" habido "+numErrors+" "+ err+".");
        else println("La cuenta no existe.");
    }

    private void processAccounts() {
//        String acList = readLine("Transferencias: ");
        String acList = "CC1#CC4#100 CC21#CC1#200 CA4#CC21#350";
        StringTokenizer tk = new StringTokenizer(acList, " ");

        while(tk.hasMoreTokens()){
            String c = tk.nextToken();
            StringTokenizer tk2 = new StringTokenizer(c, "#");

            while(tk2.hasMoreTokens()){
                String idFrom = tk2.nextToken();
                String idTo = tk2.nextToken();
                int amount = Integer.parseInt(tk2.nextToken());

                if(!accountsDB.transfer(idFrom, idTo, amount)) numErrors += 1;
            }
        }

    }


    private void initializeResults() {
        accountsDB = loadAccounts();
        numErrors = 0;
    }

    private AccountsDB loadAccounts(){
        AccountsDB ac = new AccountsDB(10, 20);
        for (int i = 0; i < ac.getListLength(); i++) {
            ac.addAccount("CC"+i, gen());
        }
        return ac;
    }

    public int gen(){
        RandomGenerator rg = RandomGenerator.getInstance();
        return rg.nextInt(-1000, 5000);
    }

    public static void main(String[] args) {
        new AccountProgram().start(args);
    }
}
