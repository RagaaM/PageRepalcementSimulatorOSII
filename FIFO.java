/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.osii;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
//import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.Queue; 
import javax.swing.JPanel;
/**
 *
 * @author Ragaa
 */
public class FIFO extends JFrame implements ActionListener{

    JButton SREB[] = new JButton[3]; //submitting,reseting and exiting buttons
    String ButtonsNames[] = {"SUBMIT","RESET","EXIT"};
    int NumberOfFrames;
    int NumberOfMemoryRef;
   // int MemoryRef[];
    Container con;
    JPanel  Output1,Output2; //1= string reference&frames, 2=page faults
    JLabel MemoRef;
    JTextField MemoryRef[];
    
    public FIFO()
    {
        setTitle("FIFO Page Replacement");
	   con = getContentPane();
////////////        //   con.setLayout(new  GridLayout(2,NumberOfMemoryRef+1,70,70));
            con.setLayout( new FlowLayout());
           
           NumberOfFrames= Integer.parseInt(JOptionPane.showInputDialog("Enter number of frames"));
           NumberOfMemoryRef = Integer.parseInt(JOptionPane.showInputDialog("Enter number of page reference string"));
           
           MemoRef=new JLabel("page reference string: ");
           MemoryRef = new JTextField[NumberOfMemoryRef];
           
           
           con.add(MemoRef);
//    int l=0;       
            for(int i=0;i<NumberOfMemoryRef;i++)
	   {
		MemoryRef[i]  = new JTextField(10);
                con.add(MemoryRef[i]);
//                con.add(MemoryRef[i]);
//            l++;
	   }
//    l=0;        
            for(int i=0;i<3;i++)
            {
		  SREB[i] = new JButton(ButtonsNames[i]);
                  con.add(SREB[i]);
	    SREB[i].addActionListener(this);
//                  con.add(SREB[i]);
 //                 l++;
            }
           
            
            
//    int l=0;
//            for(int i=0;i<NumberOfMemoryRef;i++)
//          {
//            con.add(MemoryRef[i]);
// //           l++;
//          }
//    l=0;
//	  for(int i=0;i<3;i++)
//	{
//            con.add(SREB[i]);
//	    SREB[i].addActionListener(this);
////            l++;
//        }
    
    
}// end of constructor

    @Override
    public void actionPerformed(ActionEvent ae) {
        JPanel main = new JPanel();
           main.setLayout(new BorderLayout());
                    Output1 = new JPanel(); Output1.setLayout(new GridLayout(2,NumberOfMemoryRef));
                    Output2 = new JPanel(); Output2.setLayout(new FlowLayout());
      //  int Frames[] = new int[NumberOfFrames];
        Queue<Integer> Frames = new LinkedList<Integer>(); //FIFO
        int liveFrames[]=new int[NumberOfFrames]; 
        for (int i=0;i<liveFrames.length;i++)
            liveFrames[i]=-1;
        
        int c=0;
        int PageFaults=0;
        int hits=0;
//        for(int i = 0; i < NumberOfFrames; i++)
//        {
//            if (Frames.contains(Integer.parseInt(MemoryRef[i].getText()))==false)
//            Frames.add(Integer.parseInt(MemoryRef[i].getText()));
//        }
        
        
          //   Frames.add(Integer.parseInt(MemoryRef[0].getText()));
        
        
//        Frames.add(Integer.parseInt(MemoryRef[1].getText()));
//        Frames.add(Integer.parseInt(MemoryRef[2].getText()));
//        for(int i = 0; i < Frames.length; i++)
//        {
//             Frames[i] = Integer.parseInt(MemoryRef[i].getText());
//        }
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(ae.getSource() == SREB[2])
           {
               System.exit(0);
           }
        
        else if(ae.getSource() == SREB[0]) //FIFO calculations
           {
            
            int counter =0;
        for (int i=0;i<NumberOfMemoryRef;i++ )
        {
             if(MemoryRef[i].getText().equals(""))
                 counter++;    
        }
        if (counter!=0)
             JOptionPane.showMessageDialog(null,"invalid or incorrect input, please try again by reseting", "Error",JOptionPane.ERROR_MESSAGE);
            
        boolean hit;
         for (int i=0;i<NumberOfMemoryRef;i++ )
                      Output1.add(new JLabel(""+Integer.parseInt(MemoryRef[i].getText())));
        
        for  (int i = 0;  i<NumberOfMemoryRef; i++) {
          //  for(int j=NumberOfFrames-1;j>0;j--)
      //       for(int j=0;j <NumberOfFrames;j++)
    //        {
//                if (Integer.parseInt(MemoryRef[i].getText())!=Frames[j]){
//                    PageFaults++;
//                }
        //        hit=Integer.parseInt(MemoryRef[i].getText())==Frames[j];
                 hit = Frames.contains(Integer.parseInt(MemoryRef[i].getText()));
                 if (hit){Output1.add(new JLabel("(hit/no pagefault)")); hits++;}
                if(!hit)
                {
                    PageFaults++;
                    if(Frames.size()==NumberOfFrames){
                    Frames.remove();
                    }
                    Frames.add(Integer.parseInt(MemoryRef[i].getText()));
                    
                    //Output1.add(new JLabel(""+Frames));
                    
                    String a=" ";
                    liveFrames[c]=(Integer.parseInt(MemoryRef[i].getText()));
                    c++;
                    
                    for (int p = 0; p < liveFrames.length; p++) {
                        if (liveFrames[p]!=-1)
                        a+=liveFrames[p];
                    }
                    Output1.add(new JLabel("miss:"+a));
                    if (c == liveFrames.length ) c=0;
                    
//                    for (int row=0;i<NumberOfFrames;row++ )
//                    {
//                        for (int col=0;i<NumberOfMemoryRef;col++ )
//                        {
//                       Output2.add(new JLabel(""+Frames));
//                        }
//                        
//                    }
                }
            }
            
//        JOptionPane.showMessageDialog(null, "page faults: " + PageFaults);
           //             for (int i=0;i<NumberOfMemoryRef;i++ )
           //            Output1.add(new JLabel(""+Integer.parseInt(MemoryRef[i].getText())));
                        Output2.add(new JLabel("page faults: "+PageFaults));
                        Output2.add(new JLabel("hits: "+hits));
                        
                        
       main.add(Output1,BorderLayout.NORTH);
     //  main.add(Output1,BorderLayout.CENTER);
       main.add(Output2,BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(null,main,"output",JOptionPane.PLAIN_MESSAGE);
           }
         else if(ae.getSource() == SREB[1])
           {
               setVisible(false);
               FIFO  window = new FIFO();
               window.setSize(1000,300);
               window.setVisible(true);
               window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
           }
    }
}