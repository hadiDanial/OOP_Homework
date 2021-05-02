package circuits;

class GateHelper 
{
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
