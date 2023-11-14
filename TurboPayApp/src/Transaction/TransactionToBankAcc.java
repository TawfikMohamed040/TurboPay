package Transaction;

import API.DatabaseAPI;
import UserAccount.UserAccount;


public class TransactionToBankAcc implements Transaction {
    @Override
    public void transfer(int amount, UserAccount sender, String bankID) {
        if (sender.getBalance() < amount) {
            System.out.println("Balance is not enough");
            return;
        }
        sender.setBalance(sender.getBalance() - amount);
        UserAccount receiverAccount = DatabaseAPI.accounts.returnAccountWithBankID(bankID);
        if (receiverAccount != null) {
            receiverAccount.setBalance(receiverAccount.getBalance() + amount);
        }
        System.out.println("Transaction Done!");

    }
}


