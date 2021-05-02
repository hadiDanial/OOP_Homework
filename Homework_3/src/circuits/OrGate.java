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
		Gate[] simplified = new Gate[inGates.length];
		Gate[] orInGates = new Gate[inGates.length];

		int countNotFalse = 0;
		for (int i = 0; i < inGates.length; i++) 
		{
			simplified[i] = inGates[i].simplify();
			if(simplified[i] instanceof TrueGate)
			{
				return TrueGate.instance();
			}
			else if(!(simplified[i] instanceof FalseGate))
			{
				orInGates[countNotFalse] = simplified[i];
				countNotFalse++;
			}
		}
		if(countNotFalse == 0) 
			return FalseGate.instance();
		if(countNotFalse == 1) 
			return orInGates[0];
		else 
			return new OrGate(GateHelper.copyGateArray(orInGates, countNotFalse));
	}
}