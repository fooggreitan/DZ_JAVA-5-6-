import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static ArrayList<BaseHero> list1 = new ArrayList<>();
    public static ArrayList<BaseHero> list2 = new ArrayList<>();
    public static ArrayList<BaseHero> allUnits = new ArrayList<>();
    public static final int GANG_SIZE = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Planner.Init(list2, list1, GANG_SIZE);

        while (true) {
            ConsoleView.view();
            sc.nextLine();
            Planner.step(allUnits, list2, list1);
        }
    }
}

class Planner {

    public static Random random = new Random();

    public static void Init(ArrayList<BaseHero> list1, ArrayList<BaseHero> list2, int GANG_SIZE) {
        for (int i = 1; i < GANG_SIZE + 1; i++) {
            switch (random.nextInt(4)) {
                case 0:
                    list1.add(new Peasant(BaseHero.generateName(), random.nextInt(15), random.nextInt(15)));
                    break;
                case 1:
                    list1.add(new Robber(BaseHero.generateName(), random.nextInt(15), random.nextInt(10)));
                    break;
                case 2:
                    list1.add(new SniperHero(BaseHero.generateName(), random.nextInt(10), random.nextInt(10)));
                    break;
                default:
                    list1.add(new Magician(BaseHero.generateName(), random.nextInt(15), random.nextInt(19)));
                    break;
            }
            switch (random.nextInt(4)) {
                case 0:
                    list2.add(new Peasant(BaseHero.generateName(), random.nextInt(5), random.nextInt(10)));
                    break;
                case 1:
                    list2.add(new Spearman(BaseHero.generateName(), random.nextInt(10), random.nextInt(10)));
                    break;
                case 2:
                    list2.add(new Crossbowman(BaseHero.generateName(), random.nextInt(5), random.nextInt(10)));
                    break;
                default:
                    list2.add(new Monk(BaseHero.generateName(), random.nextInt(5), random.nextInt(10)));
                    break;
            }
        }
    }

    public static void step(ArrayList<BaseHero> allUnits, ArrayList<BaseHero> list1, ArrayList<BaseHero> list2) {
        allUnits.addAll(list2);
        allUnits.addAll(list1);
        allUnits.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero u1, BaseHero u2) {
                if (u1.getSpeed() == u2.getSpeed())
                    return 0;
                else if (u1.getSpeed() > u2.getSpeed())
                    return 1;
                else
                    return -1;
            }
        });

        for (BaseHero unit : allUnits) {
            if (list2.contains(unit)) {
                unit.step(list1, list2);
            } else
                unit.step(list2, list1);
        }
    }
}