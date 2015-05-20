
public class RecursiveList implements SimpleList
{
	private RecursiveNode value;
	
	public RecursiveList(RecursiveNode value)
	{
		this.value = value;
	}
	
	public void addToEnd(RecursiveNode element)
	{
		value.addToEnd(element);
	}
	
	public void add(int index, RecursiveNode element)
	{
		value.add(index, element);
	}
	
	public void remove(int index)
	{
		value.remove(index);
	}
	
	public RecursiveNode get(int index)
	{
		value.get(index);
	}
	
	public int indexOf(RecursiveNode element)
	{
		value.indexOf(element);
	}
	
	public int size()
	{
		value.size();
	}
	
	public <R> SimpleList<R> map(java.util.function.Function<T, R> function)
	{
		return value.map(funcion);
	}
}
