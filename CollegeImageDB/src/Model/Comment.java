/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Diogo
 */
public class Comment extends Message{
    
    String content;
    
    String userEdited;
    
    Date date;

    public Comment(String content, String userEdited, Date date)
    {
        this.content = content;
        this.userEdited = userEdited;
        this.date = date;
        
    }
    
   
    
}
