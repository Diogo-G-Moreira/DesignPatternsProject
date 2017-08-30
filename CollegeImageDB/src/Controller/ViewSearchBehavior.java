/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ViewRecord;
import com.mongodb.DBObject;

/**
 *
 * @author Diogo
 */
public class ViewSearchBehavior implements SearchBehavior {

    @Override
    public void PerformAction(DBObject obj, String collection) {

        int dataType = 0;
        if (collection.equals("school")) {
            dataType = 1;
        }

        if (collection.equals("schoolHardware")) {
            dataType = 3;
        }

        if (collection.equals("schoolLocation")) {
            dataType = 4;
        }

        if (collection.equals("images")) {
            dataType = 2;
        }
        if (dataType != 0) {
            new ViewRecord(dataType, obj).setVisible(true);
        } else {
            System.out.println(dataType);
        }

    }

}
