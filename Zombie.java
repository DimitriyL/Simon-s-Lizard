public class Zombie extends Character
{
    protected String type;
    protected int health;
    protected int mobility;
    protected int reward;
    
    public Zombie(String type1, int health1, int mobility1, int reward1, int xCor1, int yCor1){
	type = type1;
	health = health1;
	mobility = mobility1;
	reward = reward1;
	super.xCor = xCor1;
	super.yCor = yCor1;
    }

    public int adjustHealth(int damage){
	int oldHealth = health;
	health -= damage;
	return oldHealth;
    }

    public int die(){

	type = " ";

	return reward;
    }

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
    

