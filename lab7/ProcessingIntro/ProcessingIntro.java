import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import processing.core.*;
import processing.core.PApplet;

public class ProcessingIntro extends PApplet
{
   private List<PImage> imgs;
   private int current_image;
   private long next_time;
   private PImage wall;
   private PImage water;
   private PImage goal;
   private Point w1;
   private int[][] world;
   private int[][] path;
   private boolean goalReached;
   private List<Point> init;

   private final int BGND_COLOR = color(220, 230, 245);
   private static final int ANIMATION_TIME = 100;
   
   private final int BGND_VALUE = 1;
   private final int WALL_VALUE = 2;
   private final int GOAL_VALUE = 3;
   private final int VISITED = 4;
   private static int worldWidth = 20;
   private static int worldHeight = 15;

   /* @pjs preload="wyvern1.png,wyvern2.png,wyvern3.png,wall.png,water.png,star.png"; */

   public void setup()
   {
      size(640,480);
      background(BGND_COLOR);

      imgs = new ArrayList<PImage>();
      imgs.add(loadImage("wyvern1.png"));
      imgs.add(loadImage("wyvern2.png"));
      imgs.add(loadImage("wyvern3.png"));
	  
      wall = loadImage("wall.png");
      water = loadImage("water.png");
      goal = loadImage("star.png");
      
      goalReached = false;
	  
      world = new int[worldWidth][worldHeight];
	  path = new int[worldWidth][worldHeight];
	  init = new LinkedList<Point>();
	  
      for (int i = 0; i < worldWidth; i++)
      {
         for (int j = 0; j < worldHeight; j++)
         {
            world[i][j] = BGND_VALUE;
         }
      }
      
	  for (int x = 5; x < 10; x++)
	  {
		  for (int y = 2; y < 5; y++)
		  {
			  world[x + y][y] = WALL_VALUE;
		  }
	  }
	  for (int y = 7; y > 0; y--)
	  {
		  world[2 + y][y] = WALL_VALUE;
	  }
	  world[12][10] = GOAL_VALUE;
	  
      w1 = new Point(5, 2);

      current_image = 0;
      next_time = System.currentTimeMillis() + ANIMATION_TIME;
  }

   private void next_image()
   {
      current_image = (current_image + 1) % imgs.size();
   }
   
   private boolean canMove(String direction)
   {
     if (goalReached)
     {
       return false;
     }
     else
     {
       if (direction == "LEFT")
       {
         if ((w1.getXCoord() - 1) >= 0 && world[w1.getXCoord() - 1][w1.getYCoord()] != WALL_VALUE)
         {
           return true;
         }
         return false;
       }
       else if (direction == "RIGHT")
       {
         if ((w1.getXCoord() + 1) < worldWidth && world[w1.getXCoord() + 1][w1.getYCoord()] != WALL_VALUE)
         {
           return true;
         }
         return false;
       }
       else if (direction == "UP")
       {
         if ((w1.getYCoord() - 1) >= 0 && world[w1.getXCoord()][w1.getYCoord() - 1] != WALL_VALUE)
         {
           return true;
         }
         return false;
       }
       else
       {
         if ((w1.getYCoord() + 1) < worldHeight && world[w1.getXCoord()][w1.getYCoord() + 1] != WALL_VALUE)
         {
           return true;
         }
         return false;
       }
     }
   }
   
   public void move(String direction)
   {
     if (direction == "UP")
     {
       w1 = new Point(w1.getXCoord(), w1.getYCoord() - 1);
     }
     else if (direction == "DOWN")
     {
       w1 = new Point(w1.getXCoord(), w1.getYCoord() + 1);
     }
     else if (direction == "LEFT")
     {
       w1 = new Point(w1.getXCoord() - 1, w1.getYCoord());
     }
     else
     {
       w1 = new Point(w1.getXCoord() + 1, w1.getYCoord());
     }
     
     if (world[w1.getXCoord()][w1.getYCoord()] == GOAL_VALUE)
     {
       goalReached = true;
     }
     
   }
   
   public boolean withinBounds(Point pt, int[][] grid)
   {
	   return (pt.getXCoord() >= 0 && pt.getXCoord() < grid.length && pt.getYCoord() >= 0 && pt.getYCoord() < grid[pt.getXCoord()].length);
   }
   
   public boolean dfs(Point pt, int[][] grid, List<Point> newPath)
   {
	   if (!withinBounds(pt, grid))
		   return false;
	   if (grid[pt.getXCoord()][pt.getYCoord()] == WALL_VALUE)
		   return false;
	   if (this.path[pt.getXCoord()][pt.getYCoord()] == VISITED)
		   return false;
	   if (grid[pt.getXCoord()][pt.getYCoord()] == GOAL_VALUE)
	   {
		   newPath.add(0, pt);
		   return true;
	   }
	   this.path[pt.getXCoord()][pt.getYCoord()] = VISITED;
	   boolean found = (dfs(new Point(pt.getXCoord() + 1, pt.getYCoord()), grid, newPath) ||
					   dfs(new Point(pt.getXCoord() - 1, pt.getYCoord()), grid, newPath) ||
					   dfs(new Point(pt.getXCoord(), pt.getYCoord() + 1), grid, newPath) ||
					   dfs(new Point(pt.getXCoord(), pt.getYCoord() - 1), grid, newPath));
	   if(found)
		   newPath.add(0, pt);
	   return found;
   }
   
   public void findPath()
   {
	   dfs(w1, world, init);
   }
   
   public void keyPressed()
   {
	   
     if (key == 'a' || key == 'A')
	 {
       if (canMove("LEFT"))
         move("LEFT");
     }
     
     else if (key == 's' || key == 'S')
	 {
       if (canMove("DOWN"))	
         move("DOWN");
     }
     
     else if (key == 'd' || key == 'D')
	 {
       if (canMove("RIGHT"))
         move("RIGHT");
     }
     else if (key == 'w' || key == 'W')
	 {
       if (canMove("UP"))
         move("UP");
     }
	 
	 else if (key == 'o' || key == 'O')
	 {
		 init = new LinkedList<Point>();
		 path = new int[worldWidth][worldHeight];
		 findPath();
	 }
	 else if (key == ' ')
	 {
		 w1 = new Point(5, 2);
		 init = new LinkedList<Point>();
		 path = new int[worldWidth][worldHeight];
		 goalReached = false;
	 }
	 
   }

   public void draw()
   {
	   int m = millis();
	   if (!goalReached)
	   {
		 for (int i = 0; i < worldWidth; i++)
		 {
			 for (int j = 0; j < worldHeight; j++)
			 {
				 if (world[i][j] == BGND_VALUE)
				 {
				   image(water, i * 32, j * 32);
				 }
				 else if (world[i][j] == WALL_VALUE)
				 {
				   image(wall, i * 32, j * 32);
				 }
				 else if (world[i][j] == GOAL_VALUE)
				 {
				   image(goal, i * 32, j * 32);
				 }
				 if (path[i][j] == VISITED)
				 {
					 fill(100, 200, 130);
					 ellipse((i * 32) + 16, (j * 32) + 16, 20, 20);
				 }
			 
		     }
		 }
		 
		 for (Point p : init)
		 {
			 fill(200, 250, 40);
			 ellipse((p.getXCoord() * 32) + 16, (p.getYCoord() * 32) + 16, 12, 12);
		 }
		 
		  long time = System.currentTimeMillis();
		  if (time >= next_time)
		  {
			 next_image();
			 next_time = time + ANIMATION_TIME;
		  }

		  //background(BGND_COLOR);
		  image(imgs.get(current_image), w1.getXCoord() * 32, w1.getYCoord() * 32);
	   
	   }
	   else
	   {
		   fill(170, 170, 5);
		   textSize(50);
		   text("Congratulations!", 32*(worldWidth/5), 32*(worldHeight/2));
	   }
	    
      // A simplified action scheduling handler

	 
   }

   public static void main(String[] args)
   {
      PApplet.main("ProcessingIntro");
   }
}
