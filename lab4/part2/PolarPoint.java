import java.lang.Math;

public class PolarPoint
   implements Point
   {
	   private double radius;
	   private double angle;
	   
	   public PolarPoint(double radius, double angle)
	   {
		   this.radius = radius;
		   this.angle = angle % Math.toRadians(360);
	   }
	   
	   public double xCoordinate()
	   {
		   double fin_x = Math.cos(this.angle()) * this.radius();
		   return fin_x;
	   }
	   
	   public double yCoordinate()
	   {
		   double fin_y = Math.sin(this.angle()) * this.radius();
		   return fin_y;
	   }
	   
	   public double radius()
	   {
		   return this.radius;
	   }
	   
	   public double angle()
	   {
		   return this.angle;
	   }
	   
	   public Point rotate90()
	   {
		   Point fin = new PolarPoint(this.radius(), ((this.angle() + Math.toRadians(90)) % Math.toRadians(360)));
		   return fin;
	   }
   }