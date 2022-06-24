package co.com.sofka.bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionDate {

    private LocalDate date;

    public TransactionDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate date() {
        return date;
    }

    public String dateFormat(){
        var format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(format);
    }


}
