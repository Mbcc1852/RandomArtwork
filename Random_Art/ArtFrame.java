import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ArtFrame extends JFrame {
 private static final long serialVersionUID = 1L;
 
 private ArtPanel panel;
 private JTextField rExprLabel, gExprLabel, bExprLabel;
 private JButton generateButton;
 private JButton exportButton;
 
 public ArtFrame() {
  getContentPane().setPreferredSize(new Dimension(400, 530));
  getContentPane().setLayout(null);
  
  panel = new ArtPanel(400, 400);
  panel.setLocation(0, 0);
  getContentPane().add(panel);
  
  int labelStart = 410;
  
  rExprLabel = createTextField();
  rExprLabel.setLocation(0, labelStart);
  getContentPane().add(rExprLabel);
  gExprLabel = createTextField();
  gExprLabel.setLocation(0, labelStart + 25);
  getContentPane().add(gExprLabel);
  bExprLabel = createTextField();
  bExprLabel.setLocation(0, labelStart + 50);
  getContentPane().add(bExprLabel);

  generateButton = new JButton();
  generateButton.setSize(new Dimension(150, 25));
  generateButton.setText("Generate!");
  generateButton.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    generate();
    repaint();
   }
  });
  generateButton.setLocation(0, labelStart + 75);
  getContentPane().add(generateButton);
  
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
  getContentPane().add(exportButton);

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
  frame.pack();
  frame.setVisible(true);
 }
}
