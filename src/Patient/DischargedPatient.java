
package Patient;

import AdminPage.AdminHome;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DischargedPatient extends javax.swing.JFrame {

    
    public DischargedPatient() {
        initComponents();
        showDisPatient();
    }
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
    
    public ArrayList<DischargePatient> getDischargePatientList(){
        connect();
        ArrayList<DischargePatient> dispatientList = new ArrayList<DischargePatient>();
        connect();
        String query= "SELECT * FROM dischargedpatient";
        try{
            rs = st.executeQuery(query);
            DischargePatient dischargePatient;
            
            while(rs.next()){
                int id = rs.getInt("patientID");
                String name=rs.getString("name");
                
                int age=rs.getInt("age");
                String address=rs.getString("address");
                
                String pdisdate=rs.getString("dischargedDate");
                String pdate=rs.getString("admittedDate");
                int pWardID=rs.getInt("wardID");
                int pConsultantID=rs.getInt("consultantID");
                
        
                dischargePatient = new DischargePatient(id,name,age,address,pdate,pdisdate,pWardID,pConsultantID);
                dispatientList.add(dischargePatient);
            }    
        
        }catch(SQLException e){
        }
        return dispatientList;
    
    }
    
    public void showDisPatient(){
        
        ArrayList<DischargePatient> list = getDischargePatientList();
        DefaultTableModel model =(DefaultTableModel)DispatientsTable.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[8];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getName();
            row[2]=list.get(i).getAge();
            row[3]=list.get(i).getAddress();
            row[4]=list.get(i).getWardId();
            row[5]=list.get(i).getWardId();
            row[6]=list.get(i).getWardId();
            row[7]=list.get(i).getConsultantId();
            
            
            model.addRow(row);
        }
    
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DispatientsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ClosePatient = new javax.swing.JButton();
        patientDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        DispatientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Name", "Age", "Address", "Admitted Date", "Discharged Date", "Ward ID", "Consultant ID"
            }
        ));
        DispatientsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DispatientsTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(DispatientsTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Discharged patient");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        ClosePatient.setBackground(new java.awt.Color(102, 102, 102));
        ClosePatient.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        ClosePatient.setText("CLOSE");
        ClosePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClosePatientActionPerformed(evt);
            }
        });

        patientDelete.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        patientDelete.setText("Delete");
        patientDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(ClosePatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(patientDelete)
                        .addGap(44, 44, 44)
                        .addComponent(ClosePatient)
                        .addGap(156, 156, 156))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DispatientsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DispatientsTableMouseClicked
        //int index = DispatientsTable.getSelectedRow();
       // pid.setText(Integer.toString(d.getPatientList().get(index).getId()));
        //ShowPatientDetails(index);
    }//GEN-LAST:event_DispatientsTableMouseClicked

    private void ClosePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClosePatientActionPerformed
        AdminHome x = new AdminHome();
        x.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ClosePatientActionPerformed

    private void patientDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientDeleteActionPerformed
        int index=-1;
        index = DispatientsTable.getSelectedRow();
        if(index != -1){

            int id = getDischargePatientList().get(index).getId();
            connect();
            String query = "DELETE FROM dischargedpatient WHERE patientID='"+id+"'";
            try{
                st.executeUpdate(query);
                con.close();
            
            }catch(SQLException e){
            
            }
            JOptionPane.showMessageDialog(null,"Deleted");
            showDisPatient();            
        }
        else
            JOptionPane.showMessageDialog(null,"There is no selected ID to delete");

    }//GEN-LAST:event_patientDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(DischargedPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DischargedPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DischargedPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DischargedPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DischargedPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClosePatient;
    private javax.swing.JTable DispatientsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton patientDelete;
    // End of variables declaration//GEN-END:variables
}
