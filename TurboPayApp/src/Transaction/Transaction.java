package Transaction;

import UserAccount.UserAccount;

public interface Transaction {
    public void transfer(int amount, UserAccount sender, String receiver);
}
