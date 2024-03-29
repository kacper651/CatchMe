import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Kanwa extends JPanel{

    int mouseX;
    int mouseY;

    private boolean rysuj = true;

    Sprajt sp = null;

    public boolean isRysuj() {
        return rysuj;
    }

    public void setRysuj(boolean rysuj) {
        this.rysuj = rysuj;
    }

    public boolean hasSprajt() {
        return sp != null;
    }

    public void addSprajt(Sprajt spr) {
        this.sp = spr;
    }

    private boolean drawSquare;

    public boolean drawSquare() {
        return drawSquare;
    }

    public void setDrawSquare(boolean drawSquare) {
        this.drawSquare = drawSquare;
    }

    public Kanwa() {
        setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
        setBounds(100, 300, 500, 300);
        setBackground(Color.white);
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        setLayout(null);

        setFocusable(true);
        requestFocusInWindow();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        try {
            if (!isRysuj()) return;
            if (sp == null) return;
            g2d.setColor(Color.GRAY);
            sp.draw(g2d);
        } finally {
            g2d.dispose();
        }
    }
}

