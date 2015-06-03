import java.util.Iterator;
import java.lang.Iterable;
import java.io.IOException;


public class FilterIterator<T> implements Iterator<T>, Iterable<T>
{
	private Filter<T> filter;
	private Iterator<T> iter;
	
	public FilterIterator(Filter<T> filter, Iterator<T> iter)
	{
		this.filter = filter;
		this.iter = iter;
	}
	
	public T next()
	{
		T temp = this.iter.next();
		while (!filter.accept(temp) || temp == null)
			temp = this.iter.next();
		return temp;
	}
	
	public Iterator<T> iterator()
	{
		return this;
	}
	
	public boolean hasNext()
	{
		return this.iter.hasNext();
	}
	
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
	
}
