package Validator;

public class UserNameValidator implements ValidatorSchema {
    @Override
    public boolean isValid(String name) {
        String nameRegex = "^[a-zA-Z]+([\\s][a-zA-Z]+)*$";
        return name.matches(nameRegex);
    }
}
