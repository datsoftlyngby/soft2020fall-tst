package dk.cphbusiness.banking;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaseAccountTest {
  private Bank bank;
  private Customer customer;

  @BeforeEach
  public void setup() {
    bank = new BankMock();
    customer = new CustomerMock();
    }

  @Test
  public void testCreateAccount() {
    String number = "ABC-123";
    BaseAccount account = new BaseAccount(bank, customer, number);
    assertNotNull(account);
    }

  @Test
  public void testCreatedAccountHasBank() {
    String number = "ABC-123";
    BaseAccount account = new BaseAccount(bank, customer, number);
    assertEquals(bank, account.getBank());
    }

  @Test
  public void testCreatedAccountHasCustomer() {
    String number = "ABC-123";
    BaseAccount account = new BaseAccount(bank, customer, number);
    assertEquals(customer, account.getCustomer());
    }

  @Test
  public void testCreatedAccountHasNumber() {
    String number = "ABC-123";
    BaseAccount account = new BaseAccount(bank, customer, number);
    assertEquals(number, account.getNumber());
    }

  @Test
  public void testCreatedAccountHasZeroBalance() {
    String number = "ABC-123";
    BaseAccount account = new BaseAccount(bank, customer, number);
    assertEquals(0L, account.getBalance());
    }

  }