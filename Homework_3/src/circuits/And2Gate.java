package circuits;

public class And2Gate extends AndGate
{

	public And2Gate(Gate g1, Gate g2)
	{
		super(GateHelper.getGateArray(g1, g2));
	}

}
