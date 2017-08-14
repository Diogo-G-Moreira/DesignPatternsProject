/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Diogo
 */
public abstract class Message {
    
    
    String content;
    
    User userEdited;
    
    Date date;


    public void setContent(String content) {
       throw new UnsupportedOperationException();
    }

    public void setUserEdited(User userEdited) {
       throw new UnsupportedOperationException();
    }

    public void setCalendar(Date date) {
        throw new UnsupportedOperationException();
    }

    public String getContent() {
        throw new UnsupportedOperationException();
    }

    public User getUserEdited() {
        throw new UnsupportedOperationException();
    }

    public Date getCalendar() {
        throw new UnsupportedOperationException();
    }
     
}
