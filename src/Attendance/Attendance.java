
package Attendance;

public class Attendance {
      
    private int attNo;
    private int empID;
    private String status;
    private int numofdays;
    private String date;

    public Attendance(int attNo, int empID, String status, int numofdays, String date) {
        this.attNo = attNo;
        this.empID = empID;
        this.status = status;
        this.numofdays = numofdays;
        this.date = date;
    }

    public int getAttNo() {
        return attNo;
    }

    public int getEmpID() {
        return empID;
    }

    public String getStatus() {
        return status;
    }

    public int getNumofdays() {
        return numofdays;
    }

    public String getDate() {
        return date;
    }
   
}
