
package Employee;


public class JunDoctor extends Employee {
    
    private final String workField;
    

    public JunDoctor(int empid, String name, String gender, String address, String contactNo, String dob,String workField) {
        super(empid, name, gender, address, contactNo, dob);
        this.workField=workField;
        
    }

    public String getWorkField() {
        return workField;
    }
    
    
}
