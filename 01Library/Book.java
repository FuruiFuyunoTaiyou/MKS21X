public  class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book(){
    }

    public Book(String Author, String Title, String ISBNum){
	author = Author;
	title = Title;
	ISBN = ISBNum;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public boolean setAuthor(String Author){
	boolean successful = false;
	author = Author;
	return successful;
    }

     public boolean setTitle(String Title){
	boolean successful = false;
	title = Title;
	return successful;
    }

    public boolean setISBN(String ISBNum){
	boolean successful = false;
	ISBN = ISBNum;
	return successful;
    }

    public String toString(){
	return title + ", " + author + ", " + ISBN;
    }
}
