class Abs extends Functions{
 int ran = random.nextInt(1);
  public double result(double x,double y){
    if(ran == 0)
      return Math.abs(Math.PI* x);
    return Math.abs(Math.PI* y);
  }
  
  public String getExpr(String x,String y){
    if(ran == 0)
      return "abs(pi*"+x+")";
    return "abs(pi*"+y+")";
  }
}