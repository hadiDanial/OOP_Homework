package ex4_3;

public class Bathroom extends Room {

	private int height;

	public Bathroom(int length, int width, int height, int costPerMeter) {
		super(length, width, costPerMeter);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
