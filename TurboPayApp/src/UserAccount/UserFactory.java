package UserAccount;

import Bill.ElectricityBill;
import Bill.GasBill;
import Bill.WaterBill;

public class UserFactory {
    public UserAccount makeUser(String userAccType){
        // BankWalletUser
        // EpayWalletUser
        // TeleComWalletUser
        userAccType = userAccType.toLowerCase();

        return switch (userAccType) {
            case "epayWallet" -> new EpayWalletUser();
            case "teleWallet" -> new TeleComWalletUser();
            case "bankWallet" -> new BankWalletUser();
            case "bank" -> new BankAccUser();
            default -> null;
        };
    }
}
