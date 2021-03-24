package ex3;

public class List 
{
	private Node head;
	private Node tail;
	
	public void addAtHead(int val)
	{
		head = new Node(val, null, head);
		if(tail == null) tail = head;
	}
	
	public void addAtTail(int val)
	{
		tail = new Node(val, tail, null);
		if(head == null) head = tail;
	}
	

	public int deleteHead()         
	{
		Node temp = head;
		head = head.getNext();
		return temp.discard();
	}
	public int deleteTail()         
	{
		Node temp = tail;
		tail = tail.getPrev();
		return temp.discard();
	}
	public int deleteAt(int i)      
	{ 
		Node tmp = head;
		for (int j = 0; j < i; j++) 
		{
			if(tmp != null) tmp = tmp.getNext();
		}
		if(tmp != null) return tmp.discard();
		return i;
	}


	
	@Override
	public String toString()
	{
		String s = "";
		Node node = head;
		while(node != null)
		{
			s += node.getVal() + " ";
			node = node.getNext();
		}
		return s;
	}
	
}
