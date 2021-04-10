package tree;

public class Node 
{
	private int count = 0;
	private Node[] children;
	private static final int LETTERS = 26;
	

	public Node()
	{
		children = new Node[LETTERS];
		count = 0;
	}
	
	public int num(String s)     
	{ 
		int index;
		Node n = this;
		for(int i = 0; i < s.length(); i++)
		{
			index = letterToInt(s.charAt(i));
			if(n.children[index] == null)
				return 0;
			n = n.children[index];
		}
		return n.count;
	}
	public void add(String s)    
	{ 
		int index;
		Node n = this;
		s.toLowerCase();
		for(int i = 0; i < s.length(); i++)
		{
			index = letterToInt(s.charAt(i));
			//System.out.println("Index: " + index + ", letter: " + s.charAt(i));
			if(n.children[index] == null)
				n.children[index] = new Node();
			n = n.children[index];
		}
		n.count++;
	}
	
	private int letterToInt(char c)
	{
		if(isLowerCase(c))
			return c - 'a';		
		else
		{			
			c = 'a';
			return c - 'a';
		}
	}
	
	@SuppressWarnings("unused")
	private char intToLetter(int num)
	{
		char c = (char) ('a' + num);
		if(c > 'z') c = 'z';
		return c;
	}

	
	private boolean isLowerCase(char c)
	{
		return (c <= 'z' && c >= 'a');
	}
	
	private String treeToString()
	{
		StringBuilder sb = new StringBuilder("[");
		Node n = this;
		
		for(int i = 0; i < n.children.length; i++)
		{
			if(n.children[i] != null)
				sb.append(n.children[i].nodeToString());
		}
		
		sb.replace(sb.length() - 2, sb.length(), "]");
		return sb.toString();
	}
	
	private String nodeToString()
	{
		StringBuilder sb = new StringBuilder("<");
		
		sb.append(">, ");
		return sb.toString();

	}
}
