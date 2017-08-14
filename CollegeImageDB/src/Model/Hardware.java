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
public abstract class Hardware {
    
    String machine;
    String serial;
    String stock;

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
    
    public void add(Hardware hardware) {
       throw new UnsupportedOperationException();
    }
    
    public boolean update(Hardware hardware) {
       throw new UnsupportedOperationException();
    }
    
    public void delete(Hardware hardware) {
       throw new UnsupportedOperationException();
    }
   
}
