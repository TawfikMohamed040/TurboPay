package TurboPayMainMenu;

import AccountDatabaseManger.*;
import Registration.*;
import SignInManager.SignInManger;
import UserAccount.*;

import java.util.Scanner;

public class TurboPayMainMenu {
    private Registration registration;
    private SignInManger signInManger;
    Scanner scanner;
    private UserAccount userAccount;
    private UserFactory userFactory;

    public TurboPayMainMenu() {
        scanner = new Scanner(System.in);
        signInManger = new SignInManger();
        userAccount = new UserAccount();
        userFactory = new UserFactory();
    }

    public static final AccountRuntimeDatabase accountDatabaseManger = new AccountRuntimeDatabase();


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
        System.out.println("=================================================\n");
        System.out.println(">>User Wallet Account\n 1-epay\n 2-tele\n 3-bank");
        System.out.println(">>4.Bank User");
        int userType = scanner.nextInt();
        userAccount = userFactory.makeUser(userType);
        if (userAccount instanceof WalletUser) {
            registration = new WalletAccRegistration();
        } else {
            registration = new BankAccRegistration();
        }
        registration.setUser(userType);
        registration.register();
        userAccount = registration.returnUser();
        accountDatabaseManger.addNewUser(userAccount);
        System.out.println("=================================================\n");
    }

    private void loginUser() {
        System.out.println("=================================================\n");

        do {
            System.out.println("Enter username");
            signInManger.setUsername(scanner.nextLine());
            System.out.println("Enter password");
            signInManger.setPassword(scanner.nextLine());
            // Consume the newline character
            scanner.nextLine();
        } while (!signInManger.completeSignIn());

        userAccount = accountDatabaseManger.returnAccount(signInManger.getUsername());

        if (userAccount instanceof WalletUser) {
            System.out.println("=================================================\n");
            showWalletUserMenu();
        } else {
            System.out.println("=================================================\n");
            showBankUserMenu();
        }
    }


    private void showWalletUserMenu() {
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("Wallet user menu");
            System.out.println("1. Transfer to wallet");
            System.out.println("2. Transfer to another acc");
            System.out.println("3. Inquire about balance");
            System.out.println("4. Pay bill");
            System.out.println("5. Back to main menu");
            System.out.println("-----------------------------");

            int walletUserOption = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (walletUserOption) {
                case 1:
                    transferToWallet();
                    break;
                case 2:
                    transferToAnotherAccount();
                    break;
                case 3:
                    inquireBalance();
                    break;
                case 4:
                    payBill();
                    break;
                case 5:
                    runApp();
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

        private void showBankUserMenu () {
            while (true) {
                System.out.println("-----------------------------");
                System.out.println("Bank user menu");
                System.out.println("1. Transfer to wallet");
                System.out.println("2. Transfer to another acc");
                System.out.println("3. Transfer to another bank acc");
                System.out.println("4. Inquire about balance");
                System.out.println("5. Pay bill");
                System.out.println("6. Back to main menu");
                System.out.println("-----------------------------");

                int BankUserOption = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (BankUserOption) {
                    case 1:
                        transferToWallet();
                        break;
                    case 2:
                        transferToAnotherAccount();
                        break;
                    case 3:
                        transferToAnotherBankAccount();
                        break;
                    case 4:
                        inquireBalance();
                        break;
                    case 5:
                        payBill();
                        break;
                    case 6:
                        runApp();
                        return;
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                }
            }
        }

    private void transferToAnotherBankAccount() {
        System.out.println("Please enter Bank ID");
        String bankID= scanner.nextLine();
        System.out.println("Please enter the amount");
        int amount = scanner.nextInt();
        ((BankAccUser)userAccount).transferToBankAcc( amount, bankID);
    }


    private void payBill() {
        System.out.println("enter bill type");
        String billType = scanner.nextLine();
        userAccount.payBill(billType);
    }

    private void inquireBalance() {
        System.out.println("Current Balance : "  + userAccount.getBalance());
    }

    private void transferToAnotherAccount() {
        System.out.println("Please enter username");
        String username= scanner.nextLine();
        System.out.println("Please enter the amount");
        int amount = scanner.nextInt();
        userAccount.transferToAcc( amount, username);
    }

    private void transferToWallet() {
        System.out.println("Please enter the Phone Number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please enter the amount you want to transfer");
        int amount=scanner.nextInt();
        userAccount.transferToWallet(amount,phoneNumber);
    }
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