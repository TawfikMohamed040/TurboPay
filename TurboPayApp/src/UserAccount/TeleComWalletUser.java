package UserAccount;

public class TeleComWalletUser extends WalletUser{

    @Override
    void withdraw(int amount) {
        System.out.println("TELECOM WITHDRAW" + amount);
    }

    @Override
    void debt(int amount) {
        System.out.println("TELECOM DEBT" + amount);

    }
}
