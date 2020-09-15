package dk.cphbusiness.banking;

import static org.mockito.Mockito.mock;

public class BankMock implements Bank {
  private BaseAccount account = new BaseAccount(mock(SmsService.class), this, new CustomerMock(), "XYZ");

  @Override
  public BaseAccount getAccount(String number) {
    return account;
    }

  }
