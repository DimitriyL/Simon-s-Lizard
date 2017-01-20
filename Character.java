public class Character {

    protected char symbol;
    protected int health;
    protected int atk;
    protected int xCor;
    protected int yCor;
    protected String name;

    public int adjustHealth(int amount){
	health -= amount;
	return health;
    }
    
    public String die ( ) {
	String s = "";
	return s;
    }
    
}
