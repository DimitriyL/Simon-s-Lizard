/*
this was a class created to be a superclass for Plants and Zombie
however, it ultimately became easier to simply use those as separate classes instead
 */
public class Character {

    protected char symbol;
    //replaced by "type" in Plants and Zombie
    protected int health;
    //replaced by "health"
    protected int xCor;
    protected int yCor;
    //xCor and yCor ultimately went unused because of plaBoard and zomBoax

    /*
      int adjustHealth(int amount)
      this method takes the pre-existing health of a character, alters it by input value "amount," and outputs the new health value
      however, this was overriden in Zombie to output the old health
     */
    public int adjustHealth(int amount){
	health -= amount;
	return health;
    }
}
