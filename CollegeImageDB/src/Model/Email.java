/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DatabaseProxy;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Diogo
 */
public class Email extends Message{
    
    
    
    public Email(String content, String userEdited, Date date)
    {
        this.content = content;
        this.userEdited = userEdited;
        this.date = date;
        
    }
    
   //privilege
    
    public ArrayList <DBObject> setup(){
        
        
        BasicDBObject field = new BasicDBObject("privilage","admin");
        DatabaseProxy dp = new DatabaseProxy();
        ArrayList<DBObject> results = dp.getRecord(field, "accounts");
        return results;
        
        
    }
    
    public void send( ArrayList<DBObject> results){
        
        
        for (int i = 0; i < results.size();i++)
        {
            DBObject obj = results.get(i);
            BasicDBObject email = new BasicDBObject();
                email.put("content", getContent());
                email.put("date", getCalendar());
                email.put("user", getUserEdited());
                BasicDBObject newRecord = new BasicDBObject();
            if(obj.get("emails") == null)
            {
               BasicDBList allEmails = new BasicDBList();  
               allEmails.add(email);
               newRecord.put("emails", allEmails);
            }
            else{
                BasicDBList allEmails = (BasicDBList) obj.get("emails");
                allEmails.add(allEmails);
                newRecord.put("emails", allEmails);
            }
            DatabaseProxy dbp = new DatabaseProxy();
            dbp.updateRecord(newRecord, "accounts", obj.get("_id").toString());
            dbp = null;
        }
    
    }
    
}
