
public class nonEmpty implements RecursiveNode
{
	private RecursiveNode value;
	private RecursiveNode next;
	
	public nonEmpty(RecursiveNode value, RecursiveNode next)
	{
		this.value = value;
		this.next = next;
	}
	
	public RecursiveNode getValue()
	{
		return this.value;
	}
	
	public RecursiveNode getNext()
	{
		return this.next;
	}
}
