package Transaction;

import API.DatabaseAPI;
import AccountDatabaseManger.*;
import UserAccount.UserAccount;


public class TransactionToWallet implements Transaction{

    @Override
    public void transfer(int amount, UserAccount sender, String walletNo) {
        if (sender.getBalance() < amount){
            System.out.println("Balance is not enough");
            return;
        }
        sender.setBalance(sender.getBalance() - amount);
        UserAccount receiverAccount = DatabaseAPI.accounts.returnAccountWithWalletNo(walletNo);
        if (receiverAccount != null){
            receiverAccount.setBalance(receiverAccount.getBalance() + amount);
        }
        System.out.println("Transaction Done!");

    }
}
