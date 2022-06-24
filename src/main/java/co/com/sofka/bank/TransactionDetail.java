package co.com.sofka.bank;

public class TransactionDetail {
    private TransactionType type;
    private TransactionValues values;


    public TransactionDetail(TransactionType type, TransactionValues values) {
        this.type = type;
        this.values = values;
    }

    public TransactionType transactionDetailType() {
        return type;
    }

    public TransactionValues values() {
        return values;
    }

    public String transactionDetailAmount(){
        return values.amount();
    }

    public String transactionDetailBalance(){
        return values().balance();
    }

}
