package co.com.sofka.bank;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TransactionValues {
    private BigDecimal amount;
    private BigDecimal balance;

    public TransactionValues(BigDecimal amount, BigDecimal balance) {
        this.amount = amount;
        this.balance = balance;
    }

    public String amount() {
        var format = new DecimalFormat("#,###.00");
        return format.format(amount);
    }

    public String balance() {
        var format = new DecimalFormat("#,###.00");
        return format.format(balance);
    }

}
