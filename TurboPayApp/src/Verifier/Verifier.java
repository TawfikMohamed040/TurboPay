package Verifier;

import java.util.Objects;

public abstract class Verifier {
    String code ;
    abstract public void sendVerificationCode();
     public boolean isVerified(String userCode){
         return (Objects.equals(userCode, code));
     };
}
