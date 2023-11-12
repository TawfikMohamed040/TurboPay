package Bill;

public class ElectricityBill extends  Bill{
    @Override
    protected void billInfo() {
        System.out.println("Electricity BILL");
        mainInfo();
        System.out.println("Electricity USED THIS MONTH >> 3239 volts");
    }
}
