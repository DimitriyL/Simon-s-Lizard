public class Plants extends Character{

    protected String type;
    //the symbol representing each plant-only P at this point
    protected String bullet;
    //the symbol representing a bullet-only -
    protected int cost;
    //3 suns
    protected int freq;
    //determines the chance that a plant will fire a bullet; always 5

    //overloaded constructor that could have been default
    public Plants(String bullet1, int freq1, int xCor1, int yCor1, String type1){
	bullet = bullet1;
	freq = freq1;
	//refers to Character
	super.xCor = xCor1;
	super.yCor = yCor1;
	type = type1;
    }

    //how the plant will appear
    public String toString() {
	return type;
    }

    //was going to be the main method for shoot, but that method was re-written in the driver file
    //this was mostly a diagnostic to view whether a Plant had fired a bullet
    public String shoot () {
	return bullet;
    } 
}
