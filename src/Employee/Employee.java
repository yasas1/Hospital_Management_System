
package Employee;

import java.sql.*;
import java.util.ArrayList;


public class Employee {
    int empid;
    String name;
    String gender;
    String address;
    String contactNo;
    String dob;
           
    public Employee(int empid,String name,String gender,String address,String contactNo,String dob){
        this.empid=empid;
        this.name=name;
        this.gender=gender;       
        this.address=address;
        this.contactNo=contactNo;
        this.dob=dob;        
    }
    public int getEmpId(){
        return empid;
    }
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
   
    public String getAddress(){
        return address;
    }
    public String getContactNo(){
        return contactNo;
    }
    public String getDOB(){
        return dob;
    }
    
    
    
   
}
