public class Plants extends Character{

    protected String type;
    protected String bullet;
    protected int cost;
    protected int freq;

    public Plants(String bullet1, int freq1, int xCor1, int yCor1, String type1){
	bullet = bullet1;
	freq = freq1;
	super.xCor = xCor1;
	super.yCor = yCor1;
	if (type1 == "P") {
        symbol = "P";
        health = 10;
        atk = 5;
        cost = 5;
    }
    
    if (type1 == "S") {
        symbol = "S";
        health = 6;
        atk = 4;
        cost = 3;
    }
    
    if (type1 == "T") {
        symbol = "T";
        health = 25;
        atk = 0;
        cost = 10;
    }
    
    if (type1 == "B") {
        symbol = "B";
        health = 10;
        atk = 7;
        cost = 8;
    }
    
    if (type1 == "C") {
        symbol = "C";
        health = 8;
        atk = 8;
        cost = 7;
    }
    
    if (type1 == "W") {
        symbol = "W";
        health = 15;
        atk = 15;
        cost = 20;
    }
    }

    public String toString() {
	return symbol;
    }

    public String shoot () {
	return bullet;
    } 
    
}
