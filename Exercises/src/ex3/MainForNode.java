package ex3;

public class MainForNode {

	public static void main(String[] args) 
	{
//		nodeMainTest();
		listMainTest();
	}

	private static void listMainTest() {
		List l = new List();
		l.addAtHead(1);
		l.addAtHead(2);
		l.addAtHead(3);
		l.addAtTail(4);
		System.out.println(l);
	}
//
//	private static void nodeMainTest() {
//		Node n1 = new Node(1, null, null);
//		Node n2 = new Node(2, null, n1);
//		Node n3 = new Node(3, n2, null);
//		Node n4 = new Node(4, n1, n3);
//		System.out.println(n4);
//
//		for(Node c = n2; c != null; c = c.getNext())
//			System.out.println(c.getVal() + " ");
//		System.out.println();
//		for(Node c = n3; c != null; c = c.getPrev())
//			System.out.println(c.getVal() + " ");
//	}

}
