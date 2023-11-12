package AccountDatabaseManger;

import UserAccount.UserAccount;

import java.util.ArrayList;

public class AccountRuntimeDatabase implements AccountDatabaseManger {

    ArrayList<UserAccount> accounts;

    @Override
    public boolean isUsernameExist(String username) {
        for (UserAccount acc:accounts) {
            if(acc.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isAccountExist(String username, String password) {
        for (UserAccount acc:accounts) {
            if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPasswordExist(String password) {
        for (UserAccount acc:accounts) {
            if(acc.getPassword().equals(password)){
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
        if(!isUsernameExist(username)){
            System.out.println("USER DOES NOT EXIST");
        }else {
            accounts.removeIf(acc -> acc.getUsername().equals(username));
            System.out.println("USER DELETED");
        }
    }


}
