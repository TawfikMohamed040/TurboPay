package Validator;

public class PhoneValidator implements ValidatorSchema{
    @Override
    public boolean isValid(String phone) {
        String phoneRegex = "01[0-9]{9}";
        return phone.matches(phoneRegex);
    }
}
