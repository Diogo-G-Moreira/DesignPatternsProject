
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
public class Software {
    
    String title;
    String version;
    
    String[] accessories;
    
    
    public Software(String title, String version, String[] accessories)
    {
        this.title = title;
        this.version = version;
        this.accessories = accessories;
    }
    

    public String getTitle() {
        return title;
    }

    public String getVersion() {
        return version;
    }

    public String[] getAccessories() {
        return accessories;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setAccessories(String[] accessories) {
        this.accessories = accessories;
    }
    
    
    
    
    
    
}
