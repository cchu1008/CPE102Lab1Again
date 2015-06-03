import java.util.Iterator;
import java.lang.Iterable;
import java.io.IOException;

public class TakeIterator<T> implements java.util.Iterator<T>, java.lang.Iterable<T>
{
	private int numToTake;
	private Iterator<T> iter;
	private int current;
	
	public TakeIterator(int numToTake, Iterator<T> iter)
	{
		this.current = 0;
		this.numToTake = numToTake;
		this.iter = iter;
	}
	
	public T next()
	{
		if (current < numToTake)
		{
			current++;
			return iter.next();
		}
		return null;
	}
	
	public Iterator<T> iterator()
	{
		return this;
	}
	
	public boolean hasNext()
	{
		return iter.hasNext() && current < numToTake;
	}
	
	public void remove()
	{
		throw new UnsupportedOperationException();
	}		
}
