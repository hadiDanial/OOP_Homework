package mines;

public class MinesMain {

	public static void main(String[] args) {
		Mines m = new Mines(3, 4, 0);
		m.addMine(0, 1);
		m.addMine(2, 3);
		m.open(2, 0);
		System.out.println(m);
		m.toggleFlag(0, 1);
		System.out.println(m);
		m.setShowAll(true);
		System.out.println(m);
	}

}
