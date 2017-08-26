/*
 * To change this license header, choose License Headers in Project Properties.
 * To  this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Diogo
 */
public class MultipleCreationState implements CreationState {

    ArrayList<CreationState> allObjects;
    
    @Override
    public void build(String machine, String serial, String stock, String name, String mac) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addComment(String content, Date date, User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create() {
        for (int i = 0; i < allObjects.size();i++)
        {
            allObjects.get(i).create();
        }
    }

    @Override
    public void add(CreationState state) {
        allObjects.add(state);
    }
    
    
    
}
