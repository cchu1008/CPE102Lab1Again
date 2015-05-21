import java.util.List;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.io.IOException;

public class IterativeList<T> implements SimpleList<T>
{
	private IterativeNode<T> start;
	
	public IterativeList()
	{
		this.start = null;
	}
	
	public void addToEnd(T element)
	{
		if (start == null)
			start = new IterativeNode<T>(element, null);
		else
		{
			IterativeNode<T> cur = start;
			while (cur.getNext() != null)
				cur = cur.getNext();
			cur.setNext(new IterativeNode<T>(element, null));
		}
	}
	
	public void add(int index, T element)
	{
		int size = this.size();
		int idx = 0;
		IterativeNode<T> cur = start;
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			start = new IterativeNode<T>(element, cur);
		else if (index == size)
		{
			addToEnd(element);
		}
		else
		{
			while (idx < index - 1)
			{
				idx++;
				cur = cur.getNext();
			}
			IterativeNode<T> newNode = new IterativeNode<T>(element, cur.getNext());
			cur.setNext(newNode);
		}
	}
	
	public void remove(int index)
	{
		int size = this.size();
		int idx = 0;
		IterativeNode<T> cur = start;
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			start = cur.getNext();
		else
		{
			while (idx < index - 1)
			{
				idx++;
				cur = cur.getNext();
			}
			cur.setNext(cur.getNext().getNext());
		}
	}
	
	public T get(int index)
	{
		int size = this.size();
		int idx = 0;
		IterativeNode<T> cur = start;
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			return start.getValue();
		else
		{
			while (idx < index)
			{
				idx++;
				cur = cur.getNext();
			}
			return cur.getValue();
		}
	}
	
	public int indexOf(T element)
	{
		int size = this.size();
		int idx = 0;
		
		while (idx < size && this.get(idx) != element)
		{
			idx++;
		}
		if (idx >= size || this.get(idx) != element)
			throw new NoSuchElementException();
		else
			return idx;
	}
	
	public int size()
	{
		int i = 0;
		IterativeNode<T> cur = start;
		while (cur != null)
		{
			i++;
			cur = cur.getNext();
		}
		return i;
	}
	
	public <R> SimpleList<R> map(java.util.function.Function<T, R> function)
	{
		SimpleList<R> fin_list = new IterativeList<R>();
		int size = this.size();
		int idx = 0;
		
		while (idx < size)
		{
			fin_list.add(idx, function.apply(this.get(idx)));
			idx++;
		}
		
		return fin_list;
	}
	
	private static class IterativeNode<R>
	{
		public R value;
		public IterativeNode<R> next;
		
		public IterativeNode(R value, IterativeNode<R> next)
		{
			this.value = value;
			this.next = next;
		}
		
		public R getValue()
		{
			return this.value;
		}
		
		public IterativeNode<R> getNext()
		{
			return this.next;
		}
		
		public void setNext(IterativeNode<R> v)
		{
			this.next = v;
		}
	}
	
}