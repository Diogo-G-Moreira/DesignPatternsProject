/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Comment;
import Model.Location;
import Model.User;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Diogo
 */
public class LocationBuilder implements Builder {
    
    String classroom;
    String capacity;

    boolean videoConferencing;

    Location location;

    @Override
    public void createObject() {
        location = new Location (classroom, capacity, videoConferencing);
        
    }

    @Override
    public void addResults() {
        BasicDBObject doc = new BasicDBObject();
        doc.put("classroom", location.getClassroom());
        doc.put("location", location.getCapacity());
        doc.put("videoConferencing", location.isVideoConferencing());
        
        if(location.getComments() != null) {
            List<BasicDBObject> allComments = new ArrayList<BasicDBObject>();  
                    for(int j = 0; j < location.getComments().size();j++)
                    {
                         BasicDBObject doc3 = new BasicDBObject();
                         doc3.put("comment",  location.getComments().get(j).getContent());
                         doc3.put("date", location.getComments().get(j).getCalendar());
                         doc3.put("user", location.getComments().get(j).getUserEdited());
                         allComments.add(doc3);
                    }

                    doc.put("comments", allComments);
        }

        DatabaseProxy dbp = new DatabaseProxy();

       dbp.addRecord(doc, "schoolLocation");

        dbp = null;

    }

    public void build(String classroom, String capacity, boolean videoConferencing) {
        this.classroom = classroom;
        this.capacity = capacity;
        this.videoConferencing = videoConferencing;

        createObject();
    }
    
    public void updateComment(String content, Date date, User user)
    {
        Comment comment = new Comment(content, user, date);
        location.addComment(comment);
    }

    
}

