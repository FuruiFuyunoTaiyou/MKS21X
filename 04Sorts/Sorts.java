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
	int indexOfCurrentSmallest = 0;
	for (int i = 0; i < data.length - 1; i++){ //for each element in data except the last one,
	    indexOfCurrentSmallest = i; //first set the  indexOfCurrentSmallest
	    for (int index = i + 1; index < data.length; index++){ //run through the rest of the array to find the actual indexOfCurrentSmallest
		if(data[index] < data[indexOfCurrentSmallest]){
		    indexOfCurrentSmallest = index;
		}
	    }
	    swap(data, i, indexOfCurrentSmallest);
	}
    }

    public static void insertionSort(int[] data){
	//compare the first element after the sorted subarray to each element from greatest to least
	//if the value to be placed is less than the value it is being compared with, switch places
	//if otherwise, you're done with placing that value; start over
	int lostValue = 0;
	for(int i = 1; i < data.length; i++){//for each value besides first one,
	    lostValue = data[i];
	    for(int index = i - 1; index >= 0; index--){//looking from greatest to least
		if(lostValue < data[index]){
		    data[index + 1] = data[index];
		    data[index] = lostValue;
		}else{
		    data[index + 1] = lostValue;
		}
	    }
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
	int[] data2 = {0};
	int[] data3 = {};
        insertionSort(data0);
	printArray(data0);
	insertionSort(data1);
	printArray(data1);
	insertionSort(data2);
	printArray(data2);
	insertionSort(data3);
	printArray(data3);
    }
}
