/*
 * Fall 2021 CSCI 185
 * Name: Jonathan Weng
 * Member: Jingsong Hu
 * December 2, 2021
 * M8: Event-driven Programming Lab
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;  
import java.awt.event.*;  
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.Color;  
import javax.swing.JOptionPane;

public class Painter implements MouseMotionListener, ActionListener
{
    private Color col = Color.BLACK;
    private JPanel Board;
    private JButton Red;
    private JButton Blue;
    private JButton Black;
    private JButton Green;
    private JButton Eraser;
    private JButton Clear;
    private JButton Brushsize;
    private JButton Save;
    private int x;
    private int y;
    private int length = 10;
    private int width = 10;
    private String A;
    public Painter()
    {
        JFrame Painter = new JFrame("Painter");
        JPanel p = new JPanel();
        Board = new JPanel();
        Painter.setLayout(new BorderLayout());
        Painter.setSize(1000,800);
        Red = new JButton("Red");
        Black = new JButton("Black");
        Blue = new JButton("Blue");
        Green = new JButton("Green");
        Eraser = new JButton("Eraser");
        Clear = new JButton("Clear");
        Brushsize = new JButton("BrushSize");
        Save = new JButton("Save");

        p.add(Red);
        p.add(Black);
        p.add(Blue);
        p.add(Green);
        p.add(Eraser);
        p.add(Clear);
        p.add(Brushsize);
        p.add(Save);

        Red.addActionListener(this);
        Black.addActionListener(this);
        Blue.addActionListener(this);
        Green.addActionListener(this);
        Eraser.addActionListener(this);
        Clear.addActionListener(this);
        Brushsize.addActionListener(this);
        Save.addActionListener(this);

        Board.addMouseMotionListener(this);
        Board.setBackground(Color.WHITE);

        Painter.add(Board, BorderLayout.CENTER);
        Painter.add(p, BorderLayout.SOUTH);
        Painter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Painter.setVisible(true);
        Painter.setResizable(false);
    }

    public void actionPerformed(ActionEvent e)
    {
        String press = e.getActionCommand();
        try{
            if(e.getSource() == Brushsize){
                A = JOptionPane.showInputDialog("Brush And Eraser Size");
                width = Integer.parseInt(A);
                length = Integer.parseInt(A);
            }
        }
        catch(Exception i){
            JOptionPane.showMessageDialog(null, "Please Enter A Number");
        }
        if(press.equals("Blue"))
        {
            col = new Color(51, 51, 204);
        }
        else if (press.equals("Red"))
        {
            col = Color.RED;
        }
        else if (press.equals("Yellow"))
        {
            col = Color.YELLOW;
        }
        else if (press.equals("Green"))
        {
            col = Color.GREEN;
        }
        else if (press.equals("Black"))
        {
            col = Color.BLACK;
        }
        else if (press.equals("Eraser"))
        {
            col = Color.WHITE;
        }
        else if (press.equals("Clear"))
        {
            Board.removeAll();
            Board.updateUI();
        }
        else if (press.equals("Save"))
        {
             SaveFile();
        }
    }

    public void mouseMoved(MouseEvent e)
    {
    }

    public void mouseDragged(MouseEvent e)
    {
        Graphics g = Board.getGraphics();
        x = e.getX();
        y = e.getY();
        g.setColor(col);
        g.fillOval(x, y, width, length);
    }

    public static void main(String [] args)
    {
        Painter p = new Painter();
    }
    
    public void SaveFile()
    {
            
    }
}