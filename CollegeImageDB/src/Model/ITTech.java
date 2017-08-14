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
public class ITTech {
    
    String userName;
    String firstName;
    String lastName;
    
    
    boolean loggedIn;
    
     ArrayList <Email> emailNotifications;
    
    public ITTech(String userName, String firstName, String lastName, boolean loggedIn, ArrayList<Email> emailNotifications)
    {
        this.firstName = firstName;
        this.lastName = firstName;
        this.userName = firstName;
        this.loggedIn = loggedIn;
        this.emailNotifications = emailNotifications;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public boolean isLoggedin() {
        return this.loggedIn;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLoggedin(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
}
