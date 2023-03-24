public class Magician extends BaseHero {

    public Magician(String name, int x, int y) {
        super(name, 34, 23, 34, 5, 4, x, y);
    }

    @Override
    public String getName() {
        return "Magician";
    }
}