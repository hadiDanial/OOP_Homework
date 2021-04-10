package tree;

import java.util.Scanner;

public class ReversedWords 
{
	public static int checkReversed()
	{
		Scanner scanner = new Scanner(System.in);
		Node node = new Node();
		String str, reverse;
		int num = 0;
		System.out.println("Enter a string to check reverse. End string by typing 'X':");
		str = scanner.next();
		while(!str.equals("X"))
		{
			node.add(str);
			reverse = getReverse(str);
			
			// Check if str and reverse are the same, so it doesn't count itself
			// Check if the reverse is found at least once already
			if(!str.equals(reverse) && node.num(reverse) >= 1) 
				num++;
			str = scanner.next();
		}
		scanner.close();
		
		return num;
	}

	
	/***
	 * Returns the reverse of a String.
	 * @param str String to reverse.
	 * @return Reversed version of str
	 */
	private static String getReverse(String str) 
	{
		StringBuilder reverse = new StringBuilder();
		int length = str.length();
		for(int i = 0; i < length; i++)
		{
			reverse.append(str.charAt(length - i - 1));
		}
		return reverse.toString();
	}
}
