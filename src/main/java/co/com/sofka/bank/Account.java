package co.com.sofka.bank;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {
    private BigDecimal amount;
    private Statement statement;

    public Account(Statement statement) {
        this.amount = new BigDecimal(0);
        this.statement = statement;
    }

    public void deposit(BigDecimal amount, LocalDate date) {
        this.amount = amount().add(amount);
        statement().add(amount, date, TransactionType.CREDIT, this.amount);
    }

    public void withdrawal(BigDecimal amount, LocalDate date){
        if (amount().compareTo(amount) < 0){
            throw new IllegalArgumentException("No puede retirar más del valor en la cuenta");
        }
        this.amount = amount().subtract(amount);
        statement().add(amount, date, TransactionType.DEBIT, this.amount);
    }

    public void printStatement(PrintStream out) {
        out.println("Date\t\t\tCredit\t\tDebit\t\tBalance");
        statement().orderList()
                .forEach(transaction -> System.out.println(transaction.viewStatus()));
    }

    public void transfer(Account account, BigDecimal amount){
        withdrawal(amount,LocalDate.now());
        account.deposit(amount,LocalDate.now());
    }

    public BigDecimal amount() {
        return amount;
    }

    public Statement statement() {
        return statement;
    }
}
