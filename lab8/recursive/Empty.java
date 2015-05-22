import java.util.NoSuchElementException;
import java.io.IOException;

public class Empty implements RecursiveNode<T>
{
	public Empty()
	{
	}
	
	public T getValue()
	{
		throw new UnsupportedOperationException();
	}
	
	public RecursiveNode getNext()
	{
		throw new UnsupportedOperationException();
	}
	
	public void addToEnd(T element)
	{
		
	}
}
