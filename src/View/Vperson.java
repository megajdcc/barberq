/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerClient;
import Controller.ControllerEmployee;
import Controller.ControllerMeeting;
import Controller.ControllerPerson;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.edisoncor.gui.panel.Panel;

/**
 *
 * @author Jnatn'h
 */
public class Vperson extends javax.swing.JDialog {
    //Field de Class
    private ControllerPerson controller;
    private ControllerEmployee controller1;
    private ControllerMeeting controller3;
    private ControllerClient controller2;
    public void setController(ControllerPerson controller){
        this.controller = controller;
        setListener(controller);
    }
    public ControllerPerson getController(){
        return controller;
    }
    public void setListener(ControllerPerson controller){
        
        getTextsearch().addKeyListener(controller);
        nuevo.addActionListener(controller);
        catperson.addMouseListener(controller);
    }
    
     public void setListener(ControllerEmployee controller){
        getTextsearch().addKeyListener(controller);
        nuevo.addActionListener(controller);
        catperson.addMouseListener(controller);
    }
    public void setListener(ControllerClient controller){
        getTextsearch().addKeyListener(controller);
        nuevo.addActionListener(controller);
        catperson.addMouseListener(controller);
    }
    public void setListener(ControllerMeeting controller){
        getTextsearch().addKeyListener(controller);
        nuevo.addActionListener(controller);
        catperson.addMouseListener(controller);
    }
    public void setController1(ControllerEmployee control){
        this.controller1 = control;
        setListener(controller1);
    }
    public ControllerEmployee getController1(){
        return controller1;
    }
    public void setController(ControllerClient control){
        this.controller2 = control;
        setListener(controller2);
    }
    public ControllerClient getController2(){
        return controller2;
    }
    public void setController(ControllerMeeting controller){
        this.controller3 = controller;
        setListener(controller3);
    }
    public ControllerMeeting getController3(){
        return controller3;
    }
     //Getters y setters
    public JTextField getTextsearch() {
        return Textsearch;
    }    

    public void setTextsearch(JTextField Textsearch) {
        this.Textsearch = Textsearch;
    }

    public JTable getCatperson() {
        return catperson;
    }

    public void setCatperson(JTable catperson) {
        this.catperson = catperson;
    }

    public JButton getExit() {
        return exit;
    }

    public void setExit(JButton exit) {
        this.exit = exit;
    }

    public JLabel getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(JLabel leyenda) {
        this.leyenda = leyenda;
    }

    public JButton getNuevo() {
        return nuevo;
    }

   
    public void setNuevo(JButton nuevo) {
        this.nuevo = nuevo;
    }

    public Panel getHeader() {
        return header;
    }

    public void setHeader(Panel header) {
        this.header = header;
    }

    /**
     * Creates new form Vperson
     * @param parent
     * @param modal
     */
    public Vperson(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Persons");
        setResizable(false);
        setLocationRelativeTo(null);
        
         setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cat = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        center = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Textsearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        cent = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        catperson = new javax.swing.JTable();
        footer = new javax.swing.JPanel();
        leyenda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        cat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/fondo.png"))); // NOI18N
        cat.setMaximumSize(new java.awt.Dimension(440, 451));
        cat.setPreferredSize(new java.awt.Dimension(440, 451));
        cat.setLayout(new java.awt.BorderLayout());

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/vperson.jpg"))); // NOI18N
        header.setMaximumSize(new java.awt.Dimension(464, 75));
        header.setOpaque(false);
        header.setPreferredSize(new java.awt.Dimension(464, 75));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cat.add(header, java.awt.BorderLayout.NORTH);

        center.setOpaque(false);
        center.setLayout(new java.awt.BorderLayout(0, 10));

        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(442, 40));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 2));

        Textsearch.setForeground(new java.awt.Color(0, 0, 0));
        Textsearch.setPreferredSize(new java.awt.Dimension(400, 37));
        Textsearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextsearchFocusGained(evt);
            }
        });
        Textsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextsearchKeyTyped(evt);
            }
        });
        jPanel2.add(Textsearch);

        center.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(448, 30));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/new.png"))); // NOI18N
        nuevo.setBorderPainted(false);
        nuevo.setContentAreaFilled(false);
        nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nuevo.setFocusPainted(false);
        nuevo.setMinimumSize(new java.awt.Dimension(150, 30));
        nuevo.setPreferredSize(new java.awt.Dimension(150, 30));
        nuevo.setRolloverEnabled(true);
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(nuevo);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/exit.png"))); // NOI18N
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setFocusPainted(false);
        exit.setPreferredSize(new java.awt.Dimension(150, 30));
        exit.setRolloverEnabled(true);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit);

        center.add(jPanel1, java.awt.BorderLayout.SOUTH);

        cent.setOpaque(false);
        cent.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 403));

        catperson.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        catperson.setForeground(new java.awt.Color(0, 0, 0));
        catperson.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Dni", "Name", "Last name "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        catperson.setToolTipText("Users");
        catperson.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        catperson.setOpaque(false);
        catperson.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                catpersonKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                catpersonKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(catperson);

        cent.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        center.add(cent, java.awt.BorderLayout.CENTER);

        cat.add(center, java.awt.BorderLayout.CENTER);

        footer.setBackground(new java.awt.Color(0, 102, 255));
        footer.setOpaque(false);
        footer.setPreferredSize(new java.awt.Dimension(0, 30));
        footer.setLayout(new java.awt.BorderLayout());

        leyenda.setFont(new java.awt.Font("Serif", 2, 14)); // NOI18N
        leyenda.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(leyenda, java.awt.BorderLayout.CENTER);

        cat.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(cat, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextsearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextsearchFocusGained
        String leyend = "Search for the corresponding person";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_TextsearchFocusGained

    private void TextsearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextsearchKeyTyped
//       
    }//GEN-LAST:event_TextsearchKeyTyped

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed

    }//GEN-LAST:event_nuevoActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
      //  getController().getModel().conexionClosed();
       this.setVisible(false);
    }//GEN-LAST:event_exitActionPerformed

    private void catpersonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_catpersonKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_catpersonKeyReleased

    private void catpersonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_catpersonKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_catpersonKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Textsearch;
    private org.edisoncor.gui.panel.Panel cat;
    private javax.swing.JTable catperson;
    private javax.swing.JPanel cent;
    private javax.swing.JPanel center;
    private javax.swing.JButton exit;
    private javax.swing.JPanel footer;
    private org.edisoncor.gui.panel.Panel header;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel leyenda;
    private javax.swing.JButton nuevo;
    // End of variables declaration//GEN-END:variables
}
