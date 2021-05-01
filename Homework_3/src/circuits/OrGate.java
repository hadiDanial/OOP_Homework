package circuits;

public class OrGate extends Gate 
{

	public OrGate(Gate[] inGates) 
	{
		super(inGates);
	}

	@Override
	protected boolean func(boolean[] inValues) 
	{
		for (int i = 0; i < inValues.length; i++) 
		{
			if(inValues[i]) return true;
		}
		return false;
	}

	@Override
	public String getName() 
	{
		return "OR";
	}

	@Override
	public Gate simplify() 
	{
		return null;
	}

}