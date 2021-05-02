package circuits;

public class CircuitException extends Exception 
{
	public CircuitException() { }
	
	public CircuitException(String string) 
	{
		super(string);
	}

	private static final long serialVersionUID = 4081258731210654545L;
}
