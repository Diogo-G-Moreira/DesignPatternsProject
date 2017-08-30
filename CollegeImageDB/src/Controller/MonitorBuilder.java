/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Comment;
import Model.Hardware;
import Model.Monitor;
import Model.User;
import com.mongodb.BasicDBObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Diogo
 */
public class MonitorBuilder implements Builder{
    
    String machine, stock, serial;
    
    Hardware hardware;

    @Override
    public void createObject() {
        hardware = new Monitor(machine, stock, serial);
    }

    @Override
    public void addResults() {

        BasicDBObject doc = new BasicDBObject();
        doc.put("machine", hardware.getMachine());
        doc.put("type", hardware.getType());
        doc.put("serial", hardware.getSerial());
        doc.put("stock", hardware.getStock());

        if (hardware.getComment() != null) {
             List<BasicDBObject> allComments = new ArrayList<BasicDBObject>();  
                    for(int j = 0; j < hardware.getComment().size();j++)
                    {
                         BasicDBObject doc3 = new BasicDBObject();
                         doc3.put("comment",  hardware.getComment().get(j).getContent());
                         doc3.put("date", hardware.getComment().get(j).getCalendar());
                         doc3.put("user", hardware.getComment().get(j).getUserEdited());
                         allComments.add(doc3);
                    }

                    doc.put("comments", allComments);
        }

        DatabaseProxy dbp = new DatabaseProxy();

       dbp.addRecord(doc, "schoolHardware");

        dbp = null;

    }
    
    public void build(String machine, String serial, String stock)
    {
        this.machine = machine;
        this.serial = serial;
        this.stock = stock;

        createObject();
    }

    public Hardware getHardware() {
        return hardware;
    }
    
        public void updateComment(String content, Date date, User user)
    {
        Comment comment = new Comment(content, user, date);
        hardware.addComment(comment);
    }
}
