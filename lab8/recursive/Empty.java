import java.util.NoSuchElementException;
import java.io.IOException;

public class Empty<T> implements RecursiveNode<T>
{	
	public T getValue()
	{
		throw new UnsupportedOperationException();
	}
	
	public RecursiveNode<T> getNext()
	{
		throw new UnsupportedOperationException();
	}
	
	public RecursiveNode<T> addToEnd(T element)
	{
		return new NonEmpty<T>(element, this);
	}
	
	public RecursiveNode<T> add(int index, T element, int myIndex)
	{
		throw new IndexOutOfBoundsException();
	}
	
	public RecursiveNode<T> remove(int index, int myIndex)
	{
		throw new IndexOutOfBoundsException();
	}
	
	public T get(int index, int myIndex)
	{
		throw new IndexOutOfBoundsException();
	}
	
	public int indexOf(T element, int myIndex)
	{
		throw new NoSuchElementException();
	}
	
	public int size()
	{
		return 0;
	}
	
	public <R> SimpleList<R> map(java.util.function.Function<T, R> function, SimpleList<R> fin)
	{
		return fin;
	}
}
