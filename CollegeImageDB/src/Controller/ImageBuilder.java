/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Comment;
import Model.Computer;
import Model.Image;
import Model.User;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Diogo
 */
public class ImageBuilder implements Builder {
    
    String image;
    String machine;
    String location;
    
    String [] accessories;
    
    ArrayList<String> softwareInstalled = new ArrayList<String>();
    
    Image imageObj;
    
     @Override
    public void createObject() {
        imageObj = new Image(image, machine, location, accessories, softwareInstalled);
    }

    @Override
    public boolean addResults() {
        BasicDBObject doc = new BasicDBObject();
        doc.put("image", imageObj.getImage());
        doc.put("machine", imageObj.getMachine());
        doc.put("location", imageObj.getLocation());
        
        doc.put("software", imageObj.getSoftwareInstalled());
       
        if (imageObj.getAccessories() != null) {
           doc.put("accessories", imageObj.getAccessories());
        }
        
        if (imageObj.getComments() != null) {
             List<BasicDBObject> allComments = new ArrayList<BasicDBObject>();  
                    for(int j = 0; j < imageObj.getComments().size();j++)
                    {
                         BasicDBObject doc3 = new BasicDBObject();
                         doc3.put("comment",  imageObj.getComments().get(j).getContent());
                         doc3.put("date", imageObj.getComments().get(j).getCalendar());
                         doc3.put("user", imageObj.getComments().get(j).getUserEdited());
                         allComments.add(doc3);
                    }

                    doc.put("comments", allComments);
        }

        DatabaseProxy dbp = new DatabaseProxy();

        boolean success = dbp.addRecord(doc, "school");

        dbp = null;

        return success;

    }

    public void build(String image, String machine, String location, String[] accessories, ArrayList<String> softwareInstalled) {
        
        this.image = image;
        this.machine = machine;
       
        this.location = location;
        this.accessories = accessories;
        this.softwareInstalled = softwareInstalled;
        createObject();
    }

    
    public void updateComment(String content, Date date, User user)
    {
        Comment comment = new Comment(content, user, date);
        imageObj.addComment(comment);
    }

}