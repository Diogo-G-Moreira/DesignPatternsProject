/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCursor;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Diogo
 */
public class Database {

    private MongoClient mongo;
    private DB db;
     public Database(){
         
     }
    
     public boolean Connect (String IP, int port){
         
         boolean connectionStatus = false;
         try{
             
        System.out.println("Connecting to Database....");
        this.mongo = new MongoClient(IP,port);
        db = mongo.getDB("school");
        connectionStatus = true;
        }catch(MongoException e){
        System.out.println("System could not connect");   
     }
         return connectionStatus;   
}
     
     
    public MongoCursor<String> getDBs ()
    {
        MongoCursor<String> dbsCursor = mongo.listDatabaseNames().iterator();
        
        return dbsCursor;
        
    }
    
    public Set<String> getCollections()
    {
        Set<String> collections = db.getCollectionNames();
        
        return collections;
    }
     
     
     
}