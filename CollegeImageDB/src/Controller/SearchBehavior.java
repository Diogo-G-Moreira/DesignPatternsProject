/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.mongodb.DBObject;

/**
 *
 * @author Diogo
 */
public interface SearchBehavior {
    
    void PerformAction(DBObject obj, String collection);
    
    
    
}
