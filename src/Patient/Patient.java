
package Patient;


public class Patient {
    private final int id;
    private final String name;
    private final String gender;
    private final int age;
    private final String address;
    private final String contactNo;
    private final String recommendation;
    private final String admittedDate;
    private final int wardId;
    private final int consultantId;
    private final int docId;
    
    public Patient(int pid,String pname,String pgender,int page,String paddress,String pcontactNo,String precommendation,String padmittedDate,int pwardId,int pconsultantId,int pdocId){
        this.id=pid;
        this.name=pname;
        this.gender=pgender;
        this.age=pid;
        this.address=paddress;
        this.contactNo=pcontactNo;
        this.recommendation=precommendation;
        this.admittedDate=padmittedDate;
        this.wardId=pwardId;
        this.consultantId=pconsultantId;
        this.docId=pdocId;
        
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public int getAge(){
        return age;
    }
    public String getAddress(){
        return address;
    }
    public String getContactNo(){
        return contactNo;
    }
    public int getWardId(){
        return wardId;
    }
    public String getRecommendation(){
        return recommendation;
    }
    public String getAdmittedDate(){
        return admittedDate;
    }
    public int getConsultantId(){
        return consultantId;
    }
    public int getDocId(){
        return docId;
    }
}
