package circuits;

public class AndGate extends Gate 
{

	public AndGate(Gate[] inGates) 
	{
		super(inGates);
	}

	@Override
	protected boolean func(boolean[] inValues) 
	{
		for (int i = 0; i < inValues.length; i++) 
		{
			if(!inValues[i]) return false;
		}
		return true;
	}

	@Override
	public String getName() 
	{
		return "AND";
	}

	@Override
	public Gate simplify() 
	{
		return null;
	}

}
