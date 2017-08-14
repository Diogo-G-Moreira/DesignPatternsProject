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
public class Location {
    
    String classroom;
    String capacity;
    
    boolean videoConferencing;
    
    ArrayList<Comment> comments = new ArrayList<Comment>();
    
    public Location (String classroom, String capacity, boolean videoConferencing)
    {
        this.classroom = classroom;
        this.capacity = capacity;
        this.videoConferencing = videoConferencing;
        
        
    }
    

    public String getClassroom() {
        return classroom;
    }

    public String getCapacity() {
        return capacity;
    }

    public boolean isVideoConferencing() {
        return videoConferencing;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setVideoConferencing(boolean videoConferencing) {
        this.videoConferencing = videoConferencing;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
    
    
    
    
    
}
