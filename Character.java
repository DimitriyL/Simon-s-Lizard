public abstract class Character {

    protected char symbol;
    protected int health;
    protected int atk;
    protected int xCor;
    protected int yCor;
    protected String name;

    public abstract int adjustHealth();
    public abstract String die();

}
