public class BetterLoop
{
   public static boolean contains(int [] values, int v)
   {
      /* TO DO: if value v is in the array, return true.
         If not, return false.  Use a "foreach" loop.
      */
	  for (int value : values)
	  {
		  if (v == value)
		  {
			  return true;
		  }		  // A bit optimistic, but a real boolean value.
	  }
	  return false;
   }
}
