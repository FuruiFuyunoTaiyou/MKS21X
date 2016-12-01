abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String Author, String Title, String ISBNum, String CallNumber){
	super(Author, Title, ISBNum);
	callNumber = CallNumber;
    }

    public String getCallNumber(){
	return callNumber;
    }

    public boolean setCallNumber(String CallNumber){
	boolean successful = false;
	callNumber = CallNumber;
	successful = true;
	return successful;
    }

    public abstract void checkout(String patron, String due);

    public abstract void returned();

    public abstract String circulationStatus();

    public String toString(){
	return getTitle() + ", " + getAuthor() + ", " + getISBN() + ", " + circulationStatus() + ", " + getCallNumber();
    }

    public int compareTo(LibraryBook o){
	return this.getCallNumber().compareTo(o.getCallNumber());
    }
}
