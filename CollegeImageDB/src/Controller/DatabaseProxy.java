/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Diogo
 */
public class DatabaseProxy implements Proxy {
    
    Database db = new Database();
    
    
    @Override
    public void addRecord(DBObject dbo, String collection)
    {
        boolean success = false;
        if (dbo != null && collection != null)
        {
           success = db.add(dbo, collection);
           if(success == true)
           {
                JOptionPane.showMessageDialog(null,"Add Record was Successful!","ADD Status",JOptionPane.PLAIN_MESSAGE);
           }
           else{
               JOptionPane.showMessageDialog(null,"Add Record Failed,","ADD Status",JOptionPane.PLAIN_MESSAGE);
           }
          
        }
        else{
            JOptionPane.showMessageDialog(null,"Add Record Failed, One of the parameters is null. -" + dbo.toString() + "  -" + collection,"ADD Status",JOptionPane.PLAIN_MESSAGE);
        }
        
    }
    
    @Override
    public void updateRecord(BasicDBObject dbo, String collection, String id)
    {
        boolean success = false;
        if (dbo != null && collection != null && id != null)
        {
            success = db.update(dbo, collection, id);
            if(success == true)
            {
                JOptionPane.showMessageDialog(null,"Update was Successful!","Update Status",JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Update Failed","Update Status",JOptionPane.PLAIN_MESSAGE);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null,"Update Failed, One of the parameters is null. -" + dbo.toString() + "  -" + collection + "  -" + id,"Update Status",JOptionPane.PLAIN_MESSAGE);
        }
        
    }
        
    @Override
    public void deleteRecord(DBObject dbo, String collection)
    {
        boolean success = false;
        if (dbo != null && collection != null)
        {
            success = db.delete(dbo, collection);
            if(success == true)
            {
                JOptionPane.showMessageDialog(null,"Delete was Successful!","Delete Status",JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Delete Failed","Delete Status",JOptionPane.PLAIN_MESSAGE);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null,"Delete Failed, One of the parameters is null. -" + dbo.toString() + "  -" + collection,"Delete Status",JOptionPane.PLAIN_MESSAGE);
        }
        
    }
    
    @Override
    public ArrayList<DBObject> getAllRecords(String collection)
    {
        ArrayList<DBObject> results = new ArrayList<DBObject>();
        if(collection != null)
        {
            results = db.getAllRecords(collection);
        }
        else{
            System.out.println("collection is null.");
        }
        
        return results;
        
    }
    
    @Override
    public ArrayList<DBObject> search(String collection, String search)
    {
        ArrayList<DBObject> results = new ArrayList<DBObject>();
        if(collection != null)
        {
            results = db.Search(collection, search);
        }
        else{
            System.out.println("collection is null or search is null.");
        }
        
        return results;
        
    }

    @Override
    public ArrayList<DBObject> getRecord(BasicDBObject dbo, String collection) {
        
        ArrayList<DBObject> results = db.getRecords(collection, dbo);
        return results;
        
    }


    @Override
    public boolean validAccount(String account, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Set<String> getAllCollections()
    {
        Set<String> results= db.getAllCollections();
        
        return results;
    }
    
    
    
    
    
    
    
}
