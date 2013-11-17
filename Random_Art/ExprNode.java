public class ExprNode {
 
  private ExprNode left;
  private ExprNode right;
  private int data;
  
  public ExprNode(int newData) {
    this.data = newData;
  }
  
  public int getData(){
    return this.data; 
  }
  
  public ExprNode getLeft(){
    return this.left; 
  }
  
  public ExprNode getRight(){
    return this.right;
  }
  
  public void setLeft(ExprNode left){
    this.left = left;
  }
  
  public void setRight(ExprNode right){
    this.right = right;
  }
  
}
