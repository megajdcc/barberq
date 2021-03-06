/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import View.completedMeeting;
import View.Vemployee;
import View.Vhaircut;
import View.Vmeeting;
import View.Rclient;
import View.Principal;
import View.Vperson;
import View.Rmeeting;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import Model.*;
import java.awt.Color;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
/**
 *
 * @author Jnatn'h
 */
public class ControllerMeeting implements ActionListener,MouseListener,KeyListener,ChangeListener,ListSelectionListener{
    
    DefaultTableModel dm;
    private final Meeting model;
    private Client modelclient;
    private Employee modelemployee;
    private Cut modelhaircut;
    private Vmeeting list;
    private Rmeeting meeting;
    private Vperson client;
    private Vemployee employee;
    private Reports report;
    private Vhaircut haircut;
    private Principal principal;
    private completedMeeting completed;
    private Service modelservices;
    private double pricehaircut, pricetotal;
    private Array priceservice;
    public ControllerMeeting(Vmeeting list){
        this.list = list;
        model = new Meeting();
        modelemployee = new Employee();
        modelclient = new Client();
        modelhaircut = new Cut();
        report = new Reports();
        modelservices = new Service();
        haircut = new Vhaircut(principal,true);
        employee = new Vemployee(principal,true);
        meeting = new Rmeeting(principal,true);
        client = new Vperson(principal,true);
        completed = new completedMeeting(principal,true);
        Tolist();
    }
    private void Tolist(){
        String[][] information =  model.meetingList();
        list.gettableMeeting().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Phone","Name","Last Name","Date","Time"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    list.gettableMeeting().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    public void SearchList(String consulta, JTable JTableBuscar){
     
        dm = (DefaultTableModel) JTableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr  = new TableRowSorter<>(dm);
        JTableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    public void Capturedata(long dni,int opc){
     
        if(opc ==1){
            boolean found = model.searchModelByPhone(dni);
           if (found){
                list.dispose();
                list.setVisible(false);
                
                boolean encclient = modelclient.captureClient(model.getId_Client());
                if(encclient){
                    
                    meeting.getPhoneClient().setText(String.valueOf(modelclient.getPhone()));
                    meeting.getNameClient().setText(modelclient.getName());
                    meeting.getLastNameClient().setText(modelclient.getLastname());
                }
                meeting.getDateClient().setDate(model.getDateTime());
                
                
                boolean enhaircut = modelhaircut.matchingIdModel(model.getId_Haircut());
                boolean enemployee = modelemployee.consultModel(model.getId_Employee(),"meeting");
                if(enhaircut && enemployee){
                    meeting.getHaircut().setText(modelhaircut.getStyle());
                    meeting.getEmployee().setText(modelemployee.getName());
                }
                TolistServices();
                ArrayList listt = model.MeeServ();
      
                for (int i = 0; i < listt.size(); i++) {
                    meeting.getServices().setSelectedValue(listt.get(i), true);
                    this.moveselection(meeting.getServices(), meeting.getSelectservi());
               }
                
                meeting.setControllerMeeting(this);
                meeting.getUpdate().setVisible(true);
                meeting.getSClient().setEnabled(false);
                meeting.getSemployee().setEnabled(true);
                meeting.getSHaircut().setEnabled(true);
                meeting.getNextBtt().setEnabled(true);
                meeting.getBackBtt().setEnabled(true);

                
              
                //TolistServices();
                meeting.setVisible(true);
               }else{
               
                JOptionPane.showMessageDialog(new JFrame(),"Record not found","Meeting",JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(opc == 2){
            boolean found = modelclient.matchingModel(dni);
           if (found){
                client.dispose();
                client.setVisible(false);
                meeting.getPhoneClient().setText(String.valueOf(modelclient.getPhone()));
                meeting.getNameClient().setText(modelclient.getName());
                meeting.getLastNameClient().setText(modelclient.getLastname());
               
               }else{
               
                JOptionPane.showMessageDialog(new JFrame(),"Record not found","Meeting",JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(opc == 3){
           employee.dispose();
           employee.setVisible(false);
           boolean capt = modelemployee.captureemployee(dni);
           if(capt){
              meeting.getEmployee().setText(modelemployee.getName());
           }
          
           TolistServices();

           meeting.getNextBtt().setEnabled(true);
           meeting.getBackBtt().setEnabled(true);
        }
           
       }
    private void TolistServices(){
        JList list  = meeting.getServices();
        modelservices.listServices(list);
    }
    private void Capturedata(String style){
         boolean found = modelhaircut.matchingModel(style);
           if (found){
               haircut.dispose();
               haircut.setVisible(false);
               
               meeting.getHaircut().setText(modelhaircut.getStyle());
               pricehaircut = modelhaircut.capturePrice();
//               meeting.getDiscount().setEnabled(true);
               this.pricetotal();
               }else{
               
                JOptionPane.showMessageDialog(principal,"Record not found","Meeting",JOptionPane.INFORMATION_MESSAGE);
            }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Object event = ae.getSource();
        if(event.equals(list.getNewBtt())){
            list.dispose();
            list.setVisible(false);
            
            meeting.setControllerMeeting(this);
            meeting.getUpdate().setVisible(false);
            meeting.getDelete().setVisible(false);
            
            meeting.getSemployee().setEnabled(true);
            meeting.getSHaircut().setEnabled(true);
            
            meeting.getNextBtt().setEnabled(false);
            meeting.getBackBtt().setEnabled(false);
            
            
//            meeting.getDiscount().setEnabled(false);
            
            meeting.setVisible(true);
        }else if(event.equals(meeting.getExit())){
            
            meeting.dispose();
            meeting.setVisible(false);
            
            list = new Vmeeting(principal,true);
            list.setVisible(true);
        }else if(event.equals(meeting.getSClient())){
            
            client.setController(this);
            TolistClient();
            client.setVisible(true);
        }else if(event.equals(client.getNewPerson())){
            
            Rclient personclient = new Rclient(principal,true);
            personclient.setControllerClient(new ControllerClient(personclient,client));
//            personclient.getPrint().setVisible(false);
            personclient.getDelete().setVisible(false);
            personclient.setVisible(true);
            TolistClient();
        }else if(event.equals(meeting.getProcessBtt())){
            this.record();
        }else if(event.equals(meeting.getUpdate())){
            this.update();
        }else if(event.equals(meeting.getSemployee())){
            employee.setController(this);
            employee.getNewBtt().setEnabled(false);
            TolistEmployee();
            employee.setVisible(true);
        }else if(event.equals(meeting.getSHaircut())){
            
            haircut.setController(this);
            haircut.getNewBtt().setEnabled(false);
            TolistHaircut();
            haircut.setVisible(true);
        }else if(event.equals(meeting.getNextBtt())){
            moveselection(meeting.getServices(), meeting.getSelectservi());
              ListModel<String> modelselect = (ListModel<String>)meeting.getSelectservi().getModel();
            try {
                modelservices.chackPrice(modelselect);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMeeting.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.pricetotal();
        }else if(event.equals(meeting.getBackBtt())){
            moveselection(meeting.getSelectservi(), meeting.getServices());
            ListModel<String> modelselect = (ListModel<String>)meeting.getSelectservi().getModel();
            try {
                modelservices.chackPrice(modelselect);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMeeting.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.pricetotal();
        }else if(event.equals(meeting.getDelete())){
            this.delete();
        }else if(event.equals(completed.getProcess())){
            this.completed();
        }
    }
    private void completed(){
        model.setDiscount(completed.getDiscount().getValue());
        model.setTotalPrice(Double.parseDouble(completed.getLtotal().getText()));
        boolean completed = model.completedMeeting();
        if(completed){
            String leyend = "Succesfully processed the appoinment.\n do you want to print invoice?";
                                   
                int opcimp = JOptionPane.showConfirmDialog(principal, leyend, "Invoice",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(opcimp == 0){
                       report.invoiceMeeting(model.getId(),true);
                        
                       this.completed.dispose();
                           this.completed.setVisible(false);
                           meeting.dispose();
                           meeting.setVisible(false);
                           
                            list = new Vmeeting(principal,true);
                            list.setVisible(true);
                       }else{
                            
                           this.completed.dispose();
                           this.completed.setVisible(false);
                           meeting.dispose();
                           meeting.setVisible(false);
                           
                            list = new Vmeeting(principal,true);
                            list.setVisible(true);
                       }
        }
    }
    private void update(){
        if(model.getId()>0){
               boolean valide = validecompleted();

               if(valide){
                   Date fech = meeting.getDateClient().getDate();
                     
                    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                      
                    String fomr = fecha.format(fech);
                    model.setDate(fomr);
                   model.setId_Employee(modelemployee.getId());
                   model.setId_User(Principal.getIduser());
                   model.setCompletedWork(0);
                   model.setId_Haircut(modelhaircut.getId());
//                   model.setTotalprice(Double.parseDouble(meeting.getLtotal().getText()));
//                   model.setDiscount(meeting.getDiscount().getValue());
                   
                   ListModel<String> listser =  meeting.getSelectservi().getModel();
                   ArrayList<String> milist = new ArrayList();
                    for (int i = 0; i < listser.getSize(); i++) {
                       milist.add(listser.getElementAt(i));
                   }
                    model.setMeetserv(milist);
                   boolean register = model.updateMeeting();
                   if(register){
                       String leyend = "Succesfully update the appointment";
                       meeting.getCommend().setText(leyend);

                   }else{
                        String leyend = "Sorry there was an error while registering.";
                        meeting.getCommend().setText(leyend);
                   }
               }else if(!valide){
                    Date fech = meeting.getDateClient().getDate();
                    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String fomr = fecha.format(fech);
                    model.setDate(fomr);
                    
                    boolean updatopc = model.updateOpc();
                    if(updatopc){
                        String leyend = "The date of the appointment has been successfully ypdated!";
                        meeting.getCommend().setText(leyend);
                    }else{
                        String leyend = "Sorry there was an error while updating.";
                        meeting.getCommend().setText(leyend);
                    }
               }else{
                   String leyend = "Sorry it could not be processed.";
                   meeting.getCommend().setText(leyend);
               }
           }
    }
    private void delete(){ 
        int opcdelete = JOptionPane.showConfirmDialog(principal,"Do you really want to cancel this appointment","Delete Meeting", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(opcdelete < 1 ){
            boolean result = model.delete();
            if(result){
                JOptionPane.showMessageDialog(principal, "You have successfully deleted the appointment!");
                meeting.dispose();
                meeting.setVisible(false);
                Tolist();
                list.setControllerMeeting(this);
                list.setVisible(true);   
            }
        }
    }
    private void pricetotal(){
        ArrayList<Double> priceservic = modelservices.getPrices();
        double sumaprice = 0;
        double pricehaircut = modelhaircut.getPrice();
        if(priceservic == null){
            pricetotal = pricehaircut;
//            meeting.getLtotal().setText(String.valueOf(pricetotal));
        }else{
            Object priceser[] = priceservic.toArray();
            for (int i = 0; i < priceser.length; i++) {
                sumaprice = sumaprice + (Double)priceser[i];
            } 
            this.pricetotal = sumaprice + pricehaircut;
//            meeting.getLtotal().setText(String.valueOf(this.pricetotal));
        }  
    }
    private void TolistHaircut(){
        String[][] information =  modelhaircut.cutList();
        haircut.getTableHairCut().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Style","Price","Gender"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    haircut.getTableHairCut().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    private void TolistEmployee(){
        String[][] information =  modelemployee.resultList();
            employee.getEmployeeTable().setModel(new javax.swing.table.DefaultTableModel(
            information,
            new String [] {"Phone","Name","Last Name"}) {
            boolean[] canEdit = new boolean [] {
                false,false,false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
    });
        employee.getEmployeeTable().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    private void record(){
       
           if(model.getId() < 1 ){
                boolean result = validarRegisternew();
                if(result){
                        Date fech = meeting.getDateClient().getDate();
                     
                    SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                      
                    String fomr = fecha.format(fech);
                    model.setDate(fomr);
                    model.setId_User(Principal.getIdUser());
                    model.setCompletedWork(0);
                   model.setId_Haircut(modelhaircut.getId());
//                   model.setTotalprice(Double.parseDouble(meeting.getLtotal().getText()));
//                   model.setDiscount(meeting.getDiscount().getValue());
                   model.setId_Client(modelclient.getId());
                   model.setId_Employee(modelemployee.getIdemployee());
                   ListModel<String> listser =  meeting.getSelectservi().getModel();
                   ArrayList<String> milist = new ArrayList();
                    for (int i = 0; i < listser.getSize(); i++) {
                       milist.add(listser.getElementAt(i));
                   }
                    model.setMeetserv(milist);
                    boolean verifyposes = model.verify();
                    if(verifyposes){
                        String leyend = "This customer already has an appointmennt,delete the previous one that has not been processed to register a new one";
                         
                        meeting.getCommend().setText(leyend);
                    }else{
    
                        boolean resultt = model.insertMeeting();
                        if(resultt){
                        String leyend = "The appointment has been successfully registered";
                        meeting.dispose();
                        meeting.setVisible(false);
                        list = new Vmeeting(principal,true);
                        list.getCommend().setText(leyend);
                        list.setVisible(true);
//                        meeting.getLeyenda().setText(leyend);
//                        meeting.getDniclient().setText("");
//                        meeting.getNameclient().setText("");
//                        meeting.getLastnameclient().setText("");
//                        meeting.getEmployee().setText("");
//                        meeting.getHaircut().setText("");
//                        meeting.getSelectservi().removeAll();
//                        meeting.getDer().setEnabled(false);
//                        meeting.getIzq().setEnabled(false);
//                        this.TolistServices();
//                        
//                        meeting.getDateclient().setDate(new Date());
                        }else{
                         String leyend = "The appointment has not been successfully registered";
                        meeting.getCommend().setText(leyend);
                        } 
                    }
                    
                }
           }else if (model.getId()>0){
               String leyend1 = "Do you want to confirm the process?";
               int opc = JOptionPane.showConfirmDialog(principal,leyend1 , "Confirmation",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
               
               if(opc == 0){
                    ListModel<String> modelselect = (ListModel<String>)meeting.getSelectservi().getModel();
            try {
                modelservices.chackPrice(modelselect);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerMeeting.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.pricetotal();
                   this.update();
                   completed.setControllerMeeting(this);
                   this.TolistCompletedServices();
                   this.TolistCompletedHaircut();
                   completed.getLinvoice().setText(String.valueOf(model.getId()));
                   completed.getClient().setText(modelclient.getName()+" "+modelclient.getLastname());
                   this.pricetotal();
                   completed.getLtotal().setText(String.valueOf(pricetotal));
                   
//                   SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                      
//                    String fomr = fecha.format(model.getDate());
                    completed.getLdate().setText(model.getDate());
                    completed.setVisible(true);
               }else{
                   
               }
           }
          
    }
    private boolean validecompleted(){
        boolean valide = false;
        if(meeting.getEmployee().getText().isEmpty()){
            String leyend = "You must select an employee";
            meeting.getCommend().setText(leyend);
        }else if(meeting.getHaircut().getText().isEmpty() && meeting.getSelectservi().getModel().getSize()<1){
            String leyend = "Select a type of cut or select a service, otherwise it will not be processed";
            meeting.getCommend().setText(leyend);
        }else{
            valide = true;
        }
        return valide;
    }
    private boolean validarRegisternew(){
        boolean validado = false;
        if(meeting.getPhoneClient().getText().isEmpty()){
            String leyend = "You must select a client";
            meeting.getCommend().setText(leyend);
        }else if(meeting.getEmployee().getText().isEmpty()){
            String leyend = "You must select an employee";
            meeting.getCommend().setText(leyend);
        }else if(meeting.getHaircut().getText().isEmpty() && meeting.getSelectservi().getModel().getSize()<1){
            String leyend = "Select a type of cut or select a service, otherwise it will not be processed";
            meeting.getCommend().setText(leyend);
        }else{
            validado = true;
        }
    return validado;
    }
    private void TolistClient(){
        String[][] information =  modelclient.resultList();
        client.getTablePerson().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Phone","Name","Last Name"}) {
        boolean[] canEdit = new boolean [] {
            false,false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    client.getTablePerson().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    private void TolistCompletedServices(){
        String[][] information =  modelservices.list2Services(model.getId());
        completed.getServicesobt().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Service","Price"}) {
        boolean[] canEdit = new boolean [] {
            false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    completed.getServicesobt().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    private void TolistCompletedHaircut(){
        String[][] information =  modelhaircut.listHairCut(model.getId());
        completed.getHairCutTable().setModel(new javax.swing.table.DefaultTableModel(
        information,
        new String [] {"Style","Price"}) {
        boolean[] canEdit = new boolean [] {
            false,false
        };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
});
    completed.getHairCutTable().setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }
    private void moveselection(JList origin, JList destino){



        DefaultListModel listaorigin = (DefaultListModel) origin.getModel();
        DefaultListModel listadestino = (DefaultListModel) destino.getModel();
 
        int[] indice = origin.getSelectedIndices();
     
      List selec = origin.getSelectedValuesList();
       byte i = 0;
       
       for(Object selecc: selec) {
         listadestino.addElement(selecc);
         i++;
       }
            if( indice.length > 0){

               listaorigin.removeRange(indice[0], indice[i - 1]);
            }else{}

//               JOptionPane.showMessageDialog(principal, "Select an item from the list", "ERROR !!!", JOptionPane.ERROR_MESSAGE);
    int contador  = 0;
    ListModel cont = meeting.getSelectservi().getModel();
    contador = cont.getSize();
    if(contador != 0){
        Color micolor = new Color(247,0,24,80);
        meeting.getNextBtt().setBackground(micolor);
        meeting.getNextBtt().setForeground(Color.white);
        meeting.getNextBtt().setText( contador + "Selected services");
    }else{
        meeting.getNextBtt().setText("Assign services");
        meeting.getNextBtt().setForeground(Color.black);
        meeting.getNextBtt().setBackground(Color.white);

    }
       
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        Object Mevent = me.getSource();
        if(Mevent.equals(list.gettableMeeting())){
            if (me.getClickCount() == 2) {
            try{
                int row = list.gettableMeeting().getSelectedRow();
                int row1 = list.gettableMeeting().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) list.gettableMeeting().getModel();
                Long captura = Long.parseLong((String)modelotabla.getValueAt(row1, 0));
                Capturedata(captura,1);
            }catch(HeadlessException ex){
                System.out.println("Error: "+ex);
            }
            }
        }else if(Mevent.equals(client.getTablePerson())){
             if (me.getClickCount() == 2) {
            try{
                int row = client.getTablePerson().getSelectedRow();
                int row1 = client.getTablePerson().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) client.getTablePerson().getModel();
                Long captura = Long.parseLong((String)modelotabla.getValueAt(row1, 0));
                Capturedata(captura,2);
            }catch(HeadlessException ex){
                System.out.println("Error: "+ex);
            }
            }
        }else if(Mevent.equals(employee.getEmployeeTable())){
                 if (me.getClickCount() == 2) {
            try{
                int row = employee.getEmployeeTable().getSelectedRow();
                int row1 =employee.getEmployeeTable().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) employee.getEmployeeTable().getModel();
                long captura = Long.parseLong((String)modelotabla.getValueAt(row1, 0));
                Capturedata(captura,3);
            }catch(HeadlessException ex){
                System.out.println("Error: "+ex);
            }
            }
        }else if(Mevent.equals(haircut.getTableHairCut())){
                 if (me.getClickCount() == 2) {
            try{
                int row = haircut.getTableHairCut().getSelectedRow();
                int row1 =haircut.getTableHairCut().convertRowIndexToModel(row);
                DefaultTableModel modelotabla=(DefaultTableModel) haircut.getTableHairCut().getModel();
                String captura = (String) modelotabla.getValueAt(row1, 0);
                Capturedata(captura);
                System.out.println("kuku");
            }catch(HeadlessException ex){
                System.out.println("Error: "+ex);
            }
            }
        }       
    }
    @Override
    public void mousePressed(MouseEvent me) {
    }
    @Override
    public void mouseReleased(MouseEvent me) {
    }
    @Override
    public void mouseEntered(MouseEvent me) {
    }
    @Override
    public void mouseExited(MouseEvent me) {
    }
    @Override
    public void keyTyped(KeyEvent ke) {
        Object kevent = ke.getSource();
        if(kevent.equals(list.getTextSearch())){
            char b = ke.getKeyChar();
            if(list.getTextSearch().getText().length()>50){
                ke.consume();
            }
        }else if(kevent.equals(client.getTextSearch())){
             char b = ke.getKeyChar();
            if(client.getTextSearch().getText().length()>50){
                ke.consume();
            }
        }else if(kevent.equals(employee.getTextSearch())){
              char b = ke.getKeyChar();
            if(employee.getTextSearch().getText().length()>50){
                ke.consume();
            }
        }else if(kevent.equals(haircut.getTextSearch())){
              char b = ke.getKeyChar();
            if(haircut.getTextSearch().getText().length()>50){
                ke.consume();
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent ke) {
    }
    @Override
    public void keyReleased(KeyEvent ke) {
       Object origin = ke.getSource();
        if(origin.equals(list.getTextSearch())){
            String search = list.getTextSearch().getText();
            SearchList(search,list.gettableMeeting());
        }else if(origin.equals(client.getTextSearch())){
            String search = client.getTextSearch().getText();
            SearchList(search,client.getTablePerson());
        }else if(origin.equals(employee.getTextSearch())){
            String search = employee.getTextSearch().getText();
            SearchList(search,employee.getEmployeeTable());
        }else if(origin.equals(haircut.getTextSearch())){
            String search = haircut.getTextSearch().getText();
            SearchList(search,haircut.getTableHairCut());
        }
    }
    @Override
    public void stateChanged(ChangeEvent ce) {
            Object evn = ce.getSource();
        if(evn.equals(completed.getDiscount())){
            completed.getLdiscount().setText(completed.getDiscount().getValue()+" %");
            int discount = completed.getDiscount().getValue();

            double total = (pricetotal * discount) / 100;
            double rtotal = pricetotal - total;
            
            completed.getLtotal().setText(String.valueOf(rtotal));
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent lse) {
     
    }
}
