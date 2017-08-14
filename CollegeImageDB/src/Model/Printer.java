/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Diogo
 */
public class Printer {
    
    String machine;
    String serial;
    String stock;

    public Printer(String machine, String serial, String stock)
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

}

