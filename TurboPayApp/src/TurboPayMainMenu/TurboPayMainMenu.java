package TurboPayMainMenu;

import AccountDatabaseManger.*;
import Registration.*;
import SignInManager.SignInManger;
import UserAccount.UserAccount;

public class TurboPayMainMenu {
    private Registration registration;
    private SignInManger signInManger;
    private UserAccount userAccount;
//    private AccountDatabaseManger accountDatabaseManger;


    public void runApp(){
        registration = new BankAccRegistration();

//        System.out.println("1.Register\n2.Signin\n");
        registration.register();
        userAccount = registration.returnUser("bank");
//        userAccount.payBill("gas");
//        AccountRuntimeDatabase.accounts(userAccount);

        signInManger  = new SignInManger();
        signInManger.setUsername("kareem");
        signInManger.setPassword("Karrem446*");
        signInManger.completeSignIn();
    }
}
