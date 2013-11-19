class Cos extends Functions{
  int ran = random.nextInt(1);
  public double result(double x,double y){
    if(ran == 0)
      return Math.cos(Math.PI* x);
    return Math.cos(Math.PI* y);
  }
  
  public String getExpr(String x,String y){
    if(ran == 0)
      return "cos(pi*"+x+")";
    return "cos(pi*"+y+")";
  }
}