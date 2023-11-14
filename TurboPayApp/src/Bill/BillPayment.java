package Bill;

import UserAccount.UserAccount;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BillPayment {
    private Bill bill;
    private BillFactory billFactory;

    public BillPayment() {
        billFactory = new BillFactory();
    }

    public void pay(UserAccount account, String billType) {
        bill = billFactory.makeBill(billType);
        if (account.getBalance() < bill.getCost()) {
            bill.setPaid(false);
            System.out.println("There is no enough balance");
            return;
        }
        bill.setPaid(true);
        account.setBalance(account.getBalance() - bill.getCost());
        bill.setCustomerName(account.getUsername());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        bill.setDate(dtf.format(LocalDateTime.now()));
        bill.billInfo();
    }

}
