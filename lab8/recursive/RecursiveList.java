
public class RecursiveList implements SimpleList<T>
{
	private RecursiveNode<T> thing;

	public RecursiveList(RecursiveNode<T> thing)
	{
		this.thing = thing;
	}
	
	public void addToEnd(T element)
	{
		thing.addToEnd(element);
	}
	
	public void add(int index, T element)
	{
		int size = this.size();
		int idx = 0;
		RecursiveNode<T> cur = thing;
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			thing = new RecursiveNode<T>(element, cur);
		else
		{
			//Maybe change to make more recursive...
			while (idx < index - 1)
			{
				idx++;
				cur = cur.getNext();
			}
			cur.add(index, element);
		}
	}
	
	public void remove(int index)
	{
		int size = this.size();
		int idx = 0;
		RecursiveNode<T> cur = thing;
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			thing = cur.getNext();
		else
		{
			//Maybe make more recursive.
			while (idx < index - 1)
			{
				idx++;
				cur = cur.getNext();
			}
			cur.remove(index);
		}
	}
	
	public T get(int index)
	{
		int size = this.size();
		int idx = 0;
		RecursiveNode<T> cur = thing;
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		else if (index == 0)
			return cur.getValue();
		else
		{
			//maybe make more recursive
			while (idx < index)
			{
				idx++;
				cur = cur.getNext();
			}
			thing.get(index);
		}
	}
	
	//Figure out how to do recursively!	
	public int indexOf(T element)
	{
		int size = this.size();
		int idx = 0;
		int result = -1;
		while (idx < size && thing.getValue() != element)
		{
			idx++;
			thing = thing.getNext();
		}
		if (idx >= size || thing.getValue() != element)
			throw new NoSuchElementException();
		else
			return idx;
		
	}
	
	public int size()
	{
		public static int i = 0;
		thing.size();
	}
	
	public <R> SimpleList<R> map(java.util.function.Function<T, R> function)
	{
		return thing.map(funcion);
	}
}
