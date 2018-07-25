/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerReport;
import Controller.ControllerReportIncome;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import datechooser.beans.DateChooserPanel;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Jnatn'h
 */
public class Income extends javax.swing.JDialog {
    private ControllerReportIncome controller;
    
    public void setController(ControllerReportIncome controller){
        this.controller = controller;
        setListener();
    }
    public ControllerReportIncome getController(){
        return controller;
    }
    private void setListener(){
        process.addActionListener(controller);
        print.addActionListener(controller);
        day.addActionListener(controller);
        month.addActionListener(controller);
        rank.addActionListener(controller);   
    }
    public JRadioButton getDay() {
        return day;
    }

    public void setDay(JRadioButton day) {
        this.day = day;
    }

    public ButtonGroup getFilter() {
        return filter;
    }

    public void setFilter(ButtonGroup filter) {
        this.filter = filter;
    }

    public JButton getProcess() {
        return process;
    }

    public void setProcess(JButton grabar) {
        this.process = grabar;
    }

    public JRadioButton getMonth() {
        return month;
    }

    public void setMonth(JRadioButton month) {
        this.month = month;
    }

    public DateChooserPanel getCalendarRank() {
        return calendarrank;
    }

    public void setCalendarRank(DateChooserPanel rank) {
        this.calendarrank = rank;
    }

   

    public JYearChooser getYear() {
        return year;
    }

    public void setYear(JYearChooser year) {
        this.year = year;
    }

    
    public JLabel getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(JLabel leyenda) {
        this.leyenda = leyenda;
    }

    public JRadioButton getRank() {
        return rank;
    }

    public void setRank(JRadioButton rank) {
        this.rank = rank;
    }

    public JButton getPrint() {
        return print;
    }

    public void setPrint(JButton print) {
        this.print = print;
    }

    public JMonthChooser getSemonth() {
        return semonth;
    }

    public void setSemonth(JMonthChooser semonth) {
        this.semonth = semonth;
    }

    /**
     * Creates new form income
     * @param parent
     * @param modal
     */
    public Income(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Income Report");
        setLocationRelativeTo(null);
        setResizable(false);
        setController(new ControllerReportIncome(this));
        GregorianCalendar fech = new GregorianCalendar();
        
        getCalendarRank().setMaxDate(fech);
        getYear().setEndYear(fech.get(Calendar.YEAR));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filter = new javax.swing.ButtonGroup();
        panel1 = new org.edisoncor.gui.panel.Panel();
        header = new org.edisoncor.gui.panel.Panel();
        cent = new javax.swing.JPanel();
        LDinam = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        calendarrank = new datechooser.beans.DateChooserPanel();
        day = new javax.swing.JRadioButton();
        month = new javax.swing.JRadioButton();
        year = new com.toedter.calendar.JYearChooser();
        rank = new javax.swing.JRadioButton();
        semonth = new com.toedter.calendar.JMonthChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Lopciones = new javax.swing.JPanel();
        print = new javax.swing.JButton();
        process = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        footer = new javax.swing.JPanel();
        leyenda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        panel1.setMaximumSize(new java.awt.Dimension(737, 504));
        panel1.setMinimumSize(new java.awt.Dimension(737, 273));
        panel1.setPreferredSize(new java.awt.Dimension(737, 352));
        panel1.setLayout(new java.awt.BorderLayout());

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/incomereport.jpg"))); // NOI18N
        header.setMaximumSize(new java.awt.Dimension(737, 75));
        header.setMinimumSize(new java.awt.Dimension(737, 75));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        panel1.add(header, java.awt.BorderLayout.NORTH);

        cent.setOpaque(false);
        cent.setLayout(new java.awt.BorderLayout());

        LDinam.setPreferredSize(new java.awt.Dimension(683, 100));

        jLabel1.setText("Filter By:");

        calendarrank.setEnabled(false);

        filter.add(day);
        day.setText("Day");
        day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayActionPerformed(evt);
            }
        });

        filter.add(month);
        month.setText("Monthly");

        filter.add(rank);
        rank.setText("Rank");

        semonth.setEnabled(false);
        semonth.setPreferredSize(new java.awt.Dimension(150, 24));

        jLabel2.setText("Month:");

        jLabel3.setText("Year:");

        javax.swing.GroupLayout LDinamLayout = new javax.swing.GroupLayout(LDinam);
        LDinam.setLayout(LDinamLayout);
        LDinamLayout.setHorizontalGroup(
            LDinamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LDinamLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(LDinamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LDinamLayout.createSequentialGroup()
                        .addGroup(LDinamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(LDinamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LDinamLayout.createSequentialGroup()
                                .addComponent(day)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(month)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rank))
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(semonth, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(calendarrank, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        LDinamLayout.setVerticalGroup(
            LDinamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LDinamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LDinamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calendarrank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LDinamLayout.createSequentialGroup()
                        .addGroup(LDinamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LDinamLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1))
                            .addGroup(LDinamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(day)
                                .addComponent(month)
                                .addComponent(rank)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LDinamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(semonth, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LDinamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        cent.add(LDinam, java.awt.BorderLayout.CENTER);

        Lopciones.setPreferredSize(new java.awt.Dimension(450, 40));

        print.setBackground(new java.awt.Color(102, 102, 102));
        print.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/print.png"))); // NOI18N
        print.setText("Print");
        print.setToolTipText("");
        print.setBorderPainted(false);
        print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print.setEnabled(false);
        print.setIconTextGap(10);
        print.setPreferredSize(new java.awt.Dimension(150, 30));
        print.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                printFocusGained(evt);
            }
        });
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        Lopciones.add(print);

        process.setBackground(new java.awt.Color(102, 102, 102));
        process.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N
        process.setForeground(new java.awt.Color(255, 255, 255));
        process.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/img/report.png"))); // NOI18N
        process.setText("To Show");
        process.setBorderPainted(false);
        process.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        process.setEnabled(false);
        process.setMaximumSize(new java.awt.Dimension(150, 30));
        process.setMinimumSize(new java.awt.Dimension(150, 30));
        process.setPreferredSize(new java.awt.Dimension(150, 30));
        process.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                processFocusGained(evt);
            }
        });
        Lopciones.add(process);

        exit.setBackground(new java.awt.Color(102, 102, 102));
        exit.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("Exit");
        exit.setBorderPainted(false);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setPreferredSize(new java.awt.Dimension(150, 30));
        exit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                exitFocusGained(evt);
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        Lopciones.add(exit);

        cent.add(Lopciones, java.awt.BorderLayout.SOUTH);

        panel1.add(cent, java.awt.BorderLayout.CENTER);

        footer.setPreferredSize(new java.awt.Dimension(450, 32));
        footer.setLayout(new java.awt.BorderLayout());

        leyenda.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        leyenda.setForeground(new java.awt.Color(0, 0, 0));
        footer.add(leyenda, java.awt.BorderLayout.CENTER);

        panel1.add(footer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayActionPerformed

    private void printFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_printFocusGained
        String leyend = "Print Report";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_printFocusGained

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printActionPerformed

    private void processFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_processFocusGained
        String leyend = "Show report";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_processFocusGained

    private void exitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exitFocusGained
        String leyend = "Get out";
        getLeyenda().setText(leyend);
    }//GEN-LAST:event_exitFocusGained

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
        this.setVisible(false);

    }//GEN-LAST:event_exitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LDinam;
    private javax.swing.JPanel Lopciones;
    private datechooser.beans.DateChooserPanel calendarrank;
    private javax.swing.JPanel cent;
    private javax.swing.JRadioButton day;
    private javax.swing.JButton exit;
    private javax.swing.ButtonGroup filter;
    private javax.swing.JPanel footer;
    private org.edisoncor.gui.panel.Panel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel leyenda;
    private javax.swing.JRadioButton month;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JButton print;
    private javax.swing.JButton process;
    private javax.swing.JRadioButton rank;
    private com.toedter.calendar.JMonthChooser semonth;
    private com.toedter.calendar.JYearChooser year;
    // End of variables declaration//GEN-END:variables
}
