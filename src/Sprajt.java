import java.awt.*;

public abstract class Sprajt {
    protected int x, y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Sprajt(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Sprajt(Point point) {
        this(1,1);
    }

    public abstract void draw(Graphics2D g2d);
}
