package dk.cphbusiness.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaseAccountTransferTest {
  private BaseAccount source;
  private BaseAccount destination;


  @BeforeEach
  public void setup() {
    Bank bank = new BankMock();
    Customer customer = new CustomerMock();
    source = new BaseAccount(bank, customer, "ABC-123");
    destination = new BaseAccount(bank, customer, "XYZ-456");
    }


  @Test
  public void testSourceBalanceIsUpdatedOnTransfer() {
    long balanceBefore = source.getBalance();
    long amount = 100_00;

    source.transfer(amount, destination);
    assertEquals(balanceBefore - amount, source.getBalance());
    }

  @Test
  public void testDestinationBalanceIsUpdatedOnTransfer() {
    long balanceBefore = destination.getBalance();
    long amount = 100_00;

    source.transfer(amount, destination);
    assertEquals(balanceBefore + amount, destination.getBalance());
    }

  }
