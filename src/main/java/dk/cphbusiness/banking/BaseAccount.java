package dk.cphbusiness.banking;

public class BaseAccount {
  private final Bank bank;
  private final Customer customer;
  private final String number;
  private long balance = 0L;

  public BaseAccount(Bank bank, Customer customer, String number) {
    this.bank = bank;
    this.customer = customer;
    this.number = number;
    }

  public Bank getBank() {
    return bank;
    }

  public Customer getCustomer() {
    return customer;
    }

  public String getNumber() {
    return number;
    }

  public long getBalance() {
    return balance;
    }

  public void transfer(long amount, BaseAccount destination) {
    balance -= amount;
    destination.balance += amount;
    }

  }
