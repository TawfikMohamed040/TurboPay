package Bill;

public class WaterBill extends Bill {

    @Override
    protected void billInfo() {
        System.out.println("WATER BILL");
        System.out.println("Date : "+ date);
        System.out.println("Customer name :"+ customerName);
        if(!isPaid){
            System.out.println("Not paid yet");
        }else{
            System.out.println("Paid successfully");
        }
        System.out.println("WATER USED THIS MONTH >> 3239 litters");
        System.out.println("Price : "+cost);
    }
}
