class Point
{
   final int xCoord;
   final int yCoord;
   
   Point(int x, int y)
   {
      xCoord = x;
      yCoord = y;
   }
   
   int getXCoord()
   {
      return xCoord;
   }
   
   int getYCoord()
   {
      return yCoord;
   }
   
   public static void main(String[] args)
   {
      PApplet.main("ProcessingIntro");
   }
}
