import java.util.Random;

abstract class Functions{
  
  protected Random random = new Random();
  
  public abstract double result(double x, double y);
  public abstract String getExpr(String x, String y); 
}