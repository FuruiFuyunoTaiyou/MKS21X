//the idea of using an if statement to account for empty arrays was form Jacqueline Xu
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

	if(data.length > 1){
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
    }

    public static void insertionSort(int[] data){
	//compare the first element after the sorted subarray to each element from greatest to least
	//if the value to be placed is less than the value it is being compared with, switch places
	//if otherwise, you're done with placing that value; start over

	if(data.length > 1){
	    int lostValue = 0;
	    for(int i = 1; i < data.length; i++){//for each value besides first one,
		lostValue = data[i];
		//System.out.println(lostValue);
		//System.out.println(i);
		int index = i - 1;
		//System.out.println(index);
		while(index >= 0 && lostValue < data[index]){
		    data[index + 1] = data[index];
		    data[index] = lostValue;
		    index--;
		}
		data[index + 1] = lostValue;
	    }
	}
    }

    public static void bubbleSort(int[] data){
	//for each value (except the last), compare it with the next value. If the next value is smaller, swap places
	//Repeat this for the array without the last element (because it is already in place) and so on if swaps have been made during the last pass
	//if no swaps have been made for a whole pass, end the method (return ;)

	boolean swapped = true;
	if(data.length > 1){
	    for(int end = data.length - 2; swapped && end >= 0; end--){ //shortening the unsorted array each time
		swapped = false;
		//System.out.println("end = " + end);
		for(int i = 0; i <= end; i++){ //actually looping through and comparing for each shortened unsorted array
		    //System.out.println("i = " + i);
		    if(data[i] > data[i + 1]){
			swap(data, i, i + 1);
			swapped = true;
		    }
		}
		if(!swapped){ //if no swaps/changes have occured by the end of a whole runthrough, 
		    return ;
		}
	    }
	}
    }

    public static void printArray(int[] data){
	String arrayValues = "[";
	if(data.length > 0){
	    arrayValues += data[0];
	    for(int i = 1; i < data.length; i++){
		arrayValues += ", " + data[i];
	    }
	}
	arrayValues += "]";
	System.out.println(arrayValues);
    }


    public static void main(String[] args){
	int[] data0 = {64, 25, 12, 22, 11};
	int[] data1 = {2, 0, 13, 0, 4, 1};
	int[] data2 = {0};
	int[] data3 = {};
        bubbleSort(data0);
	printArray(data0);
        bubbleSort(data1);
	printArray(data1);
        bubbleSort(data2);
	printArray(data2);
        bubbleSort(data3);
	printArray(data3);
    }
}
