package library;

public class Library 
{

	private Book[] books;
	
//	public static void main(String[] args) {
//		Library l = new Library(3);
//		Author a1 = new Author("Miguel de Cervantes", 1547);
//		Author a2 = new Author("Nikolai Gogol", 1809);
//		Author a3 = new Author("Brandon Sanderson", 1975);
//		l.setBook(1, "Don Quixote", a1);
//		l.setBook(0, "Dead Souls", a2);
//		l.setBook(2, "The Way Of Kings", a3);
//		l.setBook(1, "Harry Potter", new Author("JK Rowling", 1965));
//		l.setBook(3, "Oathbringer", a3);
//		System.out.println(l.getBook(1));
//		System.out.println(l.getBook(0));		
//		System.out.println(l.getBook(2));		
//	
//	}
	
	public Library(int size) 
	{
		books = new Book[size];
	}

	public void setBook(int bookNum, String title, Author auth) 
	{
		
		if(canSetBook(bookNum))
		{
			books[bookNum] = new Book(title, auth);
		}
		else System.out.println("Can't set book: " + title + ".");

	}

	public Book getBook(int bookNum) 
	{
		if(!isValidIndex(bookNum) || !isUsedIndex(bookNum)) return null;
		return books[bookNum];
	}
	
	/// Checks if a book can be added at this index.
	private boolean canSetBook(int index)
	{
		return (isValidIndex(index) && !isUsedIndex(index));
	}
	
	/// Checks if the index is valid, so we don't get an out of range exception
	private boolean isValidIndex(int index)
	{
		return !(index < 0 || index >= books.length);
	}
	
	/// Checks if the index has already been used, as we don't want to overwrite any books.
	private boolean isUsedIndex(int index)
	{
		return (books[index] != null);
	}

}
