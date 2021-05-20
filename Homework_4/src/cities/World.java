package cities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World 
{
	private Map<String, Country> countries = new HashMap<String,Country>();
	
	public void addCountry(String name)
	{
		Country country = new Country(name);
		countries.put(name, country);
	}
	
	public void addCity(String name, String countryName, int population)
	{
		Country country = countries.get(countryName);
		if(country == null) throw new IllegalArgumentException(countryName + "doesn't exist!");
		City city = new City(name, country, population);
		country.addCity(city);
	}
	
	public int population()
	{
		int count = 0;
//		for(Map.Entry<String, Country> entry : countries.entrySet())
		for(String key: countries.keySet())
		{
			count += countries.get(key).population();
		}
		return count;
	}
	
	public List<City> smallCities(int under)
	{
		List<City> list = new ArrayList<>();
		for(String key: countries.keySet())
		{
			list.addAll(countries.get(key).smallCities(under));
		}
		return list;
	}
	
	public String report()
	{
		StringBuilder sb = new StringBuilder();
		for(String key: countries.keySet())
		{
			sb.append(countries.get(key).report() + "\n");
		}
		sb.append("Total population is " + population() + "\n");
		return sb.toString();
	}
}
