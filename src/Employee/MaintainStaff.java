
package Employee;


public class MaintainStaff extends Employee {
    
    private final String mtype;
    

    public MaintainStaff(int empid, String name, String gender, String address, String contactNo, String dob,String mtype) {
        super(empid, name, gender, address, contactNo, dob);
        this.mtype=mtype;
        
    }

    public String getMtype() {
        return mtype;
    }
  
}
