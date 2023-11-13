package Bill;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BillPayment {
    private Bill bill;
    private BillFactory billFactory;

    public void setBillType(String billType){
        billFactory = new BillFactory();
        bill = billFactory.makeBill(billType);

    }
    public void pay() {
//        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        bill.setDate(dtf.format(now));
        bill.billInfo();
    }

    public Bill getBill() {
        return bill;
    }
}
