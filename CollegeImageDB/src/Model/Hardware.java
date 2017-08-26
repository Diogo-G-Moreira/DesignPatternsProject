/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Diogo
 */
public abstract class Hardware {
    
    String machine;
    String serial;
    String stock;
    String type;
    
   ArrayList<Comment> comments = new ArrayList<Comment>();
    
    public String getMachine() {
        throw new UnsupportedOperationException();
    }

    public String getSerial() {
        throw new UnsupportedOperationException();
    }

    public String getStock() {
        throw new UnsupportedOperationException();
    }

    public void setMachine(String machine) {
        throw new UnsupportedOperationException();
    }

    public void setSerial(String serial) {
        throw new UnsupportedOperationException();
    }

    public void setStock(String stock) {
        throw new UnsupportedOperationException();
    }
    
    public void setMac (String mac)
    {
        throw new UnsupportedOperationException();
    }
    
    public void setName (String name)
    {
        throw new UnsupportedOperationException();
    }
    
    public String getMac ()
    {
        throw new UnsupportedOperationException();
    }
    
    public String getName ()
    {
        throw new UnsupportedOperationException();
    }
    
    public ArrayList<Hardware> getAdditional()
    {
        throw new UnsupportedOperationException();
    }
    
    public void setAdditional( ArrayList<Hardware> hardwareList)
    {
        throw new UnsupportedOperationException();
    }
    
    
    public void add(Hardware hardware) {
       throw new UnsupportedOperationException();
    }
    
    public boolean update(Hardware hardware) {
       throw new UnsupportedOperationException();
    }
    
    public void delete(Hardware hardware) {
       throw new UnsupportedOperationException();
    }

    public ArrayList<Comment> getComment() {
        return comments;
    }

    public void setComment(ArrayList<Comment> comment) {
        this.comments = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void addComment(Comment comment)
    {
        this.comments.add(comment);
    }
    
    
   
}
