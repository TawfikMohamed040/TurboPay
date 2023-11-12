package SignInManager;

import AccountDatabaseManger.AccountDatabaseManger;

public class SignInManger {
    AccountDatabaseManger ADM;
    String username;
    String password;

    public void signIn(){
        System.out.print("SIGNED IN");
    }
    public void completeSignIn(){
        System.out.println("USER FOUND");
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setADM(AccountDatabaseManger ADM) {
        this.ADM = ADM;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public AccountDatabaseManger getADM() {
        return ADM;
    }
}
