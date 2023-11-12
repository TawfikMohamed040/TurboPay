package AccountDatabaseManger;

import UserAccount.UserAccount;

import java.util.ArrayList;

public class AccountRuntimeDatabase implements AccountDatabaseManger {

    ArrayList<UserAccount> accounts;

    @Override
    public boolean isUsernameExist(String username) {
        return false;
    }

    @Override
    public boolean isAccountExist(String username, String password) {
        return false;
    }

    @Override
    public boolean isPasswordExist(String password) {
        return false;
    }

    @Override
    public boolean addNewUser(UserAccount account) {
        accounts.add(account);
        return false;
    }
    @Override
    public void deleteUser(String username) {
//        accounts.remove(username);
    }


}
