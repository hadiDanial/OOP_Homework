package iterator;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IteratorMain {

	public static void main(String[] args) 
	{
		int[] a1 = { 1, 2, 3, 4 };
		int[] a2 = { 100, 101, 102, 103, 104, 105, 106 };
				
		TwoArrays aa = new TwoArrays(a1, a2);
		for (int i : aa) 
			System.out.print(i + " ");
		
		System.out.println();
		
		List<String> list = Arrays.asList("one", "two", "three");
		Set<String> set = new TreeSet<>();
		set.addAll(Arrays.asList("B", "A", "D", "C", "E"));
		Combined<String> c = new Combined<>(set, list);
		for (String s : c) 
			System.out.print(s + " ");


	}

}
