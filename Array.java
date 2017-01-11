public class Array {

    public static String[][] board = new String[9][9];
    
    public static String ArrayToString ( String [][] arr ) {
	rows(board);
	String retstr = "";
	for ( int s = 0; s < arr.length ; s++ ) {
	    for ( int x = 0 ; x < arr[s].length ; x ++) {
		retstr += arr[s][x] + "\t" + " ";
	    }
	    retstr += "\n\n\n\n";
	}
	return retstr;

    }
    
    
    public static void rows ( String [][] arr ) {
	for ( int s = 0; s < arr.length ; s++ ) {
	    for ( int x = 0 ; x < arr[s].length ; x ++) {
		arr[s][x] = " ";
	    }
	}
	for ( int s = 1; s < arr[0].length ; s++ ) {
	    String a = "" + s;
	    arr[0][s] = a;
	}
	
	for ( int s = 1; s < arr.length ; s++ ) {
	    String a = "" + s;
	    arr[s][0] = a;
	}
   
    }

    public static void main ( String[] args ) {
	//rows(board);
	System.out.println ( ArrayToString ( board ) );
    }
}
