
package Employee;

import java.sql.*;
import java.util.ArrayList;

public class DbNurse {
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
    public void insertNurse(String name,String gender,String address,String contactNo,String dob,String grade,int wardid){
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
            String query2 = "INSERT INTO nurse VALUES('"+empid+"','"+grade+"','"+wardid+"')";
        
            
            st.executeUpdate(query2);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void updateNurse(int empid,String name,String gender,String address,String contactNo,String dob,String grade,int wardid){
        connect();
        String query1 = "UPDATE employee SET name='"+name+"',gender='"+gender+"',address='"+address+"',contactNo='"+contactNo+"',dob='"+dob+"' WHERE empID LIKE'"+empid+"'";
        String query2 = "UPDATE nurse SET grade='"+grade+"',wardID='"+wardid+"' WHERE empID='"+empid+"'";
        try{
            st.executeUpdate(query1);
            st.executeUpdate(query2);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void deleteNurse(int empid){
        connect();
        String query1 = "DELETE FROM employee WHERE empID='"+empid+"'";
        String query2 = "DELETE FROM nurse WHERE empID='"+empid+"'";
        try{
            st.executeUpdate(query1);
            st.executeUpdate(query2);
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
    
    public  ArrayList<Nurse> getNurseList(){
        connect();
        ArrayList<Nurse> nurseList = new ArrayList<Nurse>();
        //DbEmployee db = new DbEmployee();
        
        String query= "SELECT * FROM employee,nurse WHERE employee.empID=nurse.empID";
        try{
            
            rs= st.executeQuery(query);
            Nurse nurse;
            
            while(rs.next()){
                int empid = rs.getInt("empID");               
                String name=rs.getString("name");
                String gender=rs.getString("gender");               
                String address=rs.getString("address");
                String contactNo=rs.getString("contactNo");
                String dob=rs.getString("dob");
                String grade=rs.getString("grade");
                int wardid = rs.getInt("wardID");
                
                nurse= new Nurse(empid,name,gender,address,contactNo,dob,grade,wardid);
                nurseList.add(nurse);
            }    
        
        }catch(SQLException e){
        }
        return nurseList;
    }
    
}
