package tasks;

/**
 * Represents a Task. 
 * Contains the task index, and a reference to the previous and next tasks in the dependency chain.
 * @author Hadi
 */
public class Task 
{
	private int index;
	private Task previous = null, next = null;
	
	boolean done = false;
	
	Task(int index)
	{
		this.index = index;
	}
	
	/**
	 * Sets the dependency between two tasks as follows: 
	 * task1 depends on task2 -> task2 should be completed before task1 can be executed
	 * @param task1
	 * @param task2
	 */
	static void setDependency(Task task1, Task task2)
	{
		task1.previous = task2;

		// If it already has a next, assign after it, since it doesn't matter what the order is.
		if(task2.next == null)
			task2.next = task1;
		else
		{
			Task n = task2.next;
			while(n.next != null)
			{
				n = n.next;
			}
			n.next = task1;
		}
	}

	/**
	 * Returns the previous task in the dependency chain.
	 */
	Task getPrevious() 
	{
		return previous;
	}

	/**
	 * Returns the next task in the dependency chain.
	 */
	Task getNext()
	{
		return next;
	}


	/**
	 * Finds the first task in the dependency chain.
	 * If the chain is cyclic, returns null.
	 * @param maxNum The length of the array
	 * @return First task in the chain, or null if cyclic.
	 */
	Task getFirstDependency(int maxNum) 
	{
		int count = 1;
		Task result = this;
		while(result.getPrevious() != null && count < maxNum)
		{
			count++;
			result = result.getPrevious();
		}
		if(count >= maxNum) // Means that the dependencies are cyclic
			return null; 
		else 
			return result;
	}

	/**
	 * 
	 * @return Index number of the task.
	 */
	int getIndex() 
	{
		return index;
	}

	
}
