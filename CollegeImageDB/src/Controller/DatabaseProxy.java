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

/**
 *
 * @author Diogo
 */
public class DatabaseProxy implements Proxy {
    
    Database db = new Database();
    
    
    @Override
    public boolean addRecord(DBObject dbo, String collection)
    {
        boolean success = false;
        if (dbo != null && collection != null)
        {
           success = db.add(dbo, collection);
        }
        else{
            System.out.println("One of the parameters is null. -" + dbo.toString() + "  -" + collection );
        }
        
        return success;
        
    }
    
    @Override
    public void updateRecord(BasicDBObject dbo, String collection, String id)
    {
        if (dbo != null && collection != null && id != null)
        {
            db.update(dbo, collection, id);
        }
        else{
            System.out.println("One of the parameters is null. -" + dbo.toString() + "  -" + collection + "  -" + id );
        }
        
    }
        
    @Override
    public void deleteRecord(DBObject dbo, String collection)
    {
        if (dbo != null && collection != null)
        {
            db.delete(dbo, collection);
        }
        else{
            System.out.println("One of the parameters is null. -" + dbo.toString() + "  -" + collection );
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

    
    
    
    
    
    
    
    
    
}
