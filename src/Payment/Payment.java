
package Payment;


public class Payment {
    private final int id;
    private final int patientID;
    private final String paymentFor;
    private final int amount;
    private final String paymethod;
    private final String date;

    
    public Payment(int payid,int pid,String paymentfor,int amount,String paymethod,String date){
        this.id=payid;
        this.patientID=pid;
        this.paymentFor=paymentfor;
        this.amount=amount;
        this.paymethod=paymethod;
        this.date=date;
    }
    public int getPayId(){
        return id;
    }
    public int getPatientId(){
        return patientID;
    }
    public String getPaymentFor(){
        return paymentFor;
    }

    public int getAmount(){
        return amount;
    }
    public String getPayMethod(){
        return paymethod;
    }
    public String getDate(){
        return date;
    }
}
