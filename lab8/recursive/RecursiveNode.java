
public interface RecursiveNode<T>
{
	public T getValue();
	
	public RecursiveNode<T> getNext();

	public RecursiveNode<T> addToEnd(T element);
	
	public RecursiveNode<T> add(int index, T element, int myIndex);
	
	public RecursiveNode<T> remove(int index, int myIndex);
	
	public T get(int index, int myIndex);
	
	public int indexOf(T element, int myIndex);
	
	public int size();
	
	public <R> SimpleList<R> map(java.util.function.Function<T, R> function, SimpleList<R> fin);
}

