package iterator;

public class IteratorToString
{
	public static String toString(MyIterator it)
	{
		StringBuilder sb = new StringBuilder("[");
		
		while(it.hasNext())
		{
			sb.append(it.next());
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}
}
