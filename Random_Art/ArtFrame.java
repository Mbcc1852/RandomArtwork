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
  
  exportButton = new JButton();
  exportButton.setSize(new Dimension(150, 25));
  exportButton.setText("Export");
  exportButton.setLocation(200, labelStart + 75);
  exportButton.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    System.out.println("r=" + rExprLabel.getText());
    System.out.println("g=" + gExprLabel.getText());
    System.out.println("b=" + bExprLabel.getText());
   }
  });
  //right.add(exportButton);
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

 public static void main(String[] args) {
  ArtFrame frame = new ArtFrame();
  frame.setTitle("Random Art");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
 }
}

