import java.util.Random;
import java.util.ArrayList;
import java.util.Stack;

public class ExprTree {
  
  public static final int MAX_LEVEL = 8;
  
  private ExprNode root;
  private Random rand = new Random();
  private ArrayList<Integer> list = new ArrayList<Integer>();
  
  public ExprTree(){
    root = null;
  }
  
  public ExprTree build() {
    ExprTree tree = new ExprTree();
    for(int i = 0; i < 8; i++){
      tree.insert(new ExprNode(rand.nextInt(2)+1));
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
        if (node.getData() <= 3) {
          parent = current;
          current = current.getLeft();
        }
      }
      // Create the new node and attach it to the parent node
      if(parent.getData() == 3){   
        if(parent.getRight() == null && node.getData() != 3){
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
    list.add(root.getData());
    System.out.print(root.getData() + " ");
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
    Stack<Double> operands = new Stack<Double>();
    for(int i = 0; i < list.size(); i++){
      if(i == 0)
        operands.push(avg(Math.cos(Math.PI * x), Math.sin(Math.PI *y)));
      else{
        double op1 = operands.pop();
        if(list.get(i) == 1)
          operands.push(Math.sin(Math.PI * op1));
        else if(list.get(i) == 2)
          operands.push(Math.cos(Math.PI * op1));
        //else if (list.get(i) == 3)
        //operands.push(avg(op1, (Math.sin(Math.PI * op1))));
      }
    }
    double result = operands.pop();
    //System.out.println(result);
    return result;
  }
  
  /**
   * Generate a textual representation of the function
   * represented by this node.
   */
  public String exprAsString(){
    Stack<String> operands = new Stack<String>();
    for(int i = 0; i < list.size(); i++){
      if(i == 0)
        operands.push("avg(cos(PI * x), sin(PI *y))");
      else{
        String op1 = operands.pop();
        if(list.get(i) == 1)
          operands.push("sin(PI * "+op1+")");
        else if(list.get(i) == 2)
          operands.push("cos(PI * "+op1+")");
        //else if (list.get(i) == 3)
        //  result = (avg(op1, (Math.sin(Math.PI * x))));
      }
    }
    String result = operands.pop();
    return result;
  }
  
  private double avg(double x, double y){
    return (x + y) / 2.0;
  }
}

