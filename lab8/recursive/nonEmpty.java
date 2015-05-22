import java.util.NoSuchElementException;
import java.io.IOException;

public class nonEmpty implements RecursiveNode<T>
{
	private T value;
	private RecursiveNode<T> start;
	private RecursiveNode<T> next;
	
	public nonEmpty(T value, RecursiveNode<T> next)
	{
		this.value = value;
		this.next = next;
	}
	
	public T getValue()
	{
		return this.value;
	}
	
	public RecursiveNode<T> getNext()
	{
		return this.next;
	}
	
	public void addToEnd(T element)
	{
		if (next != null)
			next.addToEnd(element);
		else
			next = null;
	}
	
	public void add(int index, T element)
	{
		RecursiveNode<T> newNode = new RecursiveNode<T>(element, this.getNext());
		this.next = newNode; 
	}
	
	public void remove(int index)
	{
		this.next = null;
	}
	
	public T get(int index)
	{
		return this.getValue();
	}
	
	public int indexOf(T element)
	{
		
	}
	public int size()
	{
		if (this.getNext() != null)
		{
			i++;
			this.getNext().size();
		}
		else
			return i;
	}
}
