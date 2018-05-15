
package Treatment;

public class Treatment {
    private int patientid;    
    private int treatno;
    private String reason;
    private String description;
    private String result;
    private String date;
    
    public Treatment(int patientid,int treatno,String reason,String description,String result,String date){
        this.patientid=patientid;
        this.treatno=treatno;
        this.reason=reason;
        this.description=description;
        this.result=result;
        this.date=date;   
    }
    public int getpatientId(){
        return patientid;
    }
    public int getTreatNo(){
        return treatno;
    }
    public String getReason(){
        return reason;
    }
    public String getDescription(){
        return description;
    }
    public String getResult(){
        return result;
    }
    public String getDate(){
        return date;
    }    
}
