package dk.cphbusiness.banking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BaseAccountMockitoTest {

  @Mock Bank bank;
  @Mock Customer customer;

  @Test
  public void testTransferAccount() {
    BaseAccount source = new BaseAccount(bank, customer, "ABC-123");
    BaseAccount target = new BaseAccount(bank, customer, "XYZ-456");
//    when(bank.getAccount(startsWith("XYZ"))).thenReturn(target);
//    when(bank.getAccount(isA(String.class))).thenReturn(target);
//    when(bank.getAccount(anyString())).thenReturn(target);
//    when(bank.getAccount(any())).thenReturn(target);
//    when(bank.getAccount(eq("XYZ-456"))).thenReturn(target);
    when(bank.getAccount("XYZ-456")).thenReturn(target);
    source.transfer(2_000_00L, "XYZ-456");
    assertEquals(-2_000_00L, source.getBalance());
    assertEquals(2_000_00L, target.getBalance());
    }

  }
