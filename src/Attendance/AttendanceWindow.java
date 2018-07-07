
package Attendance;


import AdminPage.AdminHome;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AttendanceWindow extends javax.swing.JFrame {

    public AttendanceWindow() {
        initComponents();
        showAttendance();
    }
    
    Connection con;
    Statement st;
    ResultSet rs;
   
    private void connect() {
        try{
            String driver="com.mysql.jdbc.Driver";
            Class.forName(driver);
            
            String url="jdbc:mysql://localhost:3306/hospital";
            con = DriverManager.getConnection(url,"root","");
            st = con.createStatement();
            

        }catch(ClassNotFoundException | SQLException ex){
            
        }     
    }
    public void insert(int empid, String status, int numofdays, String date){
        connect();
        String query = "INSERT INTO attendance(empID,status,numofdays,date) VALUES('"+empid+"','"+status+"','"+numofdays+"','"+date+"')";
        try{
            st.executeUpdate(query);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void update(int attNo, int empID, String status, int numofdays, String date){
        connect();
        String query = "UPDATE attendance SET status='"+status+"', numofdays='"+numofdays+"',date='"+date+"' WHERE empID ='"+empID+"' AND  attNo='"+attNo+"' ";
        try{
            st.executeUpdate(query);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void delete(int id,int attno){
        connect();
        String query = "DELETE FROM attendance WHERE empID='"+id+"' AND attNo='"+attno+"'";
        try{
            st.executeUpdate(query);
            con.close();
            
        }catch(SQLException e){
            
        }
    }

    public boolean checkInputs(){
        boolean x=true;
        if( eid.getText().equalsIgnoreCase(""))
            x=false;
        
        return x;
    }
    public ArrayList<Attendance> getAttendanceList(){
        ArrayList<Attendance> attendanceList = new ArrayList<Attendance>();
        connect();
        String query= "SELECT * FROM attendance";
        try{
            rs = st.executeQuery(query);
            Attendance attendance;
            
            while(rs.next()){
                int attno = rs.getInt("attNo");
                int eid = rs.getInt("empID");
                String status =rs.getString("status");
                int days= rs.getInt("numofdays");                
                String date=rs.getString("date");
                

                attendance= new Attendance(attno,eid,status,days,date);
                attendanceList.add(attendance);
            }    
        
        }catch(SQLException e){
        }
        return attendanceList;
    
    }
    public void showAttendance(){
        ArrayList<Attendance> list = getAttendanceList();
        DefaultTableModel model =(DefaultTableModel)AttendanceTable.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[5];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getAttNo();
            row[1]=list.get(i).getEmpID();
            row[2]=list.get(i).getStatus();
            row[3]=list.get(i).getNumofdays();
            row[4]=list.get(i).getDate();
 
            model.addRow(row);
        }
    
    }
    
    public ArrayList<Attendance> getAttendanceList(int empid){
        ArrayList<Attendance> attendanceList = new ArrayList<Attendance>();
        connect();
        String query= "SELECT * FROM attendance WHERE empID='"+empid+"'";
        try{
            rs = st.executeQuery(query);
            Attendance attendance;
            
            while(rs.next()){
                int attno = rs.getInt("attNo");
                int eid = rs.getInt("empID");
                String status =rs.getString("status");
                int days= rs.getInt("numofdays");                
                String date=rs.getString("date");
                

                attendance= new Attendance(attno,eid,status,days,date);
                attendanceList.add(attendance);
            }    
        
        }catch(SQLException e){
        }
        return attendanceList;
    
    }
    public void showAttendance(int patientid){
        ArrayList<Attendance> list = getAttendanceList(patientid);
        DefaultTableModel model =(DefaultTableModel)AttendanceTable.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[5];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getAttNo();
            row[1]=list.get(i).getEmpID();
            row[2]=list.get(i).getStatus();
            row[3]=list.get(i).getNumofdays();
            row[4]=list.get(i).getDate();
   
            model.addRow(row);
        }
    }
    public void ShowTreatmentDetails(int index){
        
        attno.setText(Integer.toString(getAttendanceList().get(index).getAttNo()));
        eid.setText(Integer.toString(getAttendanceList().get(index).getEmpID()));
        astatus.setText(getAttendanceList().get(index).getStatus());
        adays.setText(Integer.toString(getAttendanceList().get(index).getNumofdays()));        
        
        
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = getAttendanceList().get(index).getDate();
        try{
            java.util.Date addDate = dateFormat.parse(date);
            //System.out.println(addDate);
            adate.setDate(addDate);
            
        }catch(ParseException ex){} 
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        AddAttendance = new javax.swing.JButton();
        UpdateAttendance = new javax.swing.JButton();
        DeleteAttendance = new javax.swing.JButton();
        SearchAttendance = new javax.swing.JButton();
        clear2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        eid = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        astatus = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        adays = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        attno = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AttendanceTable = new javax.swing.JTable();
        CloseTreatment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel2.setText("Attendance");
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        AddAttendance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddAttendance.setText("ADD");
        AddAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAttendanceActionPerformed(evt);
            }
        });

        UpdateAttendance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UpdateAttendance.setText("Update");
        UpdateAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateAttendanceActionPerformed(evt);
            }
        });

        DeleteAttendance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeleteAttendance.setText("Delete");
        DeleteAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAttendanceActionPerformed(evt);
            }
        });

        SearchAttendance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchAttendance.setText("Search");
        SearchAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchAttendanceActionPerformed(evt);
            }
        });

        clear2.setBackground(new java.awt.Color(255, 255, 255));
        clear2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clear2.setText("Clear");
        clear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddAttendance)
                    .addComponent(DeleteAttendance))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateAttendance)
                    .addComponent(SearchAttendance))
                .addGap(18, 18, 18)
                .addComponent(clear2)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UpdateAttendance)
                            .addComponent(AddAttendance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DeleteAttendance)
                            .addComponent(SearchAttendance)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(clear2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel12.setText("Employee ID:");

        eid.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        eid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eidActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel14.setText("Date:");

        astatus.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        astatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                astatusActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel16.setText("Status:");

        jLabel17.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel17.setText("No of days:");

        adays.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        adays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaysActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel13.setText("AttendanceNo:");

        attno.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        attno.setEnabled(false);
        attno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(attno, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adays, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(astatus, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eid, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(astatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        AttendanceTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AttendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Att No", "Emp ID", "Status", "Num Of Days", "Date"
            }
        ));
        AttendanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AttendanceTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(AttendanceTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        CloseTreatment.setBackground(new java.awt.Color(102, 102, 102));
        CloseTreatment.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        CloseTreatment.setText("CLOSE");
        CloseTreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseTreatmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CloseTreatment)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 11, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseTreatment)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eidActionPerformed

    private void astatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_astatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_astatusActionPerformed

    private void AddAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAttendanceActionPerformed
        if(!eid.getText().equalsIgnoreCase("")){

            int empid = Integer.parseInt(eid.getText());
            String status = astatus.getText();
            int days = Integer.parseInt(adays.getText());
            String des= adays.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(adate.getDate());
            

            insert(empid,status,days,date);

            JOptionPane.showMessageDialog(null,"ADDED");
            
            showAttendance();

            attno.setText("");
            eid.setText("");
            adays.setText("");
            astatus.setText("");
            //tdate.setText("");
            
        }
        else
            JOptionPane.showMessageDialog(null,"There is no PatientID to Add");
    }//GEN-LAST:event_AddAttendanceActionPerformed

    private void UpdateAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateAttendanceActionPerformed
        if(!eid.getText().equalsIgnoreCase("")&& !attno.getText().equalsIgnoreCase("")){

            int attNo = Integer.parseInt(attno.getText());
            int empid = Integer.parseInt(eid.getText());
            String status = astatus.getText();
            int days = Integer.parseInt(adays.getText());
            String des= adays.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(adate.getDate());

            update(attNo,empid,status,days,date);

            JOptionPane.showMessageDialog(null,"Updated");
            
            showAttendance();

            attno.setText("");
            eid.setText("");
            adays.setText("");
            astatus.setText("");
            //tdate.setText("");
            
        }
        else
            JOptionPane.showMessageDialog(null,"There are no TreatmentNo and PatientID to Update");
    }//GEN-LAST:event_UpdateAttendanceActionPerformed

    private void DeleteAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAttendanceActionPerformed
        if(!eid.getText().equalsIgnoreCase("")&& !attno.getText().equalsIgnoreCase("")){

            int empid = Integer.parseInt(eid.getText());
            int attNo = Integer.parseInt(attno.getText());

            delete(empid,attNo);
            JOptionPane.showMessageDialog(null,"Deleted");
            showAttendance();

            attno.setText("");
            eid.setText("");
            adays.setText("");
            astatus.setText("");
            //tdate.setText("");
            
        }
        else
            JOptionPane.showMessageDialog(null,"There are no Attendance No and EmptID to delete");
    }//GEN-LAST:event_DeleteAttendanceActionPerformed

    private void SearchAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchAttendanceActionPerformed
        if(!eid.getText().equalsIgnoreCase("")){
            int empid = Integer.parseInt(eid.getText());
            showAttendance(empid);
        }
        else
            JOptionPane.showMessageDialog(null,"There is no EmpID to Search");
    }//GEN-LAST:event_SearchAttendanceActionPerformed

    private void clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2ActionPerformed
        attno.setText("");
        eid.setText("");
        adays.setText("");
        astatus.setText("");
        //tdate.setText("");
        
        showAttendance();
    }//GEN-LAST:event_clear2ActionPerformed

    private void attnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attnoActionPerformed

    private void adaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adaysActionPerformed

    private void CloseTreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseTreatmentActionPerformed
        AdminHome x = new AdminHome();
        x.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CloseTreatmentActionPerformed

    private void AttendanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AttendanceTableMouseClicked
        int index =AttendanceTable.getSelectedRow();
        ShowTreatmentDetails(index);
    }//GEN-LAST:event_AttendanceTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AttendanceWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendanceWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendanceWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendanceWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAttendance;
    private javax.swing.JTable AttendanceTable;
    private javax.swing.JButton CloseTreatment;
    private javax.swing.JButton DeleteAttendance;
    private javax.swing.JButton SearchAttendance;
    private javax.swing.JButton UpdateAttendance;
    private javax.swing.JTextField adays;
    private javax.swing.JTextField astatus;
    private javax.swing.JTextField attno;
    private javax.swing.JButton clear2;
    private javax.swing.JTextField eid;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
