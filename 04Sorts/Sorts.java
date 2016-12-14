public class Sorts{
    public static String name(){
	return "10.Chen.Winnie";
    }

    private static void swap(int[] data, int indexCurrent, int indexOfCurrentSmallest){
	int currentSmallest = data[indexOfCurrentSmallest];//remember the value at the current index
	data[indexOfCurrentSmallest] = data[indexCurrent];
	data[indexCurrent] = currentSmallest;
    }
    
    public static void selectionSort(int[] data){
	//find the index of smallest number remaining
	//swap places with the element in the place it's supposed to be in
	//repeat
	int currentSmallest = 0;//set it to the first one
	int indexOfCurrentSmallest = 0;
	for (int i = 0; i < data.length - 1; i++){ //for each element in data except the last one,
	    indexOfCurrentSmallest = i; //first set the  indexOfCurrentSmallest
	    for (int index = i + 1; index < data.length; index++){ //run through the rest of the array to find the actual indexOfCurrentSmallest
		if(data[index] < currentSmallest){
		    indexOfCurrentSmallest = index;
		}
	    }
	    swap(data, i, indexOfCurrentSmallest);
	}
    }

    public static void printArray(int[] data){
	String arrayValues = "[" + data[0];
	for(int i = 1; i < data.length; i++){
	    arrayValues += ", " + data[i];
	}
	arrayValues += "]";
	System.out.println(arrayValues);
    }


    public static void main(String[] args){
	int[] data0 = {64, 25, 12, 22, 11};
	int[] data1 = {2, 0, 13, 0, 4, 1};
	int[] data2 = {};
	selectionSort(data0);
	printArray(data0);
	selectionSort(data1);
	printArray(data1);
	selectionSort(data2);
	printArray(data2);
    }
}
