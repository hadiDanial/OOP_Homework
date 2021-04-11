package tasks;

public class TasksOld 
{
	private static final int DIMENSIONS = 4;
	private int num;
	/**
	 * 2D array - First index  [i][ ] is the task index
	 * 			  Second index [ ][j] saves dependencies and order:
	 * 				- 0 index saves which task this task depends on
	 * 				- 1 index saves which task depends on this task.
	 * 				- 2 index saves the task number.
	 * 				- 3 index saves whether that task has been moved.
	 */
	private int[][] tasks;
	private boolean cyclic = false;

	public TasksOld(int num)
	{
		this.num = num;
		tasks = new int[num][DIMENSIONS];
		for (int i = 0; i < num; i++) 
		{
			tasks[i][0] = -1;
			tasks[i][1] = -1;
			tasks[i][2] = i;
			tasks[i][3] = 0;
		}
	}
	
	public boolean dependsOn(int task1, int task2)
	{
		if(!validNumber(task1) || !validNumber(task2))
			return false;
		tasks[task1][0] = task2;
		tasks[task2][1] = task1;
		//adjustOrder(task1, task2);
		return true;
	}
	
	
	private boolean validNumber(int number) {
		if(number < 0 || number >= num)
			return false;
		return true;
	}
	
	private boolean isDependent(int i, int j) 
	{
		return tasks[i][0] == j;
	}
	
	public int[] order()
	{
		int[] order = null;
		int dependsOn;
		// for each task:
		// If it depends on another, move it after that task, move all tasks that depend on it with it
		// Move all the tasks in between backwards
		printOrder();
		for (int i = 0; i < tasks.length; i++) 
		{
			System.out.println("Task " + tasks[i][2] + " depends on " + tasks[i][0] + ", and is depended on by " + tasks[i][1]);
		}
		System.out.println();
		for (int i = 0; i < tasks.length; i++) 
		{
			dependsOn = tasks[i][0];
			if(dependsOn != -1 && tasks[i][3] == 0)
			{
				int dependents[][] = getDependents(i);
				printDependents(i, dependents);
				// Move (dependents.length + 1) elements backwards
				// Restore the dependents after the move
				
				int moveCount = 1;
				if(dependents != null)
				{
					moveCount = dependents.length + 1;
				}
				
				moveBackwards(i, moveCount + 1);
				if(dependents != null)
					reinsertDependents(i + moveCount + 1, dependents);
				
				tasks[i][3] = 1;
				
			}
			printOrder();
		}
		if(!cyclic)
		{
			 order = new int[num];
			 for (int i = 0; i < order.length; i++) 
			 {
				order[i] = tasks[i][2];
			}
		}
		
		return order;
	}
	
	private void printDependents(int i, int[][] dependents) 
	{
		System.out.print("Task " + tasks[i][2] + " depends on " + tasks[i][0] + " and its dependents are: ");
		for (int j = 0; j < dependents.length; j++) {
			System.out.print(dependents[j][2] + "->");
		}
		System.out.println();
	}

	private void printOrder() 
	{
		for (int i = 0; i < tasks.length; i++) 
		{
			System.out.print(tasks[i][2] + " -> ");
		}
		System.out.println();


	}

	/**
	 * Reinsert the dependents at a certain index, overwriting elements.
	 * @param i Index to start insertion.
	 * @param dependents Data to insert.
	 */
	private void reinsertDependents(int i, int[][] dependents) 
	{
		//for(int j = i, index = 0; j < i + dependents.length; j++, index++)
		for(int j = 0, index = i; j < dependents.length; j++, index++)
		{
			tasks[index][0] = dependents[j][0];
			tasks[index][1] = dependents[j][1];
			tasks[index][2] = dependents[j][2];
			tasks[index][3] = dependents[j][3];
		}
	}

	/**
	 * Move the elements from index i until i + moveCount backwards one space.
	 * @param i Starting index
	 * @param moveCount Amount of elements to move backwards.
	 */
	private void moveBackwards(int i, int moveCount) 
	{
		for(int j = i; j < i + moveCount; j++)
		{
			if(j + 1 >= num) return;
			tasks[j][0] = tasks[j + 1][0];
			tasks[j][1] = tasks[j + 1][1];
			tasks[j][2] = tasks[j + 1][2];
			tasks[j][3] = tasks[j + 1][3];
		}	
	}

	/**
	 * Gets a copy of all the tasks that depend on task i for execution.
	 * If the dependents are cyclic, sets cyclic to true and returns null.
	 * @param i Task to get dependencies for.
	 * @return Copy of tasks that depend on task i, null if empty.
	 */
	private int[][] getDependents(int i) 
	{
		int count = 1, currentTask, nextTask;
		int j = i + 1;
		
		if(j >= num) return null;
		
		currentTask = tasks[i][2];
		nextTask = tasks[j][1];
		
		// Count how many dependent tasks there are.
		while(j < num && nextTask == currentTask)
		{
			count++;
			
			j++;
			currentTask = nextTask;
			if(j < num)
				nextTask = tasks[j][1];   
		}
		// Create a new dependents array to return;
		int[][] dependents = new int[count][DIMENSIONS];
		
		dependents[0][0] = tasks[i][0];
		dependents[0][1] = tasks[i][1];
		dependents[0][2] = tasks[i][2];
		
		if(count == 1) // No dependents
		{
			return dependents;
		}
		
		
		for (int k = 1; k < count; k++) 
		{
			dependents[k][0] = tasks[i + k][0];
			dependents[k][1] = tasks[i + k][1];
			dependents[k][2] = tasks[i + k][2];
		}
		
		return dependents;
	}

	
	
	
	
//	private void adjustOrder(int task1, int task2) 
//	{
//		if(tasks[task1][0] == task2 && tasks[task1][2] < tasks[task2][2]) // Task 1 depends on 2 and comes before it
//		{
//
//			// Handle dependencies
//			int dependenciesCount = 0, dependencyNumber;
//			dependencyNumber = tasks[task1][1];
//			while(dependencyNumber != -1 && dependencyNumber < num)
//			{
//				dependenciesCount++;
//				dependencyNumber = tasks[dependencyNumber][1]; 				
//			}
//			if(tasks[dependencyNumber][1] != task1) 
//			{
//				cyclic = true; 
//				return;
//			}
//			
//			// Switch tasks
//			int temp = tasks[task2][2];
//			tasks[task2][2] = tasks[task1][2];
//			tasks[task1][2] = temp;
//			
//		}
//		
//	}



//	public int[] order() 
//	{
//		int orders[] = new int[num];
//		// Set initial order
//		for (int i = 0; i < num; i++) 
//		{
//			for (int j = i + 1; j < num; j++) 
//			{
//				if(isDependent(i, j))
//					swapTasks(i, j);
//			}
//		}
//		
//		for (int i = 0; i < num; i++) 
//		{
//			orders[i] = tasks[i][2];
//		}
//		if(cyclic) return null;
//		return orders;
//	}



	/**
	 * Moves all the tasks between i and j back one spot and then moves the task that was in i to j.
	 * @param i
	 * @param j
	 */
//	private void swapTasks(int i, int j) 
//	{
//		int index = i;
//		int dependsOn = tasks[i][0];
//		int dependedOnBy = tasks[i][1];
//		int taskNum = tasks[i][2];
//		
//		// Handle dependencies
//		int dependenciesCount = 0, dependencyNumber, previous;
//		int dIndex = index + 1 + dependenciesCount;
//		dependencyNumber = tasks[dIndex][0];
//		previous = tasks[index][2];
//		while(dependencyNumber != -1 && dependencyNumber == previous && dIndex < tasks.length)
//		{
//			dependenciesCount++;
//			dependencyNumber = tasks[dIndex][0];
//			dIndex = index + 1 + dependenciesCount;
//			previous = tasks[index + dependenciesCount][2];
//			if(dependencyNumber == taskNum) cyclic = true; // Cyclic
//		}
//		
//		// Copy dependencies
//		int dependencies[][] = new int[dependenciesCount][3];
//		for (int k = 0; k < dependencies.length; k++) 
//		{
//			dependencies[k][0] = tasks[i + k][0];
//			dependencies[k][1] = tasks[i + k][1];
//			dependencies[k][2] = tasks[i + k][2];
//		}
		
//		while(dependencyNumber != -1 && dependencyNumber < num)
//		{
//			dependenciesCount++;
//			dependencyNumber = tasks[dependencyNumber][1]; 
//			previous = 
//		}
//		if(tasks[dependencyNumber][1] == tasks[index][0]) 
//		{
//			cyclic = true; 
//			return;
//		}
//		

//		while(index < i + dependenciesCount)
//		{		
//			tasks[index][0] = tasks[index + dependenciesCount][0];
//			tasks[index][1] = tasks[index + dependenciesCount][1];
//			tasks[index][2] = tasks[index + dependenciesCount][2];
//			index++;
//		}
//		
//		tasks[j][0] = dependsOn;
//		tasks[j][1] = dependedOnBy;
//		tasks[j][2] = taskNum;
//	}
	
}
