package Bill;

import java.util.Date;

public abstract class Bill {
    String ID;
    int cost ;
    String customerName;
    Date date ;
    boolean isPaid ;

    abstract protected void billInfo();

    public Date getDate() {
        return date;
    }

    public int getCost() {
        return cost;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getID() {
        return ID;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
