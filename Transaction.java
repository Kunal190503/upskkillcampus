import java.util.Date;

public class Transaction {
    String type;
    double amount;
    Date date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }
}