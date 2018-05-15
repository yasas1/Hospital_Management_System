
package Employee;

import java.sql.*;
import java.util.ArrayList;

public class DbConsultant {
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
    public void insertConsultant(String name,String gender,String address,String contactNo,String dob,String specialty,String exp){
        connect();
        try{
            String query1 = "INSERT INTO employee(name,gender,address,contactNo,dob) VALUES('"+name+"','"+gender+"','"+address+"','"+contactNo+"','"+dob+"')";
            st.executeUpdate(query1);
            String quary="SELECT empID FROM employee";
            rs=st.executeQuery(quary);
            int empid = 0 ;
            while(rs.next()){
                empid=rs.getInt(1);
            }
            String query2 = "INSERT INTO consultant VALUES('"+empid+"','"+specialty+"','"+exp+"')";
        
            
            st.executeUpdate(query2);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void updateConsultant(int empid,String name,String gender,String address,String contactNo,String dob,String specialty,String exp){
        connect();
        String query1 = "UPDATE employee SET name='"+name+"',gender='"+gender+"',address='"+address+"',contactNo='"+contactNo+"',dob='"+dob+"' WHERE empID LIKE'"+empid+"'";
        String query2 = "UPDATE consultant SET specialty='"+specialty+"',experiences='"+exp+"' WHERE empID='"+empid+"'";
        try{
            st.executeUpdate(query1);
            st.executeUpdate(query2);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void deleteConsultant(int empid){
        connect();
        String query1 = "DELETE FROM employee WHERE empID='"+empid+"'";
        String query2 = "DELETE FROM consultant WHERE empID='"+empid+"'";
        try{
            st.executeUpdate(query1);
            st.executeUpdate(query2);
            con.close();
            
        }catch(SQLException e){
            
        }
    }
    
    public  ArrayList<Consultant> getConsultantList(){
        connect();
        ArrayList<Consultant> consultantList = new ArrayList<Consultant>();
        //DbEmployee db = new DbEmployee();
        
        String query= "SELECT * FROM employee,consultant WHERE employee.empID=consultant.empID";
        try{
            
            rs= st.executeQuery(query);
            Consultant consultant;
            
            while(rs.next()){
                int empid = rs.getInt("empID");                                
                String name=rs.getString("name");
                String gender=rs.getString("gender");               
                String address=rs.getString("address");
                String contactNo=rs.getString("contactNo");
                String dob=rs.getString("dob");
                String specialty=rs.getString("specialty");
                String exp=rs.getString("experiences");
                
                consultant= new Consultant(empid,name,gender,address,contactNo,dob,specialty,exp);
                consultantList.add(consultant);
            }    
        
        }catch(SQLException e){
        }
        return consultantList;
    }
    
}
