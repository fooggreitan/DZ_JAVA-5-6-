public class Monk extends BaseHero{
    public Monk(String name, int x, int y) {
        super(name, 34, 23, 34, 45, 45, x, y);
    }

    @Override
    public String getName() {
        return "Monk";
    }
}
