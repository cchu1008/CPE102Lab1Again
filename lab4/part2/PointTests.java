import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

import java.lang.Math;

public class PointTests
{
   private static final double DELTA = 0.00001;

   public Point a = new CartesianPoint(0.0, 0.0);
   public Point e = new CartesianPoint(0.0, 0.0);
   public Point b = new CartesianPoint(1.0, 0.0);
   public Point c = new CartesianPoint(0.0, 1.0);
   
   public Point d = new PolarPoint(5.0, 0.0);
   public Point g = new PolarPoint(5.0, Math.toRadians(90));
   
   @Test
   public void testCartPointX()
   {
	   assertEquals(0.0, a.xCoordinate(), DELTA);
   }
   
   @Test
   public void testCartPointY()
   {
	   assertEquals(0.0, a.yCoordinate(), DELTA);
   }
   
   @Test
   public void testCartPointR()
   {
	   assertEquals(0.0, a.radius(), DELTA);
   }
   
   @Test
   public void testCartPointA()
   {
	   assertEquals(0.0, a.angle(), DELTA);
   }
   
   @Test
   public void testCartPointRotate()
   {
	   Point second_check = a.rotate90();
	   assertEquals(e.xCoordinate(), second_check.xCoordinate(), DELTA);
	   assertEquals(e.yCoordinate(), second_check.yCoordinate(), DELTA);
	   assertEquals(e.radius(), second_check.radius(), DELTA);
	   assertEquals(e.angle(), second_check.angle(), DELTA);
   }
   
   @Test
   public void testCartPointBX()
   {
	   assertEquals(1.0, b.xCoordinate(), DELTA);
   }
   
   @Test
   public void testCartPointBY()
   {
	   assertEquals(0.0, b.yCoordinate(), DELTA);
   }
   
   @Test
   public void testCartPointBR()
   {
	   assertEquals(1.0, b.radius(), DELTA);
   }
   
   @Test
   public void testCartPointBA()
   {
	   assertEquals(0.0, a.angle(), DELTA);
   }
   
   @Test
   public void testCartPointBRotate()
   {
	   Point check = b.rotate90();
	   assertEquals(c.xCoordinate(), check.xCoordinate(), DELTA);
	   assertEquals(c.yCoordinate(), check.yCoordinate(), DELTA);
	   assertEquals(c.radius(), check.radius(), DELTA);
	   assertEquals(c.angle(), check.angle(), DELTA);
	   
   }
   
   @Test
   public void testPolarPointX()
   {
	   assertEquals(5.0, d.xCoordinate(), DELTA);
   }
   
   @Test
   public void testPolarPointY()
   {
	   assertEquals(0.0, d.yCoordinate(), DELTA);
   }
   
   @Test
   public void testPolarPointR()
   {
	   assertEquals(5.0, d.radius(), DELTA);
   }
   
   @Test
   public void testPolarPointA()
   {
	   assertEquals(0.0, d.angle(), DELTA);
   }
   
   @Test
   public void testPolarPointRotate()
   {
	   Point check_again = d.rotate90();
	   assertEquals(g.xCoordinate(), check_again.xCoordinate(), DELTA);
	   assertEquals(g.yCoordinate(), check_again.yCoordinate(), DELTA);
	   assertEquals(g.radius(), check_again.radius(), DELTA);
	   assertEquals(g.angle(), check_again.angle(), DELTA);
   }
   
}