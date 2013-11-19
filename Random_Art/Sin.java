class Sin extends Functions{
  int ran = random.nextInt(1);
  public double result(double x,double y){
    if(ran == 0)
      return Math.sin(Math.PI* x);
    return Math.sin(Math.PI* y);
  }
  
  public String getExpr(String x,String y){
    if(ran == 0)
      return "sin(pi*"+x+")";
    return "sin(pi*"+y+")";
  }
}