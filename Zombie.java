public class abstract Zombie extends Character
{
    protected int mobility;
    protected int reward;
    
    public abstract void move();

    public static void moveZombies ( Object [][] arr ){
	/*	for ( int r = 0; r < arr.length; r++ ) {
	    for ( int j = arr[r].length - 1; j >= 0; j--){
		if (arr[r][j].equals("-")){
		arr[r][j + 1] = arr[r][j];
		    arr[r][j] = "";
		}
	    }
	}

	*/

	
    }
    public abstract String dropSun();
    
}
