public class Sorts{
    public static String name(){
	return "10.Chen.Winnie";
    }

    public static void selectionSort(int[] data){
	//find the index of smallest number remaining
	//swap places with the element in the place it's supposed to be in
	//repeat
	int currentSmallest = 0;//set it to the first one
	int indexOfCurrentSmallest = 0;
	for (int i = 0; i < data.length; i++){ //for each element in data,
	    currentSmallest = data[i]; //first set the currentSmallest and indexOfCurrentSmallest
	    indexOfCurrentSmallest = i;
	    for (index = i + 1; index < data.length; index++){ //run through the rest of the array to find the actual currentSmallest and indexOfCurrentSmallest
		if(data[index] < currentSmallest){
		    currentSmallest = data[index];
		    indexOfCurrentSmallest = index;
		}
	    }
	    //swap, I believe
	}
    }
}
