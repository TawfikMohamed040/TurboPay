package UserAccount;

import java.util.Objects;

import static TurboPayMainMenu.TurboPayMainMenu.accountDatabaseManger;

public class BankAccUser extends UserAccount {
    private String bankAccID;

    public void transferToBankAcc(int amount, String bankID) {
        for(UserAccount acc:accountDatabaseManger.getAccounts()){
            if(acc instanceof BankAccUser && Objects.equals(((BankAccUser) acc).getBankAccID(), bankID )){
                acc.setBalance(acc.getBalance() + amount);
                this.setBalance(this.getBalance() - amount);
                return;
            }
        }
        System.out.println("User Not Exist");

    }

    public void setBankAccID(String bankAccID) {
        this.bankAccID = bankAccID;
    }

    public String getBankAccID() {
        return bankAccID;
    }
}
