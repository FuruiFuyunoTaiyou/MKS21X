abstract Class LibraryBook extends Book implements Comparable<LibraryBook>{
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
}
