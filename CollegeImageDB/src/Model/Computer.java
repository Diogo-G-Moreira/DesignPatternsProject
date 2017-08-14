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
public class Computer  extends Hardware{
    
    String machine;
    String serial;
    String stock;
    String mac;
    String name;
    
    ArrayList<Hardware> additional = new ArrayList<Hardware>();
    
    public Computer(String machine,String serial,String stock,String mac,String name)
    {
        this.machine = machine;
        this.serial = serial;
        this.stock = stock;
        this.mac = mac;
        this.name = name;
        
    }
     
    /*
    ***************************Getters / Setters*****************************
    */
    
    public String getMachine() {
        return this.machine;
    }

    public String getSerial() {
        return this.serial;
    }

    public String getStock() {
        return this.stock;
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

    public String getMac() {
        return mac;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Hardware> getAdditional() {
        return additional;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdditional(ArrayList<Hardware> additional) {
        this.additional = additional;
    }
    
    
    
    public void add(Hardware hardware) {
       additional.add(hardware);
    }
    
    public boolean update(Hardware hardware) {

        boolean success = false;
        
        for(int i = 0; i < additional.size();i++)
        {
            if(additional.get(i).getSerial()==hardware.getSerial())
            {
                additional.set(i,hardware);
                success = true;
                break;
            }
        }
        
        return success;
       
    }
    
    public void delete(Hardware hardware) {
       additional.remove(hardware);
    }
    
    
    
    
}
