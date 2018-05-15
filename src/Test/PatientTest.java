
package Test;

public class PatientTest {
    private int patientid;
    private int testid;
    private String date;
    private String result;


    
    public PatientTest(int patientid,int testid,String date,String result){
        this.patientid=patientid;
        this.testid=testid;
        this.date=date;
        this.result=result;
        
    }
    public int getPatientId(){
        return patientid;
    }
     public int getTestId(){
        return testid;
    }
    public String getDate(){
        return date;
    }
    public String getResult(){
        return result;
    }
    
}
