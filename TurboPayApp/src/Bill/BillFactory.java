package Bill;

import java.util.Objects;

public class BillFactory {
    public Bill makeBill(String billType) {
        billType = billType.toLowerCase();

        return switch (billType) {
            case "gas" -> new GasBill();
            case "electricity" -> new ElectricityBill();
            case "water" -> new WaterBill();
            default -> null;
        };


    }
}
