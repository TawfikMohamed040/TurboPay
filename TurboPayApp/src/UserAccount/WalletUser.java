package UserAccount;

public abstract class WalletUser extends UserAccount {
    String walletID;

    abstract void withdraw(int amount);
    abstract void debt(int amount);


    public String getWalletID() {
        return walletID;
    }

    public void setWalletID(String walletID) {
        this.walletID = walletID;
    }
}
