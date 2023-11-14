package Verifier;

import java.util.Random;

public class BankIDVerifier extends Verifier {
    @Override
    public void sendVerificationCode() {
        Random random = new Random();
        code = String.valueOf(1000 + random.nextInt(9000));
        System.out.println("Verification msg has been sent successfully "+ code);
    }
}
