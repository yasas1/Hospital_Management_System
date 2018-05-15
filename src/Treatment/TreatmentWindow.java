
package Treatment;

import AdminPage.AdminHome;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TreatmentWindow extends javax.swing.JFrame {

    public TreatmentWindow() {
        initComponents();
        showTreatment();
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
    public void insert(int patientid,String reason,String description,String result,String date){
        connect();
        String query = "INSERT INTO treatment(patientID,reason,description,result,date) VALUES('"+patientid+"','"+reason+"','"+description+"','"+result+"','"+date+"')";
        try{
            st.executeUpdate(query);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void update(int patientid,int treatmentNo,String reason,String description,String result,String date){
        connect();
        String query = "UPDATE treatment SET reason='"+reason+"', description='"+description+"',result='"+result+"',date='"+date+"' WHERE patientID ='"+patientid+"' AND  treatmentNo='"+treatmentNo+"' ";
        try{
            st.executeUpdate(query);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void delete(int id,int tno){
        connect();
        String query = "DELETE FROM treatment WHERE patientID='"+id+"' AND treatmentNo='"+tno+"'";
        try{
            st.executeUpdate(query);
            con.close();
            
        }catch(SQLException e){
            
        }
    }

    public boolean checkInputs(){
        boolean x=true;
        if( pid.getText().equalsIgnoreCase(""))
            x=false;
        
        return x;
    }
    public ArrayList<Treatment> getTreatmentList(){
        ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();
        connect();
        String query= "SELECT * FROM treatment";
        try{
            rs = st.executeQuery(query);
            Treatment treatment;
            
            while(rs.next()){
                int pid = rs.getInt("patientID");
                int treatno = rs.getInt("treatmentNo");
                String reason =rs.getString("reason");
                String des= rs.getString("description");
                String result=rs.getString("result");
                String date=rs.getString("date");
                

                treatment= new Treatment(pid,treatno,reason,des,result,date);
                treatmentList.add(treatment);
            }    
        
        }catch(SQLException e){
        }
        return treatmentList;
    
    }
    public void showTreatment(){
        ArrayList<Treatment> list = getTreatmentList();
        DefaultTableModel model =(DefaultTableModel)TreatmentTable.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[5];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getTreatNo();
            row[1]=list.get(i).getReason();
            row[2]=list.get(i).getDescription();
            row[3]=list.get(i).getResult();
            row[4]=list.get(i).getDate();
 
            model.addRow(row);
        }
    
    }
    
    public ArrayList<Treatment> getTreatmentList(int patientid){
        ArrayList<Treatment> treatmentList = new ArrayList<Treatment>();
        connect();
        String query= "SELECT * FROM treatment WHERE patientID='"+patientid+"'";
        try{
            rs = st.executeQuery(query);
            Treatment treatment;
            
            while(rs.next()){
                int pid = rs.getInt("patientId");
                int treatno = rs.getInt("treatmentNo");
                String reason =rs.getString("reason");
                String des= rs.getString("description");
                String result=rs.getString("result");
                String date=rs.getString("date");
                

                treatment= new Treatment(pid,treatno,reason,des,result,date);
                treatmentList.add(treatment);
            }    
        
        }catch(SQLException e){
        }
        return treatmentList;
    
    }
    public void showTreatment(int patientid){
        ArrayList<Treatment> list = getTreatmentList(patientid);
        DefaultTableModel model =(DefaultTableModel)TreatmentTable.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[5];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getTreatNo();
            row[1]=list.get(i).getReason();
            row[2]=list.get(i).getDescription();
            row[3]=list.get(i).getResult();
            row[4]=list.get(i).getDate();
   
            model.addRow(row);
        }
    }
    public void ShowTreatmentDetails(int index){
        
        tno.setText(Integer.toString(getTreatmentList().get(index).getTreatNo()));
        pid.setText(Integer.toString(getTreatmentList().get(index).getpatientId()));
        treason.setText(getTreatmentList().get(index).getReason());
        tdes.setText(getTreatmentList().get(index).getDescription());        
        tresult.setText(getTreatmentList().get(index).getResult());
        
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = getTreatmentList().get(index).getDate();
        try{
            java.util.Date addDate = dateFormat.parse(date);
            //System.out.println(addDate);
            tdate.setDate(addDate);
            
        }catch(ParseException ex){} 
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        AddTreatment = new javax.swing.JButton();
        treatmentUpdate = new javax.swing.JButton();
        DeleteTreatment = new javax.swing.JButton();
        SearchTreatment = new javax.swing.JButton();
        clear2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        treason = new javax.swing.JTextField();
        tdate = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        tresult = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tdes = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tno = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TreatmentTable = new javax.swing.JTable();
        CloseTreatment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel2.setText("Treatment");
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        AddTreatment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddTreatment.setText("ADD");
        AddTreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTreatmentActionPerformed(evt);
            }
        });

        treatmentUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        treatmentUpdate.setText("Update");
        treatmentUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treatmentUpdateActionPerformed(evt);
            }
        });

        DeleteTreatment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeleteTreatment.setText("Delete");
        DeleteTreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteTreatmentActionPerformed(evt);
            }
        });

        SearchTreatment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchTreatment.setText("Search");
        SearchTreatment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTreatmentActionPerformed(evt);
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
                    .addComponent(AddTreatment)
                    .addComponent(DeleteTreatment))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(treatmentUpdate)
                    .addComponent(SearchTreatment))
                .addGap(18, 18, 18)
                .addComponent(clear2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(treatmentUpdate)
                            .addComponent(AddTreatment))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DeleteTreatment)
                            .addComponent(SearchTreatment)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(clear2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel12.setText("Patient ID:");

        pid.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        pid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pidActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel14.setText("Date:");

        treason.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        treason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treasonActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel15.setText("Result:");

        tresult.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        tresult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresultActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel16.setText("Reason:");

        jLabel17.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel17.setText("Description:");

        tdes.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        tdes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdesActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel13.setText("TreatmentNo:");

        tno.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        tno.setEnabled(false);
        tno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnoActionPerformed(evt);
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
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tresult, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tdes, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(treason, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tno, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(treason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tdes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tresult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TreatmentTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TreatmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TreatmentNo", "Reason", "Description", "Result", "Date"
            }
        ));
        TreatmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TreatmentTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TreatmentTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(144, 144, 144)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(CloseTreatment)
                                .addGap(417, 417, 417))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CloseTreatment)
                .addGap(10, 10, 10))
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

    private void pidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pidActionPerformed

    private void treasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treasonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_treasonActionPerformed

    private void AddTreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTreatmentActionPerformed
        if(!pid.getText().equalsIgnoreCase("")){

            int patientid = Integer.parseInt(pid.getText());
            connect();
            String query1 = "SELECT * FROM patient WHERE patientID='"+patientid+"'";
            int x1=0;
            
            try{               
                rs=st.executeQuery(query1);
                int ptid = 0;
                while(rs.next()){                         
                 ptid = rs.getInt("patientID"); 
                }
                if(ptid==0)
                {
                    JOptionPane.showMessageDialog(null,"There are no PatientID that you entered in patient table");
                    tno.setText("");
                    pid.setText("");
                    tdes.setText("");
                    treason.setText("");
                     //tdate.setText("");
                    tresult.setText("");
                    x1=1;
                }                          
                
            }catch(SQLException e){}
            if(x1==0){
            String reason = treason.getText();
            String des= tdes.getText();
            String result= tresult.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(tdate.getDate());
            

            insert(patientid,reason,des,result,date);

            JOptionPane.showMessageDialog(null,"ADDED Treatment");
            
            showTreatment();

            tno.setText("");
            pid.setText("");
            tdes.setText("");
            treason.setText("");
            //tdate.setText("");
            tresult.setText("");
            }
        }
        else
            JOptionPane.showMessageDialog(null,"There is no PatientID to Add");
    }//GEN-LAST:event_AddTreatmentActionPerformed

    private void treatmentUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treatmentUpdateActionPerformed
        if(!pid.getText().equalsIgnoreCase("")&& !tno.getText().equalsIgnoreCase("")){

            int patientid = Integer.parseInt(pid.getText());
            int treatno = Integer.parseInt(tno.getText());
            String reason = treason.getText();
            String des= tdes.getText();
            String result= tresult.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(tdate.getDate());

            update(patientid,treatno,reason,des,result,date);

            JOptionPane.showMessageDialog(null,"Treatment is Updated");
            
            showTreatment();

            tno.setText("");
            pid.setText("");
            tdes.setText("");
            treason.setText("");
            //tdate.setText("");
            tresult.setText("");
        }
        else
            JOptionPane.showMessageDialog(null,"There are no TreatmentNo and PatientID to Update");
    }//GEN-LAST:event_treatmentUpdateActionPerformed

    private void DeleteTreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteTreatmentActionPerformed
        if(!pid.getText().equalsIgnoreCase("")&& !tno.getText().equalsIgnoreCase("")){

            int patientid = Integer.parseInt(pid.getText());
            int treatno = Integer.parseInt(tno.getText());

            delete(patientid,treatno);
            JOptionPane.showMessageDialog(null,"Treatment is Deleted");
            showTreatment();

            tno.setText("");
            pid.setText("");
            tdes.setText("");
            treason.setText("");
            //tdate.setText("");
            tresult.setText("");
        }
        else
            JOptionPane.showMessageDialog(null,"There are no TreatmentNo and PatientID to delete");
    }//GEN-LAST:event_DeleteTreatmentActionPerformed

    private void SearchTreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTreatmentActionPerformed
        if(!pid.getText().equalsIgnoreCase("")){
            int patientid = Integer.parseInt(pid.getText());
            showTreatment(patientid);
        }
        else
            JOptionPane.showMessageDialog(null,"There is no PatientID to Search");
    }//GEN-LAST:event_SearchTreatmentActionPerformed

    private void tresultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tresultActionPerformed

    private void clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2ActionPerformed
        tno.setText("");
        pid.setText("");
        tdes.setText("");
        treason.setText("");
        //tdate.setText("");
        tresult.setText("");
        showTreatment();
    }//GEN-LAST:event_clear2ActionPerformed

    private void tnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnoActionPerformed

    private void tdesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tdesActionPerformed

    private void CloseTreatmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseTreatmentActionPerformed
        AdminHome x = new AdminHome();
        x.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CloseTreatmentActionPerformed

    private void TreatmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TreatmentTableMouseClicked
        int index =TreatmentTable.getSelectedRow();
        ShowTreatmentDetails(index);
    }//GEN-LAST:event_TreatmentTableMouseClicked

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
            java.util.logging.Logger.getLogger(TreatmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TreatmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TreatmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TreatmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TreatmentWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddTreatment;
    private javax.swing.JButton CloseTreatment;
    private javax.swing.JButton DeleteTreatment;
    private javax.swing.JButton SearchTreatment;
    private javax.swing.JTable TreatmentTable;
    private javax.swing.JButton clear2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField pid;
    private com.toedter.calendar.JDateChooser tdate;
    private javax.swing.JTextField tdes;
    private javax.swing.JTextField tno;
    private javax.swing.JTextField treason;
    private javax.swing.JButton treatmentUpdate;
    private javax.swing.JTextField tresult;
    // End of variables declaration//GEN-END:variables
}
