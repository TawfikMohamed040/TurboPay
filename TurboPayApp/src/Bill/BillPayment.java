package Bill;

public class BillPayment {
    private Bill bill;
    private BillFactory billFactory;

    public void pay(String billType) {
        bill = billFactory.makeBill(billType);
        bill.billInfo();

          }
}
