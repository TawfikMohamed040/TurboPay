package TurboPayMainMenu;

import AccountDatabaseManger.*;
import Registration.*;
import SignInManager.SignInManger;
import UserAccount.*;

public class TurboPayMainMenu {
    private Registration registration;
    private SignInManger signInManger;
//    private UserAccount userAccount;
    public static final AccountRuntimeDatabase accountDatabaseManger = new AccountRuntimeDatabase();

    public void runApp(){
        registration = new BankAccRegistration();
//        while (true){
//            registration.register();
//            userAccount = registration.returnUser("epayWallet");
//            userAccount.payBill("gas");


            BankAccUser userAccount = new BankAccUser();
            BankAccUser userAccount2 = new BankAccUser();

            userAccount.setBalance(0);
            userAccount.setUsername("kareem");
            userAccount.setPassword("K34243324%43.");

            accountDatabaseManger.addNewUser(userAccount);
            userAccount.payBill("gas");

//            userAccount2.setBalance(0);
//            userAccount2.setUsername("tawfik");
//            userAccount2.setPassword("K34243324%43.");
//            userAccount2.setBankAccID("123546");
//
//
//            accountDatabaseManger.addNewUser(userAccount2);
//
//            userAccount.transferToAcc(2000, "123546");
//
            System.out.println("Kareem "+userAccount.getBalance());
//            System.out.println("Tawfik"+userAccount2.getBalance());


//            accountDatabaseManger.addNewUser(userAccount);


//            signInManger  = new SignInManger();
//            signInManger.setUsername("kareem");
//            signInManger.setPassword("Karrem446*");
//
//            signInManger.completeSignIn();
//        }
//        System.out.println("1.Register\n2.Signin\n");
    }
}
