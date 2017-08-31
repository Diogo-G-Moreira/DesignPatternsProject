/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.Set;
import org.bson.types.ObjectId;

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
     
    public void Disconnect (){
         
        mongo.close();  
}
     
     
    public MongoCursor<String> getDBs ()
    {
        MongoCursor<String> dbsCursor = mongo.listDatabaseNames().iterator();
        
        return dbsCursor;
        
    }
    
    public boolean validAccount(String account, String password)
    {
        boolean results = false;
        boolean connect = Connect("localhost",27017);
        System.out.println("Im here");
        if(connect==true)
        {
            System.out.println("Im here 2");
        DBCollection collection =  getCollection("accounts");
        BasicDBObject query = new BasicDBObject();
        BasicDBObject field = new BasicDBObject();
        ArrayList<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        
        obj.add(new BasicDBObject("account",account));
        obj.add(new BasicDBObject("password",password));
        
        query.put("$and", obj);
        
 
        DBCursor cursor = collection.find(query);
        if (cursor.hasNext()){
            if(cursor.hasNext() == true)
            {
                results = true;
                String id = cursor.next().get("_id").toString();
                System.out.println(id);
                 
                query = new BasicDBObject().append("_id",new ObjectId(id));
                field = new BasicDBObject();
                field.append("$set", new BasicDBObject().append("loggedin",true));
                collection.update(query, field);
                
            }
                
        }
        else{
            System.out.println("Account not Found");
        }

        }
         Disconnect();
        return results;
    }
    
    public void Logout ()
    {
         boolean connect = Connect("localhost",27017);
         DBCollection collection =  getCollection("accounts");
         
         BasicDBObject query = new BasicDBObject().append("loggedin", true);
          BasicDBObject field = new BasicDBObject();
         field.append("$set", new BasicDBObject().append("loggedin",false));
         collection.update(query, field);
         
         Disconnect();
         System.out.println("End Logout");
    }
    
    
    
 
    public Set<String> getAllCollections()
    {
        Connect("localhost",27017); 
        Set<String> collections = db.getCollectionNames();
        Disconnect();
        return collections;
    }
    
    public DBCollection getCollection(String name)
    {
        System.out.println(name);
        DBCollection collection = null;
        collection = db.getCollection(name);
        
        return collection;
    }
     
        public ArrayList<String> getFieldNames(String collect)
    {
        DBCollection collection =  getCollection(collect);
        BasicDBObject query = new BasicDBObject();
        
        ArrayList<String> fields = new ArrayList<String>() ;
        DBCursor results = collection.find(query);
        
       for( String key: results.next().keySet())
        {
           fields.add(key);
        }
        return fields;
    }
    
    
    public ArrayList<DBObject> Search (String collect, String search)
    {
      
        BasicDBObject query = new BasicDBObject();
        DBCollection collection =  getCollection(collect);
        ArrayList<DBObject> resultsList = new ArrayList<DBObject>();

       if(collect.equals("schoolLocation"))
       {
           query.append("classroom", new BasicDBObject("$regex", search).append("$options", "i"));
       }
       else if(collect.equals("images"))
       {
           System.out.println("made it here");
           query.append("image", new BasicDBObject("$regex", search).append("$options", "i"));
       }
       else if(collect.equals("schoolHardware"))
       {
           query.append("machine", new BasicDBObject("$regex", search).append("$options", "i"));
       }
       else if(collect.equals("school") )
       {
           query.append("title", new BasicDBObject("$regex", search).append("$options", "i"));
           
       }

        DBCursor results = collection.find(query);
        while (results.hasNext())
        {
            DBObject oneResult = results.next();
            System.out.println(oneResult.toString());
            resultsList.add(oneResult);
        }
        
        return resultsList;
           
        
    }

     public boolean add(DBObject record, String collectionSelected)
     {
         boolean success = false;
         try{
         Connect("localhost",27017); 
         DBCollection collection = getCollection(collectionSelected);
         collection.insert(record);
         success = true;
         System.out.println("Record Inserted.");
         }catch(MongoException e){
         System.out.println("Record failed to Insert.");
         System.out.println(e);
         }
         Disconnect();
         return success;
     }
     
     
     
     public boolean delete(DBObject record, String collectionSelected)
     {
         boolean success = false;
         try{
         Connect("localhost",27017); 
         DBCollection collection = getCollection(collectionSelected);
         collection.remove(record);
         success = true;
         System.out.println("Record Deleted");
         }catch(MongoException e){
         System.out.println("Record Failed to Delete");
         System.out.println(e);
         }
         Disconnect();
         return success;
     }
     
     public boolean update(BasicDBObject record, String collectionSelected, String id)
     {
         boolean success = false;
         try{
         Connect("localhost",27017); 
         DBCollection collection = getCollection(collectionSelected);
         
         collection.update(new BasicDBObject("_id",new ObjectId(id)), record);
         System.out.println("Record Updated");
         success = true;          
         }catch(MongoException e)
         {System.out.println("System could not update record");  
         System.out.println(e);}
         Disconnect();
         return success;
     }
     
     public ArrayList<DBObject> getAllRecords(String collectionName){
        
        Connect("localhost",27017); 
        DBCollection collection =  getCollection(collectionName);
        BasicDBObject query = new BasicDBObject();
        ArrayList<DBObject> classroomList = new ArrayList<DBObject>();
       
        
        DBCursor cursor = collection.find(query);
        while (cursor.hasNext())
        {
            DBObject classroom = cursor.next();
            classroomList.add(classroom);
        }
        Disconnect();
        return classroomList;
         
     }
     
     
     public ArrayList<DBObject> getRecords(String collectionName, BasicDBObject query){
        
        Connect("localhost",27017); 
        DBCollection collection =  getCollection(collectionName);
       
        ArrayList<DBObject> classroomList = new ArrayList<DBObject>();
       
        
        DBCursor cursor = collection.find(query);
        System.out.println(cursor.hasNext());
        while (cursor.hasNext())
        {
            DBObject classroom = cursor.next();
            classroomList.add(classroom);
        }
        Disconnect();
        return classroomList;
         
     }
     
} 