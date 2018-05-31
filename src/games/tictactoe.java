package games;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class tictactoe extends JFrame implements MouseListener
{
    private static final Color COLOR_UNCLICKED = Color.white;
    private static final Color COLOR_HITT= Color.CYAN;
    private static final Color COLOR_HIT = Color.red;
    private static final int UNCLICKED = 5;
    private static final int HIT = 7;
    private static final int HIT1 = 6;
    private JLabel title;
    private JPanel titlePanel;
    private JButton[][] gridButton;
    private JPanel gridPanel;
    private final int ROWS = 3;
    private final int COLS = 3;
    private int[][] board;
    ImageIcon cross,o;
    int count=0;
    GridListener gridListener = new GridListener();
    
    Dimension boardSize = new Dimension(340, 400);
    public tictactoe()
    {
        cross = new ImageIcon(getClass().getClassLoader().getResource("resources/crop.png"));
         o = new ImageIcon(getClass().getClassLoader().getResource("resources/o .png"));

        title = new JLabel("TIC TAC TOE");
        titlePanel = new JPanel();
        titlePanel.add(title);
        gridButton = new JButton[ROWS][COLS];
        board= new int [ROWS][COLS];
        gridPanel = new JPanel();
        gridPanel.setPreferredSize(boardSize);
        gridPanel.setLayout(new GridLayout(3, 3));
        for (int r = 0; r < gridButton.length; r++)
            for (int c = 0; c < gridButton[r].length; c++)
            {
            gridButton[r][c] = new JButton();
            gridButton[r][c].setEnabled(true);
            gridButton[r][c].addActionListener(gridListener);
            gridPanel.add(gridButton[r][c]);
            }
        again();
        this.setLayout(new BorderLayout());
        this.add(titlePanel, "North");
        this.add(gridPanel, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(400, 400));
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

     class GridListener implements ActionListener
    {


    
    public void actionPerformed(ActionEvent evt) {
            
    for (int r = 0; r < gridButton.length; r++)
    for(int c = 0; c < gridButton[r].length; c++)
    {
        
    if (evt.getSource() != gridButton[r][c])
    continue;
    handleGridButton(r,c);
    gridButton[r][c].setEnabled(false);
    check();
    return;
    }
        }
    }
     public void handleGridButton(int r, int c)
     {
     if (board[r][c] == UNCLICKED)
     {
         if(count%2==0)
         {
             board[r][c] = HIT;
             
             gridButton[r][c].setIcon(cross);
             gridButton[r][c].setEnabled(false);
             
         }
     
     else
     {

         board[r][c] = HIT1;
         gridButton[r][c].setIcon(o);
        
         gridButton[r][c].setEnabled(false);
     }
     ++count;
     }
     }
     public void check()
     {
         if(board[0][0]==HIT && board[0][1]==HIT && board[0][2]==HIT)
             message();
         else if (board[0][0]==HIT1 && board[0][1]==HIT1 && board[0][2]==HIT1)
             message();
         else if (board[1][0]==HIT && board[1][1]==HIT && board[1][2]==HIT)
             message();
         else if (board[1][0]==HIT1 && board[1][1]==HIT1 && board[1][2]==HIT1)
             message();
         else if (board[2][0]==HIT && board[2][1]==HIT && board[2][2]==HIT)
             message();
         else if (board[2][0]==HIT1 && board[2][1]==HIT1 && board[2][2]==HIT1)
             message();
         else if(board[0][0]==HIT && board[1][0]==HIT && board[2][0]==HIT)
             message();
         else if(board[0][0]==HIT1 && board[1][0]==HIT1 && board[2][0]==HIT1)
             message();
         else if(board[0][1]==HIT && board[1][1]==HIT && board[2][1]==HIT)
             message();
         else if(board[0][1]==HIT1 && board[1][1]==HIT1 && board[2][1]==HIT1)
             message();
         else if(board[0][2]==HIT && board[1][2]==HIT && board[2][2]==HIT)
             message();
         else if(board[0][2]==HIT1 && board[1][2]==HIT1 && board[2][2]==HIT1)
             message();
         else if(board[0][0]==HIT && board[1][1]==HIT && board[2][2]==HIT)
             message();
         else if(board[0][0]==HIT1 && board[1][1]==HIT1 && board[2][2]==HIT1)
             message();
         else if(board[0][2]==HIT && board[1][1]==HIT && board[2][0]==HIT)
             message();
         else if(board[0][2]==HIT1 && board[1][1]==HIT1 && board[2][0]==HIT1)
             message();
         else if(count==9)
         {
             Object[] options = { "Exit", "Play Again" };
             int choice = JOptionPane.showOptionDialog(null, 
                 "It's a tie", 
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
                 count=0;
                 again(); 
                 
             }
         }
         
         
         
     }
     public void message()
     {
         if(count%2==1)
         { Object[] options = { "Exit", "Play Again" };
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
             count=0;
             again(); 
              } 
         }
         else
         {
             Object[] options = { "Exit", "Play Again" };
             int choice = JOptionPane.showOptionDialog(null, 
                 "Player 2 wins", 
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
                 count=0;
                 again(); 
                 
             }
         }
     }
     public void again()
     {
         for (int r = 0; r < board.length; r++) 
             for (int c = 0; c < board.length; c++) 
             { board[r][c] = UNCLICKED; 
             gridButton[r][c].setEnabled(true); 
             gridButton[r][c].setBackground(COLOR_UNCLICKED);
             gridButton[r][c].setIcon(null);
             }
     }
     public static void main(String[] args) {
            tictactoe n= new tictactoe();
            n.pack();
            n.setVisible(true);
            n.setResizable(true);

        }
}
