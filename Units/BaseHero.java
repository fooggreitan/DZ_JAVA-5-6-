import java.util.ArrayList;
import java.util.Random;
 
public abstract class BaseHero implements UnitInterface {
    protected static  Random rnd = new Random();
    
    protected String name;
    protected float hp;
    protected int speed;
    protected int maxHp;
    protected int armor;
    protected int damage;
    protected Position position;
    protected int maxDamage;
    protected final String NAME;

    public BaseHero(String name, float hp, int speed, int armor, int maxDamage, int damage, int x, int y) {
        this.name = name;
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
        this.maxDamage = maxDamage;
        this.armor = armor;
        NAME = name;
        position = new Position(x, y);
    }

    public void attack(BaseHero target, int damage, int maxDamage) {
        int causedDamage;
        if (damage < target.armor) causedDamage = damage;
        else {
            switch (new Random().nextInt(4)){
                case 0:
                    causedDamage = maxDamage;
                    break;
                default:
                    causedDamage = damage;
                    break;
            }
        }
        target.getDamage(causedDamage);
    }

    public static String generateName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    @Override
    public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> team2) {
    }

    public Random getRnd() {
        return rnd;
    }

    @Override
    public String getInfo() {
        String outStr = String.format("\t%-3s\t⚔️ %-3d\t\uD83D\uDEE1 %-3d\t♥️%-3d%%\t☠️%-3d\t        " , 0, 0, armor, (int) hp * 100/70, damage);
        return outStr;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        } 
        else this.hp = 0;
    }

    public String getName() {
        return "base";
    }

    public float getHp() {
        return hp;
    }

    public Position getPosition() {
        return position;
    }
}
