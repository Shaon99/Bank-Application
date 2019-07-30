public class Bank {
    private DebitAccount [] debitAccounts;
    private int count;

    public Bank() {
        debitAccounts = new DebitAccount[100];
        count = 0;
    }

    public String create_account(String name, String DOB, String nominee){
        DebitAccount debitAccount = new DebitAccount(name, DOB, nominee);
        debitAccounts[count] = debitAccount;
        count++;
        debitAccount.getID();
        return "";
    }

    public void deposit(String ID, double amount){
        boolean flag = false;
        for(int i=0; i<count; i++){
            if (debitAccounts[i].getID().equals(ID)){
                flag = debitAccounts[i].deposit(amount);
                System.out.println("Deposite Success......." +
                                " \n"+"and your Current balance is "+debitAccounts[i].getBalance());
                //System.out.println("Current balance ........."+debitAccounts[i].getBalance());



                break;
            }else {
                flag = false;
            }
        }
        if (!flag){
            System.out.println("Account cannot be found or other ...");
        }
    }

    public void withdraw(String ID, double amount){
        boolean flag = false;
        for(int i=0; i<count; i++){
            if (debitAccounts[i].getID().equals(ID)){
                flag = debitAccounts[i].withdraw(amount);
                System.out.println("Withdraw Success......." +
                        " \n"+"and your Current balance is "+debitAccounts[i].getBalance());
             //   System.out.println("withdraw Sucess........"+debitAccounts[i].withdraw(amount));

                break;
            }else {
                flag = false;
                 }
        }
        if (!flag){
            System.out.println("Account cannot be found or other ...");
        }
    }


    public void print(String ID){
        boolean flag = false;
        int index = 0;
        for(int i=0; i<count; i++){
            if (debitAccounts[i].getID().equals(ID)){
                flag=true;
                debitAccounts[i].printAccount();
                break;
            }else {
                flag = false;
            }
        }
        if (!flag){
            System.out.println("Account cannot be found or other ...");
        }
    }
}
