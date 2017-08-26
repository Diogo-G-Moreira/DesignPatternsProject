/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.util.Date;

/**
 *
 * @author Diogo
 */
public class ComputerCreationState implements CreationState {

    ComputerBuilder builder;
    
    @Override
    public void build(String machine, String serial, String stock, String name, String mac) {
        builder = new ComputerBuilder();
        builder.build(machine, serial, stock, mac, name);
       
    }

    @Override
    public void addComment(String content, Date date, User user) {
        builder.updateComment(content, date, user);
    }

    @Override
    public void create() {
        builder.addResults();
    }

    @Override
    public void add(CreationState state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
