package library;

/**
 * A collection of Books
 */
public class Library 
{

	private Book[] books;
	
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
	
	/** Checks if a book can be added at this index.
	 * @param index The index to check
	 * @return Returns true if a book can be set at this index.
	 */
	private boolean canSetBook(int index)
	{
		return (isValidIndex(index) && !isUsedIndex(index));
	}
	
	/** Checks if the index is valid, so we don't get an out of range exception
	 * @param index The index to check
	 * @return Returns true if the index is valid.
	 */
	private boolean isValidIndex(int index)
	{
		return !(index < 0 || index >= books.length);
	}
	
	/** Checks if the index has already been used, as we don't want to overwrite any books.
	 * @param index The index to check.
	 * @return Returns true if the index is used.
	 */
	private boolean isUsedIndex(int index)
	{
		return (books[index] != null);
	}

}
