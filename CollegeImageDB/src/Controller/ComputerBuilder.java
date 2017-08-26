/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Comment;
import Model.Computer;
import Model.Hardware;
import Model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Diogo
 */
public class ComputerBuilder implements Builder {

    String machine;
    String serial;
    String stock;
    String mac;
    String name;

    Hardware hardware;

    @Override
    public void createObject() {
        hardware = new Computer(machine, serial, stock, mac, name);
    }

    @Override
    public boolean addResults() {
        BasicDBObject doc = new BasicDBObject();
        doc.put("machine", hardware.getMachine());
        doc.put("name", hardware.getName());
        doc.put("type", hardware.getType());
        doc.put("serial", hardware.getSerial());
        doc.put("stock", hardware.getStock());
        doc.put("mac", hardware.getMac());

        if (hardware.getAdditional() != null) {
            List<BasicDBObject> peripherals = new ArrayList<BasicDBObject>();

            for (int i = 0; i < hardware.getAdditional().size(); i++) {
                BasicDBObject doc2 = new BasicDBObject();
                doc2.put("machine", hardware.getAdditional().get(i).getMachine());
                doc2.put("serial", hardware.getAdditional().get(i).getSerial());
                doc2.put("stock", hardware.getAdditional().get(i).getSerial());
                doc2.put("type", hardware.getAdditional().get(i).getType());
                if (hardware.getAdditional().get(i).getMac() != null) {
                    doc2.put("mac", hardware.getAdditional().get(i).getMac());
                }
                if (hardware.getAdditional().get(i).getName() != null) {
                    doc2.put("name", hardware.getAdditional().get(i).getName());
                }
                if (hardware.getAdditional().get(i).getComment() != null) {
                   
                    List<BasicDBObject> allComments = new ArrayList<BasicDBObject>();  
                    for(int j = 0; j < hardware.getAdditional().get(i).getComment().size();j++)
                    {
                         BasicDBObject doc3 = new BasicDBObject();
                         doc3.put("comment", hardware.getAdditional().get(i).getComment().get(j).getContent());
                         doc3.put("date", hardware.getAdditional().get(i).getComment().get(j).getCalendar());
                         doc3.put("user", hardware.getAdditional().get(i).getComment().get(j).getUserEdited());
                         allComments.add(doc3);
                    }

                    doc2.put("comments", allComments);
                }
                peripherals.add(doc2);

            }
            doc.put("peripherals", peripherals);
        }

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

        boolean success = dbp.addRecord(doc, "schoolHardware");

        dbp = null;

        return success;

    }

    public void build(String machine, String serial, String stock, String mac, String name) {
        this.machine = machine;
        this.serial = serial;
        this.stock = stock;
        this.mac = mac;
        this.name = name;
        createObject();
    }

    public void addDevices(String machine, String serial, String stock, String type) {
        if (type == "Monitor") {
            MonitorBuilder mBuild = new MonitorBuilder();
            mBuild.createObject();
            hardware.add(mBuild.getHardware());
        }
        if (type == "Printer") {
            PrinterBuilder pBuild = new PrinterBuilder();
            pBuild.createObject();
            hardware.add(pBuild.getHardware());
        }
    }
    
    public void updateComment(String content, Date date, User user)
    {
        Comment comment = new Comment(content, user, date);
        hardware.addComment(comment);
    }

}
