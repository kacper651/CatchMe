import java.awt.*;

public class Kwadrat extends Sprajt{

    public Kwadrat(int x, int y) {super(x, y);}
    @Override
    public void draw(Graphics2D g2d) {
        g2d.fillRect(x, y,10,10);
    }
}
