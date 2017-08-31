/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;

/**
 *
 * @author Diogo
 */

public interface CreationState {
       
           
           public void build (String machine, String serial, String stock, String name, String mac);
           
           public void addComment(String content, Date date, String user);
           
           public void create();
           
           public void add(CreationState state);

}
