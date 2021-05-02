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
		Gate[] simplified = new Gate[inGates.length];
		Gate[] andInGates = new Gate[inGates.length];

		int countNotTrue = 0;
		for (int i = 0; i < inGates.length; i++) 
		{
			simplified[i] = inGates[i].simplify();
			if(simplified[i] instanceof FalseGate)
			{
				return FalseGate.instance();
			}
			else if(!(simplified[i] instanceof TrueGate))
			{
				andInGates[countNotTrue] = simplified[i];
				countNotTrue++;
			}
		}
		
		if(countNotTrue == 0) 
			return TrueGate.instance();
		if(countNotTrue == 1) 
			return andInGates[0];
		else 
			return new AndGate(GateHelper.copyGateArray(andInGates, countNotTrue));
	}

}
