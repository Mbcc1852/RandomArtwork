class Expo extends Functions{
  int ran = random.nextInt(1);
  public double result(double x,double y){
    if(ran == 0)
      return Math.getExponent(Math.PI* x);
    return Math.getExponent(Math.PI* y);
  }
  
  public String getExpr(String x,String y){
    if(ran == 0)
      return "exp(pi*"+y+")";
    return "exp(pi*"+x+")";
  }
}