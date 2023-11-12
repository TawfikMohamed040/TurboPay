
package Validator;
public class WalletIDValidator implements ValidatorSchema {
    @Override
    public boolean isValid( String walletID) {
        String walletIDRegex = "^\\d{6}$";
        return walletID.matches(walletIDRegex);
    }
}
