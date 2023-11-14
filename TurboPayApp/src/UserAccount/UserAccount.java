package UserAccount;

import Bill.BillPayment;


public class UserAccount {
    private String username;
    private String password;
    private String email;
    private Integer balance;
    private String phone;
    public UserAccount(){
        this.balance=5000;
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
