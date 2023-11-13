package SignInManager;

import AccountDatabaseManger.*;

import java.util.Objects;

public class SignInManger {

    String username;
    String password;

    public void completeSignIn( ){
        if(Objects.equals(AccountRuntimeDatabase.accounts.get(0).getUsername(), "kareem")) {
            System.out.println("Signed in");
        }else System.out.println("Account does not exist");
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
