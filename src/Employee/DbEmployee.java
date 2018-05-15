
package Employee;

import java.sql.*;
import java.util.ArrayList;

public class DbEmployee {
    Connection con;
    Statement st;
    ResultSet rs;
    
   
    public void connect(){
        try{
            String driver="com.mysql.jdbc.Driver";
            Class.forName(driver);
            
            String url="jdbc:mysql://localhost:3306/hospital";
            con = DriverManager.getConnection(url,"root","");
            st = con.createStatement();
            

        }catch(ClassNotFoundException | SQLException ex){
            
        }     
    }
    public void insertEmp(String name,String gender,String address,String contactNo,String dob){
        connect();
        String query = "INSERT INTO employee(name,gender,address,contactNo,dob) VALUES('"+name+"','"+gender+"','"+address+"','"+contactNo+"','"+dob+"')";
        try{
            st.executeUpdate(query);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void updateEmp(int empid,String name,String gender,String address,String contactNo,String dob){
        connect();
        String query = "UPDATE employee SET name='"+name+"',gender='"+gender+"',address='"+address+"',contactNo='"+contactNo+"',dob='"+dob+"' WHERE empID LIKE'"+empid+"'";
        try{
            st.executeUpdate(query);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void deleteEmp(int empid){
        connect();
        String query = "DELETE FROM employee WHERE empID='"+empid+"'";
        try{
            st.executeUpdate(query);
            con.close();
            
        }catch(SQLException e){
            
        }
    }
    public void search(int empid){
        connect();
        String query = "SELECT * FROM employee WHERE empID='"+empid+"'";
        try{
            rs=st.executeQuery(query);
             
        }catch(SQLException e){
            
        }
    }
    
    public  ArrayList<Employee> getEmployeeList(){
        connect();
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        //DbEmployee db = new DbEmployee();
        String query= "SELECT * FROM employee";
        try{
            rs = st.executeQuery(query);
            Employee employee;
            
            while(rs.next()){
                int empid = rs.getInt("empID");
                String name=rs.getString("name");
                String gender=rs.getString("gender");               
                String address=rs.getString("address");
                String contactNo=rs.getString("contactNo");
                String dob=rs.getString("dob");
                
                employee = new Employee(empid,name,gender,address,contactNo,dob);
                employeeList.add(employee);
            }    
        
        }catch(SQLException e){
        }
        return employeeList;
    }
    
}
