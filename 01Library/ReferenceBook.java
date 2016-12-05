class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String Author, String Title, String ISBNum, String CallNumber, String Collection){
	super(Author, Title, ISBNum, CallNumber);
	collection = Collection;
    }

    public String getCollection(){
	return collection;
    }

    public boolean setCollection(String Collection){
	boolean successful = false;
	collection = Collection;
	successful = true;
	return successful;
    }

    public void checkout(String patron, String due){
	System.out.println("cannot check out a reference book");
    }

    public void returned(){
	System.out.println("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
	return "non-circulating reference book";
    }

    public String toString(){
	return super.toString() + ", " + getCollection();
    }
}
