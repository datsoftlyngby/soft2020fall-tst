package dk.cphbusiness.banking;

public class BankMock implements Bank {
  private BaseAccount account = new BaseAccount(this, new CustomerMock(), "XYZ");

  @Override
  public BaseAccount getAccount(String number) {
    return account;
    }

  }
