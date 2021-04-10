package tree;

public class MainForNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root= new Node();
		root.add("c");
		root.add("c");
		root.add("ab");
		root.add("az"); root.add("az"); root.add("az"); root.add("az");
		root.add("a"); root.add("a"); root.add("a");
		root.add("ca");
		root.add("ac");
		root.add("ca");

		root.add("abcdefghijklmnopqrstuvwxyz");
		
		System.out.println("c: " + root.num("c"));
		System.out.println("ab: " + root.num("ab"));
		System.out.println("az: " + root.num("az"));
		System.out.println("a: " + root.num("a"));
		System.out.println("ca: " + root.num("ca"));
		System.out.println("ac: " + root.num("ac"));
		
		System.out.println("Alphabet: " + root.num("abcdefghijklmnopqrstuvwxyz"));
		
		System.out.println(ReversedWords.checkReversed());
	}

}