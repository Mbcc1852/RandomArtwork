import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ArtPanel extends JPanel {
 private static final long serialVersionUID = 1L;
 private ExprTree[] rgbExpr;
 
 public ArtPanel(int width, int height) {
  rgbExpr = new ExprTree[3];
  
  setSize(new Dimension(width, height));
 }
 
 public void setRGBExpr(int rgb, ExprTree tree) {
  rgbExpr[rgb] = tree;
 }
 
 @Override
 public void paint(Graphics gr) {
  for (int j = 0; j < getHeight(); j++) {
   for (int i = 0; i < getWidth(); i++) {
     
    double x = ((((double) i) / getWidth()) * 2.0) - 1.0;
    double y = ((((double) j) / getHeight()) * 2.0) - 1.0;
    
    double r = rgbExpr[0].evaluate(x, y);
    double g = rgbExpr[1].evaluate(x, y);
    double b = rgbExpr[2].evaluate(x, y);
    
    Color c = new Color(reColor(r), reColor(g), reColor(b));
    gr.setColor(c);
    gr.fillRect(i, j, 1, 1);
   }
  }
 }

 private static int reColor(double val) {
  val += 1.0;
  if (val < 0) {
   val *= -1;
  }
  val /= 2.0;
  int col = (int) (val * 255);
  if (col >= 255) {
   col = 255;
  }
  return col;
 }
}
