package circuits;

public class NotGate extends Gate
{

	public NotGate(Gate in)
	{
		super(GateHelper.getGateArray(in));
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException 
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
		Gate gate = inGates[0].simplify();
		if(gate instanceof TrueGate)
		{
			return FalseGate.instance();
		}
		else if(gate instanceof FalseGate)
		{
			return TrueGate.instance();
		}
		if(gate instanceof NotGate)
		{
			return gate.inGates[0].simplify();
		}
		return this;
	}

}
