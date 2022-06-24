package co.com.sofka.bank;

import java.time.LocalDate;

public class Transaction {
    private TransactionDate date;
    private TransactionDetail detail;

    public Transaction(LocalDate date, TransactionDetail state) {
        this.date = new TransactionDate(date);
        this.detail = state;
    }

    public TransactionDetail detail() {
        return detail;
    }

    public LocalDate date() {
        return date.date();
    }

    public String viewStatus() {
        final StringBuilder sb = new StringBuilder();
        if (detail.transactionDetailType().equals(TransactionType.CREDIT)){
            sb.append(date.dateFormat())
                    .append("\t\t")
                    .append(detail.transactionDetailAmount())
                    .append("\t\t\t\t")
                    .append(detail.transactionDetailBalance());
            return sb.toString();
        }
        sb.append(date.dateFormat())
                .append("\t\t")
                .append("\t\t\t")
                .append(detail.transactionDetailAmount())
                .append("\t\t")
                .append(detail.transactionDetailBalance());
        return sb.toString();
    }

    @Override
    public String toString() {
        String sb = "Transaction{" + "date=" + date +
                ", detail=" + detail +
                '}';
        return sb;
    }
}