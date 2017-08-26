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
public class Monitor extends Hardware{
    
    String machine;
    String serial;
    String stock;
    String type = "monitor";
    
    ArrayList<Comment> comments = new ArrayList<Comment>();

    public Monitor(String machine, String serial, String stock)
    {
        this.machine = machine;
        this.serial = serial;
        this.stock = stock;
    }
    
    public String getMachine() {
        return machine;
    }

    public String getSerial() {
        return serial;
    }

    public String getStock() {
        return stock;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Comment> getComment() {
        return comments;
    }



    public void setType(String type) {
        this.type = type;
    }

    public void setComment(ArrayList<Comment> comment) {
        this.comments = comment;
    }
    
    

}
