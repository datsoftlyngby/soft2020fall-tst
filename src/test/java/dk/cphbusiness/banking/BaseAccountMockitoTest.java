package dk.cphbusiness.banking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BaseAccountMockitoTest {

  @Mock Bank bankMock;
  @Mock Customer customerMock;
  @Mock SmsService smsServiceMock;

  @Test
  public void testTransferAccount() {
    BaseAccount source = new BaseAccount(smsServiceMock, bankMock, customerMock, "ABC-123");
    BaseAccount target = new BaseAccount(smsServiceMock, bankMock, customerMock, "XYZ-456");
//    when(bank.getAccount(startsWith("XYZ"))).thenReturn(target);
//    when(bank.getAccount(isA(String.class))).thenReturn(target);
//    when(bank.getAccount(anyString())).thenReturn(target);
//    when(bank.getAccount(any())).thenReturn(target);
//    when(bank.getAccount(eq("XYZ-456"))).thenReturn(target);
    when(bankMock.getAccount("XYZ-456")).thenReturn(target);
    source.transfer(2_000_00L, "XYZ-456");
    assertEquals(-2_000_00L, source.getBalance());
    assertEquals(2_000_00L, target.getBalance());
    }

  }
