public class Barcode implements Comparable<Barcode>{
    private String _zip;
    //private int _checkDigit;

    private boolean digitsOnly(String zip){
	for(int i = 0; i < 5; i++){
	    //System.out.println((int)'0');
	    //System.out.println((int)zip.charAt(i));
	    //System.out.println((int)'9');
	    if((int)'0' > (int)zip.charAt(i) || (int)zip.charAt(i) > (int)'9'){
		return false;
	    }
	}
	return true;
    }

    private int checkSum(){
	int sum = 0;
	for(int i = 0; i < 5; i++){
	    //sum += Integer.parseInt(_zip.charAt(i));
	    sum += Character.getNumericValue(_zip.charAt(i));
	}
	return sum % 10;
    }

    public static String toCode(String zip){
	//Using an array discussed in class
	String[] code = {
	    "||:::",
	    ":::||", 
	    "::|:|",
	    "::||:",
	    ":|::|",
	    ":|:|:",
	    ":||::",
	    "|:::|",
	    "|::|:",
	    "|:|::"
	};
	String barcode = "|";
	for(int i = 0; i < zip.length(); i++){
	    barcode += code[Character.getNumericValue(zip.charAt(i))];
	}
	//do not know how to reference checkSum() in a static method
	int sum = 0;
	for(int i = 0; i < 5; i++){
	    //sum += Integer.parseInt(_zip.charAt(i));
	    sum += Character.getNumericValue(zip.charAt(i));
	}
        sum %= 10;
	barcode += code[sum] + "|";
	return barcode;
    }

    /*public static String toZip(String barcode){

      }*/

    public Barcode(String zip){
	//System.out.println(zip.length());
	//System.out.println(digitsOnly(zip));
	if(zip.length() != 5 || !digitsOnly(zip)){
	    throw new IllegalArgumentException();
	}else{
	    _zip = zip;
	}
	/*if(zip.length() != 5){
	    throw new ZipIncorrectLengthException();
	}else if(!digitsOnly(zip)){
	    throw new ZipContainsNondigitException();
	}else{
	    _zip = zip;
	    //_checkDigit = findCheckDigit(zip);
	    }*/
    }

    public String toString(){
	return _zip + checkSum() + " " + toCode(_zip);
    }

    public int compareTo(Barcode other){
	//problem is that is compares char by char, not the overall difference
	return ((this.toString()).substring(0, 6)).compareTo((other.toString()).substring(0,6));

	/*String comparison = "";
	for(int i = 0; i < 6; i++){
	    comparison += ((this.toString()).substring(i, i + 1)).compareTo((other.toString()).substring(i, i + 1));
	}
	return Integer.parseInt(comparison);*/
    }

    public static void main(String[]args){
        Barcode bars = new Barcode("01234");
	System.out.println(bars);
	System.out.println(bars.compareTo(new Barcode("12345")));
    }
}
