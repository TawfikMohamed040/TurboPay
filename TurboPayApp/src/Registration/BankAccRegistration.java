package Registration;

import API.ValidatorAPI;
import API.VerifierAPI;
import UserAccount.BankAccUser;
import Validator.BankIdValidator;
import Verifier.BankIDVerifier;

import java.util.Scanner;

public class BankAccRegistration extends Registration {
    String BankAccID;

    @Override
    public void completeRegistration() {
        ValidatorAPI.validator = new BankIdValidator();
        do {
            System.out.println("Please Enter a correct Bank ID:");
            BankAccID = scanner.nextLine();
        } while (!ValidatorAPI.validator.isValid(BankAccID));

        System.out.println("BANK USER COMPLETED REGISTRATION");

        VerifierAPI.verifier = new BankIDVerifier();
        VerifierAPI.verifier.sendVerificationCode();
        String userMsg = "";
        do {
            System.out.println("Please enter the correct verification code:");
            userMsg = scanner.nextLine();
        } while (!VerifierAPI.verifier.isVerified(userMsg));
        ((BankAccUser) account).setBankAccID(BankAccID);
    }
}