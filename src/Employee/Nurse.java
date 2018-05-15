
package Employee;


public class Nurse extends Employee {
    
    private final String grade;
    private final int wardid;

    public Nurse(int empid, String name, String gender, String address, String contactNo, String dob,String grade,int wardid) {
        super(empid, name, gender, address, contactNo, dob);
        this.grade=grade;
        this.wardid=wardid;
    }


    public String getGrade() {
        return grade;
    }

    public int getWardID() {
        return wardid;
    }
    
}
