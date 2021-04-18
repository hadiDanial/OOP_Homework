package bank;

public class Account 
{
	private String name;
	private int balance;
	
	
	public Account(String name)    
	{ 
		this.name = name;
		balance = 0;
	}
	
	public int getShekels()        
	{ 
		return balance;
	}
	
	public String getName()        
	{
		return name;
	}
	
	public void add(int amount)    
	{ 
		balance += amount;
	}
	
   public String toString()       
	{ 
		return name + " has " + balance + " shekels";
	}
}
    
