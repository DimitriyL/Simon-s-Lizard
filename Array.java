public class Array {

    public static String[][] board = new String[9][9];
    
    public static String ArrayToString ( String [][] arr ) {
	String retstr = "";
	for ( int s = 0; s < arr.length ; s++ ) {
	    for ( int x = 0 ; x < arr[s].length ; x ++) {
		retstr += "_ \t" + " ";
	    }
	    retstr += "\n";
	}
	return retstr;
    }

    public static void main ( String[] args ) {
	System.out.println ( ArrayToString ( board ) );
    }
}
