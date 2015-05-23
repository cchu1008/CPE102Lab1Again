import java.util.NoSuchElementException;
import java.io.IOException;

public class NonEmpty<T> implements RecursiveNode<T>
{
	private T value;
	private RecursiveNode<T> next;
	
	public NonEmpty(T value, RecursiveNode<T> next)
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
	
	public RecursiveNode<T> addToEnd(T element)
	{
		this.next = this.next.addToEnd(element);
		return this;
	}
	
	public RecursiveNode<T> add(int index, T element, int myIndex)
	{
		if (index == 0 && myIndex == 0)
		{
			RecursiveNode<T> cur = new NonEmpty<T>(element, this);
			return cur;
		}
		else if (myIndex + 1 == index)
		{
			RecursiveNode<T> cur = new NonEmpty<T>(element, this.next);
			this.next = cur;
			return this;
		}
		else
		{
			this.next = this.next.add(index, element, myIndex + 1);
			return this;
		}
		
	}
	
	public RecursiveNode<T> remove(int index, int myIndex)
	{
		if (index == 0 && myIndex == 0)
		{
			RecursiveNode<T> cur = this.next;
			return cur;
		}
		else if (myIndex + 1 == index)
		{
			this.next = this.next.getNext();
			return this;
		}
		else
		{
			this.next = this.next.remove(index, myIndex + 1);
			return this;
		}
	}
	
	public T get(int index, int myIndex)
	{
		if (myIndex == index)
			return this.getValue();
		else
			return next.get(index, myIndex + 1);
	}
	
	public int indexOf(T element, int myIndex)
	{
		if (this.getValue() == element)
			return myIndex;
		else
			return this.next.indexOf(element, myIndex + 1);
	}
	
	public int size()
	{
		return 1 + next.size();
	}
	
	public <R> SimpleList<R> map(java.util.function.Function<T, R> function, SimpleList<R> fin)
	{
		fin.addToEnd(function.apply(this.getValue()));
		return this.next.map(function, fin);
	}
}
