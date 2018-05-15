
package Test;

import AdminPage.AdminHome;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TestWindow extends javax.swing.JFrame {
    
    public TestWindow() {
        initComponents();
        showTest();
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
    public void insert(String description,int price,String conditions){
        connect();
        String query = "INSERT INTO test(description,price,conditions) VALUES('"+description+"','"+price+"','"+conditions+"')";
        try{
            st.executeUpdate(query);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void update(int id,String description,int price,String conditions){
        connect();
        String query = "UPDATE test SET description='"+description+"',price='"+price+"',conditions='"+conditions+"' WHERE testID LIKE'"+id+"'";
        try{
            st.executeUpdate(query);
            con.close();
        }catch(SQLException e){
            
        }
    }
    public void delete(int id){
        connect();
        String query = "DELETE FROM test WHERE testID='"+id+"'";
        try{
            st.executeUpdate(query);
            con.close();
            
        }catch(SQLException e){
            
        }
    }
    public void search(int id){
        connect();
        String query = "SELECT * FROM test WHERE wardID='"+id+"'";
        try{
            rs=st.executeQuery(query);
             
        }catch(SQLException e){
            
        }
    }

    public boolean checkInputs(){
        boolean x=true;
        if( tdes.getText().equalsIgnoreCase(""))
            x=false;
        
        return x;
    }
    
    public ArrayList<Test> getTestList(){
        ArrayList<Test> testList = new ArrayList<Test>();
        connect();
        String query= "SELECT * FROM test";
        try{
            rs = st.executeQuery(query);
            Test test;
            
            while(rs.next()){
                int id = rs.getInt("testId");
                String description=rs.getString("description");
                int price=rs.getInt("price");
                String conditions=rs.getString("conditions");

                test= new Test(id,description,price,conditions);
                testList.add(test);
            }    
        
        }catch(SQLException e){
        }
        return testList;
    
    }
    public void showTest(){
        ArrayList<Test> list = getTestList();
        DefaultTableModel model =(DefaultTableModel)TestTable.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[4];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getDescription();
            row[2]=list.get(i).getPrice();
            row[3]=list.get(i).getConditions();
   
            model.addRow(row);
        }
    
    }
    
    public void ShowTestDetails(int index){
        
        tid1.setText(Integer.toString(getTestList().get(index).getId()));
        tdes.setText(getTestList().get(index).getDescription());
        tprice.setText(Integer.toString(getTestList().get(index).getPrice()));
        tcond.setText(getTestList().get(index).getConditions());
        
    
    }
    public ArrayList<PatientTest> getPatientTestList(int patientid){
        ArrayList<PatientTest> testList = new ArrayList<PatientTest>();
        connect();
        String query= "SELECT * FROM patienttest WHERE patientID='"+patientid+"'";
        try{
            rs = st.executeQuery(query);
            PatientTest test;

            int c=0;
            if(patientid==0)
                c=1;
            while(rs.next()){
                int ptid = rs.getInt("patientID");
                int testid = rs.getInt("testID");
                String date=rs.getString("date");
                String result=rs.getString("result");

                test= new PatientTest(ptid,testid,date,result);
                testList.add(test);
                c++;
            }
            
            if(c==0)
                JOptionPane.showMessageDialog(null,"No Patient ID Found");
              
        
        }catch(SQLException e){
        }
        return testList;
    
    }
    public void showTestForPatient(int patientid){
        ArrayList<PatientTest> list = getPatientTestList(patientid);
        DefaultTableModel model =(DefaultTableModel)patientTestTable.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[3];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getTestId();
            row[1]=list.get(i).getDate();
            row[2]=list.get(i).getResult();
   
            model.addRow(row);
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tid1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tdes = new javax.swing.JTextField();
        tprice = new javax.swing.JTextField();
        tcond = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TestTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        TestAdd = new javax.swing.JButton();
        TestUpdate = new javax.swing.JButton();
        TestDelete = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        CloseTest = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tid2 = new javax.swing.JTextField();
        tdate = new com.toedter.calendar.JDateChooser();
        AddTestForPatient = new javax.swing.JButton();
        patientTestUpdate = new javax.swing.JButton();
        DeletePatientTest = new javax.swing.JButton();
        SearchPatientTest = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        tresult = new javax.swing.JTextField();
        clear2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        patientTestTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("BankGothic Md BT", 1, 36)); // NOI18N
        jLabel1.setText("Test Details");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel8.setText("Test ID:");

        tid1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        tid1.setEnabled(false);
        tid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tid1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel9.setText("Description:");

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel10.setText("Price:");

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel11.setText("Conditions:");

        tdes.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        tdes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdesActionPerformed(evt);
            }
        });

        tprice.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        tprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpriceActionPerformed(evt);
            }
        });

        tcond.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        tcond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcondActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tid1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(tdes)
                            .addComponent(tprice)
                            .addComponent(tcond)))
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tdes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TestTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test ID", "Description", "Price", "Conditions"
            }
        ));
        TestTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TestTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TestTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        TestAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TestAdd.setText("Add");
        TestAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestAddActionPerformed(evt);
            }
        });

        TestUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TestUpdate.setText("Update");
        TestUpdate.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TestUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestUpdateActionPerformed(evt);
            }
        });

        TestDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TestDelete.setText("Delete");
        TestDelete.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TestDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestDeleteActionPerformed(evt);
            }
        });

        Clear.setBackground(new java.awt.Color(204, 204, 204));
        Clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Clear.setText("Clear");
        Clear.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TestAdd)
                    .addComponent(TestDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TestUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(TestAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TestUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TestDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        CloseTest.setBackground(new java.awt.Color(153, 153, 153));
        CloseTest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CloseTest.setText("CLOSE");
        CloseTest.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        CloseTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(CloseTest)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CloseTest)
                        .addGap(14, 14, 14)))
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("BankGothic Md BT", 1, 36)); // NOI18N
        jLabel2.setText("Test for patients");
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        jLabel13.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel13.setText("Test ID:");

        jLabel14.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel14.setText("Date:");

        tid2.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        tid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tid2ActionPerformed(evt);
            }
        });

        AddTestForPatient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AddTestForPatient.setText("Add");
        AddTestForPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTestForPatientActionPerformed(evt);
            }
        });

        patientTestUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        patientTestUpdate.setText("Update");
        patientTestUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientTestUpdateActionPerformed(evt);
            }
        });

        DeletePatientTest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeletePatientTest.setText("Delete");
        DeletePatientTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletePatientTestActionPerformed(evt);
            }
        });

        SearchPatientTest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SearchPatientTest.setText("Search");
        SearchPatientTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchPatientTestActionPerformed(evt);
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

        clear2.setBackground(new java.awt.Color(255, 255, 255));
        clear2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clear2.setText("Clear");
        clear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear2ActionPerformed(evt);
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
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pid))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tid2)
                            .addComponent(tdate, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(tresult))))
                .addGap(51, 51, 51)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientTestUpdate)
                    .addComponent(AddTestForPatient)
                    .addComponent(DeletePatientTest)
                    .addComponent(SearchPatientTest)
                    .addComponent(clear2))
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddTestForPatient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(patientTestUpdate)
                        .addComponent(tid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeletePatientTest))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tresult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchPatientTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clear2)
                        .addContainerGap())))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        patientTestTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        patientTestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Test ID", "Date", "Result"
            }
        ));
        jScrollPane2.setViewportView(patientTestTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tid1ActionPerformed

    private void tdesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tdesActionPerformed

    private void tpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpriceActionPerformed

    private void tcondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcondActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcondActionPerformed

    private void TestAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestAddActionPerformed
        if(checkInputs()==true){
        
            String description= tdes.getText();
            int price= Integer.parseInt(tprice.getText());
            String conditions = tcond.getText();

           
            insert(description,price,conditions);            
            
            JOptionPane.showMessageDialog(null,"ADDED TEST");
            
            showTest();

            //tid1.setText("");
            tdes.setText("");
            tprice.setText("");
            tcond.setText("");
         
        }
        else  
            JOptionPane.showMessageDialog(null,"One or More Field are empty");
    }//GEN-LAST:event_TestAddActionPerformed

    private void TestUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestUpdateActionPerformed
        if(!tid1.getText().equalsIgnoreCase("")){
            int id = Integer.parseInt(tid1.getText());
            String description= tdes.getText();
            int price= Integer.parseInt(tprice.getText());
            String conditions = tcond.getText();
           
        
            update(id,description,price,conditions);
        
            JOptionPane.showMessageDialog(null,"Test is Updated");
            
            showTest();
            
            tid1.setText("");
            tdes.setText("");
            tprice.setText("");
            tcond.setText("");
        }
        else
            JOptionPane.showMessageDialog(null,"There are no TestID to UPDATE");
        
    }//GEN-LAST:event_TestUpdateActionPerformed

    private void TestDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestDeleteActionPerformed
        if(!tid1.getText().equalsIgnoreCase("")){
            
            int id = Integer.parseInt(tid1.getText());
            delete(id);
            
            showTest();
            
            JOptionPane.showMessageDialog(null,"Test is Deleted");
            
            tid1.setText("");
            tdes.setText("");
            tprice.setText("");
            tcond.setText("");
          
        }
        else
           JOptionPane.showMessageDialog(null,"There is no ID to delete");
    }//GEN-LAST:event_TestDeleteActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        tid1.setText("");
        tdes.setText("");
        tprice.setText("");
        tcond.setText("");
        showTest();
    }//GEN-LAST:event_ClearActionPerformed

    private void pidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pidActionPerformed

    private void tid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tid2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tid2ActionPerformed

    private void tresultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tresultActionPerformed

    private void TestTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestTableMouseClicked
        int index = TestTable.getSelectedRow();
        ShowTestDetails(index);
    }//GEN-LAST:event_TestTableMouseClicked

    private void AddTestForPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTestForPatientActionPerformed
        if(!pid.getText().equalsIgnoreCase("")&& !tid2.getText().equalsIgnoreCase("")){
            
            int patientid = Integer.parseInt(pid.getText());
            connect();
            String query1 = "SELECT * FROM patient WHERE patientID='"+patientid+"'";
            int x1=0;
            int x2=0;
            try{               
                rs=st.executeQuery(query1);
                int ptid = 0;
                while(rs.next()){                         
                 ptid = rs.getInt("patientID"); 
                }
                if(ptid==0)
                {
                    JOptionPane.showMessageDialog(null,"There are no PatientID that you entered in patient table");
                    x1=1;
                    //tid2.setText("");
                    //pid.setText("");
                    //tdate.setText("");
                    //tresult.setText("");
                }                          
                
            }catch(SQLException e){}
            
            int testid = Integer.parseInt(tid2.getText());
            if(x1==0){
            String query2= "SELECT * FROM test WHERE testID='"+testid+"'";
            try{
            rs = st.executeQuery(query2);  
            int id = 0;
            while(rs.next()){
                id = rs.getInt("testId");
            }
            if(id==0)
                {
                    JOptionPane.showMessageDialog(null,"There are no testID that you entered in test table");
                    x2=1;
                   // tid2.setText("");
                   // pid.setText("");
                    //tdate.setText("");
                   // tresult.setText("");
                }
            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
            }
            if(x1==0 && x2==0){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(tdate.getDate());
            String result= tresult.getText();
        
           // connect();
            String query = "INSERT INTO patienttest VALUES('"+patientid+"','"+testid+"','"+date+"','"+result+"')";
            try{
                st.executeUpdate(query);
                con.close();
            }catch(SQLException e){
            }
        
            JOptionPane.showMessageDialog(null,"ADDED TEST FOR PATIENT");
            
            tid2.setText("");
            pid.setText("");
            //tdate.setText("");
            tresult.setText("");
            }
        }
        else
            JOptionPane.showMessageDialog(null,"There are no TestID and PatientID to Add");
    }//GEN-LAST:event_AddTestForPatientActionPerformed

    private void patientTestUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientTestUpdateActionPerformed
        if(!pid.getText().equalsIgnoreCase("")&& !tid2.getText().equalsIgnoreCase("")){
            
            int patientid = Integer.parseInt(pid.getText());
            int testid = Integer.parseInt(tid2.getText());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateFormat.format(tdate.getDate());
            String result= tresult.getText();
                   
            connect();
            String query = "UPDATE patienttest SET date='"+date+"',result='"+result+"' WHERE patientID LIKE'"+patientid+"' AND testID='"+testid+"'";
            try{
                st.executeUpdate(query);
                con.close();
            }catch(SQLException e){
            
            }
        
            JOptionPane.showMessageDialog(null,"Patient's Test is Updated");
            
            tid2.setText("");
            pid.setText("");
            //tdate.setText("");
            tresult.setText("");
        }
        else
            JOptionPane.showMessageDialog(null,"There are no TestID and PatientID to Update");
    }//GEN-LAST:event_patientTestUpdateActionPerformed

    private void DeletePatientTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePatientTestActionPerformed
        if(!pid.getText().equalsIgnoreCase("")&& !tid2.getText().equalsIgnoreCase("")){
            
            int patientid = Integer.parseInt(pid.getText());
            int testid = Integer.parseInt(tid2.getText());
            
            connect();
            String query = "DELETE FROM patienttest WHERE patientID='"+patientid+"' AND testID='"+testid+"'";
            try{
               st.executeUpdate(query);
               con.close();
            
            }catch(SQLException e){
            
            }
            JOptionPane.showMessageDialog(null,"Patient's Test is Deleted");
            
            pid.setText("");
            tid2.setText("");
            tresult.setText("");              
        }
        else
            JOptionPane.showMessageDialog(null,"There are no TestID and PatientID to delete");

    }//GEN-LAST:event_DeletePatientTestActionPerformed

    private void SearchPatientTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchPatientTestActionPerformed
        if(!pid.getText().equalsIgnoreCase("")){
            int patientid = Integer.parseInt(pid.getText());
            
            showTestForPatient(patientid);
        }
        else
           JOptionPane.showMessageDialog(null,"There is no PatientID to Search");
    }//GEN-LAST:event_SearchPatientTestActionPerformed

    private void clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2ActionPerformed
        tid2.setText("");
        pid.setText("");
        //tdate.setText("");
        tresult.setText("");
        showTestForPatient(0);
    }//GEN-LAST:event_clear2ActionPerformed

    private void CloseTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseTestActionPerformed
        AdminHome x = new AdminHome();
        x.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CloseTestActionPerformed

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
            java.util.logging.Logger.getLogger(TestWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddTestForPatient;
    private javax.swing.JButton Clear;
    private javax.swing.JButton CloseTest;
    private javax.swing.JButton DeletePatientTest;
    private javax.swing.JButton SearchPatientTest;
    private javax.swing.JButton TestAdd;
    private javax.swing.JButton TestDelete;
    private javax.swing.JTable TestTable;
    private javax.swing.JButton TestUpdate;
    private javax.swing.JButton clear2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable patientTestTable;
    private javax.swing.JButton patientTestUpdate;
    private javax.swing.JTextField pid;
    private javax.swing.JTextField tcond;
    private com.toedter.calendar.JDateChooser tdate;
    private javax.swing.JTextField tdes;
    private javax.swing.JTextField tid1;
    private javax.swing.JTextField tid2;
    private javax.swing.JTextField tprice;
    private javax.swing.JTextField tresult;
    // End of variables declaration//GEN-END:variables
}
