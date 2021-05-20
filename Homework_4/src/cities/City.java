package cities;

public class City implements Comparable<City>
{
	private String name;
	private Country country;
	private int population;
	public City(String name, Country country, int population)
	{
		this.name = name;
		this.country = country;
		this.population = population;
	}
	
	public String getName()
	{
		return name;
	}

	public Country getCountry()
	{
		return country;
	}
	
	public int getPopulation()
	{
		return population;
	}
	
	public String toString()
	{
		return getName() + " (of " + getCountry() + ")";
	}

	@Override
	public int compareTo(City other) 
	{
		if(getCountry().equals(other.getCountry()))
			return getName().compareTo(other.getName());
		else
			return getCountry().compareTo(other.getCountry());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof City))
			return false;
		City other = (City) obj;
		return (getCountry().equals(other.getCountry()) && getName().equals(other.getName()));
	}
}
