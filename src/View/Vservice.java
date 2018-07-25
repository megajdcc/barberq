/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import Controller.ControllerService;
import javax.swing.JButton;
/**
 *
 * @author Jnatn'h
 */
public class Vservice extends javax.swing.JDialog {

    private ControllerService controller;
    
    public void setController(ControllerService controller){
        this.controller = controller;
        setListener();
    }
    public ControllerService getController(){
        return controller;
    }
    private void setListener(){
        nuevo.addActionListener(controller);
        Textbusqueda.addKeyListener(controller);
        catservice.addMouseListener(controller);
    }

    public JTextField getTextbusqueda() {
        return Textbusqueda;
    }

    public void setTextbusqueda(JTextField Textbusqueda) {
        this.Textbusqueda = Textbusqueda;
    }

    public JTable getCatservice() {
        return catservice;
    }

    public void setCatservice(JTable catservice) {
        this.catservice = catservice;
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
    
    
    /**
     * Creates new form Vservice
     * @param parent
     * @param modal
     */
    public Vservice(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Services");
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
        Textbusqueda = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        cent = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        catservice = new javax.swing.JTable();
        footer = new javax.swing.JPanel();
        leyenda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        cat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/fondo.png"))); // NOI18N
        cat.setMaximumSize(new java.awt.Dimension(440, 451));
        cat.setPreferredSize(new java.awt.Dimension(440, 451));
        cat.setLayout(new java.awt.BorderLayout());

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/Service.jpg"))); // NOI18N
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

        Textbusqueda.setForeground(new java.awt.Color(0, 0, 0));
        Textbusqueda.setPreferredSize(new java.awt.Dimension(400, 37));
        Textbusqueda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextbusquedaFocusGained(evt);
            }
        });
        Textbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextbusquedaKeyTyped(evt);
            }
        });
        jPanel2.add(Textbusqueda);

        center.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(448, 30));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/new.png"))); // NOI18N
        nuevo.setBorderPainted(false);
        nuevo.setContentAreaFilled(false);
        nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nuevo.setFocusPainted(false);
        nuevo.setMaximumSize(new java.awt.Dimension(150, 30));
        nuevo.setMinimumSize(new java.awt.Dimension(150, 30));
        nuevo.setPreferredSize(new java.awt.Dimension(150, 30));
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
        exit.setMaximumSize(new java.awt.Dimension(150, 30));
        exit.setMinimumSize(new java.awt.Dimension(150, 30));
        exit.setPreferredSize(new java.awt.Dimension(150, 30));
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

        catservice.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        catservice.setForeground(new java.awt.Color(0, 0, 0));
        catservice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Service", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        catservice.setToolTipText("Users");
        catservice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        catservice.setOpaque(false);
        catservice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                catserviceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                catserviceKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(catservice);

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

    private void TextbusquedaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextbusquedaFocusGained
        String leyend = "Look for the service you want";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_TextbusquedaFocusGained

    private void TextbusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextbusquedaKeyTyped
        //
    }//GEN-LAST:event_TextbusquedaKeyTyped

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed

    }//GEN-LAST:event_nuevoActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        //  getController().getModel().conexionClosed();
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void catserviceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_catserviceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_catserviceKeyReleased

    private void catserviceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_catserviceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_catserviceKeyTyped

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Textbusqueda;
    private org.edisoncor.gui.panel.Panel cat;
    private javax.swing.JTable catservice;
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
