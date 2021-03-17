package cities;

/**
 * Describes a city by its name and the roads connected to it.
 */
public class City 
{
	private Road[] roads;
	private String name;
	private int numRoads;
	private int maxRoadsNum = 10;	
	
	public City(String name)
	{
		this.name = name;
		roads = new Road[maxRoadsNum];
	}

	public void connect(Road r) 
	{
		if(numRoads < maxRoadsNum) // We still have room in the array.
		{
			roads[numRoads] = r;
			numRoads++;
		}
	}

	public City nearestCity() 
	{
		if(numRoads == 0) return null; // No roads connected, return null.
		else 
		{
			int minDistance = roads[0].getLength(), index = 0;
			for (int i = 1; i < numRoads; i++) 
			{
				if(roads[i].getLength() < minDistance)
				{
					minDistance = roads[i].getLength();
					index = i;
				}
			}
			return getOtherCity(roads[index]);
		}
	}
	
	/**
	 * Returns the other city connected to this road
	 */
	private City getOtherCity(Road road)
	{
		// We don't know if the other city is stored in city1 or city2
		City c1, c2;
		c1 = road.getCity1();
		c2 = road.getCity2();
		if(c1.name == name) // city1 is this city, so return the other city
			return c2;
		else return c1; // city2 is this city, so return city1
	}

	public String toString() 
	{
		return name;
	}
}
