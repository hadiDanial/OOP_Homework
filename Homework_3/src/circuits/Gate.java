package circuits;

import java.util.NoSuchElementException;

public abstract class Gate 
{
	protected Gate[] inGates;
	
	public Gate(Gate[] inGates)                                                     
	{ 
		this.inGates = inGates;
	}
	
	
	protected Gate()
	{
		inGates = null; //??????
	}
	
	public boolean calc()                                    
	{ 
		if(inGates == null) return func(null);
		boolean[] values = new boolean[inGates.length];
		for (int i = 0; i < values.length; i++) 
		{
			if(inGates[i] == null) 
				throw new NoSuchElementException(); // TODO throw CircuitException
			else if(inGates[i].inGates == null)
				values[i] = inGates[i].func(null); 
			else
				values[i] = inGates[i].calc();
		}
		return func(values);
	}
	protected abstract boolean func(boolean[] inValues);// TODO throw CircuitException     

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

	
	protected static Gate[] getGateArray(Gate gate)
	{
		Gate[] gates = new Gate[1];
		gates[0] = gate;
		return gates;
	}
	protected static Gate[] getGateArray(Gate g1, Gate g2)
	{
		Gate[] gates = new Gate[2];
		gates[0] = g1;
		gates[1] = g2;
		return gates;
	}

}
