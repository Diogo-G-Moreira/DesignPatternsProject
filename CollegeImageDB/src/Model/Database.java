/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
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
        System.out.println("System could not connect " + e);   
     }
         return connectionStatus;   
}
     
     
    public MongoCursor<String> getDBs ()
    {
        MongoCursor<String> dbsCursor = mongo.listDatabaseNames().iterator();
        
        return dbsCursor;
        
    }
    
    public Set<String> getAllCollections()
    {
        Set<String> collections = db.getCollectionNames();
        
        return collections;
    }
    
    public DBCollection getCollection()
    {
        DBCollection collection = db.getCollection("school");
        
        return collection;
    }
     
     public boolean addRecordSoftware (String software, String version, String[] tools)
     {
         boolean success = false;
         try{
         DBCollection collection = getCollection();
         BasicDBObject doc = new BasicDBObject();
         doc.put("title",software);
         doc.put("version",version);
         if(tools != null)
         {doc.put("tools",tools);}
         collection.insert(doc);
         success = true;
         }catch(MongoException e)
         {System.out.println("System could not add record " + e);   }
         
         return success;
         
     }
     
     public boolean addRecordSoftware (String software, String version)
     {
         boolean success = false;
         String[] empty = null;
         success = addRecordSoftware(software, version,empty );
         return success;
     }
     
}