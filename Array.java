import cs1.Keyboard;

public class Array {

    public static String[][] board = new String[9][9];
    

    public static String ArrayToString ( String [][] arr ) {
	rows(board);
	chars(board);
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

    public static void chars ( String [][] arr ) {
	int x = Keyboard.readInt();
	int y = Keyboard.readInt();
	arr[y][x] = Keyboard.readWord();
    }

    public static void main ( String[] args ) {
	//	System.out.println ( ArrayToString ( board ) );
	
	String r = "";
	Array kelly = new Array();
	r = "Welcome to PvZ";
	//kelly.chars(board);
	System.out.println( kelly.ArrayToString(board) );
	

    }
}
