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

    }

    public void loadProfileBankUser(String username, String password) {

    }

    public void runApp() {
        while (true) {
            System.out.println("Welcome to TurboPay System!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int mainMenuOption = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (mainMenuOption) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Exiting Instapay System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private void registerUser() {
        // Implementation for user registration
        System.out.println("1.User Wallet Account\n -epay\n -tele\n -bank");
        System.out.println("2.Bank User");
        String userType = scanner.nextLine();
        userAccount = userFactory.makeUser(userType);
        if(userAccount instanceof WalletUser){
            registration = new WalletAccRegistration();
        }else {
            registration = new BankAccRegistration();
        }
        registration.register();
        userAccount = registration.returnUser(userType);
        accountDatabaseManger.addNewUser(userAccount);
    }

    private void loginUser() {
        
        System.out.println("Enter user type (1 for Wallet User, 2 for Bank User): ");
        int userType = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (userType) {
            case 1:
                showWalletUserMenu();
                break;
            case 2:
                showBankUserMenu();
                break;
            default:
                System.out.println("Invalid user type. Returning to the main menu.");
        }
    }

    private void showWalletUserMenu() {
        // Implementation for wallet user menu
        System.out.println("Wallet User menu logic goes here.");
    }

    private void showBankUserMenu() {
        // Implementation for bank user menu
        System.out.println("Bank User menu logic goes here.");
    }


//        registration = new BankAccRegistration();
////        while (true){
////            registration.register();
////            userAccount = registration.returnUser("epayWallet");
////            userAccount.payBill("gas");
//
//
//            BankAccUser userAccount = new BankAccUser();
//            BankAccUser userAccount2 = new BankAccUser();
//
//            userAccount.setBalance(0);
//            userAccount.setUsername("kareem");
//            userAccount.setPassword("K34243324%43.");
//
//            accountDatabaseManger.addNewUser(userAccount);
//            userAccount.payBill("gas");
//
////            userAccount2.setBalance(0);
////            userAccount2.setUsername("tawfik");
////            userAccount2.setPassword("K34243324%43.");
////            userAccount2.setBankAccID("123546");
////
////
////            accountDatabaseManger.addNewUser(userAccount2);
////
////            userAccount.transferToAcc(2000, "123546");
////
//            System.out.println("Kareem "+userAccount.getBalance());
////            System.out.println("Tawfik"+userAccount2.getBalance());
//
//
////            accountDatabaseManger.addNewUser(userAccount);
//
//
////            signInManger  = new SignInManger();
////            signInManger.setUsername("kareem");
////            signInManger.setPassword("Karrem446*");
////
////            signInManger.completeSignIn();
////        }
////        System.out.println("1.Register\n2.Signin\n");
}

