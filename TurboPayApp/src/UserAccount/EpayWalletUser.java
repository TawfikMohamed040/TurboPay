package UserAccount;

public class EpayWalletUser extends WalletUser {

    @Override
    void withdraw(int amount) {
        System.out.println("EPAY WITHDRAW" + amount);

    }

    @Override
    void debt(int amount) {
        System.out.println("EPAY DEBT" + amount);

    }
}
