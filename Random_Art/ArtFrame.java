import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JButton;




/**
 * Write a description of class ArtFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArtFrame extends JFrame {
  private static final long serialVersionUID = 1L;
  
  private ArtPanel panel;
  private JTextField rExprLabel, gExprLabel, bExprLabel;
  private JButton generateButton;
  private JButton exportButton;
  private ImageIcon logo = new ImageIcon("logo.png");
  private ImageIcon frame = new ImageIcon("frame.png");
  
  public ArtFrame() {
    
    setBackground(Color.black);
    setLayout(new BorderLayout());
    setSize(800,580);
    
    panel = new ArtPanel(400,400);
    
    //Create the menu bar.
    JMenuBar menuBar = new JMenuBar();
    
    //Add a JMenu
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    
    setJMenuBar(menuBar);
    
    JMenuItem exit = new JMenuItem("Exit");
    JMenuItem maxLevel = new JMenuItem("Max Level");
    JMenuItem export = new JMenuItem("Export");
    
    menuBar.add(file);
    menuBar.add(edit);
    file.add(exit);
    edit.add(maxLevel);
    edit.add(export);
    
    export.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("=========================================================================================================================================");
        System.out.println("                   Function of Expr                 ");
        System.out.println("Red = " + rExprLabel.getText());
        System.out.println("Green = " + gExprLabel.getText());
        System.out.println("Blue = " + bExprLabel.getText());
        System.out.println("=========================================================================================================================================");
      }
    });
    
    maxLevel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent maxLevel) {
        maxLevel();
      }
    });
    
    exit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent exit) {
        exit();
      }
    });
    
    JPanel left = new JPanel();
    left.setSize(450,450);
    left.setLayout(new BorderLayout());
    left.add(new JLabel(frame), BorderLayout.CENTER);
    left.add(panel);
    
    add(left, BorderLayout.CENTER);
    
    JPanel right = new JPanel();
    right.setLayout(new BorderLayout());
    right.add(new JLabel(logo), BorderLayout.NORTH);
    
    
    JPanel bottom = new JPanel();
    bottom.setLayout(new GridLayout(3,1));
    
    int labelStart = 410;
    
    rExprLabel = createTextField();
    bottom.add(rExprLabel);
    gExprLabel = createTextField();
    bottom.add(gExprLabel);
    bExprLabel = createTextField();
    bottom.add(bExprLabel);
    
    generateButton = new JButton();
    generateButton.setSize(150,70);
    generateButton.setText("Generate!");
    generateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        generate();
        repaint();
      }
    });
    right.add(generateButton, BorderLayout.CENTER);
    add(right, BorderLayout.EAST);
    
    add(bottom, BorderLayout.SOUTH);
    generate();
  }
  
  private void generate() {
    ExprTree rExpr = new ExprTree().build();
    ExprTree gExpr = new ExprTree().build();
    ExprTree bExpr = new ExprTree().build();
    
    panel.setRGBExpr(0, rExpr);
    panel.setRGBExpr(1, gExpr);
    panel.setRGBExpr(2, bExpr);
    
    rExprLabel.setText(rExpr.exprAsString());
    gExprLabel.setText(gExpr.exprAsString());
    bExprLabel.setText(bExpr.exprAsString());
  }
  
  private JTextField createTextField() {
    JTextField textField = new JTextField();
    textField.setSize(new Dimension(400, 20));
    return textField;
  }
  
  private void maxLevel(){
    String maxlv = JOptionPane.showInputDialog(panel, "What's level do you want?","number of maxlevel");
    int y = Integer.parseInt(maxlv);
    ExprTree.setMaxlv(y);
  }
  
  private void exit(){
    int n = JOptionPane.showConfirmDialog(panel, "Are you want exit ?","Exit",JOptionPane.YES_NO_OPTION);
    if (n == JOptionPane.YES_OPTION) {
      System.exit(0);
      
    } 
  }
  
  
  public static void main(String[] args) {
    ArtFrame frame = new ArtFrame();
    frame.setTitle("Random Art");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

