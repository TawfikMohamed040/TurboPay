package UserAccount;

import Bill.ElectricityBill;
import Bill.GasBill;
import Bill.WaterBill;

public class UserFactory {
    public UserAccount makeUser(int userAccType){
        // BankWalletUser
        // EpayWalletUser
        // TeleComWalletUser

        return switch (userAccType) {
            case 1 -> new EpayWalletUser();
            case 2 -> new TeleComWalletUser();
            case 3 -> new BankWalletUser();
            case  4-> new BankAccUser();
            default -> null;
        };
    }
}
