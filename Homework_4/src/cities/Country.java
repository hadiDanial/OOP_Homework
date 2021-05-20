package cities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Country implements Comparable<Country>
{
	private Set<City> cities;
	private String name;
	
	public Country(String name)
	{
		this.name = name;
		cities = new TreeSet<>();
	}
	
	public void addCity(City city)
	{
		if(!this.equals(city.getCountry()))
		{
			throw new IllegalArgumentException("Tried to add " + city.getName() + " to " + name + ", but the countries do not match!");
		}
		cities.add(city);
	}
	
	public int population()
	{
		int count = 0;
		for(City c : cities)
		{
			count += c.getPopulation();
		}
		return count;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
	public List<City> smallCities(int under)
	{
		List<City> list = new ArrayList<>();
		for(City c : cities)
		{
			if(c.getPopulation() < under)
				list.add(c);
		}
		Collections.sort(list);
		return list;
	}
	
	public String report()
	{
		 StringBuilder sb = new StringBuilder(name);
		 sb.append("(" + population() + ") : ");
		 for(City c : cities)
		 {
			 sb.append(c.getName());
			 sb.append("(");
			 sb.append(c.getPopulation());
			 sb.append("), ");
		 }
		 sb.delete(sb.length() - 2, sb.length());
		 return sb.toString();
	}
	
	@Override
	public int compareTo(Country other) 
	{
		if(this.equals(other)) 
			return 0;
		return name.compareTo(other.name);
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if(!(other instanceof Country))
			return false;
		Country country = (Country) other;
		return name.equals(country.name);
	}

}
