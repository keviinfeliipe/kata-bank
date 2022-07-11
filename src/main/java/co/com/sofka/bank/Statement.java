package co.com.sofka.bank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Statement {

    private Set<Transaction> transactions;
    public Statement() {
        this.transactions = new HashSet<>();
    }

    public void add(BigDecimal amount, LocalDate date, TransactionType type, BigDecimal balance){
            transactions.add(new Transaction(date, new TransactionDetail(type, new TransactionValues(amount, balance))));
    }

    public Stream<Transaction> orderList(){
        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::date).reversed());
    }

    public Set<Transaction> filterByType(TransactionType type){
        return orderList()
                .filter(transaction -> transaction
                        .detail()
                        .transactionDetailType()
                        .equals(type)
                ).collect(Collectors.toSet());
    }

    public Set<Transaction> filterByDate(LocalDate startDate, LocalDate endDate){
        return orderList()
                .filter(transaction -> transaction.date().isAfter(startDate) || transaction.date().equals(startDate))
                .filter(transaction -> transaction.date().isBefore(endDate) || transaction.date().equals(endDate))
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        String sb = "Statement{" + "transactions=" + transactions +
                '}';
        return sb;
    }
}