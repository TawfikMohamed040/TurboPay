package Verifier;

import java.util.Objects;
import java.util.Random;

public class OTPSMSVerifier extends Verifier{

    @Override
    public void sendVerificationCode() {
        Random random = new Random();
        code = String.valueOf(1 + random.nextInt(50));
        System.out.println("OTP SMS has been sent successfully "+ code);
    }
}
