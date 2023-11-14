package TurboPayMainMenu;

import API.DatabaseAPI;
import AccountDatabaseManger.*;
import Bill.BillPayment;
import Registration.*;
import SignInManager.SignInManger;
import Transaction.TransactionToAcc;
import Transaction.TransactionToBankAcc;
import Transaction.TransactionToWallet;
import UserAccount.*;
import UserAccountFunctionalites.UserAccountFunctionalites;

import java.util.Scanner;

public class TurboPayMainMenu {
    private Registration registration;
    private SignInManger signInManger;
    Scanner scanner;
    private UserAccount userAccount;
    private UserAccountFunctionalites userAccFuncs;
    private UserFactory userFactory;

    public TurboPayMainMenu() {
        scanner = new Scanner(System.in);
        signInManger = new SignInManger();
//        userAccount = new BankAccUser();
        userFactory = new UserFactory();
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
                    System.out.println("Exiting TurboPay System. Goodbye!");
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
        if (userType != 4) {
            registration = new WalletAccRegistration();
        } else {
            registration = new BankAccRegistration();
        }
        registration.setUser(userType);
        registration.register();
        userAccount = registration.returnUser();
        DatabaseAPI.accounts.addNewUser(userAccount);
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

        userAccount = DatabaseAPI.accounts.returnAccountWithUsername(signInManger.getUsername());

        userAccFuncs = new UserAccountFunctionalites(userAccount) ;
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
                    payBillChoice();
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
                        payBillChoice();
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
        userAccFuncs.setTransaction(new TransactionToBankAcc());
        userAccFuncs.transfer(amount, bankID);
    }


    private void payBillChoice() {
        System.out.println("enter bill type");
        String billType = scanner.nextLine();
        userAccFuncs.payBill(billType);
    }

    private void inquireBalance() {
        userAccFuncs.inquireAboutBalance();
    }

    private void transferToAnotherAccount() {
        System.out.println("Please enter username");
        String username= scanner.nextLine();
        System.out.println("Please enter the amount");
        int amount = scanner.nextInt();
        userAccFuncs.setTransaction(new TransactionToAcc());
        userAccFuncs.transfer(amount, username);
    }

    private void transferToWallet() {
        System.out.println("Please enter the Phone Number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please enter the amount you want to transfer");
        int amount=scanner.nextInt();
        userAccFuncs.setTransaction(new TransactionToWallet());
       userAccFuncs.transfer(amount, phoneNumber);
    }
}
