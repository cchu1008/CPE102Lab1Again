import java.util.List;
import java.util.ArrayList;
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
   private boolean goalReached;

   private final int BGND_COLOR = color(220, 230, 245);
   private static final int ANIMATION_TIME = 100;
   
   private final int BGND_VALUE = 1;
   private final int WALL_VALUE = 2;
   private final int GOAL_VALUE = 3;
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
      for (int i = 0; i < worldWidth; i++)
      {
         for (int j = 0; j < worldHeight; j++)
         {
            world[i][j] = BGND_VALUE;
         }
      }
      
      world[5][7] = WALL_VALUE;
      world[6][7] = WALL_VALUE;
      world[7][7] = WALL_VALUE;
	  world[12][10] = GOAL_VALUE;
	  
      w1 = new Point(5, 5);

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
   
   public void keyPressed()
   {
     if (key == 'a' || key == 'A')
     {
       if (canMove("LEFT"))
       {
         move("LEFT");
       }
     }
     
     else if (key == 's' || key == 'S')
     {
       if (canMove("DOWN"))	
       {
         move("DOWN");
       }
     }
     
     else if (key == 'd' || key == 'D')
     {
       if (canMove("RIGHT"))
       {
         move("RIGHT");
       }
     }
     else if (key == 'w' || key == 'W')
     {
       if (canMove("UP"))
       {
         move("UP");
       }
     }
   }

   public void draw()
   {
	   boolean stopBack = false;
	   if (!stopBack)
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
		     }
		 }
	   }
	   else
	   {
		   fill(150, 150, 5);
		   textSize(20);
		   text("Congratulations!", 32*(worldWidth/2), 32*(worldHeight/2));
	   }
	    
      // A simplified action scheduling handler
	  long time = System.currentTimeMillis();
	  if (time >= next_time)
	  {
		 next_image();
		 next_time = time + ANIMATION_TIME;
	  }

	  //background(BGND_COLOR);
	  image(imgs.get(current_image), w1.getXCoord() * 32, w1.getYCoord() * 32);
	 
   }

   public static void main(String[] args)
   {
      PApplet.main("ProcessingIntro");
   }
}
