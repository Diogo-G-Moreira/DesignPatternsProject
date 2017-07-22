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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import javax.swing.text.Document;

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
    
        public ArrayList<DBObject> getSoftware ()
    {
        
        DBCollection collection =  getCollection("school");
        BasicDBObject query = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject();
        ArrayList<DBObject> softwareList = new ArrayList<DBObject>();
        
        fields.put("title",1);
        fields.put("version",1);
        
        DBCursor cursor = collection.find(query, fields);
        while (cursor.hasNext())
        {
            DBObject software = cursor.next();
            softwareList.add(software);
        }

        return softwareList;
        
    }
        
    public ArrayList<DBObject> getLocation ()
    {
        
        DBCollection collection =  getCollection("schoolLocation");
        BasicDBObject query = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject();
        ArrayList<DBObject> classroomList = new ArrayList<DBObject>();
        
        fields.put("classroom",1);
        
        DBCursor cursor = collection.find(query, fields);
        while (cursor.hasNext())
        {
            DBObject classroom = cursor.next();
            classroomList.add(classroom);
        }

        return classroomList;
        
    }
    
    public Set<String> getAllCollections()
    {
        Set<String> collections = db.getCollectionNames();
        
        return collections;
    }
    
    public DBCollection getCollection(String name)
    {
        DBCollection collection = db.getCollection(name);
        
        return collection;
    }
     
     public boolean addRecordSoftware (String software, String version, String[] tools)
     {
         boolean success = false;
         try{
         DBCollection collection = getCollection("school");
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
     
     public boolean addRecordLocation (String classroom, String capacity, boolean video, String comment)
     {
         boolean success = false;
         try{
         DBCollection collection = getCollection("schoolLocation");
         BasicDBObject doc = new BasicDBObject();
         doc.put("classroom",classroom);
         doc.put("version",capacity);
         doc.put("videoconferencing",video);
         if(comment != null)
         {
             List<BasicDBObject> allComments = new ArrayList<BasicDBObject>();  
             BasicDBObject doc2 = new BasicDBObject();
               doc2.put("comment", comment);
               Calendar calendar = Calendar.getInstance();
               SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
               doc2.put("date",dateFormat.format(calendar.getTime()));
              allComments.add(doc2);
              doc.put("comments", allComments);
         }
         collection.insert(doc);
         success = true;
         }catch(MongoException e)
         {System.out.println("System could not add record " + e);   }
         
         return success;
         
     }
     
     public boolean addRecordLocation (String classroom, String capacity, boolean video)
     {
         boolean success = false;
         String comment = null;
         success = addRecordLocation(classroom, capacity,video, comment );
         return success;
     }
     
     public boolean addRecordHardware (String machine, String name, String mac, String stock,String serial, String monitor, String mstock, String mserial, String comment)
     {
         boolean success = false;
         try{
         DBCollection collection = getCollection("schoolHardware");
         BasicDBObject doc = new BasicDBObject();
         doc.put("machine",machine);
         doc.put("name",name);
         doc.put("serial",mac);
         doc.put("stock",stock);
         doc.put("mac",serial);
         if(monitor != null)
         {
             List<BasicDBObject> monitorData = new ArrayList<BasicDBObject>();  
             BasicDBObject doc2 = new BasicDBObject();
               doc2.put("monitor", monitor);
               doc2.put("mSerial", mserial);
               doc2.put("mStock", mstock);
             monitorData.add(doc2);
             doc.put("monitor", monitorData);
         }
         if(monitor != null)
         {
             List<BasicDBObject> allComments = new ArrayList<BasicDBObject>();  
             BasicDBObject doc3 = new BasicDBObject();
               doc3.put("comment", comment);
               Calendar calendar = Calendar.getInstance();
               SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
               doc3.put("date",dateFormat.format(calendar.getTime()));
              allComments.add(doc3);
              doc.put("comments", allComments);
         }
         collection.insert(doc);
         success = true;
         }catch(MongoException e)
         {System.out.println("System could not add record " + e);   }
         
         return success;
         
     }
     
     public boolean addRecordHardware (String machine, String name, String mac, String stock,String serial, String monitor, String mstock, String mserial)
     {
         boolean success = false;
         String comment = null;
         success = addRecordHardware( machine, name, mac, stock,serial, monitor, mstock, mserial, comment );
         return success;
     }

     public boolean addRecordHardware (String machine, String name, String mac, String stock,String serial)
     {
          String monitor=null, mstock=null, mserial=null;

         boolean success = false;
         String comment = null;
         success = addRecordHardware( machine, name, mac, stock,serial, monitor, mstock, mserial, comment );
         return success;
     }
     
     
}