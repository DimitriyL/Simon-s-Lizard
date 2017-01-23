import java.util.Random;

import cs1.Keyboard;


public class Woo {
    
    //the physical game board that is displayed in the terminal
    public static Object[][] board = new Object[9][9];//size of playing grid
    /*
      while the game board consists of mostly Strings, zomBoard and plaBoard keep track of the coordinates, x and y, of specifically Plants and Zombies
    */
    public static Zombie[][] zomBoard = new Zombie[9][9];
    public static Plants[][] plaBoard = new Plants[9][9];
    
    public static String plantsDir = "------------------------------\n\t~Plants Directory~\n------------------------------\nP=\n\tPea Pod: 5 suns (10HP, 5ATK)\nS=\n\tShroom: 3 suns (10HP, 0ATK)\nO=\n\tPotato: 10 suns (25HP, 4ATK)\nC=\n\tCorn Cobbler: 8 suns (10HP, 7ATK)\nT=\n\tCactus: 8 suns (8HP, 8ATK)\nW=\n\tWaterm'Cannon: 15 suns (15HP, 20ATK))";
    
    //public static String plantsDir = "------------------------------\n\t~Plants Directory~\n------------------------------\nP=\n\tProper Plant: 3 suns, 5ATK\nThis is the only plant";
    //public static int plantCount = 0;
    //suns are currency, used for predisposing a plant up the surface of the board
    public static int suns;
    //this determines whether the game will proceed another turn, and is triggered by the player
    public static boolean keepGoing = false;
    //game ends once life reaches 0
    //life reduces as Zombies reach the leftmost edge of the board
    public static int life = 50;

    //very little need for this; we could do without
    public Woo(){
	suns = 15;
    }
    
    //empty grid
    public static String ArrayToString ( Object [][] arr ) {
	String retstr = "";
	for ( int s = 0; s < arr.length ; s++ ) {
	    for ( int x = 0 ; x < arr[s].length ; x++ ) {
		//parses each element one by one
		//space used to make sure that no "null" spots are displayed
		retstr += arr[s][x] + "\t" + " ";
	    }
	    //aesthetic
	    retstr += "\n\n\n\n";
	}
	return retstr;

    }

    /*
      static String ArrayToClass(Object[][] arr)
      pre: the game board is due to be represented by an array
      post: the class, whether String, Plant, or Zombie, of each element of the board is returned
      this was used as a diagnostic to show why certain methods did not work when areas of the array went from Plant to String
    */
    public static String ArrayToClass(Object[][] arr){
	String retstr = "";
	for ( int s = 0; s < arr.length ; s++ ) {
	    for ( int x = 0 ; x < arr[s].length ; x++ ) {
		retstr += arr[s][x].getClass() + "\t" + " ";
	    }
	    retstr += "\n\n\n\n";
	}
	return retstr;
	
    }
    
    /*
      static void labeling(Object[][] arr)
      pre: an array of empty Object slots
      post: the top and left edges are labeled 1-8 to display an 8x8 grid
    */
    public static void labeling ( Object [][] arr ) {
        
	for ( int s = 0; s < arr.length ; s++ ) {//changes grid from being all "null" to space
	    for ( int x = 0 ; x < arr[s].length ; x++ ) {
		//important
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

    /*
      void chars (Object[][] arr)
      pre: a 2-d object array, in this case the game board, lacks any characters beyond edge markings
      post: a true travesty in method naming, chars draws user input to place a Plant at a specified spot on the game board.  The coordinates are then also registered in the plaBoard
    */
    public void chars ( Object [][] arr ) {
	int x;
	int y;
	String type;
        System.out.println("Type in x coordinate:");
        x = Keyboard.readInt();
        System.out.println("Type in y coordinate:");
        y = Keyboard.readInt();
        System.out.println(plantsDir);
        System.out.println("Choose a plant ( CaSe SeNsItIvE ):");
        type = Keyboard.readWord();
	try{
	    if((!(arr[y][x] instanceof Plants)) && ((x > 0) && (y > 0))){
		if ( type.equals("P") && suns > 4) {
		    Plants p = new Plants("-", 5, x, y, "P" );
		    arr[y][x] = p;
		    //the reversal of x and y here is for aestheric purposes but ultimately has only led to headaches
		    plaBoard[x][y] = p;
		    //registered accordingly; plaBoard is ultimately just a log of class instances, as many turn into Strings later within the game board
		    suns -= 5;
		    System.out.println("Suns are now at: " + suns);
		}
		else if ( type.equals("S") && suns > 2) {
		    Plants s = new Plants("-", 0, x, y, "S" );
		    arr[y][x] = s;
		    plaBoard[x][y] = s;
		    suns -= 3;
		    System.out.println("Suns are now at: " + suns);
		}
		else if ( type.equals("C") && suns > 7 ) {
		    Plants c = new Plants("-", 4, x, y, "C" );
		    arr[y][x] = c;
		    plaBoard[x][y] = c;
		    suns -= 8;
		    System.out.println("Suns are now at: " + suns);
		}
		else if ( type.equals("O") && suns > 9 ) {
		    Plants o = new Plants("-", 7, x, y, "O" );
		    arr[y][x] = o;
		    plaBoard[x][y] = o;
		    suns -= 10;
		    System.out.println("Suns are now at: " + suns);
		}
		else if ( type.equals("T") && suns > 7) {
		    Plants t = new Plants("-", 8, x, y, "T" );
		    arr[y][x] = t;
		    plaBoard[x][y] = t;
		    suns -= 8;
		    System.out.println("Suns are now at: " + suns);
		}
		else if ( type.equals("W") && suns > 14) {
		    Plants w = new Plants("-", 20, x, y, "W" );
		    arr[y][x] = w;
		    plaBoard[x][y] = w;
		    suns -= 15;
		    System.out.println("Suns are now at: " + suns);
		}
		else { System.out.println("You can not purchase that plant!"); }
	    }
	    else if((x == 0) || (y == 0)){
		System.out.println("That is not a space on the game board. Everyone knows that plants can't grow there!");
	    }
	    else{
		System.out.println("That space is occupied, and everyone knows that plants can't grow together!");
	    }
	}
	catch(ArrayIndexOutOfBoundsException e){
	    System.out.println("Because of your ridiculousness, you have forfeited your plant.");
	}
    }

    /*
      void trackPos()
      pre: the plant and zombie-specific boards exist with the x- and y-coordinates of each character registered
      post: this outputs a list of values for diagnostic purposes that represent each of Characters on the board
    */
    public void trackPos(){
	System.out.println("Zombie Board:\n");
	System.out.println(zomBoard);
	System.out.println("Zombie Coordinates:\n");
	for(int i = 0; i < zomBoard.length; i++){
	    for(int j = 0; j < zomBoard[i].length; j++){
		if(zomBoard[i][j] instanceof Zombie){
		    //instanceof works, as some slots will be empty
		    String retStr = "";
		    retStr += "(" + i + "," + j + ")\n" + zomBoard[i][j].health;
		    System.out.println(retStr);
		}
	    }
	}
	System.out.println("Plant Board\n");
	System.out.println(plaBoard);
	System.out.println("Plant Coordinates:\n");
	for(int a = 0; a < plaBoard.length; a++){
	    for(int b = 0; b < plaBoard[a].length; b++){
		if(plaBoard[a][b] instanceof Plants){
		    String retStr2 = "";
		    retStr2 += "(" + a + "," + b + ")\n" + plaBoard[a][b].type;
		    //literally meant to look like coordinates
		    System.out.println(retStr2);
		}
	    }
	}
    }

    /*
      void turn()
      pre: with all the boards and helper methods in place, this is the heart of the game
      post: first, all the bullets will move to their further locations.  Then, the user is given the option to add plants. After that, Zombies are created and new Plants may or may not fire their weapons.  Finally, any potential bullet hits are noted, and Zombies finally move.
      Now that I think of it, moveBullets and move should probably both be before the addition of Plants, as that is the step that has the least bearing on the current state of the board.  As well, the hit calculator could probably be run twice, once after each of the moves.
    */
    public void turn () {
	//return true;
	//bullets move one spot to the right
	moveBullets(board);
        hit(board, zomBoard, plaBoard);
	//move(board, zomBoard);
	//hit(board, zomBoard, plaBoard);
	System.out.println( ArrayToString(board) );

	boolean go;
	String input;

	if(suns >= 3){
	    System.out.println ( "Would you like to add a plant? \ny = yes \nn = no" );
	    System.out.println( "All characters beyond y and n are interpreted as n for no");
	    //	    boolean go;
	    input = Keyboard.readWord();
	    //allows the user to add as many plants as they choose
	    if ( input.equals("y") ) {
		go = true;
	    }
	    else{
		go = false; 
	    }
	    while ( go == true ) {
		chars(board);
		System.out.println ( "Would you like to add a plant? \ny = yes \nn = no" );
		//boolean go;
		if ( suns >= 3 ) {
		    input = Keyboard.readWord();
		    if ( input.equals("y") ) {
			go = true;
		    }
		    else { go = false; }
		}
		else{ go = false; }
	    }
	}
	else{
	    System.out.println("Insufficient suns.  Wait, impatient patriot.");
	}
	//randomly creates Zombies upon unoccupied spaces of the board
	createZombie(board);
	for(int i = 0; i < board.length; i++){
	    for(int j = board.length - 2; j >= 0; j--){
		//ah, this is a doozy.  First and foremost, Plants should be able to fire, so that is one of the positive conditions.  However, if a bullet passes through a plant, the spot on the board actually goes from class Plant to String, forcing the second portion
		if((board[i][j] instanceof Plants) || 
		   ((board[i][j] instanceof String) && (((String)board[i][j]).contains("P"))) ||
		   (((String)board[i][j]).contains("S")) || 
		   (((String)board[i][j]).contains("O")) ||
		   (((String)board[i][j]).contains("C")) ||
		   (((String)board[i][j]).contains("T")) ||
		   (((String)board[i][j]).contains("W"))
		   ){
		    //it would be too easy if a Plant fired every time
		    if((int)(Math.random() * 11.0) < plaBoard[j][i].freq){
			//	shoot((Plants) board[i][j]);
			shoot(plaBoard[j][i]);
			//System.out.println(plaBoard[j][i].bullet);
		    }
		}
	    }
	}
	
	//to include /trackPos();
	//hit takes all three boards, but for now only the first two are in use
	move(board, zomBoard);
	//when a bullet and Zombie are on the same space, damage is done to the Zombie, and, theoretically, the bullet should disappear
	hit(board, zomBoard, plaBoard);
	//this should allow Zombies to move each step, but they do not always
	System.out.println( ArrayToString(board) );
	cleanup(board);

	//to include/System.out.println(ArrayToClass(board));
	// System.out.println("Suns = " + suns);
	   

	//gets rid of stray bullets and Zombies and assigns health/life/suns values accordingly
	///	    cleanup(board);

	//largely diagnostic but still good for the player to see
	System.out.println("Suns: " + suns);
	System.out.println("Life: " + life);

	if(life <= 0){
	    return;
	}

	System.out.println("Stop playing?\n(y/n)");
	input = Keyboard.readWord();
	if(input.equals("n")){
	    keepGoing = true;
	    go = true;
	}
	else{
	    System.out.println("All characters other than n will be interpreted as a y for yes. Are you sure?");
	    input = Keyboard.readWord();
	    if(!(input.equals("n"))){
		go = false; keepGoing = false;
	    }
	}
    }

    /*
      void shoot (Plants c)
      this causes each Plant, or Plant-looking spot, to output a bullet
      since bullet is an instance variable, that will simply be placed on the board if the space in front of the plant is clear.
      you could also try using += instead of =; that would likely get rid of the need for that bulky conditional
    */
    public void shoot ( Plants c ) {
	String s = c.bullet;
	if((board[ c.yCor ][ c.xCor + 1].equals(" ")) || (board[c.yCor][c.xCor + 1].equals(""))){
	    //essentially if there is empty space ahead
	    board[ c.yCor ][ c.xCor + 1 ] = s; 
	}
    } 

    /*
      void moveBullets (board)
      pre: the board, after Plants having shot, is laden with bullets
      post: all the bullets move one spot to the right without leaving the board
    */
    public void moveBullets ( Object [][] arr ){
	for ( int r = 0; r < arr.length; r++ ) {
	    for ( int c = arr[r].length - 2; c > 0; c-- ) {
		//the "-2" is to ensure that bullets don't head out of bounds
		if ( (arr[r][c] instanceof String) && ((String)arr[r][c]).contains("-")){
		    //   System.out.println(arr[r][c]);
		    arr[r][c] = ((String)arr[r][c]).replace("-", "");
		    arr[r][c] = ((String)arr[r][c]).replace(" ", "");
		    //the removal of the space ensures that bullets are not awkwardly pushed one space over
		    //to include /System.out.println(("Class of the bullet's slot: " + arr[r][c]).getClass());
		    arr[r][c + 1] += "-";
		    arr[r][c + 1] = ((String)arr[r][c + 1]).replace(" ", "");
		    //one column over-> c+1
		    //		    System.out.println(arr[r][c + 1]);
		}
		
	    }
	}
    }

    /*
      void createZombie(board)
      pre: the board has Plants and bullets, but Zombies are yet to be created
      post: Zombies are created and randomly dispersed throughout the rightmost 3 columns of the board
    */
    public void createZombie(Object[][] arr){
	//proceed determines whether the randomly-selected space is clear for a Zombie to be placed
	boolean proceed = false;
	//a random spot within the last 3 columns
	int x = (int)(Math.random() * 3.0) + 6;
	int y = (int)(Math.random() * 8.0) + 1;
	
	/*
	  ah, another hefty conditional.  In this case, the selected spot must first be of Class String rather than a pre-existing plant or zombie.  As well, it must not contain any relevant game characters
	*/
	if((arr[y][x] instanceof String) && (!(((String)arr[y][x]).contains("-"))) && (!((String)arr[y][x]).contains("Z"))){
	    //	    if(!(arr[y][x] instanceof Zombie)){
	    if((Math.random() * 10.0) < 7){
		//thus, a zombie is not always created
		proceed = true;
	    }
	}

	//diagnostic print statement
	if(proceed == true){
	    System.out.println("Watch out! Zombie at (" + (x - 1) + "," + y + ")");
	}
	else{System.out.println("Y'all safe for now...");}

	if(proceed == true){
	    //constructor for the zombie's attributes
	    //the only truly relevant ones are all of them besides mobility
	    Zombie z = new Zombie("Z", 10, 10, 10, x, y);
	    arr[y][x] = z.type;
	    //registers within the zomBoard
	    zomBoard[x][y] = z;
	    //must be turned on again
	    proceed = false;
	    
	}
    }

    /*
      void hit (all the boards)
      the bBoard is the game board, and the rest are self-explanatory
      basically, if a space on the board contains both a bullet ("-") and a zombie ("Z"), even though that space's class may still be a String, that is still considered a hit
      thus, using the spot's coordinates, the zombie's health is accessed in the zomBoard (zBoard), and altered accordingly, while the bullet is also supposed to vanish
      as well, the zombie could die, in which case it transforms into its sun value for a turn, before the value is added to the sun total
    */
    public void hit(Object[][] bBoard, Zombie[][] zBoard, Plants[][] pBoard){
	for(int y = 0; y < bBoard.length; y++){
	    for(int x = 0; x < bBoard[y].length; x++){
		if((bBoard[y][x] instanceof String) && (((String)bBoard[y][x]).contains("-") && ((String)bBoard[y][x]).contains("Z"))){
		    //the space must be a String that contains both a bullet and a zombie

		    //no longer purely diagnostic
		    System.out.println("Hit!");
		    //System.out.println(bBoard[y][x]);
		    System.out.println("At (" + x + "," + y + ")");
		    //accessing the zBoard using bBoard coordinates
		    System.out.println("Original health: " + zBoard[x][y].health);
		    //currently, all bullets bring down health by 5
		    zBoard[x][y].adjustHealth(5);
		    //for player use and as a diagnostic
		    System.out.println("Current health: " + zBoard[x][y].health);
		    //should remove the bullet, but this does not always work
		    bBoard[y][x] = ((String)bBoard[y][x]).replace("-", "");
		    if(zBoard[x][y].health <= 0){
			zBoard[x][y].die();
			bBoard[y][x] = "" + zBoard[x][y].reward;
			System.out.println("A Zombie has died");
			//strangely enough, this part works rather consistently, but with a one-turn delay
			System.out.println("Your reward: " + bBoard[y][x] + " suns");
		    }
		}
	    }
	}
    }

    /*
      void move(board, zomBoard)
      pre: the Zombies exist, but are stationary
      post: Zombies are moved 1 space to the left
    */
    public static void move( Object [][] arr, Zombie[][] zArr ){
        for ( int r = 0; r < arr.length; r++ ) {
	    //starts at 2 to avoid breaching the leftmost boundary
            for ( int j = 2; j < arr[r].length; j++){
		//basically, any space with a "Z" string to show a zombie
                if ((arr[r][j] instanceof String) && (((String)arr[r][j]).contains("Z"))){
                    arr[r][j] = ((String)arr[r][j]).replace("Z", "");
                    arr[r][j] = ((String)arr[r][j]).replace(" ", "");        

                    arr[r][j - 1] += "Z";
                    arr[r][j - 1] = ((String)arr[r][j - 1]).replace(" ", "");
		    //same algorithm as with bullets  
                    //zArr[j][r].(super.xCor) -= 1;

		    //this part is important
		    /*
		      the zombies must be also moved within the zomBoard to allow coordinates to still correspond were any bullets to hit while the zombie is moving
		    */
                    Zombie mock = zArr[j - 1][r];
                    zArr[j - 1][r] = zArr[j][r];
                    zArr[j][r] = mock;
		    //this should likely be placed before hit and trackPos withing the turn() method, now that I think of it
		    //there seems to be a one-turn lag at the moment
                }
            }
        }
    }

    /*
      void Cleanup(board)
      the first part removes any bullets left in the rightmost column, as they have no use
      the second part should remove any zombies in the leftmost column, and also lower the player's life accordingly. 
      the third part finds the remnants of any dead zombies on the board, which are shown by the zombie's value in suns (at the moment "10").  This part both removes these numbers from the board and also adds them to the suns total
    */
    public void cleanup(Object[][] arr){
	//all rows, only the final column
	for(int i = 0; i < 9; i++){
	    if (arr[i][8] instanceof String){
		//not sure, but I could also turn the spaces into ""
		arr[i][8] = ((String)arr[i][8]).replace("-", " "); 
	    }
	}
	for(int m = 0; m < 9; m++){
	    //all rows, first column
	    if ((arr[m][1] instanceof String) && (((String)arr[m][1]).contains("Z"))){
		arr[m][1] = ((String)arr[m][1]).replace("Z", " ");
		//again, should the spaces be removed 
		life -= 10; 
		System.out.println("Careful! You're like Russell Wilson, you need better protection.");
		//also, I am not sure if I need that second part of the if statement, as it seems to be hindering the primary goal of this, which is lowering the life
	    }
	}
	for(int a = 1; a < arr.length; a++){
	    for(int b = 1; b < arr[a].length; b++){
		//this works well
		//all of the suns values dropped by dead zombies are parsed through, and their values are added to the suns total and removed from the board
		if(arr[a][b] instanceof String){
		    try{
			int n = Integer.parseInt((String)arr[a][b]);
			suns += n;
			arr[a][b] = ((String)arr[a][b]).replace("" + n, " ");
		       
		    }
		    //simply doesn't run for non-Strings
		    catch(NumberFormatException e){}
		}
	    }
	}
    }

    public static void main ( String[] args ) {
        Woo kelly = new Woo();
	//allows for non-static variables
		
	String r = "==============================";
	System.out.println(r);
	System.out.println("\tWelcome to Plants vs Zombies!");
	System.out.println(r);

	System.out.println("Suns = " + suns);
	System.out.println("Here is today's game board: ");
	System.out.println(r);
	//purely aesthetics
	
	kelly.labeling(board);
	System.out.println( kelly.ArrayToString(board) );

	System.out.println(r);
	
	System.out.println("Now let's begin the game!");
	
	kelly.labeling(board);

	System.out.println(r);
	
	//	System.out.println( kelly.ArrayToString(board) );
	System.out.println("Suns = " + suns);
	System.out.println("Life = " + life);
	System.out.println(r);
	
	//	boolean go = false;
	System.out.println("Play a turn?\n(y/n)");
	//this algorithm currently works for playing turns and adding multple plants per turn
	//allows player to insert plants independantly of the game going on
	String input = Keyboard.readWord();
	if(input.equals("y")){
	    keepGoing = true;
	}
	else if(!(input.equals("n"))){
	    System.out.println("Please input y for yes or n for no. All other characters will be interpreted as no.");
	    input = Keyboard.readWord();
	    if(input.equals("y")){
		keepGoing = true;
	    }
	}
	while(keepGoing == true){
	    kelly.turn();
	    if(life <= 0){
		keepGoing = false;
		System.out.println("This game is over!");
	    }
	}
    }
}
