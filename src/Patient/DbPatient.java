
package Patient;

import Employee.*;
import java.sql.*;
import java.util.ArrayList;

public class DbPatient {
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
    public void insert(String name,String gender,int age,String address,String contactNo,String recom,String pdate,int pWardID,int pConsultantID,int pDoctorID){
        connect();
        String query = "INSERT INTO patient(name,gender,age,address,contactNo,recommendation,admittedDate,wardID,consultantID,jdoctorID) VALUES('"+name+"','"+gender+"','"+age+"','"+address+"','"+contactNo+"','"+recom+"','"+pdate+"','"+pWardID+"','"+pConsultantID+"','"+pDoctorID+"')";
        try{
            st.executeUpdate(query);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void update(int id,String name,String gender,int age,String address,String contactNo,String recom,String pdate,int pWardID,int pConsultantID,int pDoctorID){
        connect();
        String query = "UPDATE patient SET name='"+name+"',gender='"+gender+"',age='"+age+"',address='"+address+"',contactNo='"+contactNo+"',recommendation='"+recom+"',admittedDate='"+pdate+"',wardID='"+pWardID+"',consultantID='"+pConsultantID+"',jdoctorID='"+pDoctorID+"' WHERE patientID LIKE'"+id+"'";
        try{
            st.executeUpdate(query);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void delete(int id){
        connect();
        String query = "DELETE FROM patient WHERE patientID='"+id+"'";
        try{
            st.executeUpdate(query);
            con.close();
            
        }catch(SQLException e){
            
        }
    }
    public void search(int id){
        connect();
        String query = "SELECT * FROM patient WHERE patientID='"+id+"'";
        try{
            rs=st.executeQuery(query);
            con.close();
        }catch(SQLException e){
            
        }
    }
    
    public ArrayList<Patient> getPatientList(){
        connect();
        ArrayList<Patient> patientList = new ArrayList<Patient>();
        connect();
        String query= "SELECT * FROM patient";
        try{
            rs = st.executeQuery(query);
            Patient patient;
            
            while(rs.next()){
                int id = rs.getInt("patientID");
                String name=rs.getString("name");
                String gender=rs.getString("gender");
                int age=rs.getInt("age");
                String address=rs.getString("address");
                String contactNo=rs.getString("contactNo");
                String recom=rs.getString("recommendation");
                String pdate=rs.getString("admittedDate");
                int pWardID=rs.getInt("wardID");
                int pConsultantID=rs.getInt("consultantID");
                int pDoctorID=rs.getInt("jdoctorID");
        
                patient = new Patient(id,name,gender,age,address,contactNo,recom,pdate,pWardID,pConsultantID,pDoctorID);
                patientList.add(patient);
            }    
        
        }catch(SQLException e){
        }
        return patientList;
    
    }
    
}
