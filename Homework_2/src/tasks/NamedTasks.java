package tasks;

public class NamedTasks extends Tasks
{
	private String[] names;
	
	public NamedTasks(String[] names)
	{
		super(names.length);
		this.names = names;
	}
	
	public boolean dependsOn(String task1, String task2)
	{
		if(!isValidString(task1) || !isValidString(task2))
			return false;
		else
		{			
			int s1 = getIndexByName(task1);
			int s2 = getIndexByName(task2);			
			return super.dependsOn(s1, s2);
		}
	}
	

	public String[] nameOrder()
	{
		int[] order = super.order();
		if(order == null) return null;
		String[] orderedNames = new String[names.length];
		
		for (int i = 0; i < order.length; i++) 
		{
			orderedNames[i] = names[order[i]]; 
		}
		
		return orderedNames;
	}
	
	
	/**
	 * Returns the index of the task in the names array, if it exists.
	 * @param task String to search for.
	 * @return Index of the string if it exists, -1 otherwise.
	 */
	private int getIndexByName(String task) 
	{
		for (int i = 0; i < names.length; i++) 
		{
			if(task.equals(names[i]))
				return i;
		}
		return -1;
	}

	/**
	 * Checks if the string exists within the names array.
	 * @param task String to check.
	 * @return True if the string is valid/exists, false otherwise.
	 */
	private boolean isValidString(String task) 
	{
		for (int i = 0; i < names.length; i++) 
		{
			if(task.equals(names[i]))
				return true;
		}
		return false;
	}
}
