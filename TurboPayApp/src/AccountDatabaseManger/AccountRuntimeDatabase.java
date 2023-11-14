package AccountDatabaseManger;

import UserAccount.*;

import java.util.ArrayList;
import java.util.Objects;

public class AccountRuntimeDatabase implements AccountDatabaseManger {

    public ArrayList<UserAccount> accounts;

    public AccountRuntimeDatabase() {
        accounts = new ArrayList<UserAccount>();
    }

    @Override
    public boolean isUsernameExist(String username) {
        for (UserAccount acc : accounts) {
            if (acc.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isAccountExist(String username, String password) {
        for (UserAccount acc : accounts) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPasswordExist(String password) {
        for (UserAccount acc : accounts) {
            if (acc.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addNewUser(UserAccount account) {
        accounts.add(account);
        return false;
    }

    @Override
    public void deleteUser(String username) {
        if (!isUsernameExist(username)) {
            System.out.println("USER DOES NOT EXIST");
        } else {
            accounts.removeIf(acc -> acc.getUsername().equals(username));
            System.out.println("USER DELETED");
        }
    }

    public UserAccount returnAccountWithUsername(String accUsername) {
        for (UserAccount acc : accounts) {
            if (Objects.equals(acc.getUsername(), accUsername)) {
                return acc;
            }
        }
        return null;
    }

    public UserAccount returnAccountWithBankID(String bankID) {
        for (UserAccount acc : accounts) {
            if (acc instanceof BankAccUser && Objects.equals(((BankAccUser) acc).getBankAccID(), bankID)) {
                return acc;
            }
        }
        return null;
    }
    public UserAccount returnAccountWithWalletNo(String walletNo) {
        for (UserAccount acc : accounts) {
            if (acc instanceof WalletUser && Objects.equals(((WalletUser) acc).getPhone(), walletNo)) {
                return acc;
            }
        }
        return null;
    }


    public ArrayList<UserAccount> getAccounts() {
        return accounts;
    }
}
