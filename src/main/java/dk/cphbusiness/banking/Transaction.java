package dk.cphbusiness.banking;

public class Transaction {
  private final BaseAccount source;
  private final long amount;
  private final BaseAccount target;

  public Transaction(BaseAccount source, long amount, BaseAccount target) {
    this.source = source;
    this.amount = amount;
    this.target = target;
    }

  public BaseAccount getSource() { return source; }

  public BaseAccount getTarget() { return target; }

  public long getAmount() { return amount; }

  }
