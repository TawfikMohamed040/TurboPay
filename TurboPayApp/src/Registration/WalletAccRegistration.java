package Registration;

import API.*;
import UserAccount.*;
import Validator.WalletIDValidator;
import Verifier.WalletVerifier;

public class WalletAccRegistration extends  Registration{
    String walletID;
    @Override
    public void completeRegistration() {
        ValidatorAPI.validator = new WalletIDValidator();

        do {
            System.out.println("Please Enter a correct wallet id  : ");
            this.walletID = scanner.nextLine();
        } while (! ValidatorAPI.validator.isValid(walletID));

        VerifierAPI.verifier = new WalletVerifier();
        String userMsg;

        do {
            VerifierAPI.verifier.sendVerificationCode();
            System.out.println("Please enter the correct verification code");
            userMsg = scanner.nextLine();
        } while (!VerifierAPI.verifier.isVerified(userMsg));
        ((WalletUser)account).setWalletID(walletID);
    }


}
