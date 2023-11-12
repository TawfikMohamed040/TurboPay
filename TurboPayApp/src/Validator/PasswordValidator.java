package Validator;

public class PasswordValidator implements ValidatorSchema {
    @Override
    public boolean isValid(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";
        return password.matches(passwordRegex);
    }
}
