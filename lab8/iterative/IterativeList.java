import java.util.List;
import java.util.LinkedList;

public class IterativeList<T> implements SimpleList
{
	private IterativeNode first;
	private List<IterativeNode> list;
	
	public IterativeList()
	{
		list = new LinkedList<IterativeNode>();
		this.first = list.get(0);
	}
	
	public void addToEnd(Object element)
	{
		list.add(IterativeNode(element));
	}
	
	public void add(int index, Object element)
	{
		int size = list.size();
		int idx = 0;
		while (idx < index)
		{
			idx++;
		}
		list.add(idx, IterativeNode(element, list.get(idx + 1)));
	}
	
	public void remove(int index)
	{
		list.remove(index);
	}
	
	public T get(int index)
	{
		return list.get(index).getValue();
	}
	
	public int indexOf(Object element)
	{
		int size = list.size();
		int idx = 0;
		
		while (idx < size && list.get(idx).getValue() != element)
		{
			idx++;
		}
		
		return idx;
	}
	
	public int size()
	{
		return list.size();
	}
	
	public <IterativeNode> SimpleList<IterativeNode> map(java.util.function.Function<Object, IterativeNode> function)
	{
		List<IterativeNode> fin_list = new LinkedList<IterativeNode>();
		int size = list.size();
		int idx = 0;
		
		while (idx < size)
		{
			fin_list.add(function.apply(list.get(idx)));
			idx++;
		}
		
		return (IterativeList)fin_list;
	}
	
	public class IterativeNode
	{
		private T value;
		private T next;
		
		public IterativeNode(T value, T next)
		{
			this.value = value;
			this.next = next;
		}
		
		public T getValue()
		{
			return this.value;
		}
		
		public T getNext()
		{
			return this.next;
		}
		
		public void setNext(T v)
		{
			this.next = v;
		}
	}
	
}