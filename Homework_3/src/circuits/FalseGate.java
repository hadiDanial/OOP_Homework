package circuits;

public class FalseGate extends Gate
{
	private static FalseGate instance = null;

	private FalseGate()
	{
		super(null);
	}
	
	public static Gate instance()
	{
		if(instance == null) instance = new FalseGate();
		
		return instance;
	}

	@Override
	protected boolean func(boolean[] inValues)
	{
		return false;
	}

	@Override
	public String getName() 
	{
		return "F";
	}

	@Override
	public Gate simplify() 
	{
		return instance;
	}
}
