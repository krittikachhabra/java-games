package games;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Random;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
public class paintball extends JFrame implements ActionListener {


    Timer timer;
    public JPanel contentPane;
    //public JLabel time2;

    /**
    * Launch the application.
    */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    paintball frame = new paintball();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
  
     /*time2 = new JLabel("time left " + time);
    time2.setOpaque();
    JLabel score = new JLabel("score " + hit);*/
    int p,l;
    static int x,y,hit=0;
    static int time=120;
    JLabel hitme = new JLabel("");

    /**
    * Create the frame.
    */
    public paintball() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBackground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel l1 = new JLabel("");
        l1.setBackground(Color.ORANGE);
        l1.setBounds(37, 170, 69, 69);
        l1.setOpaque(true);
        contentPane.add(l1);
        
        JLabel l2 = new JLabel("");
        l2.setBackground(Color.ORANGE);
        l2.setBounds(182, 92, 62, 57);
        l2.setOpaque(true);
        contentPane.add(l2);
        
        JLabel l3 = new JLabel("");
        l3.setBackground(Color.ORANGE);
        l3.setBounds(330, 24, 55, 47);
        l3.setOpaque(true);
        contentPane.add(l3);
        
        JLabel l4 = new JLabel("");
        l4.setBackground(Color.ORANGE);
        l4.setBounds(319, 188, 46, 32);
        l4.setOpaque(true);
        contentPane.add(l4);
        
        
        hitme.setBackground(Color.MAGENTA);
        hitme.setBounds(59, 80, 20, 20);
        hitme.setOpaque(true);
        contentPane.add(hitme);
        
        timer = new Timer(2000, this);
        timer.start();
       
        
    }
    

    public void actionPerformed(ActionEvent e) {
         x = (int)(480*Math.random())+1;
         y = (int)(480*Math.random())+1;
         time--;
        hitme.setBounds(x, y, 20, 20);
        contentPane.addMouseMotionListener(new MouseAdapter(){ 
            public void mouseMoved(MouseEvent e){
                p = e.getX();
                l = e.getY();
                                  
            }
        });
        contentPane.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent arg0) {}
            public void mousePressed(MouseEvent arg0){}
            public void mouseExited(MouseEvent arg0) {}
            public void mouseEntered(MouseEvent arg0) {}
            public void mouseClicked(MouseEvent arg0) {
            	
                if((p>=x && p<=x+20) && (l>=y && l<=y+20 ))
                    hit++;
                System.out.println(hit+"  "+time);
                if(hit==40)
                {
                	Object[] options = { "Exit", "Play Again" };
                int choice = JOptionPane.showOptionDialog(null, 
                        "Player won", 
                        "Quit?", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, 
                        null, 
                        options, 
                        options[0]);
                    if (choice == JOptionPane.YES_OPTION)
                    {
                      System.exit(0);
                    }
                    if (choice == JOptionPane.NO_OPTION)
                    {
                       dispose();
                        paintball obj=new paintball(); 
                       
                    }
                	
                }
                if(time==0)
                {
                	Object[] options = { "Exit", "Play Again" };
                int choice = JOptionPane.showOptionDialog(null, 
                        "Player lost", 
                        "Quit?", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, 
                        null, 
                        options, 
                        options[0]);
                    if (choice == JOptionPane.YES_OPTION)
                    {
                      System.exit(0);
                    }
                    if (choice == JOptionPane.NO_OPTION)
                    {
                       dispose();
                        paintball obj=new paintball(); 
                       
                    }
                	
                }
                x = (int)(480*Math.random())+1;
                y = (int)(480*Math.random())+1;
                time--;
               hitme.setBounds(x, y, 20, 20);
            }
        

    });
    }
}
