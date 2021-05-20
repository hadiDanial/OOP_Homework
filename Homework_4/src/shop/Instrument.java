package shop;

public abstract class Instrument 
{
	protected String company;
	protected int price;
	protected int instrumentSerial;
	private static int serialCounter = 0;
	
	
	public Instrument(String company, int price)
	{
		this.company = company;
		this.price = price;
		instrumentSerial = serialCounter;
		serialCounter++;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public String getCompany()
	{
		return company;
	}
	
	public int getSerial()
	{
		return instrumentSerial;
	}
}
