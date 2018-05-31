package games;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Ships extends JFrame implements ActionListener{

    private JPanel contentPane;
    Timer timer;
    Timer timer2;
    int flag=0;
    static boolean miss,hit,k=false;
    public int count=0,counta=0,countb=0,countc=0,countd=0,level=1,lives=20,xbullet=85;
    int x=418;
    public int p=75,l=10;
    public int y=5,a=-100,b=-100,c=-100,d=-100;
    
    Thread t1;
    /**
    * Launch the application.
    */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ships frame = new Ships();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        });
    }
    
    JLabel lblNewLabel = new JLabel();
    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();
    JLabel l4 = new JLabel();
    JPanel p1= new JPanel();
    JLabel l5 = new JLabel();
    JLabel l6 = new JLabel();
    JLabel l9 = new JLabel();
    public int vai=0;
    //Container container;
    /**
    * Create the frame.
    */
    public Ships() {
         //Container container= getContentPane();
         
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1363, 730);
        contentPane = new JPanel();
        contentPane.setBackground(Color.CYAN);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setVisible(true);
        lblNewLabel.setBackground(new Color(199, 21, 133));
        lblNewLabel.setBounds(1326, 5, 20, 65);
        lblNewLabel.setOpaque(true);
        contentPane.add(lblNewLabel);
        l1.setBackground(Color.PINK);
        l1.setOpaque(true);
        l1.setBounds(1226, 50, 20, 65);
        //DO-NOT ADD THE LABELS IF YOU DONT WANT THEM ON SCREEN i.e. FOR LEVELS. It means don't write the following line.
        l2.setBackground(Color.PINK);
        l2.setOpaque(true);
        l2.setBounds(1126, 150, 20, 65);
        //contentPane.add(l2);
        l3.setBackground(Color.PINK);
        l3.setOpaque(true);
        l3.setBounds(1026, 250, 20, 65);
        //contentPane.add(l3);
        l4.setBackground(Color.PINK);
        l4.setOpaque(true);
        l4.setBounds(926, 350, 20, 65);
        //contentPane.add(l4);
        contentPane.add(p1);
        p1.setBounds(0,5,85,20);
        p1.add(l5);
        p1.setLayout(null);
        l5.setBackground(Color.RED);
        l5.setOpaque(true);
        l5.setBounds(0, 0, 65, 20);
        p1.add(l6);
        l6.setBackground(new Color(255, 165, 0));
        l6.setOpaque(true);
        l6.setBounds(65, 0, 20, 20);
        contentPane.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent arg0) {}
            public void mousePressed(MouseEvent arg0){}
            public void mouseExited(MouseEvent arg0) {}
            public void mouseEntered(MouseEvent arg0) {}
            public void mouseClicked(MouseEvent arg0) {
               if(k==false)
               {
                k=true;
                flag=1;
                vai=l;
                p1.add(l6);
                l6.setBounds(65, 0, 20, 20);
                add(l6); 
                l6.setBounds(85,l,20,20);

                System.out.println(k);
            }}
        });
        timer = new Timer(10,this);
        timer.start();
        
    }
    
    void drawing(int y,int a,int b,int c,int d)
    {
        lblNewLabel.setBounds(1326, y, 20, 65);
        l1.setBounds(1226, a, 20, 65);
        l2.setBounds(1126, b, 20, 65);
        l3.setBounds(1026, c, 20, 65);
        l4.setBounds(926, d, 20, 65);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

            //System.out.println("hello");
            contentPane.addMouseMotionListener(new MouseAdapter(){ 
            public void mouseMoved(MouseEvent e){
                //if(k==false)
           // {
                
                p = e.getX();
                l = e.getY();
                p1.setBounds(0,l,85,20);
                repaint();
           // }
            }
        });
        
        if(level==2)
        {
            contentPane.add(l1);
            a=625;
        }
        if(level==5)
        {
            contentPane.add(l2);
            b=0;
        }
        if(level==10)
        {
            contentPane.add(l3);
            c=625;
        }
        if(level==15)
        {
            contentPane.add(l4);
            d=0;
        }
        
        if(count%2==0)
            y=y+1;
        else
            y=y-1;
        if(y==625 || y==0)
            count++;
        if(counta%2==0)
            a=a-3;
        else
            a=a+3;
        if(a>=625 || a<=0)
            counta++;
        if(countb%2==0)
            b=b+4;
        else
            b=b-4;
        if(b>=625 || b<=0)
            countb++;
        if(countc%2==0)
            c=c-3;
        else
            c=c+3;
        if(c>=625 || c<=0)
            countc++;
        if(countd%2==0)
            d=d+4;
        else
            d=d-4;
        if(d>=625 || d<=0)
            countd++;
        drawing(y,a,b,c,d);
        if(k==true)
        {
                int ybullet=vai;
                if((xbullet>=906 && xbullet<=946) && (ybullet>=d && ybullet<= (d+65)))
                {
                    miss=true;
                }
                else if((xbullet>=1006 && xbullet<=1046) && (ybullet>=c && ybullet<=(c+65)))
                {
                    miss=true;
                }
                else if((xbullet>=1106 && xbullet<=1146) && (ybullet>=b && ybullet<=(b+65)))
                {
                    miss=true;
                }
                else if((xbullet>=1206 && xbullet<=1246) && (ybullet>=a && ybullet<=(a+65)))
                {
                    miss=true;
                }
                else if((xbullet>=1306 && xbullet<=1363) && (ybullet>=y && ybullet<=(y+65)))
                {
                    hit=true;
                }
                add(l6);
                l6.setBounds(xbullet,ybullet,20,20);
                xbullet+=25;
            if(hit==true)
                {
                level++;
                System.out.println("Its a hit!! "+level+" "+lives);
                ((Timer)e.getSource()).stop();
                }
            else if(miss==true)
                {
                lives--;
                System.out.println("It's a miss :("+level+" "+lives);
                ((Timer)e.getSource()).stop();
                }
            else if(xbullet>1346)
                {
                lives--;
                System.out.println("It's a miss :("+level+" "+lives);
                ((Timer)e.getSource()).stop();
                }            
        if(hit==true || miss==true || xbullet > 1346)
            {
        //((Timer)e.getSource()).stop();
            k=false;
            hit=false;
            miss=false;
            xbullet=85;
            p1.add(l6);
            l6.setBounds(65, 0, 20, 20);
            
            timer.start();
            }
        if(level==20 )
        {
            Object[] options = { "Exit", "Play Again" };
            int choice = JOptionPane.showOptionDialog(null, 
                "Player wins", 
                "Quit?", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]);

            // interpret the user's choice
            if (choice == JOptionPane.YES_OPTION)
            {
              System.exit(0);
            }
            if (choice == JOptionPane.NO_OPTION)
            {
                 dispose();
                 count=0;counta=0;countb=0;countc=0;countd=0;level=1;lives=20;xbullet=85;
                 x=418;flag=0;
                 p=75;l=10;
                 y=5;a=-100;b=-100;c=-100;d=-100;
                 ((Timer)e.getSource()).stop();
                 timer.start();
                  Ships obj=new Ships();  
               
            }
             
        }
        if(lives==0 )
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
            // interpret the user's choice
            if (choice == JOptionPane.YES_OPTION)
            {
              System.exit(0);
            }
            if (choice == JOptionPane.NO_OPTION)
            {
               dispose();
               count=0;counta=0;countb=0;countc=0;countd=0;level=1;lives=20;xbullet=85;
               x=418;flag=0;
               p=75;l=10;
               y=5;a=-100;b=-100;c=-100;d=-100;
               ((Timer)e.getSource()).stop();
               timer.start();
                Ships obj=new Ships(); 
               
            }
             
        }
    }
    }
}
