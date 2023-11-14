package UserAccountFunctionalites;

import Bill.BillPayment;
import Transaction.Transaction;
import UserAccount.UserAccount;

public class UserAccountFunctionalites {
    UserAccount userAccount;
    Transaction transaction;
    BillPayment billPayment;

    public UserAccountFunctionalites(UserAccount userAccount) {
        this.userAccount = userAccount;
        billPayment = new BillPayment();
    }

    public void payBill(String billType) {
        billPayment.pay(userAccount, billType);
    }

    public void inquireAboutBalance() {
        System.out.println("Balance : " + userAccount.getBalance());
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void transfer(int amount, String receiver) {
        this.transaction.transfer(amount, userAccount, receiver);
    }
}
