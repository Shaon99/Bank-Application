import java.util.Calendar;

public class DebitAccount extends Account {
    private final double MAX_BALANCE = 100000;
    private double transactionLimit = 20000;
    public DebitAccount() {
        super();  //this constructor call account cns
    }

    public DebitAccount(String name, String DOB, String nominee) {
        super(name, DOB, nominee);
    }

    @Override
    public boolean deposit(double amount) {
        if (amount + getBalance() > MAX_BALANCE){
            return false;
        }
        return super.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        Calendar calendar = Calendar.getInstance();
        if (IDGENARATOR.currentMonth.get(Calendar.DATE) < calendar.get(Calendar.DATE)){
            IDGENARATOR.currentMonth = Calendar.getInstance();  //if the id match for the account than withdraw sucess
            this.transactionLimit = 20000;
        }
        this.transactionLimit -= amount;
        if (transactionLimit < amount ){
            return false;
        }
        return super.withdraw(amount);
    }

    @Override
    public void printAccount() {
        super.printAccount();
    }
}
