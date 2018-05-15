
package Employee;

import java.sql.*;
import java.util.ArrayList;

public class DbMaintainStaff {
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
    public void insert(String name,String gender,String address,String contactNo,String dob,String maintainType){
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
            String query2 = "INSERT INTO maintainStaff VALUES('"+empid+"','"+maintainType+"')";
        
            
            st.executeUpdate(query2);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void update(int empid,String name,String gender,String address,String contactNo,String dob,String maintainType){
        connect();
        String query1 = "UPDATE employee SET name='"+name+"',gender='"+gender+"',address='"+address+"',contactNo='"+contactNo+"',dob='"+dob+"' WHERE empID LIKE'"+empid+"'";
        String query2 = "UPDATE maintainStaff SET maintainType='"+maintainType+"' WHERE empID='"+empid+"'";
        try{
            st.executeUpdate(query1);
            st.executeUpdate(query2);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void delete(int empid){
        connect();
        String query1 = "DELETE FROM employee WHERE empID='"+empid+"'";
        String query2 = "DELETE FROM maintainStaff WHERE empID='"+empid+"'";
        try{
            st.executeUpdate(query1);
            st.executeUpdate(query2);
            con.close();
            
        }catch(SQLException e){
            
        }
    }
    
    public  ArrayList<MaintainStaff> getMaintainStaffList(){
        connect();
        ArrayList<MaintainStaff> maintainStaffList = new ArrayList<MaintainStaff>();
        
        
        String query= "SELECT * FROM employee,maintainStaff WHERE employee.empID=maintainStaff.empID";
        try{
            
            rs= st.executeQuery(query);
            MaintainStaff maintainStaff;
            
            while(rs.next()){
                int empid = rs.getInt("empID");                                
                String name=rs.getString("name");
                String gender=rs.getString("gender");               
                String address=rs.getString("address");
                String contactNo=rs.getString("contactNo");
                String dob=rs.getString("dob");
                String maintainType=rs.getString("maintainType");                
                
                maintainStaff= new MaintainStaff(empid,name,gender,address,contactNo,dob,maintainType);
                maintainStaffList.add(maintainStaff);
            }    
        
        }catch(SQLException e){
        }
        return maintainStaffList;
    }
    
}
