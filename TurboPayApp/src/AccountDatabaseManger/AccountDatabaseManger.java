package AccountDatabaseManger;

import UserAccount.UserAccount;

public interface AccountDatabaseManger {
    public boolean isUsernameExist(String username);
    public boolean isAccountExist(String username, String password);
    public boolean isPasswordExist(String password);
    public boolean addNewUser(UserAccount account);
    public void deleteUser(String username);

}