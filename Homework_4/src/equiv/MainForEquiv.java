package equiv;

public class MainForEquiv 
{
	public static void main(String[] args) 
	{
		Equiv<String> equiv = new Equiv<>();
		equiv.add("ball", "balloon");
		System.out.println(equiv); //toString can't be public :(
		equiv.add("child", "person");
		System.out.println(equiv);
		equiv.add("girl", "child");
		System.out.println(equiv);
		equiv.add("ball", "sphere");
		System.out.println(equiv);
		equiv.add("sphere", "circle");
		System.out.println(equiv);
		equiv.add("dog", "cat");
		System.out.println(equiv);
		System.out.println(equiv.are("balloon", "circle"));
		System.out.println(equiv.are("child", "girl"));
		System.out.println(equiv.are("sun", "sun"));
		System.out.println(equiv.are("dog", "ball"));
		System.out.println(equiv.are("table", "dog"));
	}
}
