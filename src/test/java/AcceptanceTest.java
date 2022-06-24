import co.com.sofka.bank.Account;
import co.com.sofka.bank.Statement;
import co.com.sofka.bank.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static co.com.sofka.bank.Mapper.amountOf;
import static co.com.sofka.bank.Mapper.date;


public class AcceptanceTest {
    Account account = new Account(new Statement());

    @Test
    public void filtrarMovimientosPorfecha() {
        account.deposit(amountOf(1000), date("10/01/2021"));
        account.deposit(amountOf(2000), date("13/01/2021"));
        account.withdrawal(amountOf(500), date("14/01/2021"));
        var statement = account.statement().filterByDate(date("10/01/2021"),date("13/01/2021"));
        Assertions.assertEquals(2,statement.size());
    }

    @Test
    public void filtrarMovimientosDepositados() {
        account.deposit(amountOf(1000), date("10/01/2021"));
        account.deposit(amountOf(2000), date("13/01/2021"));
        account.withdrawal(amountOf(500), date("14/01/2021"));
        var statement = account.statement().filterByType(TransactionType.CREDIT);
        Assertions.assertEquals(2,statement.size());
    }

    @Test
    public void filtrarMovimientosRetirados() {
        account.deposit(amountOf(1000), date("10/01/2021"));
        account.deposit(amountOf(2000), date("13/01/2021"));
        account.withdrawal(amountOf(500), date("14/01/2021"));
        var statement = account.statement().filterByType(TransactionType.DEBIT);
        Assertions.assertEquals(1,statement.size());
    }

    @Test
    public void hacerTransferencia(){
        var account2 = new Account(new Statement());
        account.deposit(amountOf(1000), date("10/01/2021"));
        account.deposit(amountOf(2000), date("13/01/2021"));
        account.transfer(account2, amountOf(1800));
        Assertions.assertEquals(1800,account2.amount().intValue());
        Assertions.assertEquals(1200,account.amount().intValue());
    }

}
