package Registration;

import API.DatabaseAPI;
import API.ValidatorAPI;
import UserAccount.UserAccount;
import UserAccount.UserFactory;
import Validator.EmailValidtor;
import Validator.PasswordValidator;
import Validator.PhoneValidator;
import Validator.UserNameValidator;

import java.util.Scanner;

public abstract class Registration {
//    private String username;
//    private String password;
//    private String email;
//    private String phone;
//    protected ValidatorSchema validator;
//    protected Verifier verifier;
    protected UserFactory userFactory;
    protected UserAccount account;
    Scanner scanner ;
    Registration(){
        userFactory = new UserFactory();
        scanner =new Scanner(System.in);
        account = new UserAccount();
    }
    public void setUser(int userType){
        account =  userFactory.makeUser(userType);
    }
    public void register(){
        setUsername();
        setPassword();
        setEmail();
        setPhone();
        completeRegistration();
    }

    public abstract void completeRegistration();
    public UserAccount returnUser(){

        return account;
    }
    public void setPassword() {
        ValidatorAPI.validator = new PasswordValidator();

        do {
            System.out.println("Please Enter a correct password : ");
            String input = scanner.nextLine();
            account.setPassword(input);
        } while (!ValidatorAPI.validator.isValid(account.getPassword()));
    }

    public void setEmail() {
        ValidatorAPI.validator = new EmailValidtor();

        do {
            System.out.println("Please Enter a correct Mail : ");
            String input = scanner.nextLine();
            account.setEmail(input);
        } while (!ValidatorAPI.validator.isValid(account.getEmail()));
    }

    public void setPhone() {
        ValidatorAPI.validator = new PhoneValidator();

        do {
            System.out.println("Please Enter a correct phone number : ");
            String input = scanner.nextLine();
            account.setPhone(input);
        } while (!ValidatorAPI.validator.isValid(account.getPhone()));
    }

    public void setUsername() {
        ValidatorAPI.validator = new UserNameValidator();
        do {
            System.out.println("Please Enter a correct username : ");
            String input = scanner.nextLine();
//            System.out.println(input);
            account.setUsername(input);
//            System.out.println(account.getUsername());
        } while (!ValidatorAPI.validator.isValid(account.getUsername()) || DatabaseAPI.accounts.isUsernameExist(account.getUsername()));
    }

}
