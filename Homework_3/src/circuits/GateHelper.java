package circuits;

class GateHelper 
{
	/**
	 * Returns a Gate array made from one gate.
	 */
	protected static Gate[] getGateArray(Gate gate)
	{
		Gate[] gates = new Gate[1];
		gates[0] = gate;
		return gates;
	}
	
	/**
	 * Returns a Gate array made from two gates.
	 */
	protected static Gate[] getGateArray(Gate g1, Gate g2)
	{
		Gate[] gates = new Gate[2];
		gates[0] = g1;
		gates[1] = g2;
		return gates;
	}
	
	/**
	 * Copies a Gate array up to a certain element and returns the new array.
	 */
	protected static Gate[] copyGateArray(Gate[] orInGates, int size) 
	{
		Gate[] gates = new Gate[size];
		for (int i = 0; i < size; i++) 
		{
			gates[i] = orInGates[i];
		}
		return gates;
	}
}
