class Avg extends Functions{
  
  int check = random.nextInt(3);
  
  public double result(double x, double y){
    double result = 0;
    if(check == 0)
      result = (x+y)/2;
    if(check == 1)
      result = ((x*x)+(y*y));
    if(check == 2)
      result = (x*y);
    if(check == 3)
      result = ((x+x)*x*(y+y))/2;          
    return result;
  }
  
  public String getExpr(String x,String y){
    String result = "";
    if(check == 0)
      result = "avg("+x+","+y+")";
    if(check == 1)
      result = "avg"+"(("+x+"*"+x+")"+","+"("+y+"*"+y+"))";
    if(check == 2)
      result = "avg"+"("+x+","+y+")";
    if(check == 3)
      result = "avg"+"(("+x+"+"+x+")"+","+x+","+"("+y+"+"+y+"))";          
    return result;
  }
}