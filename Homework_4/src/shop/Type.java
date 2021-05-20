package shop;

public enum Type 
{
	ACOUSTIC ("Acoustic"),
	ELECTRIC ("Electric"),
	CLASSICAL ("Classical");

	private String typeName;
	private Type(String typeName) 
	{
		this.typeName = typeName;
	}
	
	@Override
	public String toString() 
	{
		return typeName;
	}
	
}
