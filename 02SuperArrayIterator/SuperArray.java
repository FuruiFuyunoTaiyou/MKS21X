public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;
  
    public SuperArray(){
	size = 0;
	data = new String[10];
    }

    public SuperArray(int initialCapacity){
	if(initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	size = 0;
	data = new String[initialCapacity];
    }
    
    public int size(){
	return size;
    }
    
    public String get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }

    public int indexOf(String i){
	for(int index = 0; index < size; index++){
	    if(data[index].equals(i)){
		return index;
	    }
	}
	return -1;
    }

    public int lastIndexOf(String i){
	for(int index = size - 1; index >= 0; index--){
	    if(data[index].equals(i)){
		return index;
	    }
	}
	return -1;
    }
    
    public String toString(){
	String returnValue = "[";
	for (int index = 0; index < size - 1; index++){
	    returnValue += " " + data[index] + ",";
	}
	returnValue += " " + data[size - 1] + "]";
	return returnValue;
    }
    
    public String toStringDebug(){
	String returnValue = "[";
	if (data.length > 0){
	    for (int Index = 0; Index < data.length - 1; Index++){
		if (Index > size - 1){
		    returnValue += " _,";
		}
		else{
		    returnValue += " " + data[Index] + ",";
		}
	    }
	    if (size < data.length){
		returnValue += " _";
	    }
	    else{
		returnValue += " " + data[data.length - 1];
	    }
	}
	returnValue += "]";
	return returnValue;
    }

    private void grow(){
        String[] newData = new String[data.length * 2 + 1];
	for (int i = 0; i < data.length; i++){ 
	    newData[i] = data[i];
	}
	data = newData;
    }
    
    public boolean add(String n){
	size++;
	if (size > data.length){
	    this.grow();
	}
	data[size - 1] = n;
	return true;
    }

    public void add(int index, String element){
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	if (size + 1 > data.length){
	    this.grow();
	}
	for(int i = size; i > index; i--){
	    data[i] = data[i - 1];
	}
	size++;
	data[index] = element;
    }

    public String set(int index, String element){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	String elementReplaced = data[index];
	data[index] = element;
	return elementReplaced;
    }

    public String remove(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	String elementRemoved = data[index];
	size--;
	for(int i = index; i < size; i++){
	    data[i] = data[i + 1];
	}
	return elementRemoved;
    }

    public void clear(){
	for(int i = 0; i < size; i++){
	    data[i] = "";
	}
    }

    public void trimToSize(){
	String[] newData = new String[size];
	for (int i = 0; i < size; i++){ 
	    newData[i] = data[i];
	}
	data = newData;
    }

    public boolean isEmpty(){
	if (size < 1){
	    return true;
	}
	else{
	    return false;
	}
    }

    public String[] toArray(){
	String[] arrayVer = new String[size];
	for(int i = 0; i < size; i++){
	    arrayVer[i] = data[i];
	}
	return arrayVer;
    }

    public SuperArrayIterator iterator(){
	SuperArrayIterator correspondingIterator = new SuperArrayIterator(this, 0);
	return correspondingIterator;
    }
}
