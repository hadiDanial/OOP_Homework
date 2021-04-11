package tasks;

public class Tasks 
{
	private int num;
	private Task[] tasks;
	
	public Tasks(int num)
	{
		this.num = num;
		tasks = new Task[num];
		for (int i = 0; i < tasks.length; i++) {
			tasks[i] = new Task(i);
		}
	}


	public boolean dependsOn(int task1, int task2)
	{
		if(!isValidNumber(task1) || !isValidNumber(task2))
			return false;
		else
		{			
			Task.setDependency(tasks[task1], tasks[task2]);
			return true;
		}
	}
		
	public int[] order()
	{
		Task[] firstTasks = new Task[num], dependencyFreeTasks = new Task[num];
		int[] order = new int[num];
		int index = 0;
		
		// Add tasks that have no dependencies first
		for (int i = 0; i < tasks.length; i++) 
		{
			if(tasks[i].getNext() == null && tasks[i].getPrevious() == null)
			{
				dependencyFreeTasks[index] = tasks[i];
				index++;
			}
		}
		// Mark independent tasks as done/added to the order
		for (int i = 0; i < index; i++) 
		{
			dependencyFreeTasks[i].done = true;
			order[i] = dependencyFreeTasks[i].getIndex();
		}

		// Find the first tasks in each dependency chain
		for (int i = 0; i < tasks.length; i++) 
		{
			firstTasks[i] = tasks[i].getFirstDependency(num);
			if(firstTasks[i] == null) return null; // Cyclic
		}
		
		// Add tasks to the order array
		for (int i = 0; i < firstTasks.length; i++) 
		{
			if(!firstTasks[i].done)
			{
				firstTasks[i].done = true;
				index = addTaskOrder(order, firstTasks[i], index);
			}
		}
		
		// Print test output
//		for (int i = 0; i < tasks.length; i++) 
//		{
//			System.out.print(order[i]+ " -> ");
//		}
		
		return order;
	}

	/**
	 * Adds a task dependency chain to the order array.
	 * @param order The order array.
	 * @param task The task at the start of the dependency chain.
	 * @param index Index to start insertion from.
	 * @return
	 */
	private int addTaskOrder(int[] order, Task task, int index) 
	{
		while(task != null && index < num)
		{
			order[index] = task.getIndex(); 
			task = task.getNext();
			index++;
		}
		return index;
	}

	/**
	 * Checks whether the given number is a valid index.
	 * @param number Number to check.
	 * @return True if the number is valid.
	 */
	private boolean isValidNumber(int number) 
	{
		if(number < 0 || number >= num)
			return false;
		return true;
	}

}
