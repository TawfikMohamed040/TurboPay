package Bill;

public class BillPayment {
    private Bill bill;
    private BillFactory billFactory;

    public void pay(String billType) {
        billFactory = new BillFactory();
        bill = billFactory.makeBill(billType);
        bill.billInfo();

          }
}
