import java.util.ArrayList;

public class Peasant extends BaseHero{

    public Peasant(String name, int x, int y) {
        super(name, 34, 23, 34, 45, 34, x, y);
    }

    @Override
    public String getName() {
        return "Peasant";
    }

    @Override
    public void step(ArrayList<BaseHero> team, ArrayList<BaseHero> friends) {
    }
}