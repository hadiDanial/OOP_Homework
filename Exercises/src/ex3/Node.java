package ex3;

public class Node 
{
	private int val;
	private Node next, prev;
	
	public Node(int val, Node prev, Node next)
	{
		this.val = val;
		this.prev = prev;
		this.next = next;
		if(prev != null)
			prev.next = this;
		if(next != null)
			next.prev = this;
	}
	public int getVal()
	{
		return val;
	}
	public Node getNext()
	{
		return next;
	}
	public Node getPrev()
	{
		return prev;
	}
	
	public Node get(int i)
	{
		if(i == 0)
			return this;
		if(i > 0)
			return next.get(i - 1);
		else return prev.get(i + 1);
	}
	
	public int discard()
	{
		if(prev != null)
			prev.next = next;
		if(next != null)
			next.prev = prev;
		return val;
	}
}
