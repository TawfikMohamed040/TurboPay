package Bill;

public class GasBill extends  Bill{
    @Override
    protected void billInfo() {
        System.out.println("GAS BILL");
        mainInfo();
        System.out.println("Gas used this month >> 3239 liters");
    }
}
