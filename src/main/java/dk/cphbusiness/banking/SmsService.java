package dk.cphbusiness.banking;

public interface SmsService {
    boolean SendSms(Customer customer, String text);
}
