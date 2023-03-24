import java.util.ArrayList;

public abstract class ShooterClass extends BaseHero{
    
   int arrows; 

    public ShooterClass(String name, float hp, int speed, int damage, int maxDamage, int armor, int arrows,  int x, int y) {
        super(name, hp, speed, damage,maxDamage, armor, x , y);
        this.arrows = arrows;
    }

    @Override
    public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> friends) {

        if(this.arrows > 0 && this.hp > 0) {
            for (BaseHero unit : team) {
                if (unit.getInfo().equals("Peasant")) {
                    continue; 
                }
                else {
                    if (unit.hp <= 0) {
                        continue;
                    }
                    else if(unit.hp > 0) {
                        this.attack(unit, this.damage, this.maxDamage);
                        break;
                    }
                }
            }
        }
        
        for (BaseHero unit : friends) {
            if (unit.getInfo().equals("Peasant")) {
                this.arrows--;
                break;
            }
        }
    }
}