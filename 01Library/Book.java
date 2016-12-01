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
	successful = true;
	return successful;
    }

     public boolean setTitle(String Title){
	boolean successful = false;
	title = Title;
	successful = true;
	return successful;
    }

    public boolean setISBN(String ISBNum){
	boolean successful = false;
	ISBN = ISBNum;
	successful = true;
	return successful;
    }

    public String toString(){
	return getTitle() + ", " + getAuthor() + ", " + getISBN();
    }

    public static void main(String[]args){
	Book b0 = new Book("person", "random title", "210587689");
	b0.setTitle("new title");
	System.out.println(b0);
	
    }
}
