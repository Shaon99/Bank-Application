public class Account {
    private String name;
    private String ID;
    private String DOB;
    private String nominee;
    private double balance;

    public Account() {
    }

    public Account(String name, String DOB, String nominee) {
        this.name = name;
        this.ID = IDGENARATOR.generate();//id automatic
        this.DOB = DOB;
        this.nominee = nominee;
    }

    public boolean deposit(double amount){
        try{
            if (amount < 0){
                return false;
            }
            this.balance += amount;
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean withdraw(double amount){
        try{
            if (amount>this.balance){
                return true;
            }
            this.balance -= amount;
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public void printAccount(){
        System.out.println("_________________________\nAccount for " + this.name
    +"\nName:"+this.name
    + "\nID: " + this.ID +
    "\nDOB: " + this.DOB +
    "\nNominee: " + this.nominee +
    "\nBalance: " + this.balance +

                "\n_________________________"
);
    }
    public  String getID()
    {
        return ID;
    }
    public double getBalance() {
        return balance;
    }
}
