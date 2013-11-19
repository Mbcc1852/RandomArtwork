import java.util.Random;
import java.util.ArrayList;
import java.util.Stack;

public class ExprTree {
  
  public static final int MAX_LEVEL = 6;
  
  private ExprNode root;
  private Random rand = new Random();
  private ArrayList<Functions> list = new ArrayList<Functions>();
  
  public ExprTree(){
    root = null;
  }
  
  public ExprTree build() {
    ExprTree tree = new ExprTree();
    for(int i = 0; i < MAX_LEVEL; i++){
      tree.insert(new ExprNode());
    }
    tree.inOrder();
    return tree;
  }
  
  public void insert(ExprNode node) {
    if (root == null)
      root = node; // Create a new root
    else {
      // Locate the parent node
      ExprNode parent = null;
      ExprNode current = root;
      while (current != null){
        parent = current;
        current = current.getLeft();
      }
      // Create the new node and attach it to the parent node
      if(parent.getFun() instanceof Avg || parent.getFun() instanceof Multiple){   
        if(parent.getRight() == null){
          parent.setRight(node);
        }else{
          parent.setLeft(node);
        }
      }
      else{
        parent.setLeft(node);
      }
    }
  }
  
  /** Inorder traversal from the root*/
  public void inOrder() {
    inOrder(root);
  }
  
  /** Inorder traversal from a subtree */
  private void inOrder(ExprNode root) {
    if (root == null) return;
    inOrder(root.getLeft());
    list.add(root.getFun());
    inOrder(root.getRight());
  }
  
  /**
   * Evaluate the function represented by this node
   * for the given x and y values.
   * 
   * @param x the value of the variable x
   * @param y the value of the variable y
   * @return the result of evaluating the function
   */
  public double evaluate(double x, double y){
    double pointer = 0;
    double check = 0;
    for(Functions t : list){
      if(pointer == 0){
        pointer = t.result(x,y);
        check = pointer;
      }else{
        pointer = t.result(check,check);
        check = pointer;
      }
    }
    double result = pointer;
    return result;
  }
  
  /**
   * Generate a textual representation of the function
   * represented by this node.
   */
  public String exprAsString(){
    String x = "x";
    String y = "y";
    String pointer = null;
    String check = "";
    for(Functions t : list){
      if(pointer == null){
        pointer = t.getExpr(x,y);
        check = pointer;
      }else{
        pointer = t.getExpr(check,check);
        check = pointer;
      }
    }
    String result = pointer;
    return result;
  }
  
}

