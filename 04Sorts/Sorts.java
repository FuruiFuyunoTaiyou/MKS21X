//the idea of using an if statement to account for empty arrays was form Jacqueline Xu

import java.util.*; //for the random


public class Sorts{
    public static String name(){
	return "10.Chen.Winnie";
    }

    private static void swap(int[] data, int indexCurrent, int indexOfCurrentSmallest){
	int currentSmallest = data[indexOfCurrentSmallest];
	data[indexOfCurrentSmallest] = data[indexCurrent];
	data[indexCurrent] = currentSmallest;
    }
    
    public static void selectionSort(int[] data){
	if(data.length > 1){
	    int indexOfCurrentSmallest = 0;
	    for (int i = 0; i < data.length - 1; i++){ 
		indexOfCurrentSmallest = i; 
		for (int index = i + 1; index < data.length; index++){ 
		    if(data[index] < data[indexOfCurrentSmallest]){
			indexOfCurrentSmallest = index;
		    }
		}
		swap(data, i, indexOfCurrentSmallest);
	    }
	}
    }

    public static void insertionSort(int[] data){
	if(data.length > 1){
	    int lostValue = 0;
	    for(int i = 1; i < data.length; i++){
		lostValue = data[i];
		int index = i - 1;
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
	boolean swapped = true;
	if(data.length > 1){
	    for(int end = data.length - 2; swapped && end >= 0; end--){ 
		swapped = false;
		for(int i = 0; i <= end; i++){ 
		    if(data[i] > data[i + 1]){
			swap(data, i, i + 1);
			swapped = true;
		    }
		}
		if(!swapped){
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

    public static long testSort(int[] origin, String whichSort){
	long startTime, endTime;
	startTime = System.currentTimeMillis();
	if(whichSort.equals("selectionSort")){
	    selectionSort(origin);
	}else if(whichSort.equals("insertionSort")){
	    insertionSort(origin);
	}else if(whichSort.equals("bubbleSort")){
	    bubbleSort(origin);
	}
	endTime = System.currentTimeMillis();
	boolean asExpected = true;
	for(int i = 1; i < origin.length; i++){
	    if(origin[i] < origin[i - 1]){
		asExpected = false;
	    }
	}
	if(asExpected){
	    return (endTime - startTime);
	}
	return 10000;
    }

    public static void main(String[] args){
	if(args.length < 3){
	    System.out.println("Enter additional info: size of array, name of sort method, and the order of the array (-1 for descending, 1 for ascending, and 0 for random (I'll assume the type of input is right for now)");
	}else{
	    int[] data = new int[Integer.parseInt(args[0])];
	    Random randgen = new Random();
	    if(Integer.parseInt(args[2]) == -1){
		for(int i = 0; i < data.length; i++){
		    data[i] = 0 - i;
		}
	    }else if(args[2].equals("1")){
		for(int i = 1; i < data.length; i++){
		    data[i] = i;
		}
	    }else{
		for(int i = 0; i < data.length; i++){
		    data[i] = randgen.nextInt();
		}
	    }
	    System.out.println(testSort(data, args[1]) + " Millis");
	}	
    }
}
