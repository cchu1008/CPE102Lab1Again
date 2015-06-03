import java.util.Iterator;
import java.lang.Iterable;
import java.io.IOException;

public class BoundedIntegerRangeIterator implements Iterator<Integer>, Iterable<Integer>
{
	private int start;
	private int end;
	private int current;
	
	public BoundedIntegerRangeIterator(int start, int end)
	{
		this.start = start;
		this.end = end;
		this.current = start - 1;
	}
	
	public Iterator<Integer> iterator()
	{
		return this;
	}
	
	public Integer next()
	{
		if (current < end)
		{
			current++;
			return current;
		}
		return null;
	}
	
	public boolean hasNext()
	{
		return current < end;
	}
	
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}