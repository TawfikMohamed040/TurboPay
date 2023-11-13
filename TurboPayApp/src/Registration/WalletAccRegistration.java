package Registration;

import UserAccount.*;
import Validator.WalletIDValidator;
import Verifier.BankIDVerifier;
import Verifier.WalletVerifier;

public class WalletAccRegistration extends  Registration{
    String walletID;
    @Override
    public void completeRegistration() {
        validator = new WalletIDValidator();

        do {
            System.out.println("Please Enter a correct wallet id  : ");
            this.walletID = scanner.nextLine();
        } while (!validator.isValid(walletID));

        verifier = new WalletVerifier();
        String userMsg;

        do {
            verifier.sendVerificationCode();
            System.out.println("Please enter the correct verification code");
            userMsg = scanner.nextLine();
        } while (!verifier.isVerified(userMsg));
        ((WalletUser)account).setWalletID(walletID);
    }


}
