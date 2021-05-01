package circuits;

import java.util.NoSuchElementException;

public class VarGate extends Gate
{
	private String name;
	private boolean value, hasBeenSet = false;
	
	public VarGate(String name)
	{
		super();
		this.name = name;
	}
	
	@Override
	protected boolean func(boolean[] inValues) 
	{
		if(hasBeenSet) 
			return value;
		throw new NoSuchElementException(); // TODO throw CircuitException
	}

	@Override
	public String getName() 
	{
		return "V" + name;
	}

	@Override
	public Gate simplify() 
	{
		return null;
	}
	
	public void setVal(boolean value)
	{
		this.value = value;
		hasBeenSet = true;
	}

}
