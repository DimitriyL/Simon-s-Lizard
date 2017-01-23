public class Zombie extends Character
{
    protected String type;
    //type is the symbol on the board for the zombie: Z
    protected int health;
    //health is always 10
    protected int mobility;
    //this was a possible plan but was ultimately not implemented
    //idea was to have some Zombies move more than others
    protected int reward;
    //the number of suns a Zombie drops: 10
    
    //overloaded constructor
    //however, this could have been default, as every construction is the same
    public Zombie(String type1, int health1, int mobility1, int reward1, int xCor1, int yCor1){
	type = type1;
	health = health1;
	mobility = mobility1;
	reward = reward1;
	//only real reference to Character
	super.xCor = xCor1;
	super.yCor = yCor1;
    }

    /*
      int adjustHealth(int damage)
      pre: a Zombie exists of health > o; a specified amount of damage is taken at input
      post: health is decreased by damage amount (always 5), old health (before damage) is outputted
     */
    public int adjustHealth(int damage){
	int oldHealth = health;
	//simple swap algorithm
	health -= damage;
	return oldHealth;
    }

    /*
      int die()
      pre: a Zombie exists of health < 0
      post: the type becomes " ", which forced to Zombie to visibly disappear from the board.  As well, the Zombie's sun reward (10) is returned
     */
    public int die(){

	type = " ";

	return reward;
    }

    //how Zombies look on the board
    public String toString(){
	return type;
    }

    /*    public static void move( Object [][] arr, Zombie[][] zArr ){
	for ( int r = 0; r < arr.length; r++ ) {
	    for ( int j = 2; j < arr[r].length - 1 ; j++){
		if ( (arr[r][j] instanceof String) && (arr[r][j].contains("Z"))){
		    arr[r][j] = ((String)arr[r][j]).replace("Z", "");
		    arr[r][j] = ((String)arr[r][j]).replace(" ", "");		    
		    arr[r][j - 1] = "Z";
		    arr[r][j - 1] = ((String)arr[r][j - 1]).replace(" ", "");	    
		    zArr[j][r].super.xCor -= 1;
		    Zombie mock = zArr[j - 1][r];
		    zArr[j - 1][r] = zArr[j][r];
		    zArr[j][r] = mock;
		}
	    }
	    }*/

	

	
}
    //public abstract String dropSun();
    

