public class Barcode implements Comparable<Barcode>{
    private String _zip;

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

    private static boolean barsOnly(String barcode){
	for(int i = 0; i < 32; i++){
	    if(barcode.charAt(i) != '|' && barcode.charAt(i) != ':'){
		return false;
	    }
	}
	return true;
    }

    private static int checkSum(String zip){
	int sum = 0;
	for(int i = 0; i < 5; i++){
	    sum += Character.getNumericValue(zip.charAt(i));
	}
	return sum % 10;
    }

    private static String[] accessCode(){
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
	return code;
    }

    public static String toCode(String zip){
	String[] code = accessCode();
	String barcode = "|";
	for(int i = 0; i < zip.length(); i++){
	    barcode += code[Character.getNumericValue(zip.charAt(i))];
	}
	barcode += code[checkSum(zip)] + "|";
	return barcode;
    }

    public static String toZip(String barcode){
	if(barcode.length() != 32){
	    throw new IllegalArgumentException("barcode is not 32 characters long");
	}else if(barcode.charAt(0) != '|'){
	    throw new IllegalArgumentException("barcode does not start with |");
	}else if(barcode.charAt(31) != '|'){
	    throw new IllegalArgumentException("barcode does not end  with |");
	}
	if(!barsOnly(barcode)){
	    throw new IllegalArgumentException("barcode must only contain bars (i.e. | or :)");
	}
    
	String zipAndCheck = "";
	String[] code = accessCode();
	//find zipAndCheck
	boolean found = false;
	for(int i = 1; i < 30; i += 5){
	    found = false;
	    for(int index = 0; index < 10; index++){
		//System.out.println(index);
		//System.out.println(barcode.substring(i, i + 5));
		//System.out.println(code[index]);
		if(barcode.substring(i, i + 5).equals(code[index])){
		    zipAndCheck += index;
		    found = true;
		}
	    }
	    if(!found){
		throw new IllegalArgumentException("barcode contains nonsense code");
	    }
	}
	//verify validity of check sum
	if(checkSum(zipAndCheck) != Character.getNumericValue(zipAndCheck.charAt(5))){
	    throw new IllegalArgumentException("barcode contains invalid check sum or invalid zip");
	}
	return zipAndCheck.substring(0, 5);
    }

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
	return _zip + checkSum(_zip) + " " + toCode(_zip);
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
	System.out.println(toZip(toCode("01234")));
    }
}
