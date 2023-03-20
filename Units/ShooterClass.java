import java.util.ArrayList;

import javax.swing.text.AbstractDocument.BranchElement;

public abstract class ShooterClass extends BaseHero{
    
   int arrows; 

    public ShooterClass(String name, float hp, int speed, int damage, int arrows) {
        super(name, hp, speed, damage);
        this.arrows = arrows;
    }

    @Override
    public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> friends) {

        if(this.arrows > 0 && this.hp > 0) {
            for (BaseHero unit : team) {
                if (unit.getInfo().equals("Peasant")) {
                    continue; // Пропускаем "Peasant" и переходим к следующему персонажу команды.
                }
                else {
                    if(unit.hp > 0) {
                        System.out.println("Могу стрелять!");
                        this.attack(unit, this.damage);
                        // this.arrows--;
                        // System.out.println(toString());
                        break;
                    }
                    else {
                        System.out.println("Нет жизни!");
                    }
                }
            }
        }
        
        // else {
        //     System.out.println("Не могу стрелять!");
        // }

        // 
        System.out.println(toString());
        
        for (BaseHero unit : friends) {
            if (unit.getInfo().equals("Peasant")) {
                // this.arrows++;
                break;
            }
            this.arrows--;
        }

        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Осталось стрел: " + String.valueOf(this.arrows);
    }

}