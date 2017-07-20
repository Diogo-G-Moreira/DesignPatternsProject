/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegeimagedb;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author Diogo
 */
public class Add {
    
    private JFrame mainFrame;
    private JLabel header; 
    private JComboBox<String> collectionList; 
    private JPanel choice;
     public static void main(String[] args) {
        // TODO code application logic here
        Add add = new Add();
    }
    
    public Add () {
    
    mainFrame = new JFrame("Add Record");
    mainFrame.setSize(500,600);
    choice.setLayout(new CardLayout());
    mainFrame.setLayout(new GridLayout());
    
    mainFrame.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent windowEvent){
            System.exit(0);  
        }   
    });
    
    header = new JLabel("Add Record",JLabel.CENTER);
    collectionList = new JComboBox<String>();
    collectionList.setPreferredSize(new Dimension(100,50));
    header.setVerticalAlignment(JLabel.TOP);
    mainFrame.add(header);
    mainFrame.add(collectionList);
    mainFrame.setVisible(true);
}
    
    
    
}
