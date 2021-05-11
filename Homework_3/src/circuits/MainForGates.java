package circuits;

public class MainForGates {

	public static void main(String[] args) throws CircuitException 
	{
//		Gate[] gates =  { TrueGate.instance(), FalseGate.instance(), TrueGate.instance() };
//		Gate a = new AndGate(gates);
//		Gate b = new OrGate(gates);
//		Gate c = new NotGate(a);
//		System.out.println("AND: " + a.calc());
//		System.out.println("OR: " + b.calc());
//		System.out.println("NOT: " + c.calc());
//
//		
		VarGate v1 = new VarGate("1");
		VarGate v2 = new VarGate("2");
				
		Gate g1 = new Or2Gate(FalseGate.instance(), TrueGate.instance());
		Gate g2 = new Or2Gate(v1, new NotGate(v2)); 
		Gate out = new AndGate(new Gate[] { g1, g2, TrueGate.instance() });
		Gate simple = out.simplify();		
		v1.setVal(false);
		v2.setVal(true);
//		System.out.println(out + " = " + out.calc());
		System.out.println(out + " = " + simple);// + " = " + simple.calc());
		simple = out.simplify();	
		System.out.println(out + " = " + simple);// + " = " + simple.calc());

	}

}
