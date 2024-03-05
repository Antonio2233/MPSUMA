package bank;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setup(){
        account = new BankAccount(0);
    }

    @Test
    @DisplayName("El balance se modifica correctamente tras retirar")
    void withdraw_succeeds_when_enough_balance(){

        BankAccount account = new BankAccount(10);

        account.withdraw(5);

        assertEquals(account.getBalance(),5);
    }

    @Test
    @DisplayName("El balance se modifica correctamente tras ingresar")
    void deposit_suceeds(){
        BankAccount account = new BankAccount(0);

        account.deposit(5);

        assertEquals(account.getBalance(),5);
    }


    @Test
    void withdraw_fails_when_not_enough_balance(){
        BankAccount account = new BankAccount(0);

        account.withdraw(5);

        assertEquals(account.getBalance(),0);
    }

    @Test
    @DisplayName("El balance se modifica correctamente tras ingresar")
    void depositWithNegativeAmount(){
        BankAccount account = new BankAccount(5);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-10);
        });

        // Verificar el mensaje de la excepción
        assertEquals("Amount cannot be negative", exception.getMessage());

        // Verificar que el saldo no ha cambiado
        assertEquals(5, account.getBalance());
    }
    @Test
    void payment_succeeds(){
        BankAccount account =new BankAccount(10);
        double total_amount =10000; 
        double interes = 0.001;
        int months = 12;


        double result = account.payment(total_amount, interes, months);

        assertEquals(result, 838.759926,6);
    }

    @Test
    void pending_succeeds(){
        BankAccount account =new BankAccount(10);
        double total_amount =10000; 
        double interes = 0.001;
        int months = 12;

        double result = account.pending(total_amount, interes, months, 2);

        assertEquals(result,8341.651389,6);
    }

    @Test
    void obtain_balance(){
        BankAccount account =new BankAccount(10);

        int result = account.getBalance();


        assertEquals(result, 10);
    }




}
