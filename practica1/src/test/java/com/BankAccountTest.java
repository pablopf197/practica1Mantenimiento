package com;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    
    @Test
    @DisplayName("Test for constructor")
    public void testConstructor() {
        BankAccount account = new BankAccount(100);
        assertEquals(100, account.getBalance());
        
    }
    @Test
    @DisplayName("Test for invalid withdraw")
    public void withdrawInvalidShouldBeFalse() {
        BankAccount account = new BankAccount(100);
        boolean result = account.withdraw(200);
        assertEquals(false, result);
    }
    
    @Test
    @DisplayName("Test for valid withdraw")
    public void withdrawValidShouldBeTrue() {
        BankAccount account = new BankAccount(100);
        boolean result = account.withdraw(50);
        assertTrue(result);
    }
    @Test
    @DisplayName("Test for balance after withdraw")
    public void shouldWithdraw() {
        BankAccount account = new BankAccount(100);
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }
    
    @Test
    @DisplayName("Test for  valid deposit")
    public void shouldDeposit() {
        BankAccount account = new BankAccount(100);
        int result = account.deposit(50);
        assertEquals(150, result);
    }
    @Test
    @DisplayName("Test for invalid deposit")
    public void depositInvalidShouldThrowIllegalArgument() {
        BankAccount account = new BankAccount(100);
        try {
            account.deposit(-50);
        } catch (IllegalArgumentException e) {
            assertEquals("Amount cannot be negative", e.getMessage());
        }
    }

    @Test
    @DisplayName("Test for getBalance")
    public void shouldGetBalance() {
        BankAccount account = new BankAccount(100);
        int result = account.getBalance();
        assertEquals(100, result);
    }

    @Test
    @DisplayName("Test for payment")
    public void shouldGetPayment() {
        BankAccount account = new BankAccount(100);
        double result = account.payment(100, 0.1, 12);
        assertEquals(14.67633148, result, 0.001);
    }

    @Test
    @DisplayName("Test for pending when month is zero")
    public void pendingMonthIsZero() {
        BankAccount account = new BankAccount(100);
        double result = account.pending(100, 0.1, 12, 0);
        assertEquals(100, result);
    }

    @Test
    @DisplayName("Test for pending when month is not zero")
    public void pendingMonthIsNotZero() {
        BankAccount account = new BankAccount(100);
        double result = account.pending(100, 0.1, 12, 1);
        assertEquals(95.32366849, result, 0.001);
    }
}