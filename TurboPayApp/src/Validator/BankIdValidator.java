package Validator;

public class BankIdValidator implements ValidatorSchema{
    @Override
    public boolean isValid( String bankId) {
        String bankIDRegex = "^\\d{6}$";
        return bankId.matches(bankIDRegex);
    }
}