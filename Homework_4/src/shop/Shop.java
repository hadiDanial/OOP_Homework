package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop 
{
	private List<Instrument> instruments;
	
	public Shop()
	{
		instruments = new ArrayList<Instrument>();
	}
	
	public void add(Instrument i)
	{
		instruments.add(i);
	}
	
	public Instrument get(int serial)
	{
		for (Instrument i : instruments)
		{
			if(i.getSerial() == serial) return i;
		}
		return null;
	}
	
	public List<Integer> allSerials()
	{
		List<Integer> serials = new ArrayList<>();
		for (Instrument i : instruments)
		{
			serials.add(i.getSerial());
		}		
		return serials;
	}
	
	public List<Integer> guitarsOfType(Type t)
	{
		List<Integer> serials = new ArrayList<>();
		List<Guitar> guitars = getGuitars();
		for (Guitar g : guitars)
		{
			if(g.getType() == t)
			{
				serials.add(g.getSerial());
			}
		}		
		return serials;
	}
	
	/**
	 * @return a list of all guitars in the shop
	 */
	private List<Guitar> getGuitars()
	{
		List<Guitar> guitars = new ArrayList<>();
		for (Instrument i : instruments)
		{
			if(i instanceof Guitar)
			{
				guitars.add((Guitar) i);
			}
		}		
		return guitars;
	}
	
	public void sell(int serial) throws MusicShopException
	{
		Instrument i = get(serial);
		if(i == null) throw new MusicShopException("Serial " + serial + " doesn't exist, can't sell!");
		
		if(i instanceof Guitar)
		{
			List<Guitar> guitars = getGuitars();
			if(guitars.size() <= 1) throw new MusicShopException("This is the last guitar in the shop, can't sell!\n" + i.toString());
		}
		instruments.remove(i);
	}
	
	public int sellAll(int[] serials)
	{
		int count = 0;
		for (int i = 0; i < serials.length; i++) 
		{
			try
			{
				sell(serials[i]);
			}
			catch (MusicShopException e) 
			{
				count++;
			}
		}
		return count;
	}
}
