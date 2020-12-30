/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.osii;
import project.osii.FIFO;

import javax.swing.*;
/**
 *
 * @author Ragaa
 */
public class ProjectOSII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        menuGUI menu=new menuGUI();
        menu.setSize(500,800);
	menu.setVisible(true);
	menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//          FIFO  window = new FIFO();
//			window.setSize(1000,300);
//			window.setVisible(true);
//			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        Optimal  window = new Optimal();
//			window.setSize(1000,300);
//			window.setVisible(true);
//			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
