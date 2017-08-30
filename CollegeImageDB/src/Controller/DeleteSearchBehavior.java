/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.SearchRecord;
import com.mongodb.DBObject;
import javax.swing.JOptionPane;

/**
 *
 * @author Diogo
 */
public class DeleteSearchBehavior implements SearchBehavior{

    DatabaseProxy dbp = new DatabaseProxy();
    
    @Override
    public void PerformAction(DBObject obj, String collection) {
        String msg = "<html>Are you sure you wish to delete this record?<br>";
                            if (collection.equals("school")) {
                                msg += "Software: " + obj.get("title") + "<br> Version: " + obj.get("version");
                            }
                            if (collection.equals("schoolHardware")) {
                                msg += "Machine: " + obj.get("machine") + "<br> Name: " + obj.get("name")
                                        + "<br> Serial: " + obj.get("serial")
                                        + "<br> Stock: " + obj.get("stock")
                                        + "<br> MAC: " + obj.get("mac");
                                if (obj.get("monitor") != null) {
                                    msg += "<br> Monitor: " + obj.get("monitor.monitor")
                                            + "<br> Monitor Serial: " + obj.get("monitor.mserial")
                                            + "<br> Monitor Stock: " + obj.get("monitor.mstock");
                                }
                            }

                            if (collection.equals("schoolLocation")) {
                                msg += "Classroom: " + obj.get("classroom") + "<br> Version: " + obj.get("version")
                                        + "<br> Video Conferening: " + obj.get("videoconferencing");
                            }

                            if (collection.equals("images")) {
                                msg += "Image: " + obj.get("image") + "<br> Machine: " + obj.get("machine")
                                        + "<br> Location: " + obj.get("location");
                            }

                            int response = JOptionPane.showConfirmDialog(null, msg, "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.YES_OPTION) {
                                dbp.deleteRecord(obj, collection);
                            }
                            new SearchRecord(new DeleteSearchBehavior()).setVisible(true);
    }
    
}
