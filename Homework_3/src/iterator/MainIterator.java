package iterator;

public class MainIterator {

	public static void main(String[] args) 
	{
		MyIterator it = new IteratorExample();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		int[] x = {2, 4, 6, 1};
		MyIterator it2 = new MyArray(x);
		while(it2.hasNext())
			System.out.print(it2.next() + " ");
		System.out.println();

		MyIterator it3 = new Fibonacci(10);
		while(it3.hasNext()) 
			System.out.print(it3.next() + " ");
		System.out.println();

		System.out.println(IteratorToString.toString(new Fibonacci(10)));

	}

}
