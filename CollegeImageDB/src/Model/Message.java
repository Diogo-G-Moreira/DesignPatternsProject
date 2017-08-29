/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Diogo
 */
abstract class Message {
    
    
    String content;
    
    String userEdited;
    
    Date date;

    
    
    
    public void send(ArrayList <DBObject> results){
        throw new UnsupportedOperationException();
    }
    
    public ArrayList <DBObject> setup(){
        throw new UnsupportedOperationException();
    }
    
    public void prepare(){
        ArrayList <DBObject> results = setup();
        send(results);
    }

    public void setContent(String content) {
       this.content = content;
    }

    public void setUserEdited(String userEdited) {
       this.userEdited = userEdited;
    }

    public void setCalendar(Date date) {
        
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public String getUserEdited() {
        return userEdited;
    }

    public Date getCalendar() {
        return date;
    }
     
}
