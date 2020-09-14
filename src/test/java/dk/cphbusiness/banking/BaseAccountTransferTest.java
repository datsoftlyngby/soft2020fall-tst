package dk.cphbusiness.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaseAccountTransferTest {
  private BaseAccount source;
  private BaseAccount destination;
  private Bank bank;


  @BeforeEach
  public void setup() {
    bank = new BankMock();
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

  @Test
  public void testSourceTransactionListIsUpdatedOnTransfer() {
    long sizeBefore = source.getTransactions().size();
    long amount = 100_00;

    source.transfer(amount, destination);
    assertEquals(sizeBefore + 1, source.getTransactions().size());
    }

  @Test
  public void testDestinationTransactionListIsUpdatedOnTransfer() {
    long sizeBefore = destination.getTransactions().size();
    long amount = 100_00;

    source.transfer(amount, destination);
    assertEquals(sizeBefore + 1, destination.getTransactions().size());
    }

  @Test
  public void testSourceLastTransactionOnTransfer() {
    long amount = 100_00;
    source.transfer(amount, destination);
    Transaction last = source.getTransactions().get(source.getTransactions().size() - 1);
    assertEquals(amount, last.getAmount());
    assertEquals(source, last.getSource());
    assertEquals(destination, last.getTarget());
    }

  @Test
  public void testDestinationLastTransactionOnTransfer() {
    long amount = 100_00;
    source.transfer(amount, destination);
    Transaction last = destination.getTransactions().get(destination.getTransactions().size() - 1);
    assertEquals(amount, last.getAmount());
    assertEquals(source, last.getSource());
    assertEquals(destination, last.getTarget());
    }

  @Test
  public void testSourceBalanceIsUpdatedOnTransferByNumber() {
    long balanceBefore = source.getBalance();
    long amount = 200_00;
    String destinationNumber = "XYZ-789";
    source.transfer(amount, destinationNumber);
    assertEquals(balanceBefore - amount, source.getBalance());
    }

  @Test
  public void testDestinationBalanceIsUpdatedOnTransferByNumber() {
    String destinationNumber = "XYZ-789";
    BaseAccount destination = bank.getAccount(destinationNumber);
    long balanceBefore = source.getBalance();
    long amount = 200_00;
    source.transfer(amount, destinationNumber);
    assertEquals(balanceBefore + amount, destination.getBalance());
    }

  }
