
package Patient;


public class DischargePatient {
    private final int id;
    private final String name;
    
    private final int age;
    private final String address;
    
    private final String dischargedDate;
    private final String admittedDate;
    private final int wardId;
    private final int consultantId;
    
    
    public DischargePatient(int pid,String pname,int page,String paddress,String padmittedDate,String dischargedDate,int pwardId,int pconsultantId){
        this.id=pid;
        this.name=pname;
        
        this.age=pid;
        this.address=paddress;
       
        this.dischargedDate=dischargedDate;
        this.admittedDate=padmittedDate;
        this.wardId=pwardId;
        this.consultantId=pconsultantId;
        
        
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    public String getAddress(){
        return address;
    }
    
    public int getWardId(){
        return wardId;
    }
    
    public String getAdmittedDate(){
        return admittedDate;
    }
    public int getConsultantId(){
        return consultantId;
    }

    public String getDischargedDate() {
        return dischargedDate;
    }
    
}
