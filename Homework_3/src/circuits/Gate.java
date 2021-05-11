package circuits;

public abstract class Gate 
{
	protected Gate[] inGates;
	
	public Gate(Gate[] inGates)                                                     
	{ 
		this.inGates = inGates;
	}
	
	public boolean calc() throws CircuitException                           
	{ 
		if(inGates == null) return func(null); 
		boolean[] values = new boolean[inGates.length];
		for (int i = 0; i < values.length; i++) 
		{
			if(inGates[i] == null) // Value for a gate not defined
				throw new CircuitException();

			else // Calculate a gate's value
				values[i] = inGates[i].calc();
		}
		return func(values);
	}
	
	protected abstract boolean func(boolean[] inValues) throws CircuitException;

	public abstract String getName();                                            

	public abstract Gate simplify();                                              

	public String toString()                                                        
	{
		StringBuilder sb = new StringBuilder(getName());
		// AND[OR[F, T], OR[V1, NOT[V2]], T]
		if(inGates != null)
		{
			sb.append("[");
			for (int i = 0; i < inGates.length; i++) 
			{
					sb.append(inGates[i].toString());
					if(i < inGates.length - 1)
						sb.append(", ");
			}
			sb.append("]");
		}
		return sb.toString();
	}
}
