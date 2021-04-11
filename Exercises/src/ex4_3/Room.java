package ex4_3;

public class Room {
    private int length, width;
    private int costPerMeter;

    public Room(int length, int width, int costPerMeter) {
	this.length = length;
	this.width = width;
	this.costPerMeter = costPerMeter;
    }

    public int area() {
	return length * width;
    }

    public int cost() {
	return area() * costPerMeter;
    }

    @Override
    public String toString() {
       return String.format("%s %d X %d, cost = %d", 
getClass().getSimpleName(),length, width, cost());
    }
}
