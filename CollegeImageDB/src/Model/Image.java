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
public class Image {
    
    String image;
    String machine;
    String location;
    
    String [] accessories;
    
    ArrayList<String> softwareInstalled = new ArrayList<String>();

    ArrayList<Comment> comments = new ArrayList<Comment>();

    
    public Image(String image, String machine, String location, String[] accessories, ArrayList<String> softwareInstalled)
    {
        this.image = image;
        this.machine = machine;
        this.location = location;
        
        this.accessories = accessories;
        
        this.softwareInstalled = softwareInstalled;
    }
    
    
    public String getImage() {
        return image;
    }

    public String getMachine() {
        return machine;
    }

    public String getLocation() {
        return location;
    }

    public String[] getAccessories() {
        return accessories;
    }

    public ArrayList<String> getSoftwareInstalled() {
        return softwareInstalled;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAccessories(String[] accessories) {
        this.accessories = accessories;
    }

    public void setSoftwareInstalled(ArrayList<String> softwareInstalled) {
        this.softwareInstalled = softwareInstalled;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
    
    public void addComment(Comment comment)
    {
        this.comments.add(comment);
    }
    
    
    
    
    
}
