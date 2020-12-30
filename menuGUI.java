/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.osii;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Ragaa
 */
public class menuGUI extends JFrame {
    JButton AlgoFIFO=new JButton("Use First In First Out (FIFO)algoritham");
    JButton AlgoOptimal=new JButton("Use Optimal Page replacement algoritham");
    JButton AlgoLRU=new JButton("Use Least Recently Used algoritham");
    
    
    JButton close=new JButton("Close");
    
    public menuGUI(){
    setVisible(true);
    setLayout(new GridLayout(4,1));
    setSize(500,500);
    setTitle("Home");
    
    add(AlgoFIFO);
    AlgoFIFO.addActionListener(new AlgoFIFOButton());
    
    add(AlgoOptimal);
    AlgoOptimal.addActionListener(new AlgoOptimalButton());
    
    add(AlgoLRU);
    AlgoLRU.addActionListener(new AlgoLRUButton());
    
    
    add(close);
    close.addActionListener(new closeButton());
  
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class AlgoFIFOButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            setVisible(false);
    
              FIFO  window = new FIFO();
			window.setSize(1000,300);
			window.setVisible(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    
    }
    
    private class AlgoOptimalButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            setVisible(false);
            
            Optimal window=new Optimal();

			window.setSize(1000,300);
			window.setVisible(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    
    }
    
    private class AlgoLRUButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
//            setVisible(false);
//            sjf  window = new sjf();
//            window.setSize(500,800);
//		window.setVisible(true);
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        }
    
    }
    
    
    private class closeButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            setVisible(false);
            dispose();
            System.exit(0);
           
        }
    
    }
}