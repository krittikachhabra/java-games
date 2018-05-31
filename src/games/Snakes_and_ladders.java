package games;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableCellRenderer;

class play extends JFrame implements ActionListener{  
    
    JButton b;
    JTable jt;
    JLabel l1,l2,l3,l4;
    int x1=0,y1=450,count1=0,countplayer=0,x2=0,y2=450,count2=0;
    play()
    {
    setLayout(null);
    setVisible(true);
    setSize(650,700);
    getContentPane().setBackground(Color.yellow);
    setResizable(true);
    Object data[][]=new Object[10][10];
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();
    for(int i=0;i<10;i+=2)
        for(int j=0;j<10;j++)
        {
            data[i][j]=(100-(10*i)-j);
        }
    for(int i=1;i<10;i+=2)
        for(int j=9;j>=0;j--)
        {
            data[i][j]=(91-(10*i)+j);
        }
    Object column[]=new Object[10];
    for(int i=0;i<10;i++)
        column[i]=i;
    jt=new JTable(data, column)
    {
        public Component prepareRenderer 
        (TableCellRenderer renderer, int row, int column) 
        { 
        Component c = super.prepareRenderer( renderer, row, column); 
        if( c instanceof JComponent ) 
        ((JComponent)c).setOpaque(false); 
        return c; 
        } 
        ImageIcon abc = new ImageIcon(getClass().getClassLoader().getResource("resources/ok copy.png"));
        public void paint( Graphics g ) 
        { 
        Dimension d = getSize(); 
        for( int x = 0; x < d.width; x += abc.getIconWidth() ) 
        for( int y = 0; y < d.height; y += abc.getIconHeight() ) 
        g.drawImage( abc.getImage(), x, y, null, null ); 
        super.paint(g); 
        } 
        
    };
    jt.setOpaque(false);
   
    add(jt);

    jt.setBounds(75,75,500,500); 
    jt.setEnabled(false);
        jt.setRowHeight(50);
        l1= new JLabel();
        l1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/images.jpeg")));
        l1.setBounds(0,450,50,50);
        jt.add(l1);
        l4= new JLabel();
        l4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/images22.png")));
        l4.setBounds(0,450,50,50);
        jt.add(l4);
        b=new JButton("Play");
        add(b);
        b.setBounds(300,610,100,20);
        MatteBorder border=new MatteBorder(1,1,0,0,Color.gray);
        jt.setBorder(border);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num1 = (int)(6*Math.random())+1;
                if(countplayer%2 == 0)
                {
                    l2=new JLabel("Player 1 rolled "+num1);
                    l2.setOpaque(true);
                    add(l2);
                    l2.setBounds(400,610,100,20);

                    if(count1%2==0)
                        x1 += num1*50;
                    else 
                        x1 -= num1*50;
                    if(x1>450)
                        {
                        x1 = x1 + 50 - 2*(x1-450);
                        y1 = y1 - 50;
                        count1++;
                        }
                    else if(x1<0)
                    {
                        x1 = x1 - 50 + 2*(0-x1);
                        y1 = y1 - 50;
                        count1++;
                    }


                    if((x1<0 ||   y1<0)||(x1==0 && y1==0))
                    {
                        l1.setBounds(0,0,50,50);
                          Object[] options = { "Exit", "Play Again" };
                          int choice = JOptionPane.showOptionDialog(null, 
                              "Player 1 wins", 
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
                              play obj=new play(); 
                             
                          }
                        
                        
                        
                    }
                    else
                    {
            if(x1==200 && y1==400)
                        {
                            y1= 200;
                        }
                        else if(x1==50 && y1== 400)
                        {
                            x1=200;
                            y1=0;
                        }
                        else if(x1==400 && y1==350)
                        {
                            x1=300;
                            y1=150;
                        }
                        else if(x1==300 && y1==350)
                        {
                            x1=250;
                            y1=450;
                        }
                        else if(x1==50 && y1==250)
                        {
                            x1=0;
                            y1=350;
                        }
                        else if(x1==300 && y1==0)
                        {
                            x1=450;
                            y1=100;
                        }
                        else if(x1==50 && y1==0)
                        {
                            x1=100;
                            y1=200;
                        }
                        l1.setBounds(x1,y1,50,50);
                        countplayer++;
                    }

                }
                else
                {
                    l3=new JLabel("Player 2 rolled "+num1);
                    l3.setOpaque(true);
                    add(l3);
                    l3.setBounds(100,610,100,20);

                    if(count2%2==0)
                        x2 += num1*50;
                    else 
                        x2 -= num1*50;
                    if(x2>450)
                        {
                        x2 = x2 + 50 - 2*(x2-450);
                        y2 = y2 - 50;
                        count2++;
                        }
                    else if(x2<0)
                    {
                        x2 = x2 - 50 + 2*(0-x2);
                        y2 = y2 - 50;
                        count2++;
                    }


                    if((x2<0 ||   y2<0)||(x2==0 && y2==0))
                    {
                        l4.setBounds(0,0,50,50);
                          Object[] options = { "Exit", "Play Again" };
                          int choice = JOptionPane.showOptionDialog(null, 
                              "Player 2 wins", 
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
                              play obj=new play(); 
                             
                          }                        
                    }
                    else
                    {

                        if(x2==200 && y2==400)
                        {
                            y2= 200;
                        }
                        else if(x2==50 && y2== 400)
                        {
                            x2=200;
                            y2=0;
                        }
                        else if(x2==400 && y2==350)
                        {
                            x2=300;
                            y2=150;
                        }
                        else if(x2==300 && y2==350)
                        {
                            x2=250;
                            y2=450;
                        }
                        else if(x2==50 && y2==250)
                        {
                            x2=0;
                            y2=350;
                        }
                        else if(x2==300 && y2==0)
                        {
                            x2=450;
                            y2=100;
                        }
                        else if(x2==50 && y2==0)
                        {
                            x2=100;
                            y2=200;
                        }
                        l4.setBounds(x2,y2,50,50);
                        countplayer++;
                    }

                }
               
            }
        });
}
    public void actionPerformed(ActionEvent arg0) {}
   }
   public class Snakes_and_ladders{
       public static void main(String arg[]){
           play obj=new play();
       }
   }
