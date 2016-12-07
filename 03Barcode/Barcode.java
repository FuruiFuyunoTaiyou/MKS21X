public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private int _checkDigit;

    private boolean digitsOnly(String zip){
	for(int i = 0; i < 5; i++){
	    if((int)'0' >= (int)zip.charAt(i) || (int)zip.charAt(i) >= (int)'9'){
		return false;
	    }
	}
	return true;
    }

    private int findCheckDigit(String zip){
	int sum = 0;
	for(int i = 0; i < 5; i++){
	    sum += Integer.parseInt(zip.charAt(i));
	}
	return sum % 10;
    }

    public Barcode(String zip){
	if(zip.length() == 5 && digitsOnly(zip)){
	    _zip = zip;
	    _checkDigit = findCheckDigit(zip);
	} else{
	    throw 
	}

    public static void main(String[]args){
        
    }
}
