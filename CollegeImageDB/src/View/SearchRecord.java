/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Database;
import com.mongodb.DBObject;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Diogo
 */
public class SearchRecord extends javax.swing.JFrame {

    int functionType = 1;

    public void setFunctionType(int functionType) {
        this.functionType = functionType;
    }

    public int getFunctionType() {
        return functionType;
    }
    /**
     * Creates new form SearchRecord
     */
    Database db = new Database();
    DefaultListModel listModel;
    ArrayList<DBObject> searchResults;

    public SearchRecord() {
        setup();
    }

    public SearchRecord(int functionType) {
        setup();
        this.functionType = functionType;
        System.out.println(getFunctionType());
    }

    public void setup() {
        boolean status = db.Connect("localhost", 27017);
        initComponents();

        Set<String> collections = db.getAllCollections();

        collectionsList.addItem("");
        for (String coll : collections) {
            collectionsList.addItem(coll.toString());
        }

        MouseListener mouse = new MouseAdapter() {

            public void mouseClicked(MouseEvent mouseEvent) {
                JList list = (JList) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2) {
                    int index = list.locationToIndex(mouseEvent.getPoint());
                    System.out.println(index);
                    System.out.println(searchResults);
                    if (index >= 0) {
                        DBObject selectedObject = searchResults.get(index);
                        System.out.println(selectedObject);

                        if (getFunctionType() == 0) {
                            int dataType = 0;
                            if (collectionsList.getSelectedItem().toString().equals("school")) {
                                dataType = 1;
                            }

                            if (collectionsList.getSelectedItem().toString().equals("schoolHardware")) {
                                dataType = 3;
                            }

                            if (collectionsList.getSelectedItem().toString().equals("schoolLocation")) {
                                dataType = 4;
                            }

                            if (collectionsList.getSelectedItem().toString().equals("images")) {
                                dataType = 2;
                            }
                            if (dataType != 0) {
                                moveToView(selectedObject,dataType );
                            } else {
                                System.out.println(dataType);
                            }

                        }

                        if (getFunctionType() == 1) {
                                                        int dataType = 0;
                            if (collectionsList.getSelectedItem().toString().equals("school")) {
                                dataType = 1;
                            }

                            if (collectionsList.getSelectedItem().toString().equals("schoolHardware")) {
                                dataType = 3;
                            }

                            if (collectionsList.getSelectedItem().toString().equals("schoolLocation")) {
                                dataType = 4;
                            }

                            if (collectionsList.getSelectedItem().toString().equals("images")) {
                                dataType = 2;
                            }
                            if (dataType != 0) {
                                moveToUpdate(selectedObject, dataType);
                            } else {
                                System.out.println(dataType);
                            }
                            
                        }

                        if (getFunctionType() == 2) {
                            String msg = "<html>Are you sure you wish to delete this record?<br>";
                            if (collectionsList.getSelectedItem().toString().equals("school")) {
                                msg += "Software: " + selectedObject.get("title") + "<br> Version: " + selectedObject.get("version");
                            }
                            if (collectionsList.getSelectedItem().toString().equals("schoolHardware")) {
                                msg += "Machine: " + selectedObject.get("machine") + "<br> Name: " + selectedObject.get("name")
                                        + "<br> Serial: " + selectedObject.get("serial")
                                        + "<br> Stock: " + selectedObject.get("stock")
                                        + "<br> MAC: " + selectedObject.get("mac");
                                if (selectedObject.get("monitor") != null) {
                                    msg += "<br> Monitor: " + selectedObject.get("monitor.monitor")
                                            + "<br> Monitor Serial: " + selectedObject.get("monitor.mserial")
                                            + "<br> Monitor Stock: " + selectedObject.get("monitor.mstock");
                                }
                            }

                            if (collectionsList.getSelectedItem().toString().equals("schoolLocation")) {
                                msg += "Classroom: " + selectedObject.get("classroom") + "<br> Version: " + selectedObject.get("version")
                                        + "<br> Video Conferening: " + selectedObject.get("videoconferencing");
                            }

                            if (collectionsList.getSelectedItem().toString().equals("images")) {
                                msg += "Image: " + selectedObject.get("image") + "<br> Machine: " + selectedObject.get("machine")
                                        + "<br> Location: " + selectedObject.get("location");
                            }

                            int response = JOptionPane.showConfirmDialog(null, msg, "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.YES_OPTION) {
                                db.delete(selectedObject, collectionsList.getSelectedItem().toString());
                            }
                        }

                    }

                }
            }

        };
        resultList.addMouseListener(mouse);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        collectionsList = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultList = new javax.swing.JList<>();
        searchButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Search Record");

        collectionsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collectionsListActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(resultList);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(collectionsList, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backButton)))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(88, 88, 88)
                        .addComponent(searchButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(backButton))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(collectionsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void collectionsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collectionsListActionPerformed
        // TODO add your handling code here:
        Object selected = collectionsList.getSelectedItem();
        listModel = new DefaultListModel();
        switch (selected.toString()) {
            case "school":
                searchResults = db.getSoftware();
                for (int i = 0; i < searchResults.size(); i++) {
                    String option = searchResults.get(i).get("title").toString() + " - "
                            + searchResults.get(i).get("version").toString();

                    listModel.addElement(option);
                }
                System.out.println("End");
                resultList.setModel(listModel);

                break;
            case "schoolLocation":
                searchResults = db.getLocation();
                for (int i = 0; i < searchResults.size(); i++) {
                    String option = searchResults.get(i).get("classroom").toString();
                    listModel.addElement(option);
                }
                System.out.println("End");
                resultList.setModel(listModel);
                break;

            case "schoolHardware":
                searchResults = db.getHardware();
                for (int i = 0; i < searchResults.size(); i++) {
                    String option = searchResults.get(i).get("machine").toString() + " - "
                            + searchResults.get(i).get("name").toString() + " - "
                            + searchResults.get(i).get("mac").toString();

                    listModel.addElement(option);
                }
                System.out.println("End");
                resultList.setModel(listModel);
                break;

            case "images":
                searchResults = db.getImage();
                for (int i = 0; i < searchResults.size(); i++) {
                    String option = searchResults.get(i).get("image").toString();

                    listModel.addElement(option);
                }
                System.out.println("End");
                resultList.setModel(listModel);
                break;

        }


    }//GEN-LAST:event_collectionsListActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed

        this.setVisible(false);
        new Menu().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        // db.getFieldNames(collectionsList.getSelectedItem().toString());
        searchResults = new ArrayList<DBObject>();
        listModel.removeAllElements();
        listModel.clear();
        searchResults = db.Search(collectionsList.getSelectedItem().toString(), searchField.getText().toString());

        ArrayList<String> secondList = new ArrayList<String>();
        if (collectionsList.getSelectedItem().toString().equals("school")) {
            for (int i = 0; i < searchResults.size(); i++) {
                String option = searchResults.get(i).get("title").toString() + " - "
                        + searchResults.get(i).get("version").toString();

                secondList.add(option);

                listModel.addElement(option);
            }
            System.out.println("End");
            resultList.setModel(listModel);
        } else if (collectionsList.getSelectedItem().toString().equals("schoolLocation")) {
            for (int i = 0; i < searchResults.size(); i++) {
                String option = searchResults.get(i).get("classroom").toString();
                secondList.add(option);

                listModel.addElement(option);
            }
            System.out.println("End");
            resultList.setModel(listModel);
        } else if (collectionsList.getSelectedItem().toString().equals("schoolHardware")) {
            for (int i = 0; i < searchResults.size(); i++) {
                String option = searchResults.get(i).get("machine").toString() + " - "
                        + searchResults.get(i).get("name").toString() + " - "
                        + searchResults.get(i).get("mac").toString();
                secondList.add(option);

                listModel.addElement(option);
            }
            System.out.println("End");
            resultList.setModel(listModel);
        } else if (collectionsList.getSelectedItem().toString().equals("images")) {
            for (int i = 0; i < searchResults.size(); i++) {
                String option = searchResults.get(i).get("image").toString();

                listModel.addElement(option);
            }
            System.out.println("End");
            resultList.setModel(listModel);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchRecord().setVisible(true);
            }
        });
    }

    public void moveToUpdate(DBObject selectedObject, int dataType) {
        this.setVisible(false);
        new UpdateRecord(dataType, selectedObject).setVisible(true);

    }

    public void moveToView(DBObject selectedObject, int dataType) {
        this.setVisible(false);
        new ViewRecord(dataType, selectedObject).setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> collectionsList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> resultList;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
