/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.util.ArrayList;

/**
 *
 * @author Diogo
 */
public interface Proxy {
    
    boolean addRecord(DBObject dbo, String collection);
    void updateRecord(BasicDBObject dbo, String collection, String id);
    void deleteRecord(DBObject dbo, String collection);
    
    void getRecord(DBObject dbo, String collection);
    ArrayList <DBObject> search(String collection, String search);
    
    ArrayList<DBObject> getAllRecords(String collection);
    
    boolean validAccount(String account, String password);
    
    
    
}
