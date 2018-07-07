

package Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ConsultantWindow extends javax.swing.JFrame {

    /** Creates new form ConsultantWindow */
    public ConsultantWindow() {
        initComponents();
        showConsultant();
    }
    
    public boolean checkInputs(){
        boolean x=true;
        if( ename.getText().equalsIgnoreCase(""))
            x=false;
        
        return x;
    }
    
    public void showConsultant(){
        DbConsultant d = new DbConsultant();
        ArrayList<Consultant> list = d.getConsultantList();
        DefaultTableModel model =(DefaultTableModel)consultantTable.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[4];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getEmpId();
            row[1]=list.get(i).getName();
            row[2]=list.get(i).getSpecialty();
            row[3]=list.get(i).getExp();
            
            model.addRow(row);
        }
    
    }
    public void ShowConsultantDetails(int index){
        DbConsultant d = new DbConsultant();
        eid.setText(Integer.toString(d.getConsultantList().get(index).getEmpId()));
        ename.setText(d.getConsultantList().get(index).getName());
        egender.setSelectedItem(d.getConsultantList().get(index).getGender());        
        eaddress.setText(d.getConsultantList().get(index).getAddress());
        econtact.setText(d.getConsultantList().get(index).getContactNo());
        cspec.setText(d.getConsultantList().get(index).getSpecialty());
        cexp.setText(d.getConsultantList().get(index).getExp());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = d.getConsultantList().get(index).getDOB();
        try{
            java.util.Date addDate = dateFormat.parse(date);
            //System.out.println(addDate);
            edob.setDate(addDate);
            
        }catch(ParseException ex){
        }     
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        egender = new javax.swing.JComboBox<>();
        ename = new javax.swing.JTextField();
        eid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        econtact = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cspec = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cexp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        eaddress = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        consultantTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        RegConsultant = new javax.swing.JButton();
        UpdateConsultant = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        DeleteConsultant = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        nurseCloseButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 510));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel2.setText("Employee ID:");

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel4.setText("Date of Birth:");

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel5.setText("Gender:");

        jLabel6.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel6.setText("Address:");

        egender.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        egender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        ename.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        ename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enameActionPerformed(evt);
            }
        });

        eid.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        eid.setEnabled(false);
        eid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eidActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel7.setText("Contact No:");

        econtact.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        econtact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                econtactActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel8.setText("Specialty:");

        cspec.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        cspec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cspecActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel10.setText("Experience:");

        cexp.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        cexp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cexpActionPerformed(evt);
            }
        });

        eaddress.setColumns(20);
        eaddress.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        eaddress.setRows(5);
        jScrollPane1.setViewportView(eaddress);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eid, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(ename))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(egender, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(econtact, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cspec, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cexp, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 26, Short.MAX_VALUE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(egender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(econtact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cspec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cexp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        consultantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp ID", "Name", "Specialty", "Experiences"
            }
        ));
        consultantTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultantTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(consultantTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Employee/user (2).png"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 204))); // NOI18N

        RegConsultant.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        RegConsultant.setText("Register");
        RegConsultant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegConsultantActionPerformed(evt);
            }
        });

        UpdateConsultant.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        UpdateConsultant.setText("Update");
        UpdateConsultant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateConsultantActionPerformed(evt);
            }
        });

        Clear.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        DeleteConsultant.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        DeleteConsultant.setText("Delete");
        DeleteConsultant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteConsultantActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegConsultant)
                    .addComponent(UpdateConsultant, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteConsultant, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(RegConsultant, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpdateConsultant, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteConsultant, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 204))); // NOI18N

        nurseCloseButton.setBackground(new java.awt.Color(102, 102, 102));
        nurseCloseButton.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        nurseCloseButton.setText("Close");
        nurseCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nurseCloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nurseCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nurseCloseButton)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 36)); // NOI18N
        jLabel1.setText("Consultant's Details");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enameActionPerformed

    private void eidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eidActionPerformed

    private void econtactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_econtactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_econtactActionPerformed

    private void cexpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cexpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cexpActionPerformed

    private void cspecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cspecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cspecActionPerformed

    private void UpdateConsultantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateConsultantActionPerformed
        if(!eid.getText().equalsIgnoreCase("")&&checkInputs()){
            int empid = Integer.parseInt(eid.getText());
            String name= ename.getText();
            String gender = egender.getSelectedItem().toString();
            String address = eaddress.getText();
            String contactNo = econtact.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String edate = dateFormat.format(edob.getDate());  
            String spec = cspec.getText();
            String exp = cexp.getText();
            
            DbConsultant d = new DbConsultant();
            d.updateConsultant(empid, name, gender, address, contactNo, edate,spec,exp);
        
            JOptionPane.showMessageDialog(null,"Updated");
        
            showConsultant();
            
            eid.setText("");
            ename.setText("");
            egender.setSelectedItem("");
            eaddress.setText("");
            econtact.setText("");
            cspec.setText("");
            cexp.setText("");
        }
        else
           JOptionPane.showMessageDialog(null,"There is no ID to UPDATE");
    }//GEN-LAST:event_UpdateConsultantActionPerformed

    private void nurseCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nurseCloseButtonActionPerformed
        EmployeeWindow c =new EmployeeWindow();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nurseCloseButtonActionPerformed

    private void RegConsultantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegConsultantActionPerformed
        if(checkInputs()==true){
        
            String name= ename.getText();
            String gender = egender.getSelectedItem().toString();            
            String address = eaddress.getText();
            String contactNo = econtact.getText();           
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String edate= dateFormat.format(edob.getDate());
            String spec = cspec.getText();
            String exp = cexp.getText();
            
            DbConsultant d = new DbConsultant();
            d.insertConsultant(name,gender,address,contactNo,edate,spec,exp);            
            
            JOptionPane.showMessageDialog(null,"Registered");
            
            showConsultant();
            
            eid.setText("");
            ename.setText("");
            egender.setSelectedItem("");
            eaddress.setText("");
            econtact.setText("");
            cspec.setText("");
            cexp.setText("");
                    
        }
        else  
            JOptionPane.showMessageDialog(null,"One or More Field are empty");
    }//GEN-LAST:event_RegConsultantActionPerformed

    private void consultantTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultantTableMouseClicked
        int index = consultantTable.getSelectedRow();
        ShowConsultantDetails(index);
    }//GEN-LAST:event_consultantTableMouseClicked

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        eid.setText("");
        ename.setText("");
        egender.setSelectedItem("");
        eaddress.setText("");
        econtact.setText("");
        cspec.setText("");
        cexp.setText("");
    }//GEN-LAST:event_ClearActionPerformed

    private void DeleteConsultantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteConsultantActionPerformed
       /* if(!eid.getText().equalsIgnoreCase("")){
            
            int empid = Integer.parseInt(eid.getText());

            DbConsultant d = new DbConsultant();
            d.deleteConsultant(empid);

            JOptionPane.showMessageDialog(null,"Deleted");
            
            showConsultant();
            
            eid.setText("");
            ename.setText("");
            egender.setSelectedItem("");
            eaddress.setText("");
            econtact.setText("");
            cspec.setText("");
            cexp.setText("");
        }
        else
           JOptionPane.showMessageDialog(null,"There is no ID to delete"); */
    }//GEN-LAST:event_DeleteConsultantActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultantWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultantWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultantWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultantWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultantWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton DeleteConsultant;
    private javax.swing.JButton RegConsultant;
    private javax.swing.JButton UpdateConsultant;
    private javax.swing.JTextField cexp;
    private javax.swing.JTable consultantTable;
    private javax.swing.JTextField cspec;
    private javax.swing.JTextArea eaddress;
    private javax.swing.JTextField econtact;
    private javax.swing.JComboBox<String> egender;
    private javax.swing.JTextField eid;
    private javax.swing.JTextField ename;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JButton nurseCloseButton;
    // End of variables declaration//GEN-END:variables

}
