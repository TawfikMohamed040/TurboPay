package Registration;
import UserAccount.*;
import Validator.*;
import Verifier.*;

import java.util.Scanner;

public abstract class Registration {
    private String username;
    private String password;
    private String email;
    private String phone;
    protected ValidatorSchema validator;
    protected Verifier verifier;
    protected UserFactory userFactory;
    Scanner scanner ;
    Registration(){
        scanner =new Scanner(System.in);
    }
    public void register(){
        setUsername();
        setPassword();
        setEmail();
        setPhone();
        completeRegistration();
    }

    public abstract void completeRegistration();
    public UserAccount returnUser(String userType){
        UserAccount account =  userFactory.makeUser(userType);
        account.setEmail(email);
        account.setPassword(password);
        account.setPhone(phone);
        account.setUsername(username);
        return account;
    }
    public void setPassword() {
        validator = new PasswordValidator();

        do {
            System.out.println("Please Enter a correct password : ");
            this.password = scanner.nextLine();
        } while (!validator.isValid(password));
    }

    public void setEmail() {
        validator = new EmailValidtor();

        do {
            System.out.println("Please Enter a correct Mail : ");
            this.email = scanner.nextLine();
        } while (!validator.isValid(email));
    }

    public void setPhone() {
        validator = new PhoneValidator();

        do {
            System.out.println("Please Enter a correct phone number : ");
            this.phone = scanner.nextLine();
        } while (!validator.isValid(phone));
    }

    public void setUsername() {
        validator = new UserNameValidator();

        do {
            System.out.println("Please Enter a correct username : ");
            this.username = scanner.nextLine();
        } while (!validator.isValid(username));
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }
}
