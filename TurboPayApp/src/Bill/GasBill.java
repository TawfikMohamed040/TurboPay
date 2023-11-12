package Bill;

public class GasBill extends  Bill{
    @Override
    protected void billInfo() {
        System.out.println("GAS BILL");
        mainInfo();
        System.out.println("GAZ USED THIS MONTH >> 3239 litters");
    }
}
