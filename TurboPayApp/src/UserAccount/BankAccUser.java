package UserAccount;

import API.DatabaseAPI;

import java.util.Objects;

public class BankAccUser extends UserAccount {
    private String bankAccID;


    public void setBankAccID(String bankAccID) {
        this.bankAccID = bankAccID;
    }

    public String getBankAccID() {
        return bankAccID;
    }
}
