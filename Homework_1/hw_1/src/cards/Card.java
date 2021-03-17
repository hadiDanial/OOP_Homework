package cards;

/**
 * Represents a Card with a number and a suit type.
 */
public class Card 
{
	private int num, suit;

	public Card(int num, int suit) 
	{
		this.num = num;
		this.suit = suit;
		validateCard();
	}

	public int getNum() 
	{
		return num;
	}

	public int getSuit() 
	{
		return suit;
	}

	public String toString() 
	{
		return num + suitToString();
	}

	public int compareTo(Card other) 
	{
		if(num == other.num)
		{
			if(suit == other.suit) return 0;
			return suit-other.suit;
		}
		return num - other.num;
	}
	
	/**
	 * Validates the card by clamping the values.
	 * The number must be natural, and the suit must be between 0 and 3.
	 */
	private void validateCard()
	{
		if(num < 0) num = 0;
		if(suit < 0) suit = 0;
		if (suit > 3) suit = 3;
	}
	
	/**
	 * Converts a suit number to a letter.
	 * @return The suit letter (C, D, H, or S).
	 */
	private String suitToString()
	{
		String s = "";
		switch (suit) {
		case 0:
			s = "C"; // Clubs
			break;
		case 1:
			s = "D"; // Diamonds
			break;
		case 2:
			s = "H"; // Hearts
			break;
		case 3:
			s = "S"; // Spades
			break;

		default:
			s = "-N-"; // Not defined.
			break;
		}
		return s;
	}

}
