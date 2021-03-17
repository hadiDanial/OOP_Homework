package cards;


/**
 * Manages a deck of Cards.
 */
public class Deck 
{
	private Card[] cards;
	private int cardsInDeck = 0;
	
	/**
	 * Builds a deck with numbers 0->num-1 for each suit.
	 * @param num The maximum number of cards to add to the deck (from 0->num-1).
	 */
	public Deck(int num) 
	{
		cardsInDeck = num * 4;
		cards = new Card[cardsInDeck];
		for (int i = 0; i < num; i++) 
		{
			for (int j = 0; j < 4; j++) 
			{
				int k = i * 4 + j; // Card index.
				cards[k] = new Card(i, j);
			}
		}
	}

	
	/**
	 * Builds a new deck by taking num cards from the deck.
	 * @param from The deck to take from.
	 * @param num The number of cards to take.
	 */
	public Deck(Deck from, int num) 
	{
		cards = new Card[num];
		int i = 0;
		while(i < cards.length && from.getNumCards() > 0)
		{
			cards[i] = from.takeOne();
			i++;
			cardsInDeck++;
		}
	}

	/**
	 * Builds a new deck by combining two decks in reverse order.
	 * @param first The first deck to take from.
	 * @param second The second deck to take from.
	 */
	public Deck(Deck first, Deck second) 
	{
		int i = first.getNumCards(), j = second.getNumCards();
		int k = 0;
		int num = i + j;
		cards = new Card[num];
		while(i > 0 || j > 0)
		{
			if(i > 0) 
			{
				cards[k] = first.takeOne();
				k++;
			}
			if(j > 0) 
			{
				cards[k] = second.takeOne();
				k++;
			}
			i = first.getNumCards();
			j = second.getNumCards();
		}
		cardsInDeck = num;
	}


	public int getNumCards() 
	{
		return cardsInDeck;
	}
	
	/**
	 * @return Removes the last card from the deck and returns it.
	 */
	public Card takeOne() 
	{
		if(cardsInDeck == 0) return null;
		Card taken = cards[cardsInDeck - 1];
		cards[cardsInDeck - 1] = null;
		cardsInDeck--;
		return taken;
	}
	
	
	public String toString() 
	{
		if(cardsInDeck == 0) return "[]";
		String s = "[";
		for (int i = 0; i < cardsInDeck - 1; i++) 
		{
			s += cards[i] + ", ";
		}
		s += cards[cardsInDeck - 1] + "]";
		return s;
	}
	
	/**
	 * Sorts the deck using Bubble Sort.
	 */
	public void sort()
	{
		Card temp = null;
		for (int i = 0; i < cardsInDeck; i++) 
		{
			for (int j = 1; j < cardsInDeck - i ; j++) 
			{
				if(cards[j - 1].compareTo(cards[j]) > 0)
				{
					temp = cards[j - 1];
					cards[j - 1] = cards[j];
					cards[j] = temp;
				}
			}
		}
	}

}
