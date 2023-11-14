package Verifier;

import java.util.Random;

public class WalletVerifier extends Verifier {


    @Override
    public void sendVerificationCode() {
        Random random = new Random();
        code = String.valueOf(51 + random.nextInt(100));
        System.out.println("Verification msg has been sent successfully "+ code);
    }
}
