import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.Before;

public class TestCases
{
   private static final Song[] songs = new Song[] {
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Gerry Rafferty", "Baker Street", 1978)
      };

   @Test
   public void testArtistComparator()
   {
	   ArtistComparator comp = new ArtistComparator();
	   assertTrue(comp.compare(songs[0], songs[1]) < 0);
   }

   @Test
   public void testLambdaTitleComparator()
   {
	   Comparator<Song> comp = (Song one, Song two) -> (one.getTitle().compareTo(two.getTitle()));
	   
	   assertTrue(comp.compare(songs[0], songs[1]) > 0);
   }

   @Test
   public void testComposedComparator()
   {
	   Comparator<Song> comp = (Song one, Song two) -> (one.getTitle().compareTo(two.getTitle()));
	   ArtistComparator ac = new ArtistComparator();
	   
	   ComposedComparator cc = new ComposedComparator(ac, comp);
	   
	   assertTrue(cc.compare(songs[0], songs[1]) < 0);
   }

   @Test
   public void testThenComparing()
   {
	   Comparator<Song> next_comp = (Song a, Song b) -> (a.getArtist().compareTo(b.getArtist()));
	   Comparator<Song> comp = ((Song one, Song two) -> (one.getTitle().compareTo(two.getTitle())));
	   Comparator<Song> new_comp = comp.thenComparing(next_comp);
	   
	   assertTrue(new_comp.compare(songs[0], songs[2]) > 0);
   }

   @Test
   public void runSort()
   {
      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      Comparator<Song> comp_a = (Song a, Song b) -> (a.getArtist().compareTo(b.getArtist()));
	  Comparator<Song> comp_t = (Song one, Song two) -> (one.getTitle().compareTo(two.getTitle()));
	  Comparator<Song> comp_y = (Song first, Song second) -> (first.getYear() - second.getYear());
	  
	  Comparator<Song> comp_again = comp_a.thenComparing(comp_t);
	  Comparator<Song> comp_final = comp_again.thenComparing(comp_y);

      songList.sort(comp_final);

      printList(songList);
   }

   private static void printList(List<Song> songList)
   {
      int i = 0;
      for (Song song : songList)
      {
         System.out.println(i + ": " + song);
         i++;
      }
   }
}
