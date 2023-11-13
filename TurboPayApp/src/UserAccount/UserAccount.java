package UserAccount;

import Bill.BillPayment;
import Bill.WaterBill;
import TurboPayMainMenu.*;

import java.util.Objects;

import static TurboPayMainMenu.TurboPayMainMenu.accountDatabaseManger;

public class UserAccount {
    private String username;
    private String password;
    private String email;
    private Integer balance;
    private String phone;
    private BillPayment billPayment;
    public UserAccount(){
        this.balance=5000;
    }




    public void transferToWallet(int amount , String phoneNumber){
        if(balance < amount){
            System.out.println("Balance is not enough");
            return;
        }

        for(UserAccount acc:accountDatabaseManger.getAccounts()){
            if(acc instanceof WalletUser && Objects.equals(((WalletUser) acc).getPhone(), phoneNumber)){
                acc.setBalance(acc.getBalance() + amount);
                this.setBalance(this.getBalance() - amount);
                System.out.println("Transaction Done :)");

                return;
            }
        }
        System.out.println("User Not Exist");
    }
    public void transferToAcc(int amount, String accUsername){
        if(balance < amount){
            System.out.println("Balance is not enough");
            return;
        }

        for(UserAccount acc:accountDatabaseManger.getAccounts()){
            if(Objects.equals(acc.getUsername(), accUsername)){
                acc.setBalance(acc.getBalance() + amount);
                this.setBalance(this.getBalance() - amount);
                System.out.println("Transaction Done :)");

                return;
            }
        }
        System.out.println("User Not Exist");
    }
    public void payBill(String billType){
        billPayment = new BillPayment();
        billPayment.setBillType(billType);
        billPayment.getBill().setCustomerName(username);
        if (balance < billPayment.getBill().getCost()){
            billPayment.getBill().setPaid(false);
            System.out.println("There is no enough balance");
        }
        else {
            billPayment.getBill().setPaid(true);
            balance -= billPayment.getBill().getCost();
        }
        billPayment.pay();
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }
}
