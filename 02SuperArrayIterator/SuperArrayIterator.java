import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    private SuperArray superArray;
    private int currentIndex;

    public SuperArrayIterator(SuperArray superArrayName, int CurrentIndex){
	superArray = superArrayName;
	currentIndex = CurrentIndex;
    }

    public boolean hasNext(){
	return currentIndex < superArrayName.size() - 1; 
    }

    public String next(){
	if(hasNext()){
	    currentIndex++;
	    return superArray.get(currentIndex - 1);
	}else{
	    throw new NoSuchElementException();
	}
    }

    public void remove(){
	System.out.println("The remove method is not supported for SuperArrayIterator.");
    }
}
