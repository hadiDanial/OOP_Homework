package bank;

public class ProAccount extends Account
{
	private static final int MAX_HISTORY = 100;
	private int[] history;
	private int index;

	public ProAccount(String name) 
	{
		super(name);
		history = new int[MAX_HISTORY];
		index = 0;
	}

	@Override
	public void add(int amount)
	{
		super.add(amount);
		history[index] = getShekels();
		index++;
		if(index > MAX_HISTORY - 1) index = MAX_HISTORY - 1;
	}
	
	/**
	 * Transfer money from one account to the other. Static because it doesn't work on a single instance.
	 * @param from Account to transfer money from.
	 * @param to Account to transfer money to.
	 * @param amount The amount of money to transfer.
	 */
	public static void transfer(ProAccount from, ProAccount to, int amount)
	{
		from.add(-amount);
		to.add(amount);	
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " " + historyToString();
	}
	
	/**
	 * @return A string representation of the account balance history.
	 */
	private String historyToString()
	{
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < index; i++)
		{
			sb.append(history[i] + ",");
		}
		sb.append(history[index]);
		sb.append("]");
		return sb.toString();
	}
}
