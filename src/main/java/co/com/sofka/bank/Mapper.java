package co.com.sofka.bank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Mapper {

    public static BigDecimal amountOf(int amount){
        Objects.requireNonNull(amount);
        if (amount<0){
            throw new IllegalArgumentException("No puede depositar valores negativos");
        }
        return new BigDecimal(amount);
    }

    public static LocalDate date(String date){
        Objects.requireNonNull(date);
        if(date.isBlank()){
            throw new IllegalArgumentException("Ingrese el valor de una fecha");
        }
        String regx = "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$";
        if (!date.matches(regx)){
            throw new IllegalArgumentException("Ingrese una fecha en el formato adecuado");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date,formatter);
    }

}
