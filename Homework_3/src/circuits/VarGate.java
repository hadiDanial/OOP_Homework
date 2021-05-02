package circuits;

public class VarGate extends Gate
{
	private String name;
	private boolean value, hasBeenSet = false;
	
	public VarGate(String name)
	{
		super(null);
		this.name = name;
	}
	
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException
	{
		if(hasBeenSet) 
			return value;
		throw new CircuitException("VarGate not defined!");
	}

	@Override
	public String getName() 
	{
		return "V" + name;
	}

	@Override
	public Gate simplify() 
	{
		if(!hasBeenSet) 
			return this;
		if(value) 
			return TrueGate.instance();
		else 
			return FalseGate.instance();
	}
	
	public void setVal(boolean value)
	{
		this.value = value;
		hasBeenSet = true;
	}

}
