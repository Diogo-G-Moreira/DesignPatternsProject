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
public class Email {
    
    String content;
    
    User userEdited;
    
    Date date;
    
    public Email(String content, User userEdited, Date date)
    {
        this.content = content;
        this.userEdited = userEdited;
        this.date = date;
        
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public void setUserEdited(User userEdited) {
        this.userEdited = userEdited;
    }

    public void setCalendar(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public User getUserEdited() {
        return userEdited;
    }

    public Date getCalendar() {
        return date;
    }
    
}
