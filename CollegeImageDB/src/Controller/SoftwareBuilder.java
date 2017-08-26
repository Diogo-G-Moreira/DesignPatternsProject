/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Software;
import com.mongodb.BasicDBObject;

/**
 *
 * @author Diogo
 */
public class SoftwareBuilder implements Builder {
    
    String title;
    String version;

   String[] accessories;

    Software software;

    @Override
    public void createObject() {
        software = new Software (title, version, accessories);
        
    }

    @Override
    public boolean addResults() {
        BasicDBObject doc = new BasicDBObject();
        doc.put("title", software.getTitle());
        doc.put("version", software.getVersion());
        doc.put("accessories", software.getAccessories());

        DatabaseProxy dbp = new DatabaseProxy();

        boolean success = dbp.addRecord(doc, "school");

        dbp = null;

        return success;

    }

    public void build(String title, String version, String[] accessories) {
        this.title = title;
        this.version = version;
        this.accessories = accessories;

        createObject();
    }

    
}
