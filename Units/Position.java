import java.util.ArrayList;

public class Position{
    protected int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(BaseHero unit){
        return Math.sqrt(Math.pow(x - unit.position.x, 2) + Math.pow(y - unit.position.y, 2));
    }

    public boolean isEquals(Position position) {
        if ((position.x == this.x) & (position.y == this.y))
            return true;
        else
            return false;
    }

    public void direction(Position position, ArrayList<BaseHero> friends) {
        boolean[] temp = checkPos(friends);
        float dx = Math.abs(this.x - position.x);
        float dy = Math.abs(this.y - position.y);
        if (dx > dy) {
            if (this.x < position.x & temp[1]) this.x += 1;
            else this.x -= 1;
        } 
        else {
            if (this.y < position.y) this.y += 1;
            else this.y -= 1;
        }
    }

    public boolean[] checkPos(ArrayList<BaseHero> friends){
        boolean[] temp = new boolean[4];
        for (BaseHero u : friends) {
            if((u.position.x == this.x+1) & (u.position.y == this.y)) temp[0] = true;
            if((u.position.x == this.x-1) & (u.position.y == this.y)) temp[1] = true;
            if((u.position.x == this.x) & (u.position.y == this.y+1)) temp[2] = true;
            if((u.position.x == this.x) & (u.position.y == this.y-1)) temp[3] = true;
        }
        return temp;
    }
}