import java.util.Random;

public class ExprNode {
  
  private Functions value;
  private ExprNode left;
  private ExprNode right;
  
  public ExprNode(){
    Random rand = new Random();
    int random = rand.nextInt(6);
    if(random == 0)
      value = new Sin();
    if(random == 1)
      value = new IEEEremainders();
    if(random == 2)
      value = new Cos();
    if(random == 3)
      value = new Abs();
    if(random == 4)
      value = new Avg();
    if(random == 5)
      value = new Multiple();
    if(random == 6)
      value = new Expo();
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
  
  public Functions getFun(){
      return this.value;
  }
}
