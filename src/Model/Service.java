package Model;

import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;


public class Service {
        
    private int id;
    private double price;
    private String service;
    public boolean registry,update,delete;
    private final Conection connection;
    private ArrayList prices;                

   
    public Service(){
        connection = new Conection();
        
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getService() {
        return service;
    }
    
    
    public void setService(String service) {
        this.service = service;
    }

    public ArrayList getPrices() {
        return prices;
    }

    public void setPrices(ArrayList prices) {
        this.prices = prices;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.
     */
    public boolean insertService() {
         registry = false;
        
        String sql = "INSERT INTO Service(price,name)"
                + "values("+this.price+",'"+this.service+"')";
        int result = connection.runUpdate(sql);
        
        if(result != 0){
            registry = true;
        }
        return registry;
    }
    
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.
     */
    public boolean updateService() {
      update = false;
        String sql = "UPDATE service set price = "+this.price+",name = '"+this.service+"'"
                + " where id = "+this.id+"";
        int result = connection.runUpdate(sql);
        
        if(result != 0){
            update = true;
        }
        return update;
    }
    /**
     * 
     * @return Returns a boolean to indicate that the statement was executed successfully or not.
     */
    public boolean deleteService() {
        delete = false;
        
        String sql = "DELETE from service where id = "+this.id+"";
        int result = connection.runUpdate(sql);
        
        if(result != 0){
            delete = true;
        }
        return delete;
    }
    public String[][] serviceList(){
           
            String sqlStatement = "select name, price from service";

            ResultSet result = connection.runQuery(sqlStatement);

            if(result == null){
               return null;
            }
            
            int i = 0;
            try {
                while(result.next()) i++;
                String[][] data = new String[i][2];
                i = 0;
                result.beforeFirst();
                while(result.next()){
                   data[i][0] = result.getString("name");
                   data[i][1] = result.getString("price");

                    i++;
                }
                return data;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }
    public boolean matchingModel(String name){
       
            boolean flag=false;
            String sql = "select * from service where name = '"+name+"'";
           
            ResultSet result = connection.runQuery(sql);
             try {
              
                if(result!=null){
                    result.next();
                    setId(result.getInt("id"));
                    setService(result.getString("name"));
                    setPrice(result.getDouble("price"));
                    flag=true;
                }else{
                    flag=false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            return flag;
            
        }
    public void listServices(JList list){
      String sql = "SELECT s.name from service as s";
      ResultSet result  = connection.runQuery(sql);
      if(result != null){
        try {
         int i = 0 ;
          DefaultListModel myList = new DefaultListModel();
          
          while(result.next()){              
               myList.addElement(result.getString("name"));
          }
          list.setCursor(new Cursor(Cursor.HAND_CURSOR));
          list.setModel(myList);
        } catch (SQLException ex) {
          Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
         
      }
    }
    public void chackPrice(ListModel<String> model) throws SQLException{
        
       int leng = model.getSize();
       
       prices = new ArrayList();
        for (int i = 0; i < leng; i++) {
            String sql = "select price from service where name = '"+ model.getElementAt(i) +"'";
            ResultSet result = connection.runQuery(sql);
            if(result!= null){
                result.next();
                prices.add(result.getDouble("price"));
            }
        }  
    }
    public String[][] list2Services(Long idMeeting){

            String sql = "select s.name,s.price from service as s \n" +
"	join meetserv as me on s.ID = me.ids\n" +
"	where me.idm = "+idMeeting+"";

            ResultSet resultQuery = connection.runQuery(sql);

            if(resultQuery == null){
               String Error = "error";
               return null;
            }
            
            int i = 0;
            try {
                while(resultQuery.next()) i++;
                String[][] data = new String[i][2];
                i = 0;
                resultQuery.beforeFirst();
                while(resultQuery.next()){
                   data[i][0] = resultQuery.getString("name");
                   data[i][1] = resultQuery.getString("price");
              
                    i++;
                }
                return data;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                    return null;
            }
        }
}
