import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.lang.Iterable;

public class Tests
{
	@Test
	public void testMakingBoundedIntegerRangeIterator()
	{
		BoundedIntegerRangeIterator first = new BoundedIntegerRangeIterator(1, 7);
		
		String g = "";
		
		for (Object i : first)
		{
			g = g + i;
		}
		
		assertEquals("1234567", g);
	}
	
	@Test
	public void testBoundedHasNext()
	{
		BoundedIntegerRangeIterator first = new BoundedIntegerRangeIterator(0, 6);
		Integer zero = first.next();
		Integer one = first.next();
		Integer two = first.next();
		Integer three = first.next();
		Integer four = first.next();
		Integer five = first.next();
		Integer six = first.next();
		Integer none = first.next();
		boolean see = first.hasNext();
		
		assertEquals(Integer.valueOf(0), zero);
		assertEquals(Integer.valueOf(1), one);
		assertEquals(Integer.valueOf(2), two);
		assertEquals(Integer.valueOf(3), three);
		assertEquals(Integer.valueOf(4), four);
		assertEquals(Integer.valueOf(5), five);
		assertEquals(Integer.valueOf(6), six);
		assertEquals(null, none);
		
		assertFalse(see);
		
		Iterator<Integer> a = first.iterator();
		
		assertEquals(a, first);
	}
	
	@Test
	public void testMakingUnbounded()
	{
		UnboundedIntegerRangeIterator first = new UnboundedIntegerRangeIterator(4);
		
		String g = "";
		
		for (Object i : first)
		{
			if (g.length() < 5)
				g += i;
			else
				break;
		}
		
		assertEquals("45678", g);
	}
	
	@Test
	public void testUnboundedHasNext()
	{
		UnboundedIntegerRangeIterator first = new UnboundedIntegerRangeIterator(4);
		
		Integer zero = first.next();
		Integer one = first.next();
		Integer two = first.next();
		Integer three = first.next();
		Integer four = first.next();
		Integer five = first.next();
		Integer six = first.next();
		Integer none = first.next();
		boolean see = first.hasNext();
		
		assertEquals(Integer.valueOf(4), zero);
		assertEquals(Integer.valueOf(5), one);
		assertEquals(Integer.valueOf(6), two);
		assertEquals(Integer.valueOf(7), three);
		assertEquals(Integer.valueOf(8), four);
		assertEquals(Integer.valueOf(9), five);
		assertEquals(Integer.valueOf(10), six);
		
		Iterator<Integer> a = first.iterator();
		
		assertEquals(a, first);
		assertTrue(see);
	}
	
	@Test
	public void testMakeTakeIterator()
	{
		BoundedIntegerRangeIterator orig = new BoundedIntegerRangeIterator(0, 8);
		TakeIterator<Integer> first = new TakeIterator<>(4, orig);
		
		String g = "";
		
		for (Object i : first)
		{
			g += i;
		}
		
		assertEquals("0123", g);
	}
	
	@Test
	public void testTakeIteratorHasNext()
	{
		UnboundedIntegerRangeIterator orig = new UnboundedIntegerRangeIterator(5);
		BoundedIntegerRangeIterator soon = new BoundedIntegerRangeIterator(0, 12);
		
		TakeIterator<Integer> first = new TakeIterator<>(3, orig);
		TakeIterator<Integer> second = new TakeIterator<>(5, soon);
		
		Integer zero = first.next();
		Integer one = first.next();
		Integer two = first.next();
		Integer three = first.next();
		boolean see = first.hasNext();
		
		
		Integer four = second.next();
		Integer five = second.next();
		Integer six = second.next();
		Integer seven = second.next();
		Integer eight = second.next();
		Integer nine = second.next();
		boolean seeAg = second.hasNext();
		
		assertEquals(Integer.valueOf(5), zero);
		assertEquals(Integer.valueOf(6), one);
		assertEquals(Integer.valueOf(7), two);
		assertEquals(null, three);
		assertFalse(see);
		
		assertEquals(Integer.valueOf(0), four);
		assertEquals(Integer.valueOf(1), five);
		assertEquals(Integer.valueOf(2), six);
		assertEquals(Integer.valueOf(3), seven);
		assertEquals(Integer.valueOf(4), eight);
		assertEquals(null, nine);
		assertFalse(seeAg);

		Iterator<Integer> a = first.iterator();
		Iterator<Integer> b = second.iterator();
		
		assertEquals(a, first);
		assertEquals(b, second);
	}
	/*
	@Test
	public void testMakeFilterIterator()
	{
		BoundedIntegerRangeIterator orig = new BoundedIntegerRangeIterator(0, 6);
		Filter<Integer> OddFilter = (Integer i) -> {return (i & 0x1) == 1;};
		
		FilterIterator<Integer> first = new FilterIterator<>(OddFilter, orig);
		
		String g = "";
		
		for (Object i : first)
		{
			g += i;
		}
		
		assertEquals("135", g);
		
		
		Integer zero = first.next();
		Integer one = first.next();
		Integer two = first.next();
		boolean see = first.hasNext();
		
		assertEquals(Integer.valueOf(1), zero);
		assertEquals(Integer.valueOf(3), one);
		assertEquals(Integer.valueOf(5), two);

		assertFalse(see);
		
	}
	*/
	
}
