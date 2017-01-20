import cs1.Keyboard;


public class Woo {
    
    public static Object[][] board = new Object[9][9];//size of playing grid
    public static Plants[] plantList = new Plants[25];
    public static String plantsDir = "------------------------------\n\t~Plants Directory~\n------------------------------\nP=\n\tPea Pod: 5 suns (10HP, 5ATK)\nS=\n\tShroom: 3 suns (10HP, 0ATK)\nO=\n\tPotato: 10 suns (25HP, 0ATK)\nC=\n\tCorn Cobbler: 8 suns (10HP, 7ATK)\nT=\n\tCactus: 8 suns (8HP, 8ATK)\nW=\n\tWaterm'Cannon: 15 suns (15HP, 20ATK)";
    public static int plantCount = 0;
    
    //empty grid
    public static String ArrayToString ( Object [][] arr ) {
	//labeling(board);
	//chars(board);
	String retstr = "";
	for ( int s = 0; s < arr.length ; s++ ) {
	    for ( int x = 0 ; x < arr[s].length ; x++ ) {
		retstr += arr[s][x] + "\t" + " ";
	    }
	    retstr += "\n\n\n\n";
	}
	return retstr;

    }
    
    
    public static void labeling ( Object [][] arr ) {
        
	for ( int s = 0; s < arr.length ; s++ ) {//changes grid from being all "null" to space
	    for ( int x = 0 ; x < arr[s].length ; x++ ) {
		arr[s][x] = " ";
	    }
	}
	
	for ( int s = 1; s < arr[0].length ; s++ ) {//numbers along x-axis
	    String a = "" + s;
	    arr[0][s] = a;
	}
	
	for ( int s = 1; s < arr.length ; s++ ) {//numbers along y-axis
	    String a = "" + s;
	    arr[s][0] = a;
	}

	//arr[0][0] = " \nx \ny";
    }

    public static void chars ( Object [][] arr ) {
	System.out.println("Type in x coordinate:");
	int x = Keyboard.readInt();
	System.out.println("Type in y coordinate:");
	int y = Keyboard.readInt();
	System.out.println(plantsDir);
	System.out.println("Choose a plant:");
	arr[y][x] = Keyboard.readWord();
	Plants p = new Plants("-", 1, x, y);
	plantList[plantCount] = p;
	plantCount++;
	System.out.println(p.shoot());
	moveBullets(arr);
	for(Plants l: plantList){
	    shoot(p);
	}

	//System.out.println(plantList);
	//
    }

    public void turn () {
	//return true;
	
	System.out.println ( "Would you like to add a plant? \ny = yes \nn = no" );
	boolean go;
	String input = Keyboard.readWord();
	if ( input.equals("y") ) {
	    go = true;
	}
	else { go = false; }
	while ( go == true ) { 
	    //labeling(board);
	    chars(board);
	    // System.out.println(r);
	    System.out.println( ArrayToString(board) );
	    // System.out.println("Suns = " + suns);
	   
	    /*for(Plants p: plantList){
		p.shoot();
		}*/

	    System.out.println ( "Would you like to add a plant? \ny = yes \nn = no" );
	    //boolean go;
	    input = Keyboard.readWord();
	    if ( input.equals("y") ) {
		go = true;
	    }
	    else { go = false; }
	}

    }

    public static void shoot ( Plants c ) {
	String s = c.bullet;
	board[ c.xCor ][ c.yCor + 1 ] = s; 
    } 

    public static void moveBullets ( Object [][] arr ){
	for ( int r = 0; r < arr.length; r++ ) {
	    for ( int c = arr[r].length - 2; c > 0; c-- ) {
		if ( arr[r][c].equals("-")){
		    arr[r][c + 1] = "-";
		    arr[r][c] = "";
		}
	    }
	}
    }

    public static void main ( String[] args ) {
        Woo kelly = new Woo();
	int suns = 15;
	
	String r = "==============================";
	System.out.println(r);
	System.out.println("\tWelcome to PvZ!");
	System.out.println(r);

	System.out.println("Suns = " + suns);
	System.out.println(r);
	
	kelly.labeling(board);
	System.out.println( kelly.ArrayToString(board) );

	System.out.println(r);
	
	System.out.println("Now let's begin the game!");
	
	kelly.labeling(board);
	kelly.chars(board);

	System.out.println(r);
	
	System.out.println( kelly.ArrayToString(board) );
	System.out.println("Suns = " + suns);
	System.out.println(r);
	
	kelly.turn();
    }
}
