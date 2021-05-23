package graph;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class GIExample implements GraphInterface<Integer> {

	@Override
	public Collection<Integer> neighbours(Integer v) {
		if (v == 0) 
			return Arrays.asList(1, 2);
		else if (v == 1)
			return Arrays.asList(0);
		else if (v == 2)
			return Arrays.asList(0, 4);
		else if (v == 4)
			return Arrays.asList(2);
		else 
			return Collections.emptyList();
	}
	
	public static void main(String[] args) {
		GraphInterface<Integer> g = new GIExample();
		ConnectionChecker<Integer> cc = new ConnectionChecker<>(g);
		System.out.println(cc.check(4,  2));
	}
}
