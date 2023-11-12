package UserAccount;

public class BankWalletUser extends WalletUser{
    @Override
    void withdraw(int amount) {
        System.out.println("BANK WALLET WITHDRAW" + amount);

    }

    @Override
    void debt(int amount) {
        System.out.println("BANK WALLET DEBT" + amount);
    }
}
