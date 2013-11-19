class Multiple extends Functions{
    
   public double result(double x, double y){
    return x * y;
  }
   
  public String getExpr(String x,String y){
    return "mul("+x+"*"+y+")";
  }
}