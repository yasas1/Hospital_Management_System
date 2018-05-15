
package Employee;


public class Consultant extends Employee {
    
    private final String specialty;
    private final String exp;

    public Consultant(int empid, String name, String gender, String address, String contactNo, String dob,String specialty,String exp) {
        super(empid, name, gender, address, contactNo, dob);
        this.specialty=specialty;
        this.exp=exp;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getExp() {
        return exp;
    }   
    
}
