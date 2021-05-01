package circuits;

public class NotGate extends Gate
{

	public NotGate(Gate in)
	{
		super(getGateArray(in));
	}

	@Override
	protected boolean func(boolean[] inValues) 
	{
		return !inGates[0].calc();
	}

	@Override
	public String getName() 
	{
		return "NOT";
	}

	@Override
	public Gate simplify() 
	{
		return null;
	}

}
