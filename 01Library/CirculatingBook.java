class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String Author, String Title, String ISBNum, String CallNumber){
	super(Author, Title, ISBNum,CallNumber);
	currentHolder = null;
	dueDate = null;
    }

    public String getCurrentHolder(){
	return currentHolder;
    }

    public String getDueDate(){
	return dueDate;
    }

    public boolean setCurrentHolder(String CurrentHolder){
	boolean successful = false;
	currentHolder = CurrentHolder;
	successful = true;
	return successful;
    }

    public boolean setDueDate(String DueDate){
	boolean successful = false;
	dueDate = DueDate;
	successful = true;
	return successful;
    }

    public void checkout(String patron, String due){
	setCurrentHolder(patron);
	setDueDate(due);
    }

    public void returned(){
	setCurrentHolder(null);
	setDueDate(null);
    }

    public String circulationStatus(){
	if(getCurrentHolder() == null){
	    return "book available on shelves";
	} else{
	    return getCurrentHolder() + "will return the book by " + getDueDate();
	}
    }

    public String toString(){
	if(getCurrentHolder() == null){
	    return super.toString();
	} else{
	    return super.toString() + ", " + getCurrentHolder() + ", " + getDueDate();
	}
    }
}
