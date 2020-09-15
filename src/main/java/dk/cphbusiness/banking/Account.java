package dk.cphbusiness.banking;

public interface Account {
  void transfer(long amount, BaseAccount destination);
  }
