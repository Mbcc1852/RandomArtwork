class IEEEremainders extends Functions{
  
  public double result(double x, double y){
    return Math.IEEEremainder(x,y);
  }
  
  public String getExpr(String x,String y){
    return "IEEEremainder("+x+"*"+y+")";
  }
}