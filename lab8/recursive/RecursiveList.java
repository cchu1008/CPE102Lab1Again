
public class RecursiveList<T> implements SimpleList<T>
{
	private RecursiveNode<T> head;

	public RecursiveList()
	{
		this.head = new Empty<T>();
	}
	
	public void addToEnd(T element)
	{
		head = head.addToEnd(element);
	}
	
	public void add(int index, T element)
	{
		head = head.add(index, element, 0);
	}
	
	public void remove(int index)
	{
		head = head.remove(index, 0);
	}
	
	public T get(int index)
	{
		return head.get(index, 0);
	}
	
	public int indexOf(T element)
	{
		return head.indexOf(element, 0);
	}
	
	public int size()
	{
		return head.size();
	}
	
	public <R> SimpleList<R> map(java.util.function.Function<T, R> function)
	{
		SimpleList<R> fin = new RecursiveList<R>();
		return head.map(function, fin);
	}
}
