package Bill;

public class ElectricityBill extends  Bill{
    @Override
    protected void billInfo() {
        System.out.println("ELECTRICITY BILL");
    }
}
