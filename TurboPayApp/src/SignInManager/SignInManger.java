package SignInManager;

import API.DatabaseAPI;
import AccountDatabaseManger.*;
import UserAccount.UserAccount;



import java.util.Objects;

public class SignInManger {

    String username;
    String password;


    public boolean completeSignIn(){
        if(DatabaseAPI.accounts.isAccountExist(username, password)) {
            System.out.println("Signed in");
            return true;
        }else System.out.println("Account does not exist");
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


}
