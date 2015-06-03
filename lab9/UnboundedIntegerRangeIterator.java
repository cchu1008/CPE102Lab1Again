import java.util.Iterator;
import java.io.IOException;

public class UnboundedIntegerRangeIterator implements Iterator<Integer>, Iterable<Integer>
{
	private int current;
	private int lower;
	
	public UnboundedIntegerRangeIterator(int lower)
	{
		this.lower = lower;
		this.current = lower - 1;
	}
	
	public Integer next()
	{
		current++;
		return current;
	}
	
	public boolean hasNext()
	{
		return true;
	}
	
	public Iterator<Integer> iterator()
	{
		return this;
	}
	
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}
