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
public class AccessProxy implements Proxy {
    
    Database db = new Database();
    
    @Override
    public boolean validAccount(String account, String password){
        
        boolean success = false;
        
        if(account.length() > 0 && password.length()> 0)
        {
            success = db.validAccount(account, password);
        }
        else{
            System.out.println("Information needs to be given.");
        }
        
        return success;
    }

    @Override
    public boolean addRecord(DBObject dbo, String collection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRecord(BasicDBObject dbo, String collection, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRecord(DBObject dbo, String collection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getRecord(DBObject dbo, String collection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DBObject> search(String collection, String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DBObject> getAllRecords(String collection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
