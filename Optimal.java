
/**
 *
 * @author Ragaa
 */
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
import java.util.ArrayList;
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
public class Optimal extends JFrame implements ActionListener{

    JButton SREB[] = new JButton[3]; //submitting,reseting and exiting buttons
    String ButtonsNames[] = {"SUBMIT","RESET","EXIT"};
    int NumberOfFrames;
    int NumberOfMemoryRef;
   // int MemoryRef[];
    Container con;
    JPanel  Output1,Output2; //1= string reference&frames, 2=page faults+hits
    JLabel MemoRef;
    JTextField MemoryRef[];
    
    public Optimal()
    {
        setTitle("Optimal Page Replacement");
	   con = getContentPane();
////////////        //   con.setLayout(new  GridLayout(2,NumberOfMemoryRef+1,70,70));
            con.setLayout( new FlowLayout());
           
           NumberOfFrames= Integer.parseInt(JOptionPane.showInputDialog("Enter number of frames"));
           NumberOfMemoryRef = Integer.parseInt(JOptionPane.showInputDialog("Enter number of memory ref"));
           
           MemoRef=new JLabel("string Reference: ");
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
           
            
    
}// end of constructor

    @Override
    public void actionPerformed(ActionEvent ae) {
        JPanel main = new JPanel();
           main.setLayout(new BorderLayout());
                    Output1 = new JPanel(); Output1.setLayout(new GridLayout(2,NumberOfMemoryRef));
                    Output2 = new JPanel(); Output2.setLayout(new FlowLayout());
        int PageFaults=0;
        int hits=0;
        
//        boolean found[]=new boolean[NumberOfFrames];
//for (int i=0;i<found.length;i++)
//            found[i]=false;

// int liveFrames[]=new int[NumberOfFrames]; 
//        for (int i=0;i<liveFrames.length;i++)
//            liveFrames[i]=-1; 
ArrayList<Integer> liveFrames = new ArrayList<Integer>(NumberOfFrames);
for(int frame=0;frame<NumberOfFrames;frame++)
{
    liveFrames.add(-1);
}
ArrayList<Boolean> found = new ArrayList<Boolean>(NumberOfFrames);
for(int frame=0;frame<NumberOfFrames;frame++)
{
    found.add(false);
}
        
        
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(ae.getSource() == SREB[2])
           {
               System.exit(0);
           }
        
        else if(ae.getSource() == SREB[0]) //Optimal calculations
           {
            
            int counter =0;
        for (int i=0;i<NumberOfMemoryRef;i++ )
        {
             if(MemoryRef[i].getText().equals(""))
                 counter++;    
        }
        if (counter!=0)
             JOptionPane.showMessageDialog(null,"invalid or incorrect input, please try again by reseting", "Error",JOptionPane.ERROR_MESSAGE);
            
        for (int i=0;i<NumberOfMemoryRef;i++ )
                      Output1.add(new JLabel(""+Integer.parseInt(MemoryRef[i].getText())));
        
        String a ="";
        boolean hit;
       int farthestfound=0;
       int checkfull=0;
for  (int i = 0;  i<NumberOfMemoryRef; i++)
{
    hit = liveFrames.contains(Integer.parseInt(MemoryRef[i].getText()));
                // if (hit){Output1.add(new JLabel("[no page fault here]")); hits++;}
                 if (hit){Output1.add(new JLabel("(hit/no pagefault)")); hits++;}
//                 if (!hit)
//                 {
//                  PageFaults++;
//                  
//                   if(checkfull<=NumberOfFrames) //case 1 frames are empty
//                   { 
//                   for (int x=0;x<NumberOfFrames;x++){
//                               if(liveFrames.get(x)==-1)
//                               {
//                                   liveFrames.set(x, Integer.parseInt(MemoryRef[i].getText()));
//                                   checkfull++;
//                                   break;
//                               }
//                           }
//                   }
//                   else{
//                    for  (int c = i;  c<NumberOfMemoryRef; c++)
//                    {
//                        for  (int frame = 0;  frame<NumberOfFrames; frame++)
//                        {
//                            if (Integer.parseInt(MemoryRef[c].getText())== liveFrames.get(frame))
//                            {
//                               // found[frame]=true;
//                                found.set(frame, true);
//                                farthestfound=frame; //lw kolo mwgod fi future yb2a fariftheresnofalsefound dh index akher frame geh(farthest)
//                                break;
//                            }
//                        }
//                     }
//                    //case 2 if the frames are all in the 'future'
//                    if (!found.contains(false)) liveFrames.set(farthestfound, Integer.parseInt(MemoryRef[i].getText()));
//                    
//                    //case 3 msh kol aly fi frames mwgoden fi future fa hanbdal wahda mn al not found
//                    if (found.contains(false))
//                    {
//                        for (int x=0;x<NumberOfFrames;x++)
//                        {
//                               if (found.get(x)==false )
//                               {
//                                   liveFrames.set(x, Integer.parseInt(MemoryRef[i].getText()));
//                                   break;
//                               }
//                        }
//
//                    }
//                   }
//                   for (int p = 0; p < liveFrames.size(); p++) {
//                        if (liveFrames.get(p)!=-1)
//                        a+=liveFrames.get(p);
//                    }
//                    Output1.add(new JLabel(""+a));
//                    a="";
//                 }
                  
                 

                 if(!hit)
                 {
                     PageFaults++;
                       for  (int c = i;  c<NumberOfMemoryRef; c++)
                       {
                        for  (int frame = 0;  frame<NumberOfFrames; frame++)
                        {
                            if (Integer.parseInt(MemoryRef[c].getText())== liveFrames.get(frame))
                            {
                               // found[frame]=true;
                                found.set(frame, true);
                                farthestfound=frame; //lw kolo mwgod fi future yb2a fariftheresnofalsefound dh index akher frame geh(farthest)
                                break;
                            }
                        }
                       }
                       
                       if(!found.contains(false)) liveFrames.set(farthestfound, Integer.parseInt(MemoryRef[i].getText())); 
                       else 
                       {
                           
                           for (int x=0;x<NumberOfFrames;x++){
                               if(liveFrames.contains(Integer.parseInt(MemoryRef[i].getText()))){break;}
                               if(liveFrames.get(x)==-1)
                               {
                                   liveFrames.set(x, Integer.parseInt(MemoryRef[i].getText()));
                                   checkfull++;
                                   break;
                               }
                               
                           }
                           //if(checkfull==NumberOfFrames){
                           for (int x=0;x<NumberOfFrames;x++){
                               if(checkfull<=NumberOfFrames){ checkfull+=1; break;}
                               if(liveFrames.contains(Integer.parseInt(MemoryRef[i].getText()))){break;}
                               if (found.get(x)==false )
                               {
                                   liveFrames.set(x, Integer.parseInt(MemoryRef[i].getText()));
                                   break;
                               }
                        }
                       }
                       for (int p = 0; p < liveFrames.size(); p++) {
                        if (liveFrames.get(p)!=-1)
                        a+=liveFrames.get(p);
                    }
                    Output1.add(new JLabel("miss:"+a));
                    a="";
                 }
                 
                 
                 
                 
                 
//                 for  (int frame = 0;  frame<NumberOfFrames; frame++)
//      {
//            if (liveFrames.get(frame)== -1 && !hit) //if empty
//            {
//                liveFrames.set(frame, Integer.parseInt(MemoryRef[i].getText()));
//                PageFaults++;
//               // Output1.add(new JLabel(""+Integer.parseInt(MemoryRef[i].getText())));
//                 for (int p=0;p<liveFrames.size();p++)
//            {
//                if (liveFrames.get(p)!=-1)
//                    a+=liveFrames.get(p);   
//            }
//            Output1.add(new JLabel(""+a));
//            a=" ";
//                break;
//            }
//           // if (hit){Output1.add(new JLabel("[no page fault here]")); hits++;}
//        }
//        if (!liveFrames.contains(-1)) {i+=1;}//not empty
//       // hit= liveFrames.contains(Integer.parseInt(MemoryRef[i].getText()));
//        if (!liveFrames.contains(-1)) //not empty
//        {
//            if (hit){Output1.add(new JLabel("[no page fault here]")); hits++; }
//            if(!hit) {
//            for  (int c = i;  c<NumberOfMemoryRef; c++){
//                 for  (int frame = 0;  frame<NumberOfFrames; frame++){
//            if (Integer.parseInt(MemoryRef[c].getText())== liveFrames.get(frame))
//            { found[frame]=true;
//            fariftheresnofalsefound=frame; //lw kolo mwgod yb2a fariftheresnofalsefound dh index akher frame geh(farthest)
//            break;
//            }
//        }
//        }
//            }
//            
//            for  (int frame = 0;  frame<NumberOfFrames; frame++){
//                if (!found[frame]){
//                    liveFrames.set(frame, Integer.parseInt(MemoryRef[i].getText()));
//                    PageFaults++;
//                   // break;
//                }
//                else
//                {
//                    liveFrames.set(fariftheresnofalsefound, Integer.parseInt(MemoryRef[i].getText()));
//                    PageFaults++;
//                }
//            }
//            
//            for (int p=0;p<liveFrames.size();p++)
//            {
//                if (liveFrames.get(p)!=-1)
//                    a+=liveFrames.get(p);   
//            }
//            Output1.add(new JLabel(""+a));
//            a=" ";
//            }
}  
            
                        Output2.add(new JLabel("page faults: "+PageFaults));
                        Output2.add(new JLabel("hits: "+hits));
                        
                        
       main.add(Output1,BorderLayout.NORTH);
       main.add(Output2,BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(null,main,"output",JOptionPane.PLAIN_MESSAGE);
           }
         else if(ae.getSource() == SREB[1])
           {
               setVisible(false);
               Optimal  window = new Optimal();
               window.setSize(1000,300);
               window.setVisible(true);
               window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
           }
    }
}
//138