
package Employee;

import java.sql.*;
import java.util.ArrayList;

public class DbJunDoctor {
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
    public void insert(String name,String gender,String address,String contactNo,String dob,String workfield){
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
            String query2 = "INSERT INTO junDoctor VALUES('"+empid+"','"+workfield+"')";
        
            
            st.executeUpdate(query2);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void update(int empid,String name,String gender,String address,String contactNo,String dob,String workfield){
        connect();
        String query1 = "UPDATE employee SET name='"+name+"',gender='"+gender+"',address='"+address+"',contactNo='"+contactNo+"',dob='"+dob+"' WHERE empID LIKE'"+empid+"'";
        String query2 = "UPDATE junDoctor SET workfield='"+workfield+"' WHERE empID='"+empid+"'";
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
        String query2 = "DELETE FROM junDoctor WHERE empID='"+empid+"'";
        try{
            st.executeUpdate(query1);
            st.executeUpdate(query2);
            con.close();
            
        }catch(SQLException e){
            
        }
    }
    
    public  ArrayList<JunDoctor> getJunDoctorList(){
        connect();
        ArrayList<JunDoctor> junDoctorList = new ArrayList<JunDoctor>();
        //DbEmployee db = new DbEmployee();
        
        String query= "SELECT * FROM employee,junDoctor WHERE employee.empID=junDoctor.empID";
        try{
            
            rs= st.executeQuery(query);
            JunDoctor junDoctor;
            
            while(rs.next()){
                int empid = rs.getInt("empID");                                
                String name=rs.getString("name");
                String gender=rs.getString("gender");               
                String address=rs.getString("address");
                String contactNo=rs.getString("contactNo");
                String dob=rs.getString("dob");
                String workfield=rs.getString("workfield");                
                
                junDoctor= new JunDoctor(empid,name,gender,address,contactNo,dob,workfield);
                junDoctorList.add(junDoctor);
            }    
        
        }catch(SQLException e){
        }
        return junDoctorList;
    }
    
}
