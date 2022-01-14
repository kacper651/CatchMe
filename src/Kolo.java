import java.awt.*;

public class Kolo extends Sprajt{

    public Kolo(int x, int y) {super(x, y);}
    @Override
    public void draw(Graphics2D g2d) {
        g2d.fillOval(x, y, 10,10);
    }
}
